package multitelas.br.com.curso;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.StringCharacterIterator;


public class SegundaTela extends AppCompatActivity {
    private  Context context;

    private TextView tv_valor_recebido;
    private Button btn_devolver_valor;

    private int tipo;
    private int valor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_tela);

        inicializaVariavel();
        inicializaAcao();

    }

    private void inicializaVariavel() {
        context = getBaseContext();
        tv_valor_recebido = (TextView) findViewById(R.id.segundatela_tv_valor_recebido);
        btn_devolver_valor = (Button) findViewById(R.id.segundatela_btn_devolver);

        tipo = getIntent().getIntExtra(Constantes.TIPO, -1);
        valor = getIntent().getIntExtra(Constantes.VALOR, -1);

        tv_valor_recebido.setText(String.valueOf(valor));
    }

    private void inicializaAcao() {
        btn_devolver_valor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tipo == 1) {
                    int novo_valor = valor + 15;
                    Intent mIntent = new Intent();
                    mIntent.putExtra(Constantes.VALOR_RETORNO, novo_valor);
                    setResult(RESULT_OK, mIntent);
                    finish();
                }
            }
        });
    }

    //Quando o usuário clicar no botao voltar do aparelho
    @Override
    public void onBackPressed() {
        if(tipo == 0) {
            Intent mIntent = new Intent(context, MainActivity.class);
            startActivity(mIntent);
        }

        //Encerra a tela
        super.onBackPressed();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_segunda_tela, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
