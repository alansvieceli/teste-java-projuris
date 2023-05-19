# teste-java-projuris

Projeto de teste solicitado pela Projuris/Softplan.

-  Aplicação com CRUD de pessoas com auditoria e usando boas práticas. 

# Explicação

Projeto foi feito em Java com o framework Spring Boot e utilizando um banco de dados H2 (em memória.)

- Java 17
- Mavaen 3.9.2
- Spring Boot 3.0.6

## Subir aplicação
```sh
 mvn spring-boot:run
```

## Operações
```sh
curl -X POST -H "Content-Type: application/json" -d '{ "usuario": "Alan", "password": "1234", "email": "alan@empresa.com.br", "idade": 40 }' http://localhost:8080/api/usuario
```

```sh
curl -X GET http://localhost:8080/api/usuario
```

```sh
curl -X GET http://localhost:8080/api/usuario/1
```

```sh
curl -X PUT -H "Content-Type: application/json" -d '{ "idade": 41 }' http://localhost:8080/api/usuario/1
```

```sh
curl -X DELETE http://localhost:8080/api/usuario/1
```