# Profile Thumbnailer

Microsserviço responsável por gerar thumbnails das fotos de perfil dos zuppers. As imagens geradas recebem a marca d'água da Zup. Ela foi construída
usando as seguintes tecnologias:

- Java 11;
- Spring Boot 2.5.x;
- Thumbnailator 0.4.14;
- Maven;

## Ambiente de desenvolvimento

Para configurar o ambiente basta seguir os passos:

1. Clonar o repositório ou fazer seu download:

```shell
git clone https://github.com/zup-academy/treinamento-troubleshooting-projetos
cd profile-thumbnailer
```

2. Importar o projeto na IDE IntelliJ;

3. Iniciar a aplicação via IDE ou linha de comando:

```shell
./mvnw spring-boot:run
``` 

5. Consumir a API REST da aplicação via url http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/ .

### Exemplo rápido: consumindo a API REST

Uma boa forma de entender o que a API REST faz exatamente é executando-a. Podemos gerar um thumbnail de uma foto qualquer, para isso, basta submetermos uma imagem em formato base64 no payload JSON da requisição. Abaixo, usamos o comando `curl` como client HTTP para submetermos uma foto do Keanu Reeves:

```shell
curl -v -X POST \
 -H "Content-Type: application/json" \
 -d @samples\keanu-reeves-12-payload.json \
 -o samples/thumbnail.png \
 http://localhost:8080/api/thumbnails/preview
```

O endpoint da API acima exercitado é utilizado para preview do thumbnail em páginas web ou dispositivos mobile. Lembre-se que a API possui outros endpoints com o mesmo fim, mas que podem ser úteis em cenários diferentes.

### Dica rápida: encodando sua foto em base64

Para fazer você vai precisar encodar imagens em base64 e o inverso. Existem diversos sites online que podem auxiliar nessas transformações. Mas uma forma simples de encodar sua foto de perfil (ou qualquer imagem) em base64 é através do comando abaixo:
```shell
base64 -w0 minha-foto.png > minha-foto.png.txt
```

Desse modo você pode usá-la para fazer seus testes sempre que necessário :-)

## Ambiente de produção

1. Execute o build da aplicação para gerar o executável (JAR):
```shell
./mvnw clean package
```

2. Copie o JAR para o ambiente de produção (encontra-se na pasta `target` gerada pelo Maven);

3. Execute a aplicação informando a configuração do banco de dados de produção via variáveis de ambiente:
```
java -server -Xms256m -Xmx256m -jar profile-thumbnailer-1.0.1.jar
```

## Duvidas e suporte

Basta entrar em contato com a equipe da Zup Edu no horário comercial. 