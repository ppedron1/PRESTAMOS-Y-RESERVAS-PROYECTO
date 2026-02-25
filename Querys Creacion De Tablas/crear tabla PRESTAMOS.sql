CREATE TABLE PRESTAMOS (
    idPrestamo INT AUTO_INCREMENT PRIMARY KEY,
    fechaSalida DATETIME,
    fechaLimite DATETIME,
    fechaDevolucion DATETIME NULL,
    idUsuario INT,
    idEquipo INT,
    CONSTRAINT fk_prestamo_usuario FOREIGN KEY (idUsuario) REFERENCES USUARIOS(idUsuario),
    CONSTRAINT fk_prestamo_equipo FOREIGN KEY (idEquipo) REFERENCES EQUIPOS(idEquipo)
);