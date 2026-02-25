CREATE TABLE Aulas (
    id_aula INT PRIMARY KEY AUTO_INCREMENT,
    nombre_aula VARCHAR(100) NOT NULL,
    capacidad INT,
    esta_ocupada BOOLEAN DEFAULT FALSE
);