CREATE TABLE SANCIONES (
    idSancion INT AUTO_INCREMENT PRIMARY KEY,
    fechaInicio DATE,
    fechaFin DATE,
    motivo TEXT,
    idUsuario INT,
    CONSTRAINT fk_sancion_usuario FOREIGN KEY (idUsuario) REFERENCES USUARIOS(idUsuario)
);