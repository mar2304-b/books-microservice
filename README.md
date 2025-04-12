# 📚 Microservicio de Gestión de Libros

Este proyecto consiste en un microservicio desarrollado con **Spring Boot** que implementa un CRUD (Crear, Leer, Actualizar, Eliminar) para la gestión de una entidad de libros. El microservicio ha sido contenerizado con **Docker**, orquestado con **Docker Compose**, y cuenta con pruebas unitarias e integración, así como una colección de pruebas en **Postman**.

## 🚀 Tecnologías Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- MariaDB
- Docker & Docker Compose
- JUnit + Mockito
- JaCoCo
- Postman

## 🧱 Arquitectura del Proyecto

- **Controladores:** Endpoints REST para interactuar con la API.
- **Servicios:** Lógica de negocio.
- **DAO (Repository):** Acceso a datos usando Spring Data JPA.
- **Base de Datos:** MariaDB en contenedor Docker.
- **Persistencia:** Volumen Docker para mantener datos.

## 🔧 Configuración

### 1. Variables de entorno

En el archivo `application.properties` se encuentra configurada la conexión a MariaDB:

```properties
spring.datasource.url=jdbc:mariadb://db:3306/librosdb
spring.datasource.username=root
spring.datasource.password=tu_password
