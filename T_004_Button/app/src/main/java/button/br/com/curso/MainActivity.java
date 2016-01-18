package button.br.com.curso;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {

    private Button btn_acionar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        //
        inicializarVariavel();
        inicializarAcao();
    }

    private void inicializarVariavel() {
        btn_acionar = (Button) findViewById(R.id.btn_acionar);
    }

    private void inicializarAcao() {
        btn_acionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Oi veio!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
