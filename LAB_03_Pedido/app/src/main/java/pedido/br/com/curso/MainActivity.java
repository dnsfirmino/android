package pedido.br.com.curso;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    Context context;

    private ListView lv_cp;
    private ArrayList<String> array_cp;
    private ArrayAdapter<String> adapter_cp;

    private ListView lv_tf;
    private ArrayList<String> array_tf;
    private ArrayAdapter<String> adapter_tf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);
        context = getBaseContext();

        lv_cp = (ListView) findViewById(R.id.lv_cp);
        array_cp = new ArrayList<>();
        array_cp.add("Cartão");
        array_cp.add("Dinheiro");

        adapter_cp = new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,array_cp);
        lv_cp.setAdapter(adapter_cp);

        //
        lv_tf = (ListView) findViewById(R.id.lv_tf);
        array_tf = new ArrayList<>();
        array_tf.add("Teste 1");
        array_tf.add("Teste 2");
        array_tf.add("Teste 3");

        adapter_tf = new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,array_tf);
        lv_tf.setAdapter(adapter_tf);

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
