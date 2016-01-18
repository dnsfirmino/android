package com.example.impacta.t_030_camera;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    private Context context;
    //
    private ImageView iv_foto;
    private Button btn_foto;

    private File file;
    private String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);
        //
        inicializarVariavel(savedInstanceState);
        inicializarAcao();
        //
        iv_foto.setImageDrawable(Drawable.createFromPath("/sdcard/DBase/foto.png"));
    }

    private void inicializarVariavel(Bundle savedInstanceState) {
        context = getBaseContext();
        //
        iv_foto = (ImageView) findViewById(R.id.iv_foto);
        btn_foto = (Button) findViewById(R.id.btn_foto);
        //
        if (savedInstanceState != null) {
            file = (File) savedInstanceState.getSerializable("fileChave");
        } else {
            file = new File("/sdcard/DBase/", "foto.png");
        }
    }

    private void inicializarAcao() {
        btn_foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tirarFoto();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable("fileChave", file);
        //
        super.onSaveInstanceState(outState);
    }

    private void tirarFoto() {
        Intent mIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        mIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
        //
        startActivityForResult(mIntent, 10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 10:
                //
                iv_foto.setImageDrawable(Drawable.createFromPath(Uri.fromFile(file).getPath()));
                //
                break;
            default:
                break;
        }
    }
}
