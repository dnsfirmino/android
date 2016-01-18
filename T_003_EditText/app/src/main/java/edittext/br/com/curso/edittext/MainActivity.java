package edittext.br.com.curso.edittext;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;


public class MainActivity extends Activity {

    private EditText et_nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        //
        inicializarVariavel();
        inicializaAcao();
    }

    //Ligacao entre os ids da interface ao Java
    private void inicializarVariavel() {
        et_nome = (EditText) findViewById(R.id.et_nome);
        et_nome.setText("Denis");

        //Pega o valor do edit text
        String texto = et_nome.getText().toString();

        //
        et_nome.requestFocus();
    }

    //
    private void inicializaAcao() {

    }
}
