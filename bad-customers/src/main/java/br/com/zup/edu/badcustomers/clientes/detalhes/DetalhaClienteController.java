package br.com.zup.edu.badcustomers.clientes.detalhes;

import br.com.zup.edu.badcustomers.clientes.Cliente;
import br.com.zup.edu.badcustomers.clientes.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@RestController
public class DetalhaClienteController {

    @Autowired
    private ClienteRepository jdbcRepository;

    private final ClienteRepository repository;

    public DetalhaClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/clientes-caloteiros/{id}")
    public ResponseEntity<?> detalha(@PathVariable("id") @NotNull @Positive Long id) {

        Cliente cliente = jdbcRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "cliente não encontrado");
        });

        return ResponseEntity
                .ok(new DetalhesDoClienteResponse(cliente));
    }

}
