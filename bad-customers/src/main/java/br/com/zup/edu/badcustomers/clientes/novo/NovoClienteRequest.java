package br.com.zup.edu.badcustomers.clientes.novo;

import br.com.zup.edu.badcustomers.clientes.Cliente;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class NovoClienteRequest {

    @NotBlank
    @Size(max = 120)
    private String nome;

    @CPF
    @NotBlank
    @Size(max = 11)
    private String cpf;

    @NotNull
    @Positive
    private BigDecimal debitoAtual;

    public NovoClienteRequest(String nome, String cpf, BigDecimal debitoAtual) {
        this.nome = nome;
        this.cpf = cpf;
        this.debitoAtual = debitoAtual;
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

    public Cliente toModel() {
        return new Cliente(nome, cpf, debitoAtual);
    }
}
