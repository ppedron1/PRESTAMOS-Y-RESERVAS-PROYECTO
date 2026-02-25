Sistema de Gestión de Aulas y Préstamos de Equipos
Este proyecto es una aplicación de consola desarrollada en Java diseñada para gestionar la reserva de aulas y el préstamo de equipos tecnológicos (portátiles y tablets) en un entorno educativo. El sistema permite interactuar con una base de datos MariaDB para persistir la información y ofrece funcionalidades de exportación y análisis de datos mediante XML y XPath.

📁 Estructura del Proyecto
El proyecto sigue una estructura estándar de Maven:

src/main/java/: Contiene el código fuente Java.

Modelos: Usuario, Alumno, Profesor, Equipo, Portatil, Tablet, Aula, Reserva, Prestamo.

DAO (Data Access Object): UsuarioDAO, ReservaDAO, PrestamoDAO (Gestión de base de datos).

Servicios: ConexionDB, ExportadorXML, AnalizadorEstadisticas.

Controlador Principal: Main.java.

pom.xml: Configuración de dependencias (MariaDB Driver, SLF4J).

Archivos de Datos: reservas.xml, prestamos.xml (Generados automáticamente).

🚀 Funcionalidades Principales
El sistema ofrece un menú interactivo con las siguientes opciones:

Alta de Alumnos: Registro de nuevos usuarios en la base de datos.

Gestión de Aulas:

Visualización del estado de las aulas (Libre/Ocupada).

Realización de reservas, lo que marca automáticamente el aula como no disponible.

Liberación de aulas para que vuelvan a estar disponibles.

Gestión de Equipos:

Préstamo de equipos con cálculo automático de fecha límite (7 días).

Devolución de equipos.

Exportación y Análisis:

Exportación XML: Genera archivos físicos con el historial de préstamos y reservas directamente desde la BD.

Estadísticas XPath: Analiza los archivos XML generados para contar reservas por fechas específicas utilizando consultas XPath.

Informes de Actividad: Muestra los usuarios más activos y los equipos más solicitados mediante consultas de agregación SQL.

🛠️ Requisitos Técnicos
Java: JDK 17 o superior.

Base de Datos: MariaDB/MySQL.

Configurada por defecto en: 192.168.204.129:3306/DEBIANDB.

Credenciales: Usuario pablo / Contraseña pablo.

Dependencias Maven: mariadb-java-client y slf4j-simple.

🔧 Configuración e Instalación
Base de Datos: Asegúrate de tener una instancia de MariaDB con las tablas USUARIOS, AULAS, RESERVAS y PRESTAMOS.

Conexión: Si tu base de datos no está en la IP por defecto, modifica la clase ConexionDB.java.

Compilación:

Bash
mvn clean compile
Ejecución:

Bash
mvn exec:java -Dexec.mainClass="Main"
