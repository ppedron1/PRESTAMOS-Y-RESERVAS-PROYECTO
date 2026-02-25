# Sistema de Gestión de Aulas y Préstamos de Equipos

Este proyecto es una aplicación de consola desarrollada en Java diseñada para gestionar la reserva de aulas y el préstamo de equipos tecnológicos (portátiles y tablets) en un entorno educativo. El sistema permite interactuar con una base de datos MariaDB para persistir la información y ofrece funcionalidades de exportación y análisis de datos mediante XML y XPath.

## 📁 Estructura del Proyecto
El proyecto sigue una estructura estándar de Maven:
- **src/main/java/**: Contiene el código fuente Java.
- **Modelos**: Usuario, Alumno, Profesor, Equipo, Portatil, Tablet, Aula, Reserva, Prestamo.
- **DAO (Data Access Object)**: UsuarioDAO, ReservaDAO, PrestamoDAO.
- **Servicios**: ConexionDB, ExportadorXML, AnalizadorEstadisticas.
- **Controlador Principal**: `Main.java`.
- **pom.xml**: Configuración de dependencias como `mariadb-java-client` y `slf4j-simple`.

---

# 📖 Manual de Usuario

El sistema se maneja a través de un menú interactivo por consola. Al iniciar, el usuario debe identificarse como **Alumno** o **Profesor**.

### Funcionalidades del Menú:

1.  **Alta de Alumnos**: Permite registrar nuevos alumnos en la base de datos solicitando DNI, nombre, apellido, email y número de expediente.
2.  **Ver Estado de Aulas**: Muestra un listado de las aulas indicando si su estado es **LIBRE** u **OCUPADA**.
3.  **Reservar Aula**:
    * Muestra las aulas disponibles para elegir.
    * Solicita el ID del usuario y el ID del aula.
    * Al realizar la reserva, el aula se marca automáticamente como ocupada en la base de datos.
4.  **Prestar Equipo**: Registra el préstamo de un equipo. El sistema calcula automáticamente una **fecha límite de devolución de 7 días** a partir de la fecha de salida.
5.  **Exportar a XML**: Genera los archivos físicos `reservas.xml` y `prestamos.xml` directamente desde las tablas de la base de datos.
6.  **Ver Estadísticas (XPath)**: Permite introducir una fecha (YYYY-MM-DD) para contar cuántas reservas se realizaron ese día analizando el archivo XML generado.
7.  **Informes de Actividad**: Muestra el "Top" de usuarios con más reservas y los equipos más solicitados mediante consultas SQL de agregación.
8.  **Liberar Aula**: Cambia el estado de un aula específica de vuelta a **disponible**.
9.  **Devolver Equipo**: Registra la fecha de devolución de un equipo en el sistema.

---

# 🛠️ Documentación de Clases

### 1. Entidades (Modelos)
- **Usuario (Abstracta)**: Clase base con atributos como `idUsuario`, `dni`, `nombre`, `apellido` y `email`.
    - **Alumno**: Hereda de Usuario e incluye el atributo `expediente`.
    - **Profesor**: Hereda de Usuario e incluye el atributo `departamento`.
- **Equipo (Abstracta)**: Clase base para dispositivos con `idEquipo`, `numeroMAC` y `estado`.
    - **Portatil** y **Tablet**: Especializaciones de la clase Equipo.
- **Aula**: Representa un espacio con un ID, nombre y su estado de disponibilidad.
- **Reserva**: Modela la vinculación entre un usuario, un aula y una fecha específica.
- **Prestamo**: Gestiona la información de salida, fecha límite y devolución de equipos.

### 2. Capa de Datos (DAO)
- **UsuarioDAO**: Gestiona la inserción de registros en la tabla `USUARIOS`.
- **ReservaDAO**: Implementa la lógica para realizar reservas, liberar aulas, mostrar estados y generar informes de usuarios activos.
- **PrestamoDAO**: Controla la creación de nuevos préstamos, devoluciones y estadísticas de uso de equipos.

### 3. Servicios y Configuración
- **ConexionDB**: Centraliza la configuración JDBC para la conexión a MariaDB con credenciales predefinidas.
- **ExportadorXML**: Traduce los registros de la base de datos a formato XML estándar.
- **AnalizadorEstadisticas**: Utiliza la API `javax.xml.xpath` para realizar consultas sobre los datos exportados.

### 4. Ejecución (Main)
- **Main**: Clase principal que orquestra el flujo de la aplicación, capturando la entrada del usuario mediante un `Scanner` y delegando las acciones a los DAOs y servicios correspondientes.

# Sistema de Gestión de Aulas y Préstamos de Equipos

Este proyecto es una aplicación de consola desarrollada en Java diseñada para gestionar la reserva de aulas y el préstamo de equipos tecnológicos (portátiles y tablets) en un entorno educativo. El sistema utiliza una base de datos MariaDB para la persistencia de datos y permite la exportación y análisis de información mediante XML y consultas XPath.

---

# 🛠️ Guía de Compilación y Ejecución

El proyecto está gestionado con **Maven**, lo que simplifica la gestión de dependencias y el ciclo de vida de la aplicación.

### Requisitos Previos
* **Java**: JDK 17 o superior.
* **Maven**: Instalado y configurado en el sistema.
* **Base de Datos**: Instancia de MariaDB/MySQL activa (configurada por defecto en `192.168.204.129`).

### Pasos para Compilar
Desde la raíz del proyecto, ejecuta el siguiente comando para limpiar compilaciones previas y generar los nuevos archivos `.class`:
```bash
mvn clean compile
