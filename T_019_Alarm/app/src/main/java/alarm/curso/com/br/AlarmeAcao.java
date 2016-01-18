package alarm.curso.com.br;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by no3511 on 21/10/2015.
 */
public class AlarmeAcao extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Mensagem vinda do alarme ação", Toast.LENGTH_SHORT).show();
    }
}
