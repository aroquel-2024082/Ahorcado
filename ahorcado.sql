drop database if exists DB_Ahorcado;
Create database DB_Ahorcado;
Use DB_Ahorcado;

Create table Usuario (
	id_Usuario Int auto_increment,
    nombreUsuario VARCHAR(100),
    contrasenia VARCHAR(100),
    primary key PK_id_Usuario(id_Usuario)
);

Create table Palabra (
	id_Palabra Int auto_increment,
    palabra VARCHAR(100),
    pista1 VARCHAR(150),
    pista2 VARCHAR(150),
    primary key PK_id_Palabra(id_Palabra)
);

insert into Usuario (nombreUsuario, contrasenia) values ('1','1');
select * from Usuario;

DELIMITER $$
	Create procedure sp_AgregarPalabra (
		in palabra VARCHAR(100),
        in p1 VARCHAR(150),
        in p2 VARCHAR(150)
    )
    Begin
		insert into Palabra (palabra, pista1, pista2)
			values (palabra, p1, p2);
	end$$
DELIMITER ;

CALL sp_AgregarPalabra('ARGENTINA', 'Pais campeon del mundo.', 'Famoso por tomar mucho mate.');
CALL sp_AgregarPalabra('ELEFANTE', 'Este animal le teme a los ratones.', 'Es un animal muy grande y gris.');
CALL sp_AgregarPalabra('MARIPOSA', 'Es un insecto con alas coloridas.', 'Es pequeño y primero es una oruga.');
CALL sp_AgregarPalabra('DINOSAURIO', 'Es un reptil muy grande.', 'Jurasic word se trata de ellos.');
CALL sp_AgregarPalabra('CHOCOLATE', 'Es rico, dulce y color cafe.', 'Se puede comor en barras o se puede beber caliente.');
CALL sp_AgregarPalabra('CLASHROYALE', 'Juego de dispositivos moviles.', 'Se trata de tirar torres y su nombre empieza con C.');
CALL sp_AgregarPalabra('GUATEMALA', 'Pais de america central.', 'Un centro turistico es el gran jaguar.');

DELIMITER $$
	Create procedure sp_ListarPalabra ()
    Begin
		select
			id_Palabra,
            palabra,
            pista1,
            pista2
            from Palabra;
    End$$
DELIMITER ;
CALL sp_ListarPalabra();