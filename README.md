# Proyecto: Reportes Inmobiliarios - API

## Descripción
Esta es una API RESTful desarrollada en Java utilizando Spring Boot que permite gestionar proyectos inmobiliarios. La API proporciona funcionalidades para registrar usuarios, autenticarse y realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre proyectos inmobiliarios.

## Tecnologías Utilizadas
- **Java 17+**
- **Spring Boot 3.3.3**
- **Spring Security** (JWT para autenticación)
- **PostgreSQL** (Base de datos relacional)
- **JPA/Hibernate** (ORM)
- **Maven** (Gestor de dependencias)

## Requisitos Previos
Antes de ejecutar este proyecto, asegúrate de tener instalados los siguientes componentes:
- **JDK 17** o superior
- **Maven 3.8+**
- **PostgreSQL** o cualquier otra base de datos compatible

## Instalación y Configuración

### 1. Crear la base de datos PostgreSQL:

Crea una base de datos PostgreSQL llamada `reportes_inmobiliaria`:
```sql
CREATE DATABASE reportes_inmobiliaria;
```

### 2. Modificar el archivo `application.properties`:

Modifica el archivo `application.properties` para reflejar la configuración de tu base de datos:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/reportes_inmobiliaria
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
```

### 3. Compilar y ejecutar la aplicación:

Ejecuta el siguiente comando para compilar y ejecutar la aplicación:

```bash
mvn spring-boot:run
```

### Endpoints de la API

### Autenticación

#### Registrar Usuario
- **POST** `/api/auth/register`
- **Body** (JSON):
  ```json
  {
    "username": "usuario2",
    "password": "password123"
  }
Descripción: Crea un nuevo usuario con el rol USER.

#### Login
- **POST** `/api/login`
- **Body** (JSON):
  ```json
  {
    "username": "admin",
    "password": "admin123"
  }
Descripción: Autentica un usuario y devuelve un token JWT.

### Proyectos Inmobiliarios

#### Obtener todos los proyectos
- **GET** `/api/proyectos`
- **Autenticación:** Bearer Token
- **Descripción:** Devuelve una lista de todos los proyectos.

#### Obtener un proyecto por ID
- **GET** `/api/proyectos/{id}`
- **Autenticación:** Bearer Token
- **Ejemplo:**
  ```bash
  GET http://localhost:8080/api/proyectos/5
  ```

#### Crear un nuevo proyecto
- **POST** `/api/proyectos`
- **Autenticación:** Bearer Token (Rol ADMIN)
- **Body** (JSON):
  ```json
  {
    "nombre": "nuevo proyecto",
    "descripcion": "casas",
    "direccion": "Calle Nueva 123",
    "precio": 15000,
    "vendedor": "sebastian"
  }
  ```
#### Actualizar un proyecto existente
- **PUT** `/api/proyectos/{id}`
- **Autenticación:** Bearer Token (Rol ADMIN)
- **Body** (JSON):
  ```json
  {
    "nombre": "nuevo proyecto actualizado",
    "descripcion": "casas",
    "direccion": "Calle Nueva 123",
    "precio": 15000,
    "vendedor": "sebastian"
  }
  ```

#### Eliminar un proyecto
- **DELETE** `/api/proyectos/{id}`
- **Autenticación:** Bearer Token (Rol ADMIN)
- **Descripción:** Elimina un proyecto por su ID.


### Seguridad
Esta API utiliza **JWT (JSON Web Tokens)** para la autenticación. Para acceder a los endpoints protegidos, el cliente debe incluir un token JWT en el encabezado de la solicitud.

#### Autenticación Bearer Token:
```bash
Authorization: Bearer <token>
```

### Dependencias Importantes
- **Spring Boot Starter Web:** Para construir la API REST.
- **Spring Boot Starter Security:** Para la gestión de usuarios y autenticación con JWT.
- **Spring Boot Starter Data JPA:** Para la interacción con la base de datos mediante JPA.
- **PostgreSQL Driver:** Para conectarse a una base de datos PostgreSQL.
- **jjwt:** Librería para manejar JWT.


### Ejemplo de Archivo `application.properties`
```properties
spring.application.name=reportes_inmobiliaria
spring.datasource.url=jdbc:postgresql://localhost:5432/reportes_inmobiliaria
spring.datasource.username=postgres
spring.datasource.password=clave
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```
### Licencia
Este proyecto está bajo la licencia MIT. Ver [LICENSE](LICENSE) para más detalles.




