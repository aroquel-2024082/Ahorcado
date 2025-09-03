package Modelo;

public class Usuario {
    int id_Usuario;
    String nombreUsuario;
    String constrasenia;

    public Usuario() {
    }

    public Usuario(int id_Usuario, String nombreUsuario, String constrasenia) {
        this.id_Usuario = id_Usuario;
        this.nombreUsuario = nombreUsuario;
        this.constrasenia = constrasenia;
    }

    public int getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getConstrasenia() {
        return constrasenia;
    }

    public void setConstrasenia(String constrasenia) {
        this.constrasenia = constrasenia;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_Usuario=" + id_Usuario + ", nombreUsuario=" + nombreUsuario + ", constrasenia=" + constrasenia + '}';
    }
    
    
}
