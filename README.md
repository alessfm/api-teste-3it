#API REST WebService - Pessoas, Estado e Cidade - Copyright © 3IT

**Pre-requisitos:** Para a API usamos [Java 11](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html) e para o Web usamos [Node.js 8.11.3](https://nodejs.org/) e Angular Core 11.2.5v

* [Iniciar](#iniciar)
* [Licença](#Licença)

## API

Para rodar o `Api (Spring)` faça:
 
```bash
git https://github.com/LucasCosta619/api-teste-3it.git
cd api-teste-3it
```

Instruções Inicialização - Projeto

1. Importe o projeto na "api" em sua IDE de preferência (lembre-se, projeto baseado em Spring & Maven)

2. Crie o banco de dados com o nome "api_teste"

3. Realize o Build do projeto para executá-lo.

> Você precisa ter o PostgreSQL 14, Java 11 instalado para executar esse passo.


## Banco de Dados

Instale o PostgreSQL 14, link para o [download](https://www.postgresql.org/download/)

## Documentação 

> Após executar o projecto com Spring, você pode acessar a documentação com os end-points no [Link](http://localhost:8080/swagger-ui/index.html)

## Desafio

### Criar uma aplicação com Angular 7.3 e integrar com a API

1. Lista de pessoas cadastradas

2. Cadastrar nova pessoa com os campos

    - Nome, CPF, Email, Estado, Cidade
    - Os campos Estado e Cidade deverão ser listados do banco 

3. Editar os cadastros

4. Excluir os cadastros