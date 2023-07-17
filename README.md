# how-is-the-trips

## Sobre o projeto
- O projeto foi escrito usando Java 17 e springBoot 2.7.5;
- Para executar o projeto, os seguintes requisitos devem estar instalados no seu ambiente: Jdk17, Docker Engine.
- Commandos:
  - ``` maven package``` para criar o arquivo .jar utilizado para o deploy;
  - ``` docker build <name>/<tag> .``` para criar a imagem contendo o jar;
  - ``` docker compose up``` para iniciar o arquivo de orquestração docker-compose.yml;
  - Caso queira executar somente o banco de dados para fins de desenvolvimento, execute o comando ``` docker-compose up --no-deps db  ```;
- As documentações dos endpoints ficarão disponíves após o start do projeto nos seguintes caminhos:
  - ``` http://localhost:8080/swagger-ui/index.html#/``` para interface interativa do Swagger;
  - ``` http://localhost:8080/v3/api-docs/``` json com a especifição em formato OpenApi3.0 da API.