package barcode.br.com.curso;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Context context;
    private Button btn_scan;
    private TextView tv_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        inicializarVariavel();
        inicializarAcao();
    }

    private void inicializarVariavel() {
        context = getBaseContext();
        btn_scan = (Button) findViewById(R.id.btn_scan);
        tv_resultado = (TextView) findViewById(R.id.tv_resultado);
    }

    private void inicializarAcao() {
        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scanCode();
            }
        });
    }

    private void scanCode() {
        Intent mIntent = new Intent("com.google.zxing.client.android.SCAN");

        //
        if (mIntent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(mIntent, 10);
        }else{
            Toast.makeText(context,"ZXING Precisa ser instalado", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       switch (requestCode){
           case 10:
               if (resultCode == RESULT_OK){
                   String codigo = data.getStringExtra("SCAN_RESULT");
                   String simbologia = data.getStringExtra("SCAN_RESULT_FORMAT");
                   tv_resultado.setText(codigo);
               }else{
                   tv_resultado.setText("Cancelado");
               }
               break;
           default:
               break;
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
