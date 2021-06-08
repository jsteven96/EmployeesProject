# Employees Technical Knowledge Test
Proyecto hecho en Java/Springboot como parte de un ejercicio práctico de creación de API, usando una base de datos H2 (En memoria).

## Descarga
Para descargar el código fuente del proyecto utilizar el comando
```bash
git clone https://github.com/jsteven96/EmployeesProject.git
```
## Construcción y ejecución
Para poder construir el proyecto dirígete a la ruta en la que se encuentre el archivo pom.xml y, utilizando Maven, ejecuta el comando
```bash
mvn clean install
```
Por último ejecuta el JAR generado con el comando
```bash
java -jar EmployeesProject
```
## Documentación del API
Dentro del proyecto se encuentra configurado Swagger UI, de forma que se puede visualizar la documentación del API a través del siguiente enlace ```http://localhost:8083/swagger-ui/index.html``` allí se puede encontrar las definiciones de las operaciones disponibles, los esquemas utilizados y se pueden realizar diferentes pruebas.