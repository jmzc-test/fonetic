Test Spring REST 

* Funcionalidad *
La aplicación permite invovar un servicio REST con el objetivo de testar una implementacion Spring REST + Hibernate
Permite consultar una lista de items creados en una base de datos en memoria HSQLDB

La representacion de las entidades es JSON

Ejemplo:

http:// localhost:8080/item/list
  
http:// localhost:8080/item/list?type=A


*Modo de uso:*

Para ejecutar la aplicación usando Spring Boot

mvn clean spring-boot:run

Para ejecutar test (JUnit4)

mvn test

Los test consisten en 
1) verificar que se consultan todos los items
2) sólo los filtrados por un determinado tipo 
3) obtener una lista vacía de items para un tipo inexistente
4) emular un fallo en base de datos ( HTTP 500 )




