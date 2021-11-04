package br.com.zup.edu.pixkeymanager.keys.remove;

import br.com.zup.edu.pixkeymanager.keys.PixKey;
import br.com.zup.edu.pixkeymanager.keys.PixKeyRepository;
import br.com.zup.edu.pixkeymanager.keys.shared.cache.LocalCacheService;
import br.com.zup.edu.pixkeymanager.keys.shared.integration.bcb.BcbClient;
import br.com.zup.edu.pixkeymanager.keys.shared.integration.bcb.DeletePixKeyBcbRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.notFound;

@RestController
@RequestMapping("/api/clients/{clientId}/pix/")
public class DeletePixKeyController {

    private final PixKeyRepository repository;
    private final BcbClient bcbClient;
    private final LocalCacheService cacheService;

    public DeletePixKeyController(PixKeyRepository repository,
                                  BcbClient bcbClient,
                                  LocalCacheService cacheService) {
        this.repository = repository;
        this.bcbClient = bcbClient;
        this.cacheService = cacheService;
    }


    @DeleteMapping("/{pixId}")
    public ResponseEntity<?> deleteBy(@PathVariable("clientId")UUID clientId,
                                      @PathVariable("pixId")UUID pixId) {


        Optional<PixKey> possiblePixKey = repository.findById(pixId);

        if (possiblePixKey.isEmpty()) {
            return notFound().build();
        }

        PixKey pixKey = possiblePixKey.get();

        bcbClient.removeKey(pixKey.getKey(), new DeletePixKeyBcbRequest(pixKey.getKey()));
        repository.deleteById(pixId);

        cacheService.invalidate(pixId);


        return ResponseEntity.noContent().build();
    }
}
