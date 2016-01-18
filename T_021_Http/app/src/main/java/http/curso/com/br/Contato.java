package http.curso.com.br;

/**
 * Created by no3511 on 22/10/2015.
 */
public class Contato {
    private int idcontato;
    private String nome;

    public int getIdcontato() {
        return idcontato;
    }

    public void setIdcontato(int idcontato) {
        this.idcontato = idcontato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
