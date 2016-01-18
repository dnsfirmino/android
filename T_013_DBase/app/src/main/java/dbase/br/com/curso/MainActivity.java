package dbase.br.com.curso;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import dbase.br.com.curso.banco.Constantes;
import dbase.br.com.curso.dao.ContatoDao;
import dbase.br.com.curso.model.Contato;
import dbase.br.com.curso.util.HMAux;


public class MainActivity extends AppCompatActivity {

    private Context context;
    //
    private ListView lv_contatos;
    //
    private ContatoDao contatoDao;

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
        lv_contatos = (ListView) findViewById(R.id.telainicial_lv_contatos);
        //
        contatoDao = new ContatoDao(context);
        //
        montarLista();
    }

    private void montarLista() {
        lv_contatos.setAdapter(
                new ArrayAdapter<HMAux>(
                        context,
                        android.R.layout.simple_list_item_1,
                        contatoDao.obterListaContatos()
                )
        );
    }

    private void inicializarAcao() {
        lv_contatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HMAux item = (HMAux) parent.getItemAtPosition(position);
                //
                chamarSegundaTela(Long.parseLong(item.get(HMAux.ID)));
            }
        });

    }

    private void chamarSegundaTela(long id) {
        Intent mIntent = new Intent(context, SegundaTela.class);
        mIntent.putExtra(Constantes.ID_CONTATO, id);
        //
        startActivity(mIntent);
        //
        finish();
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
        //
        if (id == R.id.telainicial_inserir_contato) {
            chamarSegundaTela(-1L);
        }

        return super.onOptionsItemSelected(item);
    }
}
