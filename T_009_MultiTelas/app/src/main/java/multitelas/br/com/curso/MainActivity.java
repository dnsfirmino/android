package multitelas.br.com.curso;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Context context;

    private Button btn_cs;
    private Button btn_cr;
    private Button btn_telefone;

    private TextView tv_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        inicializaVariavel();
        inicializaAcao();
    }

    private void inicializaVariavel() {
        context = getBaseContext();

        btn_cr = (Button) findViewById(R.id.telainicial_btn_cr);
        btn_cs = (Button) findViewById(R.id.telainicial_btn_cs);
        btn_telefone = (Button) findViewById(R.id.telainicial_btn_telefone);

        tv_resultado = (TextView) findViewById(R.id.telainicial_tv_resultado);
    }

    private void inicializaAcao() {

        //Acao do botao cs
        btn_cs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chamado a tela
                Intent mIntent = new Intent(context,SegundaTela.class);

                //Passando valor para segunda tela
                //mIntent.putExtra("valor", 5); //este caso pode ocorrer erro

                //Passando valor para segunda tela
                mIntent.putExtra(Constantes.TIPO, 0);
                mIntent.putExtra(Constantes.VALOR, 5);

                //chamando a tela
                startActivity(mIntent);

                //encerrando a tela inicial somente faca isso se nao for mais usar
                finish();
            }
        });

        //Acao do botao cr
        btn_cr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chamado a tela
                Intent mIntent = new Intent(context,SegundaTela.class);

                //Passando valor para segunda tela
                mIntent.putExtra(Constantes.TIPO, 1);
                mIntent.putExtra(Constantes.VALOR, 5);

                //chamando a tela
                startActivityForResult(mIntent, 0);
            }
        });

        btn_telefone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_CALL);
                mIntent.setData(Uri.parse("tel:" + "888888888"));
                startActivity(mIntent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 0:
                if (resultCode == RESULT_OK){
                    String resposta = String.valueOf(data.getIntExtra(Constantes.VALOR_RETORNO, -1));
                    tv_resultado.setText(resposta);
                }else{
                    tv_resultado.setText("Cancelado");
                }
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
