CREATE TABLE RESERVAS (
    idReserva INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATETIME,
    idUsuario INT,
    idAula INT,
    CONSTRAINT fk_reserva_usuario FOREIGN KEY (idUsuario) REFERENCES USUARIOS(idUsuario),
    CONSTRAINT fk_reserva_aula FOREIGN KEY (idAula) REFERENCES AULAS(idAula)
);