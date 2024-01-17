CREATE TABLE Prestamos (
Prestamo_ID INT PRIMARY KEY,
Fecha_Prestamo DATE,
Fecha_Devolucion_Esperada DATE,
ISBN VARCHAR(20) REFERENCES Libros(ISBN),
Lector_ID INT
);
