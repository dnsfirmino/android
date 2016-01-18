package bs1.br.com.curso;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by no3511 on 15/10/2015.
 */
public class BReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Receiver do BS1", Toast.LENGTH_SHORT).show();
    }
}
