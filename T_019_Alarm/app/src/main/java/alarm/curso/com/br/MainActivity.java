package alarm.curso.com.br;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
    private Context context;
    private Button btn_alarme_unico;
    private Button btn_alarme_repetitivo;
    private Button btn_cancelar_alarme;

    private PendingIntent mPendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        context = getBaseContext();
        btn_alarme_unico = (Button) findViewById(R.id.btn_alarme_unico);
        btn_alarme_repetitivo = (Button) findViewById(R.id.btn_alarme_repetitivo);
        btn_cancelar_alarme = (Button) findViewById(R.id.btn_alarme_cancelar);

        btn_alarme_unico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();//Pega a data e hora atual
                calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + 5);//Acrescenta 5 secundos na data atual

                Intent mIntent = new Intent(context, AlarmeAcao.class);
                mPendingIntent = PendingIntent.getBroadcast(context, 0, mIntent, 0);

                AlarmManager mAlarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);
                mAlarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), mPendingIntent);
            }
        });

        btn_alarme_repetitivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(context, AlarmeAcao.class);
                mPendingIntent = PendingIntent.getBroadcast(context, 0, mIntent, 0);

                AlarmManager mAlarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);
                mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (2 * 1000), 5 * 1000, mPendingIntent);
            }
        });

        btn_cancelar_alarme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(context, AlarmeAcao.class);
                mPendingIntent = PendingIntent.getBroadcast(context, 0, mIntent, 0);

                AlarmManager mAlarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);
                mAlarmManager.cancel(mPendingIntent);
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
