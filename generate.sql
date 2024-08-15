create database bside;

CREATE TABLE Alumno (
    matricula SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    fecha_nacimiento DATE,
    email VARCHAR(255),
    telefono VARCHAR(15),
    direccion VARCHAR(255),
    fecha_inscripcion DATE
);

commit;