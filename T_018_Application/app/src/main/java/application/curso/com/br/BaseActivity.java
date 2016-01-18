package application.curso.com.br;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by no3511 on 20/10/2015.
 */
public class BaseActivity extends AppCompatActivity {
    protected AppCentral app;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //
        app = (AppCentral) getApplication();
    }
}
