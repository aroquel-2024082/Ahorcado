package Modelo;

public class Palabra {
    int id_Palabra;
    String palabra;
    String pista1;
    String pista2;

    public Palabra() {
    }

    public Palabra(int id_Palabra, String palabra, String pista1, String pista2) {
        this.id_Palabra = id_Palabra;
        this.palabra = palabra;
        this.pista1 = pista1;
        this.pista2 = pista2;
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

    public String getPista1() {
        return pista1;
    }

    public void setPista1(String pista1) {
        this.pista1 = pista1;
    }

    public String getPista2() {
        return pista2;
    }

    public void setPista2(String pista2) {
        this.pista2 = pista2;
    }

    @Override
    public String toString() {
        return "Palabra{" + "id_Palabra=" + id_Palabra + ", palabra=" + palabra + ", pista1=" + pista1 + ", pista2=" + pista2 + '}';
    }
    
    
}
