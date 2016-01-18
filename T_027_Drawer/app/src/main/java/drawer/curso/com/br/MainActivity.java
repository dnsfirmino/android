package drawer.curso.com.br;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity implements Frag_opc.iFrag_opc {
    private Context context;
    private DrawerLayout mDrawerLayout;
    private LinearLayout ll_opc;
    private LinearLayout ll_content;

    private ActionBarDrawerToggle mActionBarDrawerToggle;

    private Frag_opc mFrag_opc;
    private Frag_content mFrag_content;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        inicializarVariavel();
        inicializarAcao();

        mActionBarDrawerToggle.syncState();
    }

    private void inicializarVariavel() {
        context = getBaseContext();
        mFrag_content = new Frag_content();
        mFrag_opc = new Frag_opc();
        mFrag_opc.delegate = MainActivity.this;

        mDrawerLayout = (DrawerLayout) findViewById(R.id.main_drawer_layout);
        ll_content = (LinearLayout) findViewById(R.id.ll_content);
        ll_opc = (LinearLayout) findViewById(R.id.ll_opcao);

        mActionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this, mDrawerLayout,
                                                           R.string.drawer_aberto, R.string.drawer_fechado){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

                //
                invalidateOptionsMenu();
            }
        };

    }

    private void inicializarAcao() {
        //Habilita a opção de clique
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.ll_opcao, mFrag_opc, "opc");
        ft.replace(R.id.ll_content, mFrag_content, "content");

        ft.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds item                                                                                                                                                                              s to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        if (mActionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void mudarTT(String texto) {
        //Fecha o drawer lateral
        mDrawerLayout.closeDrawer(ll_opc);

        //Envia o texto para o segundo fragmento
        mFrag_content.modificarTexto(texto);
    }
}
