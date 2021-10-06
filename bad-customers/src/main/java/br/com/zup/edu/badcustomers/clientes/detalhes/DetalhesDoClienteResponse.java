package br.com.zup.edu.badcustomers.clientes.detalhes;

import br.com.zup.edu.badcustomers.clientes.Cliente;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DetalhesDoClienteResponse {

    private String nome;
    private String cpf;
    private BigDecimal debitoAtual;
    private LocalDateTime criadoEm;

    public DetalhesDoClienteResponse(Cliente cliente) {
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.debitoAtual = cliente.getDebitoAtual();
        this.criadoEm = cliente.getCriadoEm();
    }

    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public BigDecimal getDebitoAtual() {
        return debitoAtual;
    }
    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    @Override
    public String toString() {
        return "DetalhesDoClienteResponse{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", debitoAtual=" + debitoAtual +
                ", criadoEm=" + criadoEm +
                '}';
    }
}
