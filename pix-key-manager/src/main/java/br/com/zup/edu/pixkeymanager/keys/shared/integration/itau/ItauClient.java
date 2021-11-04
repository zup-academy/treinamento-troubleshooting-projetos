package br.com.zup.edu.pixkeymanager.keys.shared.integration.itau;

import br.com.zup.edu.pixkeymanager.keys.AccountType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@FeignClient(name = "itauClient", url = "${integration.itau.uri}")
public interface ItauClient {

    @GetMapping("/clients/{clientId}")
    AccoutResponse findByOwnerAndType(@PathVariable("clientId") UUID clientId,
                                      @RequestParam("accountType") AccountType accountType);
}
