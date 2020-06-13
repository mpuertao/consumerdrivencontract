README EN CONSTRUCCIÓN ¡¡¡


# Consumer Driven Contract

Este patrón nos impulsa a desarrollar los Microservicios desde la pruebas de contrato, estrategia basada en diferentes librerias como PACT, SPRING CLOUD VERIFIER, SPRING CLOUD STUB RUNNER, entre otras. 

- [SpringFramework](https://spring.io/)
- [Spring initializr](https://start.spring.io/)
- [Spring Cloud Contract](https://spring.io/projects/spring-cloud-contract)


ANTES DE SEGUIR, LES RECOMIENDO LEER LA TEORÍA.

## Instalación

Primero se tiene un Microservicio llamado Creditcardservice ,  lo tomaremos como el Consumidor para ejemplificar un escenario de solicitud de tarjeta de crédito, donde este microservicio hará la aprobación o el rechazo de la solicitud dependiendo de la respuesta de otro Microservicio que será llamado CreditCheckService 

El microservicio CreditCheckService hará el análisis y responderá si el puntaje del cliente es Alto o Bajo, es su única función, aparte de tener el contrato con el que validaremos el Contract Testing.


Para construir los proyectos, primero debes compilar el proveedor (CreditCheckService) este contiene el contrato, comandos maven:

```
mvn clean install -DskipTests
```

Luego puedes compilar el consumidor (CreditCardService):

```
mvn clean install
```
Por ultimo puedes compilar el proveedor (CreditCheckService) sin omitir los tests:

```
mvn clean install
```

Ambos Microservicios contienen 2 escenarios, uno positivo con aprobacion segun score, y el otro con denegacion segun score.

# Contenido

## Que es un contrato en el arquitecturas orientadas a Microservicios?:

  - Serie de interacciones entre un Consumidor y un Proveedor
  - Los contratos se prueban continuamente tanto desde el consumidor como del proveedor
  - No son una API de Documentación
  
## Que componen un Contrato:
  - politica de seguridad
  - Estructura de objetos de negocio
  - interfaces (firmas)
  - calidad del servicio
  - gestión de errores
  - modelo de conversación
  
## Que es CDC (Consumer Driven Contract):
  - Es un patrón que proporciona a los proveedores ideas de obligaciones con el consumidor y enfoca la evolución del servicio entorno a las entregas del valor del negocio demandadas por los consumidores.
   > "ES EL TDD DE LAS API Y ARQUITECTURAS DE SERVICIOS"
  
## Que es Spring Cloud Contract:
  - Proporciona un andamiaje para realizar Pruebas basadas en el Consumidor por medio de Contratos. Esta ligada en aplicaciones JVM, definiendo un lenguaje de contrato en un groovy DSL donde tendremos todas las necesidades del consumidor y proveedor.
  

![contract testing](https://www.xenonstack.com/wp-content/uploads/xenonstack-contract-testing.png)




Agradecimiento a @andrewMorgan por el curso de Introduction to Spring Cloud Contract




