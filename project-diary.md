# Diário do projeto e tomada de decisões

## início
- Nome do projeto, sempre opto por começar meus projetos com um nome, pois assim fica mais fácil de visualizar a ferramenta, então optei por "how-is the-trips" por ser uma ferramenta de consulta de viagens.
- Optei por Utilizar o projeto fornecido por dois motivos: tempo, e diminuir a margem de erro para caso eu importe alguma dependência errada.

## antes de codificar
- Após a leitura do caso de uso, fui pesquisar algumas formas de como eu poderia otimizar a importação de arquivos CSV, levando em considerção 2 fatores:
    - o cenário atual, temos uma base de dados pequena, então não precisaria de uma solução muito robusta;
    - em um sistema de produção com certeza criaria uma ferramenta a parte para esse fim, no geral, ferramentas de ETL tendem a consumir bastante processamento,  então pensei em algo embarcado no próprio spring.
- Optei por seguir o seguinte caminho: irei realizar 2 formas possíveis de atualização da base: 1 delas, quando a ferarmenta iniciar irá consumir os arquivos no diretório especifico e a outra opção de fazer o upload dos próprios arquivos. ( dei uma olhada na fonte, e em um cenário real eu optaria por construir um scrapping com python ou alguma outra ferramenta, para capturar esses dados, e salva-los em um diretório diário, onde meu sistema tivesse acesso, e  houvesse uma rotina de atualização da base diária)
- Antes de começar a codificação, preciso definir por onde começar a implementação, então decide pelos seguintes tópicos
  - 1 - Irei começar definindo as classes de entidade do meu sistema, e seus relacionamentos;
  - 2 - Depois irei construir a service que busca os arquivos em um diretório e realiza a persistência na base de dados (irei verificar se existe uma lentidão se caso necessário aplico uma outra abordagem para melhoria de perfomance);
  - 3 - Depois criarei as queries de consulta e a service de consultas para os endpoints da API, e também a controller responsável por conter esses endpoints;
- Irei realizar um commit quando cada etapa do código feito for considerada concluida, exemplo: criar classes de domínio, criar repositories, criar services, criação de testes, criação de controllers. Os commits terão as seguintes flag: feat -> criação, test -> para testes, refac -> para refatorações, bugfix -> correção de algum bug encontrado.

## etapa de codificação
- Movimentando os arquivos CSV: usei a classe buffered reader para ler o conteudo do arquivo csv, e estou utilizando a lib OPenCSV para serializar meu csv para minha classe de domínio;
- Para adicionar a documentação via OpenApi do meu projeto, usei a lib: pringdoc-openapi-ui que já me traz um endpoint que gera a documentação: /api-docs, e também uma interface interativa do swagger: / swagger-ui/index.html#/.
