package labservice.br.com.curso;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private Context context;
    private TextView tv_resultado;
    private Button btn_acionar;

    private ProgressBar progressBar;

    private ReceberEvento receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        context = getBaseContext();
        tv_resultado = (TextView) findViewById(R.id.tv_resultado);
        btn_acionar = (Button) findViewById(R.id.btn_iniciar);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);


        receiver = new ReceberEvento();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Constantes.EVENTO);
        filter.addCategory(Intent.CATEGORY_DEFAULT);
        registerReceiver(receiver, filter);

        btn_acionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_acionar.setEnabled(false);
                Intent mIntent = new Intent(context, ServiceContador.class);
                startService(mIntent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(receiver);
        super.onDestroy();
    }

    private class ReceberEvento extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            //Resgatando valor do servico
            int valor = intent.getIntExtra(Constantes.VALOR, 0);
            switch (valor){
                case 0:
                    break;
                case -1:
                    btn_acionar.setEnabled(true);
                    break;
                default:
                    tv_resultado.setText(String.valueOf(valor));
                    progressBar.setProgress(valor * 4);
                    break;
            }
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
