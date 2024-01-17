CREATE TABLE Libros_Categorias (
ISBN VARCHAR(20) REFERENCES Libros(ISBN),
Categoria_ID INT REFERENCES Categorias(Categoria_ID),
PRIMARY KEY (ISBN, Categoria_ID)
);
