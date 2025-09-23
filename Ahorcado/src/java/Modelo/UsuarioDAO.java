package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public Usuario validar(String nombreUsuario, String contrasenia) {
        Usuario usuario = new Usuario();
        String sql = "SELECT * FROM Usuario WHERE nombreUsuario = ? AND contrasenia = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombreUsuario);
            ps.setString(2, contrasenia);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                usuario.setId_Usuario(rs.getInt("id_Usuario"));
                usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                usuario.setConstrasenia(rs.getString("contrasenia"));
            } else {
                System.out.println("El usuario o contrasenia son incorrectos");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }
}
