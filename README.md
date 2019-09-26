#### Executando o projeto
Para executar o projeto estando em sua raiz através de algum terminal executar:
./mvnw spring-boot:run 

#### Verificando os endpoints
Na raiz do projeto existe um arquivo chamado 'postman_collection.json'. Esse arquivo 
se refere a uma coleção do Postman com os testes para os endpoints 'bots' e 'messages'.

#### Informações adicionais
O projeto foi implementado utilizando o banco em memória H2 para facilitar os testes
e desenvolvimento. A configuração das credenciais do banco se encontram no arquivo 
application.properties. Sendo um banco em memória, se atentar para o fato de os dados 
serem perdidos a cada inicialização.

#### Considerações finais
A arquitetura geral da aplicação se define em três camadas: controller, negócio (business), e 
repository, sendo que esta última camada faz uso do Spring Data para abstrair os métodos 
de interação com a base de dados.
Projeto desenvolvido e testado em ambiente openjdk 11.0.3 2019-04-16.