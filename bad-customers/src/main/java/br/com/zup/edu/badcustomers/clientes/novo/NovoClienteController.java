package br.com.zup.edu.badcustomers.clientes.novo;

import br.com.zup.edu.badcustomers.clientes.Cliente;
import br.com.zup.edu.badcustomers.clientes.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class NovoClienteController {

    @Autowired
    private ClienteRepository repository;

    public NovoClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @PostMapping("/api/clientes-caloteiros")
    public ResponseEntity<?> cadastra(@RequestBody @Valid NovoClienteRequest request, UriComponentsBuilder uriBuilder) {

        if (repository.existsByCpf(request.getCpf())) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "cliente já existente");
        }

        Cliente cliente = request.toModel();
        repository.save(cliente);

        URI location = uriBuilder
                .path("/api/clientes-caloteiros/{id}")
                .buildAndExpand(cliente.getId())
                .toUri();

        return ResponseEntity
                .created(location).body(new NovoClienteResponse(cliente));
    }
}
