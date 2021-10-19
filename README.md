API REST WebService - Pessoas, Estado e Cidade - Copyright © 3IT.

Projeto em Spring Boot de uma construção API RESTFul voltado a atender o desafio da 3IT

Uma solução criada em Java em formato de API REST que atenda aos requisitos para a recepção e/ou criação de 
pessoas contendo os seus respectivos dados. Onde todos os serviços devem trabalhar com JSON em suas chamadas e retornos.

Stack do projeto

Escrito em Java 11;
Utilizando as facilidades e recursos framework Spring Boot;
Framework Hibernarte e Spring Data JPA para garantir a persistência dos dados e facilitar as operações CRUD (aumentando o nivel de desempenho e escalabilidade);
Banco de dados PostgreSQL;


Visão Geral

A aplicaçao tem como objetivo disponibilizar endpoints para consulta de informações e operações à respeito de:

Pessoas, com os seus respectivos dados, tais como:

Nome;
CPF;
Email;
Cidade;
Estado

Instruções Inicialização - Projeto

 1. Clone o repositório https://github.com/gomeshenio/crud.git
  
  2. Ou faça o download do arquivo ZIP do projeto em https://github.com/gomeshenio/crud/archive/refs/heads/main.zip
      
  3. Importar o projeto em sua IDE de preferência (lembre-se, projeto baseado em Spring & Maven)
  
  4. Buildar o projeto e executá-lo.
  
  Endpoints:
  
  Retornar uma lista completa de pessoas em formato (JSON):
  http://localhost:8080/pessoas/
  
  Autor do projeto
  
 https://github.com/gomeshenio
 
 https://www.linkedin.com/in/henio-gomes-b6a950164/
 
