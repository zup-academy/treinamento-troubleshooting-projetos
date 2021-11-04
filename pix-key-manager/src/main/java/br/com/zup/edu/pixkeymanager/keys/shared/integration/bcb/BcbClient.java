package br.com.zup.edu.pixkeymanager.keys.shared.integration.bcb;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "bcbClient", url = "${integration.bcb.uri}")
public interface BcbClient {


    @PostMapping(
            path = "/api/v1/pix/keys",
            produces = { MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_XML_VALUE }
    )
    CreatePixKeyBcbResponse createPix(CreatePixKeyBcbRequest createPixKeyBcbRequest);

    @DeleteMapping(
            path = "/api/v1/pix/keys/{key}",
            produces = { MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_XML_VALUE }
    )
    void removeKey(@PathVariable("key") String key,
                   DeletePixKeyBcbRequest deletePixKeyBcbRequest);
}
