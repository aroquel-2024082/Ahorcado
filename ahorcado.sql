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
    pista3 VARCHAR(150),
    primary key PK_id_Palabra(id_Palabra)
);

DELIMITER $$
Create procedure sp_AgregarUsuario (
    in nomUsuario VARCHAR(100),
    in contra VARCHAR(100)
)
Begin
    insert into Usuario (nombreUsuario, contrasenia)
    values (nomUsuario, contra);
end$$
DELIMITER ;

CALL sp_AgregarUsuario('Fiore', '1');
CALL sp_AgregarUsuario('Belli', '2');
CALL sp_AgregarUsuario('Alan', '3');
CALL sp_AgregarUsuario('Cris', '4');
CALL sp_AgregarUsuario('Adrian', '5');
CALL sp_AgregarUsuario('Iver', '6');
CALL sp_AgregarUsuario('Sara', '7');
CALL sp_AgregarUsuario('Cavani', '8');
CALL sp_AgregarUsuario('Aura', '9');
CALL sp_AgregarUsuario('Jorge', '10');

DELIMITER $$
Create procedure sp_ListarUsuario ()
Begin
    select
        id_Usuario,
        nombreUsuario,
        contrasenia
    from Usuario;
End$$
DELIMITER ;

CALL sp_ListarUsuario();

DELIMITER $$
	Create procedure sp_AgregarPalabra (
		in palabra VARCHAR(100),
        in p1 VARCHAR(150),
        in p2 VARCHAR(150),
        in p3 VARCHAR(150)
    )
    Begin
		insert into Palabra (palabra, pista1, pista2, pista3)
			values (palabra, p1, p2, p3);
	end$$
DELIMITER ;

CALL sp_AgregarPalabra('ARGENTINA', 'Pais campeon del mundo.', 'Famoso por tomar mucho mate.', 'Nacio Messi.');
CALL sp_AgregarPalabra('ELEFANTE', 'Este animal le teme a los ratones.', 'Es un animal muy grande.', 'Es de color gris.');
CALL sp_AgregarPalabra('MARIPOSA', 'Es un insecto con alas coloridas.', 'Es pequeño y primero es una oruga.', 'Su nombre empieza por M.');
CALL sp_AgregarPalabra('DINOSAURIO', 'Es un reptil muy grande.', 'Jurasic word se trata de ellos.', 'Los extinguio un metiorito.');
CALL sp_AgregarPalabra('CHOCOLATE', 'Es rico, dulce y color cafe.', 'Se puede comor en barras o se puede beber caliente.', 'Lo vende la marca Hershey.');
CALL sp_AgregarPalabra('CLASHROYALE', 'Juego de dispositivos moviles.', 'Se trata de tirar torres.', 'Empieza con la letra C.');
CALL sp_AgregarPalabra('GUATEMALA', 'Pais de america central.', 'Un centro turistico es el gran jaguar.', 'Su ave nacional es el Quetzal.');
CALL sp_AgregarPalabra('MURCIELAGO', 'Es el unico mamifero que vuela.', 'Duerme de cabeza.', 'Dicen que es un vampiro.');
CALL sp_AgregarPalabra('OCELOTE', 'Es un felino manchado.', 'Habita en America y es un animal nocturno.', 'Su nombre comienza con O.');
CALL sp_AgregarPalabra('BICICLETA', 'Es un vehiculo de dos ruedas.', 'Se impulsa pedaleando.', 'La mayoria usa casco por seguridad.');
CALL sp_AgregarPalabra('Electroencefalografista', 'nada', 'nada', 'nada');



DELIMITER $$
	Create procedure sp_ListarPalabra ()
    Begin
		select
			id_Palabra,
            palabra,
            pista1,
            pista2,
            pista3
            from Palabra;
    End$$
DELIMITER ;
CALL sp_ListarPalabra();


-- Trigger y Funcion
