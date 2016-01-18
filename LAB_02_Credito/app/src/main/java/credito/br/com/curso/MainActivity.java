package credito.br.com.curso;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    private EditText et_nome;
    private EditText et_idade;
    private CheckBox cb_cidadesp;
    private Button btn_calcular;
    private TextView tv_titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        inicilizaVariavel();
        inicializaAcao();
    }

    private void inicilizaVariavel() {
        //context = getBaseContext();

        //
        et_nome         = (EditText) findViewById(R.id.telainicial_et_nome);
        et_idade        = (EditText) findViewById(R.id.telainicial_et_idade);
        cb_cidadesp     = (CheckBox) findViewById(R.id.telainicial_cb_cidadesp);
        btn_calcular    = (Button) findViewById(R.id.telainicial_btn_calcular);
        tv_titulo       = (TextView) findViewById(R.id.telainicial_tv_titulo);
    }

    private void inicializaAcao() {
        //
        final String nome = et_nome.getText().toString().trim();

        final int idade = conversao(et_idade.getText().toString().trim());

        //
        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Verifica os campos estão preeenchidos
                if (nome.length() == 0){
                    //
                    Toast.makeText(getBaseContext(),"Erro: Campo nome é obrigatório!", Toast.LENGTH_SHORT).show();
                }

                if (idade == 0){
                    Toast.makeText(getBaseContext(),"Erro: Campo idade é obrigatória", Toast.LENGTH_SHORT).show();
                }

                //Calcula Crédito
                if (cb_cidadesp.isChecked()){
                    if (idade >= 25){
                        tv_titulo.setText("Crédito de R$ 5000");
                    }else{
                        tv_titulo.setText("Crédito de R$ 1000");
                    }
                }else{
                    if (idade > 25 ){
                        tv_titulo.setText("Crédito de R$ 500");
                    }
                }
            }
        });
    }

    private int conversao(String s) {
        try{
            return Integer.parseInt(s);
        } catch (Exception e){
            return 0;
        }
    }
}
