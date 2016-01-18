package CkeckBoxRadioButtonToggleButton.br.com.curso;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ToggleButton;


public class MainActivity extends ActionBarActivity {

    private Context context;

    private CheckBox ckb_android;
    private CheckBox ckb_ios;

    private RadioGroup rg;
    private RadioButton rb_masculino;
    private RadioButton rb_feminino;

    private ToggleButton tb_tomada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        inicializarVariavel();
        inicializarAcao();
    }

    private void inicializarVariavel() {
        context = getBaseContext();

        ckb_android = (CheckBox) findViewById(R.id.ckb_android);
        ckb_ios = (CheckBox) findViewById(R.id.ckb_ios);

        rb_masculino = (RadioButton) findViewById(R.id.rb_masculino);
        rb_feminino = (RadioButton) findViewById(R.id.rb_feminino);
        rg = (RadioGroup) findViewById(R.id.rg);

        tb_tomada = (ToggleButton) findViewById(R.id.tb_tomada);

        //Lendo do banco que esta marcado como sim
        if ("s".equals("s")){
            ckb_android.setChecked(true);
        } else {
            ckb_android.setChecked(false);
        }

        //Lendo do banco que esta marcado como sim
        if ("s".equals("s")){
            ckb_ios.setChecked(true);
        } else {
            ckb_ios.setChecked(false);
        }

        if ("s".equals("s")){
            rb_masculino.setChecked(true);
        } else {
            rb_masculino.setChecked(false);
        }

        if ("s".equals("s")){
            rb_feminino.setChecked(true);
        } else {
            rb_feminino.setChecked(false);
        }

        if ("s".equals("s")){
            tb_tomada.setChecked(true);
        } else {
            tb_tomada.setChecked(false);
        }
    }

    private void inicializarAcao() {

    }
}
