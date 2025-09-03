drop database if exists DB_Ahorcado;
Create database DB_Ahorcado;
Use DB_Ahorcado;

Create table Usuario (
	id_Usuario Int auto_increment,
    nombreUsuario VARCHAR(100),
    contrasenia VARCHAR(100),
    primary key PK_id_Usuario(id_Usuario)
);

insert into Usuario (nombreUsuario, contrasenia) values ('1','1');
select * from Usuario;

Create table Palabra (
	id_Palabra Int auto_increment,
    palabra VARCHAR(100),
    pista VARCHAR(150),
    primary key PK_id_Palabra(id_Palabra)
);

DELIMITER $$
	Create procedure sp_AgregarPalabra (
		in palabra VARCHAR(100),
        in pista VARCHAR(150)
    )
    Begin
		insert into Palabra (palabra, pista)
			values (palabra, pista);
	end$$
DELIMITER ;
 
CALL sp_AgregarPalabra('PYTHON','Es un lenguaje de programación muy popular para el desarrollo web y la ciencia de datos.');
CALL sp_AgregarPalabra('HTML','Es la base de cualquier página web.');
CALL sp_AgregarPalabra('JAVASCRIPT','Es el lenguaje que hace que las páginas web sean interactivas.');
CALL sp_AgregarPalabra('CSS','Este lenguaje se usa para estilizar una página web.');
CALL sp_AgregarPalabra('AJAX','Permite actualizar partes de una página web sin recargarla.');
CALL sp_AgregarPalabra('DATABASE','Es un sistema que almacena y organiza datos.');

DELIMITER $$
	Create procedure sp_ListarPalabra ()
    Begin
		select
			id_Palabra,
            palabra,
            pista
            from Palabra;
    End$$
DELIMITER ;
CALL sp_ListarPalabra();