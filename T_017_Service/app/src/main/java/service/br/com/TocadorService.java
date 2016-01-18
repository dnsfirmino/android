package service.br.com;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

/**
 * Created by no3511 on 20/10/2015.
 */
public class TocadorService extends Service {

    private MediaPlayer player;

    @Override
    public void onCreate() {
        super.onCreate();

        player = MediaPlayer.create(this, R.raw.ci);
        player.setLooping(true);
        player.setVolume(50f, 50f);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        return 1;
    }

    @Override
    public void onDestroy() {
        player.stop(); //para o player
        player.release(); //libera o que esta alocado
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
