create table cliente (
    id int8 not null,
    cpf varchar(11) not null,
    criado_em timestamp,
    debito_atual numeric(19, 2) not null,
    nome varchar(120) not null,
    primary key (id)
)