package herois.br.com.curso;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    Context context;

    private ListView lv_vingadores;
    private ArrayList<HMAux> vingadores;
    private SimpleAdapter adapter_vingadores;

    private static final String ID = HMAux.ID;
    private static final String NOME = HMAux.TEXTO_01;
    private static final String PODER = HMAux.TEXTO_02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        inicializaVariaveis();
        inicializaAcao();
    }

    private void inicializaVariaveis() {
        context = getBaseContext();

        lv_vingadores = (ListView) findViewById(R.id.telainicial_lv_vingadores);

        //
        gerarListaVingadores(11);

        //
        String[] from = {HMAux.TEXTO_01, HMAux.TEXTO_02, HMAux.TEXTO_03}; //Informação que sera passada
        int[] to = {R.id.celula_iv_vingador, R.id.celula_tv_nome, R.id.celula_tv_poder};//Aonde vou demonstrar os dados

        //
        adapter_vingadores = new SimpleAdapter(context, vingadores, R.layout.celula, from, to);

        //...
        lv_vingadores.setAdapter(adapter_vingadores);
    }

    private void gerarListaVingadores(int quantidade) {
        vingadores = new ArrayList<>();

        //
        HMAux h1 = new HMAux();
        h1.put(HMAux.ID, "1");
        h1.put(HMAux.TEXTO_01, String.valueOf(R.drawable.avenger01));
        h1.put(HMAux.TEXTO_02, "Gaviao Arqueiro");
        h1.put(HMAux.TEXTO_03, "detalhes a mais!");

        //
        HMAux h2 = new HMAux();
        h2.put(HMAux.ID, "2");
        h2.put(HMAux.TEXTO_01, String.valueOf(R.drawable.avenger02));
        h2.put(HMAux.TEXTO_02, "Patriota de Ferro");
        h2.put(HMAux.TEXTO_03, "detalhes a mais!");

        //
        HMAux h3 = new HMAux();
        h3.put(HMAux.ID, "3");
        h3.put(HMAux.TEXTO_01, String.valueOf(R.drawable.avenger03));
        h3.put(HMAux.TEXTO_02, "Thor");
        h3.put(HMAux.TEXTO_03, "detalhes a mais!");

        //
        HMAux h4 = new HMAux();
        h4.put(HMAux.ID, "4");
        h4.put(HMAux.TEXTO_01, String.valueOf(R.drawable.avenger04));
        h4.put(HMAux.TEXTO_02, "Nick Fury");
        h4.put(HMAux.TEXTO_03, "detalhes a mais!");

        //
        HMAux h5 = new HMAux();
        h5.put(HMAux.ID, "5");
        h5.put(HMAux.TEXTO_01, String.valueOf(R.drawable.avenger05));
        h5.put(HMAux.TEXTO_02, "Loki");
        h5.put(HMAux.TEXTO_03, "detalhes a mais!");

        //
        HMAux h6 = new HMAux();
        h6.put(HMAux.ID, "6");
        h6.put(HMAux.TEXTO_01, String.valueOf(R.drawable.avenger06));
        h6.put(HMAux.TEXTO_02, "Homem de Ferro");
        h6.put(HMAux.TEXTO_03, "detalhes a mais!");

        //
        HMAux h7 = new HMAux();
        h7.put(HMAux.ID, "7");
        h7.put(HMAux.TEXTO_01, String.valueOf(R.drawable.avenger07));
        h7.put(HMAux.TEXTO_02, "Hulk");
        h7.put(HMAux.TEXTO_03, "detalhes a mais!");

        //
        HMAux h8 = new HMAux();
        h8.put(HMAux.ID, "8");
        h8.put(HMAux.TEXTO_01, String.valueOf(R.drawable.avenger08));
        h8.put(HMAux.TEXTO_02, "Vespa");
        h8.put(HMAux.TEXTO_03, "detalhes a mais!");

        //
        HMAux h9 = new HMAux();
        h9.put(HMAux.ID, "9");
        h9.put(HMAux.TEXTO_01, String.valueOf(R.drawable.avenger09));
        h9.put(HMAux.TEXTO_02, "Capitao America");
        h9.put(HMAux.TEXTO_03, "detalhes a mais!");

        //
        HMAux h10 = new HMAux();
        h10.put(HMAux.ID, "10");
        h10.put(HMAux.TEXTO_01, String.valueOf(R.drawable.avenger10));
        h10.put(HMAux.TEXTO_02, "Viuva Negra");
        h10.put(HMAux.TEXTO_03, "detalhes a mais!");

        //
        HMAux h11 = new HMAux();
        h11.put(HMAux.ID, "11");
        h11.put(HMAux.TEXTO_01, String.valueOf(R.drawable.avenger11));
        h11.put(HMAux.TEXTO_02, "Agente Phillip");
        h11.put(HMAux.TEXTO_03, "detalhes a mais!");

        vingadores.add(h1);
        vingadores.add(h2);
        vingadores.add(h3);
        vingadores.add(h4);
        vingadores.add(h5);
        vingadores.add(h6);
        vingadores.add(h7);
        vingadores.add(h8);
        vingadores.add(h9);
        vingadores.add(h10);
        vingadores.add(h11);
    }

    private void inicializaAcao() {

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
