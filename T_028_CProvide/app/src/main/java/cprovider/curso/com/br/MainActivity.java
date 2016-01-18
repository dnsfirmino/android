package cprovider.curso.com.br;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private Context context;
    private ListView lv_contatos;
    private ArrayList<HashMap<String, String>> listaDeContatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        inicializarVariavel();
        inicializarAcao();

        criarListaContatos();
    }

    private void criarListaContatos() {
        listaDeContatos = new ArrayList<>();
        Uri uriContatos = ContactsContract.Contacts.CONTENT_URI;
        String order = ContactsContract.Contacts.DISPLAY_NAME;
        Cursor cursor = getContentResolver().query(uriContatos, null, null, null, order);

        while (cursor.moveToNext()) {
            HashMap<String, String> item = new HashMap<>();
            item.put("codigo", cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID)));
            item.put("nome", cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)));
            item.put("temtelefone", cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)));

            listaDeContatos.add(item);
        }
        cursor.close();
        String[] from = {"codigo", "nome"};
        int[] to = {R.id.celula_tv_codigo, R.id.celula_tv_nome};
        lv_contatos.setAdapter(new SimpleAdapter(context, listaDeContatos, R.layout.celula, from, to));
    }

    private void inicializarVariavel() {
        lv_contatos = (ListView) findViewById(R.id.lv_contatos);
        context = getBaseContext();
    }

    private void inicializarAcao() {
        lv_contatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

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
}
