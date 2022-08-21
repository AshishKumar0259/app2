package my.fishdetection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import my.fishdetection.fragments.AccountFragment;
import my.fishdetection.fragments.FeedFragment;
import my.fishdetection.fragments.HomeFragment;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView btm_nav = findViewById(R.id.btm_nav);
        btm_nav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame,new HomeFragment()).commit();

    }
    //back pressed method 30-40
    int counter=0;
    @Override
    public void onBackPressed() {
        counter++;
        Toast.makeText(this, "Press Back again to exit", Toast.LENGTH_SHORT).show();
        if(counter>1)
        {
            this.finish();
        }
    }
    //bottom navigation 41-64
    private BottomNavigationView.
            OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener(){
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    Fragment selectedFragment = null;
                    switch(item.getItemId()){
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_Fishfeed:
                            selectedFragment = new FeedFragment();
                            break;

                        case R.id.nav_user_account:
                            selectedFragment = new AccountFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,selectedFragment).commit();
                    return true;
                }
            };

}