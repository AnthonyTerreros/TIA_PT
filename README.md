# Prueba Técnica TIA S.A. - Gestión y Control de Ventas de Locales.

Nombre: David Terreros

## 🛠️ Sistema de Gestión de Ventas

Este proyecto consiste en una aplicación **Full-Stack** desarrollada con **React 18 (Vite)** en el frontend y **Spring Boot 3.4.3 con Java 21 (Amazon Corretto)** en el backend, utilizando **PostgreSQL** como base de datos.

## Tecnologías

### Frontend

- React
- Axios
- TailwindCSS
- ShadCN
- React Router

### Backend

- Spring Boot
- Hibernete
- JPA
- Postgres

## Configuración

---

### **Requisitos Previos**

Antes de desplegar el proyecto, asegúrate de tener instalados:

- **Docker** y **Docker Compose** ([Guía de instalación](https://docs.docker.com/get-docker/))
- **Node.js 20+** y **npm** ([Descargar Node.js](https://nodejs.org/))
- **Java 21 (Amazon Corretto)** ([Descargar Corretto](https://aws.amazon.com/es/corretto/))
- **Maven 3.8+** ([Descargar Maven](https://maven.apache.org/))

---

### ** Configuración del Backend (Spring Boot)**

### **Configuración de la Base de Datos**

El backend usa **PostgreSQL**, asegúrate de que la configuración en `application.properties` es correcta:

```properties
spring.application.name=backend_prueba_tecnica_tia
spring.datasource.url=jdbc:postgresql://localhost:5432/DBTIAPTGestionVentas
spring.datasource.username=<TU_USUSARIO>
spring.datasource.password=<TU_PASSWORD>
spring.datasource.driver-class-name=org.postgresql.Driver


spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

> Note: Asegúrate que el nombre de la DB que creaste sea el mismo que está en el application.properties, en este caso `DBTIAPTGestionVentas`.

### **Compilar y Ejecutar el Backend**

Una vez configurado las propiedades de la aplicacion, debes ejecutar los siguientes comandos:

```sh
# Compilar el proyecto con Maven
mvn clean package


# Ejecutar el backend
java -jar target/backend_prueba_tecnica_tia-0.0.1-SNAPSHOT.jar
```

### ** Configuración del Frontend (React)**

### **Configuración de Variables de Entorno **

En la carpeta frontend, crea un archivo copia y pega el archivo .env.example, y renombralo como .env y agrega:

```env
VITE_URL_BACKEND=http://localhost:8080/api/v1
```

### **Instalar Dependencias y Ejecutar **

Ejecuta los siguientes comandos en la carpeta frontend:

```sh
# Instalar dependencias
npm install


# Iniciar el frontend en modo desarrollo
npm run dev
```

El frontend estará disponible en:
`http://localhost:5173`

## Desplegar con Docker

Ejecuta:

```sh
docker compose up -d


```

Esto iniciará:

- PostgreSQL en el puerto 5432 con persistencia de datos.
- Spring Boot en el puerto 8080.
- React (Vite) en el puerto 5173.

### Detener Contenedores

Para detener y eliminar los contenedores ejecuta:

```sh
docker compose down
```
