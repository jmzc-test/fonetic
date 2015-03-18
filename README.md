Test Spring REST 

* Funcionalidad
* 
La aplicación permite invovar un servicio REST (HTTP/JSON)con el objetivo de testear una implementacion Spring REST + Hibernate

Permite consultar una lista de items creados en una base de datos en memoria HSQLDB
Los items se crean a partir de un fichero import.sql en el momento de arrancar la aplicación


*Modo de uso:


Para ejecutar la aplicación usando Spring Boot

<i>mvn clean spring-boot:run</i>

Para ejecutar test (JUnit4)

mvn test

Los test consisten en 
1) verificar que se consultan todos los items
2) sólo los filtrados por un determinado tipo 
3) obtener una lista vacía de items para un tipo inexistente
4) emular un fallo en base de datos ( HTTP 500 )

Tambien se puede invocar directamente

Ejemplo:

http:// localhost:8080/item/list
http:// localhost:8080/item/list?type=A






