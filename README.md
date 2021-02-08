Desafio para empresa NTConsult
https://desafiontconsult.herokuapp.com/

Desenvolvimento de uma api rest (Springboot) com java 8 e implantação no Heroku usando o database postgree.

Utilizando o Postman, basta importar o arquivo desafio-NTConsult.postman_collection e realizar as chamadas.
https://github.com/RodrigoFrancaBR/desafio-NTConsult/blob/main/documentos/desafio-NTConsult.postman_collection.json

Passo a passo para utilizar a API.

1 - Cadastrar um associado
https://desafiontconsult.herokuapp.com/associados

2 - Cadastrar uma pauta
https://desafiontconsult.herokuapp.com/pautas

3 - Abrir sessão em uma pauta(informando a duração)
https://desafiontconsult.herokuapp.com/pautas/1/sessoes?duracao=60

4 - Abrir sessão em uma pauta (sem informar duração)
https://desafiontconsult.herokuapp.com/pautas/1/sessoes

5 - Realizar um voto
https://desafiontconsult.herokuapp.com/pautas/1/votos

6 - Obter o resultado final da votação.
https://desafiontconsult.herokuapp.com/pautas/1/votos
