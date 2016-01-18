package com.example.impacta.t_008_listview_simpleadapter;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    private Context context;
    //
    private ListView lv_contatos;
    private ArrayList<HMAuxHugo> contatos;
    //private ArrayAdapter<HMAuxHugo> adapter_contatos;
    private SimpleAdapter adapter_contatos;
    //
    private static final String ID = HMAuxHugo.ID;
    private static final String NOME = HMAuxHugo.TEXTO_01;
    private static final String TELEFONE = HMAuxHugo.TEXTO_02;

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
        lv_contatos = (ListView) findViewById(R.id.lv_contatos);
        //
        gerarContatos(100);
        //
        String[] from = {HMAuxHugo.TEXTO_01, HMAuxHugo.TEXTO_02};
        int[] to = {R.id.celula_tv_nome, R.id.celula_tv_telefone};
        //
        adapter_contatos = new SimpleAdapter(
                context,
                contatos,
                R.layout.celula,
                from,
                to
        );
        //
        lv_contatos.setAdapter(adapter_contatos);
    }

    private void gerarContatos(int quantidade) {
        contatos = new ArrayList<>();
        //
        for (int i = 1; i <= quantidade; i++) {
            HMAuxHugo item = new HMAuxHugo();
            item.put(HMAuxHugo.ID, String.valueOf(i));
            item.put(HMAuxHugo.TEXTO_01, "Nome - " + String.valueOf(i));
            item.put(HMAuxHugo.TEXTO_02, "Telefone - " + String.valueOf(i));
            //
            contatos.add(item);
        }
    }

    private void inicializarAcao() {
        lv_contatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HMAuxHugo item = (HMAuxHugo) parent.getItemAtPosition(position);
                //
                String resultado = item.get(ID) + "\n"
                        + item.get(NOME) + "\n"
                        + item.get(TELEFONE);
                //
                Toast.makeText(
                        context,
                        resultado,
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

    }


}
