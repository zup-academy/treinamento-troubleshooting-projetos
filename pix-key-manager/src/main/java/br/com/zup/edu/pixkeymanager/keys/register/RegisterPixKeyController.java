package br.com.zup.edu.pixkeymanager.keys.register;

import br.com.zup.edu.pixkeymanager.keys.Account;
import br.com.zup.edu.pixkeymanager.keys.PixKey;
import br.com.zup.edu.pixkeymanager.keys.PixKeyRepository;
import br.com.zup.edu.pixkeymanager.keys.shared.errors.ApiError;
import br.com.zup.edu.pixkeymanager.keys.shared.integration.bcb.CreatePixKeyBcbResponse;
import br.com.zup.edu.pixkeymanager.keys.shared.integration.itau.AccoutResponse;
import br.com.zup.edu.pixkeymanager.keys.shared.integration.bcb.BcbClient;
import br.com.zup.edu.pixkeymanager.keys.shared.integration.itau.ItauClient;
import br.com.zup.edu.pixkeymanager.keys.shared.integration.bcb.CreatePixKeyBcbRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.unprocessableEntity;

@RestController
@RequestMapping("/api/{clientId}/pix")
public class RegisterPixKeyController {

    private final PixKeyRepository repository;
    private final ItauClient itauClient;
    private final BcbClient bcbClient;

    public RegisterPixKeyController(PixKeyRepository repository,
                                    ItauClient itauClient,
                                    BcbClient bcbClient) {
        this.repository = repository;
        this.itauClient = itauClient;
        this.bcbClient = bcbClient;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> registerPixKeyTo(@PathVariable("clientId") UUID clientId,
                                              @RequestBody @Valid NewPixKeyRequest request) {


        if (repository.findByKey(request.getKey())) {
            return unprocessableEntity()
                    .body(new ApiError("pix.key", "pix.key.already.registered"));
        }


        AccoutResponse accoutResponse = itauClient.findByOwnerAndType(clientId, request.getAccountType());
        Account account = accoutResponse.toAccount();

        PixKey pixKey = request.toPixKey(clientId, account);
        repository.save(pixKey);

        CreatePixKeyBcbResponse bcbResponse = bcbClient.createPix(new CreatePixKeyBcbRequest(pixKey));

        pixKey.update(bcbResponse.getKey());
        repository.save(pixKey);

        return ResponseEntity.ok().build();
    }

}
