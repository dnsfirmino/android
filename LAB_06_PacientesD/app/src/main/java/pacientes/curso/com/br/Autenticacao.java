package pacientes.curso.com.br;

import org.json.JSONObject;

/**
 * Created by no3511 on 23/10/2015.
 */
public class Autenticacao {
    private String user;
    private String pwd;
    private int pacientes;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getPacientes() {
        return pacientes;
    }

    public void setPacientes(int pacientes) {
        this.pacientes = pacientes;
    }

    //Reescreve os dados do objeto em JSON
    public JSONObject toJSONObject(){
        try{
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("user", user);
            jsonObject.put("pwd", pwd);
            jsonObject.put("pacientes", pacientes);

            return jsonObject;
        }catch (Exception e){
            return null;
        }
    }
}
