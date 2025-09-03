package Modelo;

public class Palabra {
    int id_Palabra;
    String palabra;
    String pista;

    public Palabra() {
    }

    public Palabra(int id_Palabra, String palabra, String pista) {
        this.id_Palabra = id_Palabra;
        this.palabra = palabra;
        this.pista = pista;
    }

    public int getId_Palabra() {
        return id_Palabra;
    }

    public void setId_Palabra(int id_Palabra) {
        this.id_Palabra = id_Palabra;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getPista() {
        return pista;
    }

    public void setPista(String pista) {
        this.pista = pista;
    }

    @Override
    public String toString() {
        return "Palabra{" + "id_Palabra=" + id_Palabra + ", palabra=" + palabra + ", pista=" + pista + '}';
    }
    
    
}
