DummyAuth - API de Autenticación con DummyJSON
Descripción del Proyecto
Este proyecto es una API Spring Boot que actúa como intermediario entre el cliente y el servicio DummyJSON, proporcionando endpoints para autenticación y gestión de usuarios.

Requisitos Técnicos
Java: Versión 21

Spring Boot: 3.3.12

Spring Cloud: 2023.0.5

Lombok: 1.18.32

PostgreSQL: (Configurado en application.properties)

Feign Client: Para conexión con DummyJSON

Configuración
El archivo application.properties contiene:

properties
spring.datasource.url=jdbc:postgresql://localhost:5432/dummyauth_db
spring.datasource.username=postgres
spring.datasource.password=postgres
server.port=8080

Requisitos Funcionales para Pruebas con Postman

1. Autenticación con DummyJSON
Endpoint local:
POST http://localhost:8080/api/auth/login

Headers:
Content-Type: application/json

Ejemplo de cuerpo (Body):

json
{
    "username": "emilys",
    "password": "emilyspass"
}
Respuesta esperada:

json
{
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
    "username": "emilys"
}
Equivalente directo a DummyJSON:
POST https://dummyjson.com/auth/login

bash
curl --request POST \
--url https://dummyjson.com/auth/login \
--header 'Content-Type: application/json' \
--data '{
"username": "emilys",
"password": "emilyspass"
}'

2. Consulta de Usuario Autenticado
Endpoint local:
GET http://localhost:8080/api/auth/me

Headers:
Authorization: Bearer <token_obtenido_del_login>

Respuesta esperada:

json
{
    "id": 15,
    "username": "emilys",
    "email": "emily@example.com",
    "firstName": "Emily",
    "lastName": "Smith",
    "gender": "female",
    "image": "image_url"
}
Equivalente directo a DummyJSON:
GET https://dummyjson.com/auth/me

3. Lista de Usuarios para Prueba
Endpoint local:
GET http://localhost:8080/api/auth/test-users

Respuesta esperada (array de usuarios):

json
[
    {
        "id": 1,
        "username": "user1",
        "email": "user1@example.com",
        "firstName": "John",
        "lastName": "Doe",
        "gender": "male",
        "image": "image_url1"
    },
    {
        "id": 2,
        "username": "user2",
        "email": "user2@example.com",
        "firstName": "Jane",
        "lastName": "Doe",
        "gender": "female",
        "image": "image_url2"
    }
]
Equivalente directo a DummyJSON:
GET https://dummyjson.com/users

Notas Adicionales
El proyecto usa Feign Client para comunicarse con DummyJSON

La configuración de PostgreSQL es opcional para desarrollo local

Todos los endpoints devuelven datos en formato JSON

El logging está configurado para mostrar detalles de las llamadas Feign

