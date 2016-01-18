package json.curso.com.br;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private Context context;
    private Button btn_gravar_json;
    private Button btn_ler_json;
    private Button btn_gravar_gson;
    private Button btn_ler_gson;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        inicializarVariavel();
        inicializarAcao();
    }

    private void inicializarVariavel() {
        btn_gravar_json     = (Button) findViewById(R.id.btn_gravar_json);
        btn_ler_json        = (Button) findViewById(R.id.btn_ler_json);
        btn_gravar_gson     = (Button) findViewById(R.id.btn_gravar_gson);
        btn_ler_gson        = (Button) findViewById(R.id.btn_ler_gson);
    }

    private void inicializarAcao() {
        btn_gravar_json.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    JSONArray jsonArray = new JSONArray(gerarContatos(20));
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("contatos", jsonArray);

                    String resultado = jsonObject.toString();
                    int i = 10;

                }catch (Exception e){
                    String resultado = e.toString();
                }
            }
        });

        btn_ler_json.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder sb = new StringBuilder();

                try {
                    JSONObject jsonObject = new JSONObject(ToolBox.readFile(R.raw.dados, context));
                    JSONArray jsonArray = jsonObject.getJSONArray("contatos");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jAux = (JSONObject) jsonArray.get(i);
                        Contato cAux = new Contato();
                        cAux.setIdcontato(jAux.getInt("idcontato"));
                        cAux.setNome(jAux.getString("nome"));
                        sb.append(cAux.getNome()).append("\n");
                    }
                }catch (Exception e){

                }
            }
        });

        btn_gravar_gson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gson gson = new Gson();

                Dados_Env env = new Dados_Env();
                env.setContatos(gerarContatos_new(5));

                String resultado = gson.toJson(env);
            }
        });

        btn_ler_gson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gson gson = new Gson();
                Dados_Rec rec = gson.fromJson(ToolBox.readFile(R.raw.dados, context), Dados_Rec.class);
            }
        });
    }

    private ArrayList<JSONObject> gerarContatos(int quantidade){
        ArrayList<JSONObject> contatos = new ArrayList<>();

        //Gera a lista de contatos em JSON
        for (int i = 0; i <= quantidade; i++) {
            Contato cAux = new Contato();
            cAux.setIdcontato(i);
            cAux.setNome("Nome - " + String.valueOf(i));
            contatos.add(cAux.toJSONObject());
        }

        return contatos;
    }

    private ArrayList<Contato> gerarContatos_new(int quantidade){
        ArrayList<Contato> contatos = new ArrayList<>();

        //Gera a lista de contatos em JSON
        for (int i = 0; i <= quantidade; i++) {
            Contato cAux = new Contato();
            cAux.setIdcontato(i);
            cAux.setNome("Nome - " + String.valueOf(i));
            contatos.add(cAux);
        }

        return contatos;
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
