package br.com.zup.edu.badcustomers.clientes;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Cliente {

    private Long id;

    @NotBlank @Size(max = 120)
    private String nome;

    @CPF
    @NotBlank @Size(max = 11)
    private String cpf;

    @NotNull @Positive
    private BigDecimal debitoAtual;

    @NotNull
    private LocalDateTime criadoEm = LocalDateTime.now();

    @Deprecated
    public Cliente() {}

    public Cliente(String nome, String cpf, BigDecimal debitoAtual) {
        this.nome = nome;
        this.cpf = cpf;
        this.debitoAtual = debitoAtual;
    }

    public Long getId() {
        return id;
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
    public void setId(Long id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setDebitoAtual(BigDecimal debitoAtual) {
        this.debitoAtual = debitoAtual;
    }
    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }
}
