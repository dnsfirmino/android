package activitylifecycle.br.com.curso;

import android.content.Context;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Context context;
    private EditText et_valor;
    private Button btn_mudar_valor;
    private Button btn_monstar_valor;

    private String valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        inicializaVariavel(savedInstanceState);
        inicializaAcao();

        Log.d("TAG", "onCreate");

    }

    private void inicializaVariavel(Bundle savedInstanceState) {
        context = getBaseContext();
        et_valor = (EditText) findViewById(R.id.telainicial_tv_valor);
        btn_monstar_valor = (Button) findViewById(R.id.telainicial_btn_monstrarvalor);
        btn_mudar_valor = (Button) findViewById(R.id.telainicial_btn_mudarvalor);

        if (savedInstanceState == null){
            valor = "Hugo";
        }else{
            valor = (String) savedInstanceState.getString("teste");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.d("TAG", "onSaveInstanceState");

        outState.putString("teste", valor);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "onDestroy");
    }

    private void inicializaAcao() {
        btn_monstar_valor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, valor, Toast.LENGTH_SHORT).show();
            }
        });

        btn_mudar_valor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valor = et_valor.getText().toString().trim();
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
