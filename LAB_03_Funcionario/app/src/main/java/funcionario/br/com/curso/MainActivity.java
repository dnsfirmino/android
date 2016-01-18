package funcionario.br.com.curso;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends ActionBarActivity {
    Context context;
    private RadioGroup rg_sexo;
    private ImageView  iv_foto;
    private RadioButton rb_masc;
    private RadioButton rb_fem;
    private Button     btn_confirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        iv_foto.setImageDrawable(null);

        inicializaVariaveis();
        rb_masc.setChecked(true;);
    }

    private void inicializaVariaveis() {
        context = getBaseContext();

        rg_sexo = (RadioGroup) findViewById(R.id.tela_inicial_rg_sexo);
        rb_masc = (RadioButton) findViewById(R.id.tela_inicial_rb_masc);
        rb_fem = (RadioButton) findViewById(R.id.tela_inicial_rb_fem);
        btn_confirmar = (Button) findViewById(R.id.tela_inicial_btn_confirmar);

        iv_foto = (ImageView) findViewById(R.id.tela_inicial_iv_foto);

        rg_sexo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sexo = rg_sexo.getCheckedRadioButtonId();

                if( sexo == R.id.tela_inicial_rb_masc){
                    iv_foto.setImageDrawable(getResources().getDrawable(R.drawable.man));
                } else {
                    iv_foto.setImageDrawable(getResources().getDrawable(R.drawable.woman));
                }
            }
        });

        btn_confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}
