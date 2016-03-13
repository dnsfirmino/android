package dnsystem.com.br.recyclerview;

/**
 * Created by dnsfirmino on 24/02/16.
 */
public class Carros {
    private String modelo;
    private String marca;
    private int foto;

    public Carros(){};

    public Carros(String modelo, String marca, int foto) {
        this.modelo = modelo;
        this.marca = marca;
        this.foto = foto;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
