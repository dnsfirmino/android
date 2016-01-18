package http.curso.com.br;

import android.content.Context;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private Context context;
    private Button btn_ws;
    private ListView lv_contatos;
    private ArrayList<Contato> retorno_ws;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        inicializarVariavel();
        inicializarAcao();

    }

    private void inicializarVariavel() {
        context = getBaseContext();

        btn_ws = (Button) findViewById(R.id.btn_ws);
        lv_contatos = (ListView) findViewById(R.id.lv_contatos);
    }

    private void inicializarAcao() {
        btn_ws.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Sincronismo().execute();
            }
        });
    }

    private class Sincronismo extends AsyncTask<Void, Integer, Void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            btn_ws.setEnabled(false);
        }

        @Override
        protected Void doInBackground(Void... params) {
            //Ferramenta de teste remover no programa final não usar isso
            //StrictMode.ThreadPolicy strictModeThreadPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            //StrictMode.setThreadPolicy(strictModeThreadPolicy);

            ArrayList<Contato> contatos = new ArrayList<>();
            Contato cAux  = new Contato();
            cAux.setIdcontato(1);
            cAux.setNome("Hugo");

            Contato cAux2  = new Contato();
            cAux2.setIdcontato(2);
            cAux2.setNome("Denis");

            Contato cAux3  = new Contato();
            cAux3.setIdcontato(3);
            cAux3.setNome("Nataly");

            contatos.add(cAux);
            contatos.add(cAux2);
            contatos.add(cAux3);

            Transmissao tr_env = new Transmissao();
            tr_env.setContatos(contatos);

            Gson gson = new Gson();
            Transmissao tr_rec = gson.fromJson(Util.comunicacao("http://nmsystems.com.br/testecarga.php", gson.toJson(tr_env)),
                    Transmissao.class);

            retorno_ws = tr_rec.getContatos();

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            lv_contatos.setAdapter(new ArrayAdapter<Contato>(context, android.R.layout.simple_expandable_list_item_1,
                                                            retorno_ws));
            btn_ws.setEnabled(true);
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
