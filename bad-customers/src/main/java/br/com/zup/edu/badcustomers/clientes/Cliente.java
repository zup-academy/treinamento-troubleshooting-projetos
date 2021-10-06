package br.com.zup.edu.badcustomers.clientes;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cliente")
    @SequenceGenerator(
        name = "seq_cliente",
        sequenceName = "seq_cliente",
        allocationSize = 1
    )
    private Long id;

    @NotBlank @Size(max = 120)
    @Column(nullable = false, length = 120)
    private String nome;

    @NotBlank @Size(max = 11)
    @Column(nullable = false, length = 11, unique = true)
    private String cpf;

    @NotNull @Positive
    @Column(nullable = false)
    private BigDecimal debitoAtual;

    @CreationTimestamp
    private LocalDateTime criadoEm;

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

}
