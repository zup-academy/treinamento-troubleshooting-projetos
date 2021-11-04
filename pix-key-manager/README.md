# Pix Key Manager

Projeto responsável por fazer o gerenciamento de chaves Pix para os clientes do banco.

## Para rodar o projeto
- Java 11+
- Docker (ou outra ferramenta para subir um container)
- IDE de sua escolha
- Maven

Fazer o clone do projeto com o comando:

```shell
git clone https://github.com/yurioliveirazup/troubleshooting-pix-key-manager.git
```

Para rodar, basta subir o container do banco com o comando

```shell
docker container run --rm -e POSTGRES_PASSWORD=changeme -e POSTGRES_DB=keymanager -p 5432:5432 -d postgres:12.8
```

E pedir para o Maven ou a IDE rodar o projeto
