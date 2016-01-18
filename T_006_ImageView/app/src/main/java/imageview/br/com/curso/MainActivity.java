package imageview.br.com.curso;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {
    Context context;
    private ImageView iv_imagem;
    private Button btn_mudar_imagem;
    private boolean bimagem = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        inicializaVariavel();
        inicializaAcao();
    }

    private void inicializaVariavel() {
        iv_imagem           = (ImageView) findViewById(R.id.iv_foto);
        btn_mudar_imagem    = (Button) findViewById(R.id.btn_mudar_imagem);

        //Limpa caixa imagem
        //iv_imagem.setImageDrawable(null);

        //
        btn_mudar_imagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //
                bimagem = !bimagem;

                //
                if (bimagem){
                    iv_imagem.setImageDrawable(getResources().getDrawable(R.drawable.lincon));
                }else{
                    iv_imagem.setImageDrawable(getResources().getDrawable(R.drawable.fear));
                }
            }
        });
    }

    private void inicializaAcao() {

    }
}
