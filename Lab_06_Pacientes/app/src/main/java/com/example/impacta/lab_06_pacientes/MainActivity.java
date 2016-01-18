package com.example.impacta.lab_06_pacientes;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.impacta.lab_06_pacientes.model.Paciente;
import com.example.impacta.lab_06_pacientes.model.Transmissao_Env;
import com.example.impacta.lab_06_pacientes.model.Transmissao_Rec;
import com.example.impacta.lab_06_pacientes.util.ToolBox;
import com.google.gson.Gson;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private Context context;
    //
    private Button btn_ws;
    private ListView lv_pacientes;
    //
    private ArrayList<Paciente> pacientes;
    //
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);
        //
        inicializarVariavel();
        inicializarAcao();
    }

    private void inicializarVariavel() {
        context = getBaseContext();
        //
        btn_ws = (Button) findViewById(R.id.btn_ws);
        lv_pacientes = (ListView) findViewById(R.id.lv_pacientes);
        //
        pacientes = new ArrayList<>();
    }

    private void inicializarAcao() {
        btn_ws.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SincPacientes().execute();
            }
        });
    }

    private class SincPacientes extends AsyncTask<Void, Integer, Void> {

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setCancelable(false);
            progressDialog.setTitle("Sincronismo");
            progressDialog.setMessage("Aguarde Processando");
            //
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {

            try {
                Gson gson = new Gson();
                //
                Transmissao_Env env = new Transmissao_Env();
                env.setUser("Hugo");
                env.setPwd(ToolBox.md5("teste"));
                env.setPacientes(1000);
                //
                String resultado = ToolBox.comunicacao(
                        "http://www.nmsystems.com.br/testecargapaciente.php",
                        gson.toJson(env)
                );
                //
                String parRes[] = resultado.split("#WSTAG#");
                //
                switch (parRes.length) {
                    case 2:
                        if (parRes[0].equals("0")) {
                            Transmissao_Rec rec = gson.fromJson(
                                    parRes[1],
                                    Transmissao_Rec.class);
                            //
                            pacientes = rec.getPacientes();
                        }
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
            }
            //
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            //
            preparacaoLista();
            //
            progressDialog.dismiss();
        }
    }

    private void preparacaoLista() {
        lv_pacientes.setAdapter(
                new ArrayAdapter<Paciente>(
                        context,
                        android.R.layout.simple_list_item_1,
                        pacientes
                )
        );
    }
}
