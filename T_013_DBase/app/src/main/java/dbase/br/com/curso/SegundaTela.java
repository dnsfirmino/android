package dbase.br.com.curso;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import dbase.br.com.curso.banco.Constantes;
import dbase.br.com.curso.dao.ContatoDao;
import dbase.br.com.curso.model.Contato;

/**
 * Created by no3511 on 14/10/2015.
 */
public class SegundaTela extends AppCompatActivity {
    private Context context;
    private EditText et_codigo;
    private EditText et_nome;
    private EditText et_telefone;
    private EditText et_idade;

    private Button btn_excluir;
    private Button btn_salvar;

    private long idIndex;
    private ContatoDao contatoDao;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segundatela);

        inicializarVariavel();
        inicializaAcao();

    }

    private void inicializarVariavel() {
        context = getBaseContext();

        idIndex = getIntent().getLongExtra(Constantes.ID_CONTATO, 0);

        contatoDao =  new ContatoDao(context);

        et_codigo = (EditText) findViewById(R.id.segundatela_codigo);
        et_nome = (EditText) findViewById(R.id.segundatela_nome);
        et_telefone = (EditText) findViewById(R.id.segundatela_telefone);
        et_idade = (EditText) findViewById(R.id.segundatela_idade);
        btn_excluir = (Button) findViewById(R.id.segundatela_btn_excluir);
        btn_salvar = (Button) findViewById(R.id.segundatela_btn_salvar);

        if (idIndex != -1L){
            Contato cAux = contatoDao.obterContatoByID(idIndex);
            et_codigo.setText(String.valueOf(cAux.getIdcontato()));
            et_nome.setText(cAux.getNome());
            et_telefone.setText(cAux.getTelefone());
            et_idade.setText(String.valueOf(cAux.getIdade()));
            btn_excluir.setEnabled(true);
        }else {
            btn_excluir.setEnabled(false);
        }

    }

    private void inicializaAcao() {
        btn_excluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contatoDao.apagarContato(idIndex);
                onBackPressed();
            }
        });

        btn_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validacao()) {
                    inserirAtualizarContato();
                }
            }
        });

    }

    private void inserirAtualizarContato() {
        Contato cAux = new Contato();

        cAux.setNome(et_nome.getText().toString());
        cAux.setTelefone(et_telefone.getText().toString());
        cAux.setIdade(Integer.parseInt(et_idade.getText().toString()));

        if (idIndex != -1){
            cAux.setIdcontato(idIndex);
            contatoDao.atualizarContato(cAux);
        }else {
            idIndex = contatoDao.proximoID();
            cAux.setIdcontato(idIndex);
            contatoDao.inserirContato(cAux);
            et_codigo.setText(String.valueOf(idIndex));
            btn_excluir.setEnabled(true);
            //onBackPressed();
        }
    }

    private boolean validacao() {
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent mIntent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(mIntent);
        super.onBackPressed();
    }
}
