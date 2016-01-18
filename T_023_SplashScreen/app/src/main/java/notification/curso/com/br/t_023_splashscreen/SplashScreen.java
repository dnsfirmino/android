package notification.curso.com.br.t_023_splashscreen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Handler;

/**
 * Created by no3511 on 26/10/2015.
 */
public class SplashScreen extends AppCompatActivity {
    private Context context;
    private static final int SPLASH_TIME_OUT = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        context = getBaseContext();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mIntend = new Intent(context, MainActivity.class);
                startActivity(mIntend);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
