package login.br.com.curso;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

    private Context context;

    private EditText et_usuario;
    private EditText et_senha;

    private Button btn_conectar;
    private Button btn_cancelar;

    private String mensagem = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        //
        inicializarVariavel();
        inicializarAcao();
    }

    private void inicializarVariavel() {
        context = getBaseContext();

        et_usuario = (EditText) findViewById(R.id.et_nome);
        et_senha = (EditText) findViewById(R.id.et_senha);

        btn_conectar = (Button) findViewById(R.id.btn_conectar);
        btn_cancelar = (Button) findViewById(R.id.btn_cancelar);
    }

    private void inicializarAcao() {
        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_conectar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validacao()){
                    mensagem = "Login Válido";
                }
                //
                Toast.makeText(context,mensagem,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validacao() {

        //
        mensagem = "";

        //
        String nome = et_usuario.getText().toString().trim();
        String senha = et_senha.getText().toString().trim();

        //
        if (nome.length() == 0){
            mensagem = "Erro: Nome é obrigatório";
            return false;
        }

        //
        if (senha.length() == 0){
            mensagem = "Erro: Senha é obrigatória";
            return false;
        }

        //
        if (!nome.equalsIgnoreCase("Hugo") || !senha.equals("T123")){
            mensagem = "Erro: Usuário ou Senha incorreta!";
            return false;
        }

        //
        return true;
    }
}
