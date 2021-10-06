alter table if exists cliente
       add constraint uk_cliente_cpf unique (cpf)