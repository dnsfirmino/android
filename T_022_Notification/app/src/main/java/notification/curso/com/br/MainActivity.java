package notification.curso.com.br;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private Context context;
    private Button btn_ativar;
    private Button btn_desativar;

    private int idNotification = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        context = getBaseContext();
        btn_ativar = (Button) findViewById(R.id.btn_ativar);
        btn_desativar = (Button) findViewById(R.id.btn_desativar);

        btn_ativar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(context, MainActivity.class);
                PendingIntent pi = PendingIntent.getActivity(context, 0, mIntent, 0);
                NotificationManager mn = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                Notification.Builder builder = new Notification.Builder(context);
                builder.setContentIntent(pi).setSmallIcon(R.mipmap.ic_launcher).setAutoCancel(true)
                .setContentTitle("Sincronismo").setContentText("Sincronismo realizado com sucesso!");

                builder.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE);

                //Obtive a versão do android do equipamento
                int versao = Build.VERSION.SDK_INT;

               if (versao >= Build.VERSION_CODES.JELLY_BEAN_MR1){
                   mn.notify(idNotification, builder.build());
               }else{
                   mn.notify(idNotification, builder.getNotification());
               }

            }
        });

        btn_desativar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager mn = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                mn.cancel(idNotification);

            }
        });
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
