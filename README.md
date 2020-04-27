README EN CONSTRUCCIÓN ¡¡¡


# Consumer Driven Contract

Este patrón nos impulsa a desarrollar los Microservicios desde la prueba de contrato, estrategia basada en librerías, CDC es el TDD de las APIs o servicios 

- [SpringFramework](https://spring.io/)
- [Spring initializr](https://start.spring.io/)


## Installation

Primero se tiene un Microservicio llamado Creditcardservice ,  lo tomaremos como el Consumidor para ejemplificar un escenario de solicitud de tarjeta de crédito, donde este microservicio hará la aprobación o el rechazo de la solicitud dependiendo de la respuesta de otro Microservicio que será llamado CreditCheckService.

Para construir los proyectos, primero debes compilar el proveedor (CreditCheckService) este contiene el contrato, comandos maven:

```maven
mvn clean install
```
Lueg podras compilar el consumidor.


Ambos Microservicios contienen 2 escenarios, uno positivo con aprobacion segun score, y el otro con denegacion segun score.


Agradecimiento a @andrewMorgan por el curso de Introduction to Spring Cloud Contract




