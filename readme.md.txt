# Sistema de Calificaciones

Sistema de gestión de calificaciones desarrollado con Spring Boot para el backend y frontend.

## Estructura del Proyecto

- `calificaciones-backend/`: API REST con autenticación JWT
- `calificaciones-frontend/`: Interfaz de usuario con Spring Boot y Thymeleaf

## Requisitos

- Java 17
- Maven
- PostgreSQL
- Node.js (opcional, para desarrollo frontend)

## Configuración

### Backend

1. Configura la base de datos PostgreSQL en `application.yml`:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/tu_base_de_datos
    username: tu_usuario
    password: tu_contraseña
```

2. Ejecuta el backend:
```bash
cd calificaciones-backend
mvn spring-boot:run
```

El backend estará disponible en `http://localhost:8081`

### Frontend

1. Configura la URL del backend en `application.yml`:
```yaml
api:
  url: http://localhost:8081
```

2. Ejecuta el frontend:
```bash
cd calificaciones-frontend
mvn spring-boot:run
```

El frontend estará disponible en `http://localhost:8082`

## Características

- Autenticación JWT
- Gestión de alumnos
- Gestión de materias
- Interfaz de usuario intuitiva

## Usuarios por defecto

- Usuario: profesor3
- Contraseña: 123456

## Documentación API

- POST /auth/signin - Login
- POST /auth/signup - Registro
- GET /api/alumnos - Listar alumnos
- POST /api/alumnos - Crear alumno
- POST /api/materias - Crear materia

## Tecnologías

- Spring Boot
- Spring Security
- JWT
- PostgreSQL
- Thymeleaf
- Bootstrap 5

## Desarrollo

1. Clona el repositorio
2. Configura las bases de datos
3. Ejecuta ambos proyectos
4. Accede desde el navegador

## Contribuir

1. Fork el proyecto
2. Crea una rama para tu feature
3. Commit tus cambios
4. Push a la rama
5. Crea un Pull Request

## Licencia

[MIT](https://choosealicense.com/licenses/mit/)
