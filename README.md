README EN CONSTRUCCIÓN ¡¡¡


# Consumer Driven Contract

Este patrón nos impulsa a desarrollar los Microservicios desde la prueba de contrato, estrategia basada en librerías, CDC es el TDD de las APIs o servicios 

- [SpringFramework](https://spring.io/)
- [Spring initializr](https://start.spring.io/)


## Installation

Primero se tiene un Microservicio llamado creditcardservice ,  lo tomaremos como el Consumidor para ejemplificar un escenario de solicitud de tarjeta de crédito, donde este microservicio hará la aprobación o el rechazo de la solicitud dependiendo de la respuesta de otro Microservicio que será llamado CreditCheckService

creditcheckservice procesa la petición con numero de identificacion y responde el Score con el cual el microservicio de tarjeta de credito analizará si le brinda aprobación o rechazo.

Para construir los proyectos, comandos maven:

```bash
mvn clean install
```

## Paso a Paso

1. Desde [Spring initializr](https://start.spring.io/) creamos el primer microservicio, el cual obtendrá el nombre de creditcardservice, como dependencias escogemos SpringWeb y contract stubrunner.

En el repositorio creamos un test que permita validar si el puntaje obtenido es alto para brindar la aprobación de una solicitud de tarjeta de crédito.

Ejecutamos la prueba con las siguientes etiquetas de spring 

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

y simulamos la peticion POST que queremos hacer

La prueba fallará por obvias razones, razón que no tenemos el controller ni funcionalidades desarrolladas aún. Partimos de la prueba para desarrollar. Para esto creamos el controller, los modelos y el servicio.

2. Desde [Spring initializr](https://start.spring.io/) creamos el segundo microservicio, el cual obtendrá el nombre de creditcheckservice, como dependencias escogemos SpringWeb y contract verifier.

En este servicio se genera el contrato, es un archivo en groovy donde se especifica las partes negociadas entre el consumidor y el proveedor, este contrato será para ambos y garantiza que este en ambos componentes de manera aislada, pero garantizando el versionamiento y la calidad en ambos.


Agradecimiento a @andrewMorgan por el curso de Introduction to Spring Cloud Contract




