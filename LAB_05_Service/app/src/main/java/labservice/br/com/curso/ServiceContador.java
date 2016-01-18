package labservice.br.com.curso;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by no3511 on 20/10/2015.
 */
public class ServiceContador extends IntentService {
    private int index;

    public ServiceContador() {
        super("ServiceContador");
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            index = 1;
            while (index <= 25){
                Thread.sleep(500);
                fazerBroadCast(index++);
            }
            fazerBroadCast(-1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fazerBroadCast(int indice) {
        Intent mIntent = new Intent();
        mIntent.setAction(Constantes.EVENTO);
        mIntent.addCategory(Intent.CATEGORY_DEFAULT);
        mIntent.putExtra(Constantes.VALOR, indice);
        sendBroadcast(mIntent);
    }
}
