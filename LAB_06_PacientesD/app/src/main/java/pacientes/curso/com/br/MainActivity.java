package pacientes.curso.com.br;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private Context context;
    private Button btn_sincronizar;
    private ListView lv_pacientes;
    private ArrayList<Paciente> arrayListPacientes_ws;
    private Adapter adapter_pacientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        inicializaVariavel();
        inicializaAcao();
    }

    private void inicializaVariavel() {
        context = getBaseContext();
        btn_sincronizar = (Button) findViewById(R.id.btn_sincronizar);
        lv_pacientes = (ListView) findViewById(R.id.lv_pacientes);
    }

    private void inicializaAcao() {
        btn_sincronizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Sincronismo().execute();
            }
        });
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

    private class Sincronismo extends AsyncTask <Void, Integer, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            btn_sincronizar.setEnabled(false);
        }

        @Override
        protected Void doInBackground(Void... params) {
            Gson gson = new Gson();

            //
            ArrayList<JSONObject> pacientes = new ArrayList<>();
            Autenticacao Aaux = new Autenticacao();
            Aaux.setUser("Hugo");
            Aaux.setPwd("698dc19d489c4e4db73e28a713eab07b");
            Aaux.setPacientes(20);


            //
            Transmissao tr_envio = new Transmissao();
            tr_envio.setPacientes(pacientes);

            //
            Transmissao tr_recebimento = gson.fromJson(Util.comunicacao("http://nmsystems.com.br/testecargapaciente.php",
                            gson.toJson(tr_envio)),Transmissao.class);

            retorno_ws = tr_recebimento.getPacientes();

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            btn_sincronizar.setEnabled(true);
        }
    }
}
