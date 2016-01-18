package buttoninterface.br.com.curso;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {
    private Context context;
    //
    private Button btn_01;
    private Button btn_02;
    private Button btn_03;
    private Button btn_04;

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
        //
        btn_01 = (Button) findViewById(R.id.btn_01);
        btn_02 = (Button) findViewById(R.id.btn_02);
        btn_03 = (Button) findViewById(R.id.btn_03);
        btn_04 = (Button) findViewById(R.id.btn_04);
    }

    private void inicializarAcao() {
        btn_01.setOnClickListener(HugoListener);
        btn_02.setOnClickListener(HugoListener);
        btn_03.setOnClickListener(HugoListener);
        btn_04.setOnClickListener(HugoListener);
    }

    private View.OnClickListener HugoListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.btn_01:
                    mensagem = "Button 01";
                    break;
                case R.id.btn_02:
                    mensagem = "Button 02";
                    break;
                case R.id.btn_03:
                    mensagem = "Button 03";
                    break;
                case R.id.btn_04:
                    mensagem = "Button 04";
                    break;
                default:
                    mensagem = "Indefinido";
            }
            Toast.makeText(getBaseContext(),mensagem, Toast.LENGTH_LONG).show();
        }
    };
};