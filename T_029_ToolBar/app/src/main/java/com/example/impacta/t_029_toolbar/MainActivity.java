package com.example.impacta.t_029_toolbar;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private Context context;
    private Toolbar toolbar;
    //
    private TextView tv_nome;
    private TextView tv_nome_s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);
        //
        context = getBaseContext();
        //
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        //
        setSupportActionBar(toolbar);
        //
        tv_nome = (TextView) findViewById(R.id.tv_nome);
        tv_nome_s = (TextView) findViewById(R.id.tv_nome_s);
        //
        Typeface font_1 = Typeface.createFromAsset(getAssets(), "JollyLodger-Regular.ttf");
        tv_nome.setTypeface(font_1);
        tv_nome.setTextSize(50);
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
