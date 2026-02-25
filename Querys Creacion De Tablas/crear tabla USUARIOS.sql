CREATE TABLE USUARIOS (
    idUsuario INT AUTO_INCREMENT PRIMARY KEY,
    DNI VARCHAR(15) UNIQUE NOT NULL,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    email VARCHAR(100),
    idTipo INT,
    exp VARCHAR(50),
    dep VARCHAR(50),
    CONSTRAINT fk_usuario_tipo FOREIGN KEY (idTipo) REFERENCES TIPOUSUARIO(idTipoUsuario)
);