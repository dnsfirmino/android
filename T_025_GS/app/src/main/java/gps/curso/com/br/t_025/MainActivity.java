package gps.curso.com.br.t_025;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Context context;

    private Button btn_gps;
    private Button btn_rede;
    private Button btn_parar;
    private Button btn_verificar;
    private Button btn_cellid;

    private TextView tv_latitude;
    private TextView tv_longitude;

    private double latitude;
    private double longitude;

    private LocationManager lm;

    private LocPListenerHugo receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        inicializarVariavel();
        inicilizarAcao();

        receiver = new LocPListenerHugo();
        IntentFilter filter = new IntentFilter("android.location.PROVIDERS_CHANGED");

        registerReceiver(receiver, filter);
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(receiver);
        //
        super.onDestroy();
    }

    private void inicializarVariavel() {
        context = getBaseContext();

        btn_gps = (Button) findViewById(R.id.btn_gps);
        btn_rede = (Button) findViewById(R.id.btn_rede);
        btn_parar = (Button) findViewById(R.id.btn_parar);
        btn_verificar = (Button) findViewById(R.id.btn_ver_localizacao);
        btn_cellid = (Button) findViewById(R.id.btn_cellid_lac);

        tv_latitude = (TextView) findViewById(R.id.tv_latitude);
        tv_longitude = (TextView) findViewById(R.id.tv_longitude);

        lm = (LocationManager) context.getSystemService(LOCATION_SERVICE);
    }

    private void inicilizarAcao() {
        btn_gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparCampos();
                setarBotoes(false);

                lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locListener);
            }
        });

        btn_rede.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparCampos();
                setarBotoes(false);
                lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locListener);
            }
        });

        btn_parar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setarBotoes(true);
                lm.removeUpdates(locListener);

                String uri = "geo:0,0?q=" + String.valueOf(latitude).replace(",",".") + "," + String.valueOf(longitude).replace(",",".");
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(mIntent) ;
            }
        });

        btn_verificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultado = null;
                if (checkLocationService()){
                    resultado = "Serviço de Localização Ligado!";
                }else{
                    resultado = "Serviço de Localização Desligado!";
                }

                Toast.makeText(context, resultado, Toast.LENGTH_SHORT).show();
            }
        });

        btn_cellid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
                GsmCellLocation location = (GsmCellLocation) tm.getCellLocation();
                StringBuilder sb = new StringBuilder();
                sb.append("CellID:").append(location.getCid()).append("\nLac:").append(location.getLac());

                Toast.makeText(context, sb.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean checkLocationService() {
        if (lm != null && (lm.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                           lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER))){
            return true;

        }else{
            return false;
        }
    }


    private LocationListener locListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            latitude = location.getLatitude();
            longitude = location.getLongitude();

            tv_latitude.setText(String.valueOf(latitude));
            tv_longitude.setText(String.valueOf(longitude));
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };

    private void limparCampos() {
        tv_latitude.setText("0");
        tv_longitude.setText("0");
    }

    private void setarBotoes(boolean status) {
        btn_rede.setEnabled(status);
        btn_verificar.setEnabled(status);
        btn_gps.setEnabled(status);
    }

    private class LocPListenerHugo extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            btn_verificar.performClick();
        }
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
