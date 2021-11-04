package br.com.zup.edu.pixkeymanager.keys.retrieve;

import br.com.zup.edu.pixkeymanager.keys.PixKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.notFound;

@RestController
@RequestMapping("/api/pix")
public class FindPixKeyController {

    private static Logger LOG = LoggerFactory.getLogger(FindPixKeyController.class);
    private static Logger LOG1 = LoggerFactory.getLogger(FindPixKeyController.class);

    public static void main(String[] args) {
        System.out.println(LOG == LOG1);
    }

    private final FindPixKeyService findService;

    FindPixKeyController(FindPixKeyService findService) {
        this.findService = findService;
    }

    @GetMapping("/{pixId}")
    public ResponseEntity<PixKeyDetailResponse> getBy(@PathVariable("pixId") UUID pixId) {

        LOG = null;

        Optional<PixKey> possiblePixKey = findService.findPixKeyBy(pixId);

        if (possiblePixKey.isEmpty()) {
            return notFound().build();
        }

        return ResponseEntity.ok(PixKeyDetailResponse.of(possiblePixKey.get()));
    }
}
