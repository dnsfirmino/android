package viewpage.curso.com.br;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private Context context;
    private ArrayList<Fragment> sessions;
    private String [] titles = {"Titulo 1", "Titulo 2", "Titulo 3"};
    private ViewPager mPager;

    private ArrayList<String> denis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        inicializarVariavel();
        inicializarAcao();
    }

    private void inicializarVariavel() {
        context = getBaseContext();

        sessions = new ArrayList<>();
        sessions.add(new Frag_01());
        sessions.add(new Frag_02());
        sessions.add(new Frag_03());

        mPager = (ViewPager) findViewById(R.id.telainicial_pager);
        mPager.setAdapter(new SessionPageAdapter(getSupportFragmentManager(),titles, sessions));
    }

    private void inicializarAcao() {
    }

    private class SessionPageAdapter extends FragmentPagerAdapter{
        private String[] titulos;
        private ArrayList<Fragment> sessions;

        public SessionPageAdapter(FragmentManager fm, String[] titulos, ArrayList<Fragment> sessions) {
            super(fm);
            this.titulos = titulos;
            this.sessions = sessions;
        }

        @Override
        public Fragment getItem(int position) {
            return sessions.get(position);
        }

        @Override
        public int getCount() {
            return sessions.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titulos[position];
        }
    }

    public void mudarFragment (int position){
        mPager.setCurrentItem(position);
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
