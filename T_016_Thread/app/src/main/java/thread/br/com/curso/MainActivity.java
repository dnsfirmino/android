package thread.br.com.curso;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private Context context;
    private TextView tv_contador;
    private Button btn_acionar;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        tv_contador = (TextView) findViewById(R.id.tv_contador);
        btn_acionar = (Button) findViewById(R.id.btn_acionar);

        btn_acionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_acionar.setEnabled(false);

                Thread thread = new Thread(){
                    @Override
                    public void run() {
                        try {
                            index = 0;
                            while (index <= 25){
                                sleep(500);

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        tv_contador.setText(String.valueOf(++index));
                                    }
                                });
                            }

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    btn_acionar.setEnabled(true);
                                }
                            });
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();
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
