package json.curso.com.br;

import android.content.Context;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by no3511 on 21/10/2015.
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

    //Reescreve os dados do objeto em JSON
    public JSONObject toJSONObject(){
        try{
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("idcontato", idcontato);
            jsonObject.put("nome", nome);

            return jsonObject;
        }catch (Exception e){
            return null;
        }
    }
}
