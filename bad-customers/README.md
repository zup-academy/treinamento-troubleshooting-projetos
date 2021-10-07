# Bad Customers

Microsserviço responsável por gerenciar os clientes em débito com a empresa e que aparentemente não tem intenção de pagar suas dividas. A aplicação se trata de uma API REST que foi implementada
usando as tecnologias abaixo:

- Java 11;
- Spring Boot 2.5.x;
- PostgreSQL 13.x;
- Flyway;
- Maven;
- Docker;

## Ambiente de desenvolvimento

Para configurar o ambiente basta seguir os passos:

1. clonar o repositório ou fazer seu download:

```shell
git clone https://github.com/zup-academy/treinamento-troubleshooting-projetos
cd bad-customers
```

2. Importar o projeto na IDE IntelliJ;

3. Iniciar o banco de dados via Docker-Compose:

```shell
docker-compose up -d
``` 

4. Iniciar a aplicação via IDE ou linha de comando:

```shell
./mvnw spring-boot:run
``` 

5. Consumir a API REST da aplicação via url http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/ .

## Ambiente de produção

Para rodar a aplicação em produção basta executá-la informando a configuração do banco de dados de produção via variáveis de ambiente:
```
DATABASE_URL=jdbc:postgresql://<hostname>:<port>/postgres DATABASE_USERNAME=<username> DATABASE_PASSWORD=<password> ./mvnw spring-boot:run
```

## Duvidas e suporte

Basta entrar em contato com a equipe da Zup Edu no horário comercial. 