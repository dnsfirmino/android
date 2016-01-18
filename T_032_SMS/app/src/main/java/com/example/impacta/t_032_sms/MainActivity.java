package com.example.impacta.t_032_sms;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private Context context;
    //
    private Button btn_enviar;

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
        btn_enviar = (Button) findViewById(R.id.btn_enviar);
    }

    private void inicializarAcao() {
        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarSMS("APN:Hugo");
            }
        });
    }

    private void enviarSMS(String texto) {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage("989414186", null, texto, null, null);
    }

}
