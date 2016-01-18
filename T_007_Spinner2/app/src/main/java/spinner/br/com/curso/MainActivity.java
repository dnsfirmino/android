package spinner.br.com.curso;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    private Context context;

    private Spinner sp_valor;
    private ArrayList<String> nomes;
    private ArrayAdapter<String> adapter_nomes;
    private Button btn_nome;


    private Spinner sp_produto;
    private ArrayList<Produto> produtos;
    private ArrayAdapter<Produto> adapter_produtos;
    private Button btn_produto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getBaseContext();

        btn_nome = (Button) findViewById(R.id.btn_nome);

        sp_valor = (Spinner) findViewById(R.id.sp_nomes);

        nomes = new ArrayList<>();
        nomes.add("Android 1");
        nomes.add("Android 2");
        nomes.add("Android 3");
        nomes.add("Android 4");


        adapter_nomes = new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item,nomes);//Lista fechada
        adapter_nomes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//Lista aberta

        sp_valor.setAdapter(adapter_nomes);//manda o spinner para adapter

        btn_nome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomeVar = (String) sp_valor.getSelectedItem();
                Toast.makeText(context, nomeVar, Toast.LENGTH_SHORT).show();
            }
        });

        //
        sp_valor.setSelection(2);

        sp_produto = (Spinner) findViewById(R.id.sp_produtos);
        produtos = new ArrayList<>();

        Produto coringa = new Produto();
        coringa.setIdcodigo(-1);
        coringa.setNome("<Selecione o produto>");
        coringa.setValorVenda(0.0f);
        produtos.add(coringa);

        Produto p1 = new Produto();
        p1.setIdcodigo(10);
        p1.setNome("DeskJet 500");
        p1.setValorVenda(50.25f);

        produtos.add(p1);

        Produto p2 = new Produto();

        p2.setIdcodigo(1020);
        p2.setNome("Plotter 500PS");
        p2.setValorVenda(10800.45f);

        produtos.add(p2);

        adapter_produtos = new ArrayAdapter<Produto>(context,android.R.layout.simple_spinner_item,produtos);
        adapter_produtos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp_produto.setAdapter(adapter_produtos);

        btn_produto = (Button) findViewById(R.id.btn_produto);
        btn_produto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Produto pAux = (Produto) sp_produto.getSelectedItem();
                Toast.makeText(context, String.valueOf(pAux.getIdcodigo()),Toast.LENGTH_SHORT).show();
            }
        });

        sp_produto.setSelection(descobrirPosicao(10));

        sp_produto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Produto pAux = (Produto) parent.getItemAtPosition(position);
                Toast.makeText(context,String.valueOf(pAux.getIdcodigo()),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private int descobrirPosicao(long idproduto) {
        int iIndex = 0;

        for (int i = 0; i < sp_produto.getCount(); i++) {
            Produto pAux = (Produto) sp_produto.getItemAtPosition(i);

            if (pAux.getIdcodigo() == idproduto){
                iIndex = i;
                break;
            }
        }

        return iIndex;
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
