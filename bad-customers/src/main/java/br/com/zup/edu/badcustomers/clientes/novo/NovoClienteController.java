package br.com.zup.edu.badcustomers.clientes.novo;

import br.com.zup.edu.badcustomers.clientes.Cliente;
import br.com.zup.edu.badcustomers.clientes.ClienteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
public class NovoClienteController {

    private final ClienteRepository repository;

    public NovoClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @PostMapping("/api/clientes-caloteiros")
    public ResponseEntity<?> cadastra(@RequestBody @Valid NovoClienteRequest request, UriComponentsBuilder uriBuilder) {

        Cliente cliente = request.toModel();
        repository.save(cliente);

        URI location = uriBuilder
                .path("/api/clientes-caloteiros/{id}")
                .buildAndExpand(cliente.getId())
                .toUri();

        return ResponseEntity
                .created(location).build();
    }
}
