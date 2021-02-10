<p align="center">
  <a href="https://ntconsult-api.herokuapp.com/swagger-ui.html#/">
    <img src="https://github.com/RodrigoFrancaBR/desafio-NTConsult/blob/main/assets/urn.png" height="150" width="175" alt="Logo do SGSV" />
  </a>
</p>
<h1 align="center">Sistema Gerenciador de Sessão de Votação</h1>

<ul>
 <li> Desafio proposto pela empresa NTConsult (https://www.linkedin.com/company/ntconsult/)</li>
  <li> <em><strong>(Back-end)</strong></em> o core da aplicação expoe uma <em><strong>API Rest</strong></em> implantada na nuvem <em><strong>(Heroku) </strong></em>.  
 </ul> 
 
 ## <h1 align="center">Modelo Conceitual </h1>
 ![Modelo Conceitual](https://github.com/RodrigoFrancaBR/desafio-NTConsult/blob/main/assets/Modelo%20ER-Sistema%20Gerenciador%20de%20Sess%C3%A3o%20de%20Vota%C3%A7%C3%A3o.png)

## <h1 align="center">Ferramentas e Tecnologias envolvidas no desenvolvimento</h1>

## <h1 align="center">Back end</h1>
- JDK 8
- Spring Boot (web, data-jpa, swagger)
- STS (Spring Tool Suite)
- Postman
- Postgresql 12 e pgAdmin (dev)
- H2 Database (test)
- MySql WorkBench(dev)
- Maven
- Heroku CLI
- Git

Para realizar o teste da api, pode se usar o Postman ou o Swagger, 
Usando o postman, basta baixar o arquivo desafio-NTConsult.postman_collection no link abaixo e importar no Postman.
https://github.com/RodrigoFrancaBR/desafio-NTConsult/blob/main/documentos/desafio-NTConsult.postman_collection.json

Passo a passo para utilizar a API.

1 - Cadastrar um associado
https://desafiontconsult.herokuapp.com/associados (postman)

https://desafiontconsult.herokuapp.com/swagger-ui.html#/associado-controller/cadastrarAssociadoUsingPOST (swagger)

2 - Cadastrar uma pauta
https://desafiontconsult.herokuapp.com/pautas (postman)

https://desafiontconsult.herokuapp.com/swagger-ui.html#/pauta-controller/cadastrarPautaUsingPOST (swagger)

3 - Abrir sessão em uma pauta(informando a duração)
https://desafiontconsult.herokuapp.com/pautas/1/sessoes?duracao=60

4 - Abrir sessão em uma pauta (sem informar duração)
https://desafiontconsult.herokuapp.com/pautas/1/sessoes (postman)

https://desafiontconsult.herokuapp.com/swagger-ui.html#/pauta-controller/abrirSessaoEmUmaPautaUsingPUT (swagger)

5 - Realizar um voto
https://desafiontconsult.herokuapp.com/pautas/1/votos (postman)

https://desafiontconsult.herokuapp.com/swagger-ui.html#/pauta-controller/votarUsingPOST (swagger)

6 - Obter o resultado final da votação.
https://desafiontconsult.herokuapp.com/pautas/1/votos (postman)

https://desafiontconsult.herokuapp.com/swagger-ui.html#/pauta-controller/obterResultadoDaVotacaoUsingGET (swagger)
