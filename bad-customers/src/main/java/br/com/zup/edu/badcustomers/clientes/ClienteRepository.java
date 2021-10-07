package br.com.zup.edu.badcustomers.clientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Optional;

@Validated
@Repository
public class ClienteRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void save(@Valid Cliente cliente) {

        Long id = jdbcTemplate
                .queryForObject("SELECT nextval('seq_cliente')", Long.class);

        String sql = "INSERT INTO cliente (id, nome, cpf, debito_atual, criado_em) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate
                .update(sql, id, cliente.getNome(), cliente.getCpf(), cliente.getDebitoAtual(), cliente.getCriadoEm());

        cliente.setId(id);
    }

    public Optional<Cliente> findById(Long id) {
        try {
            String sql = "SELECT c.* FROM cliente c where c.id = ?";
            Cliente cliente = jdbcTemplate
                    .queryForObject(sql, new BeanPropertyRowMapper<Cliente>(Cliente.class), id);

            return Optional.ofNullable(cliente);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public boolean existsByCpf(String cpf) {

        String sql = "SELECT count(1) FROM cliente c where c.cpf = ?";
        Long count = jdbcTemplate
                .queryForObject(sql, Long.class, cpf);

        return count > 0;
    }

}
