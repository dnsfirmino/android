package spinner.br.com.curso;

/**
 * Created by no3511 on 01/10/2015.
 */
public class Produto {
    private long idcodigo;
    private String nome;
    private float valorVenda;

    public long getIdcodigo() {
        return idcodigo;
    }

    public void setIdcodigo(long idcodigo) {
        this.idcodigo = idcodigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
