package pt.infovota.app;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    FragmentManager manager = getSupportFragmentManager();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_presidenciais:
                    getSupportActionBar().setTitle("Presidenciais");
                    manager.beginTransaction().replace(R.id.frame, new Presidenciais()).commit();
                    return true;
                case R.id.navigation_legislativas:
                    getSupportActionBar().setTitle("Legislativas");
                    manager.beginTransaction().replace(R.id.frame, new Legislativas()).commit();
                    return true;
                case R.id.navigation_europeias:
                    getSupportActionBar().setTitle("Europeias");
                    manager.beginTransaction().replace(R.id.frame, new Europeias()).commit();
                    return true;
                case R.id.navigation_autarquicas:
                    getSupportActionBar().setTitle("Autarquicas");
                    manager.beginTransaction().replace(R.id.frame, new Autarquicas()).commit();
                    return true;
                case R.id.navigation_regionais:
                    getSupportActionBar().setTitle("Regionais");
                    manager.beginTransaction().replace(R.id.frame, new Regionais()).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //#95a168 Cor verde, titulo e textos
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Candidatos para Presidência");
        manager.beginTransaction().replace(R.id.frame, new Presidenciais()).commit();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}


