package br.com.zup.edu.badcustomers.clientes.novo;

import br.com.zup.edu.badcustomers.clientes.Cliente;

import java.time.LocalDateTime;

public class NovoClienteResponse {

    private final Long id;
    private final LocalDateTime criadoEm;

    public NovoClienteResponse(Cliente cliente) {
        this.id = cliente.getId();
        this.criadoEm = cliente.getCriadoEm();
    }

    public Long getId() {
        return id;
    }
    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    @Override
    public String toString() {
        return "NovoClienteResponse{" +
                "id=" + id +
                ", criadoEm=" + criadoEm +
                '}';
    }
}
