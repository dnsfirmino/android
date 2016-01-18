package listview.br.com.curso;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    private Context context;
    private ListView lv_nomes;
    private ArrayList<String> array_nomes;
    private ArrayAdapter<String> array_adapter_nomes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        context = getBaseContext();

        lv_nomes    = (ListView) findViewById(R.id.lv_nomes);
        array_nomes = new ArrayList<>(); //Inicializa ArrayList
        array_nomes.add("Android 1");
        array_nomes.add("Android 2");
        array_nomes.add("Android 3");
        array_nomes.add("Android 4");
        array_nomes.add("Android 5");
        array_nomes.add("Android 6");
        array_nomes.add("Android 7");
        array_nomes.add("Android 8");
        array_nomes.add("Android 9");
        array_nomes.add("Android 10");
        array_nomes.add("Android 11");
        array_nomes.add("Android 12");
        array_nomes.add("Android 13");
        array_nomes.add("Android 14");

        array_adapter_nomes = new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,array_nomes);
        lv_nomes.setAdapter(array_adapter_nomes);

        lv_nomes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nomeVar = (String) parent.getItemAtPosition(position);
                Toast.makeText(context,nomeVar,Toast.LENGTH_SHORT).show();
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
