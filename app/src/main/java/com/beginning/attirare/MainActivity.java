package com.beginning.attirare;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.beginning.attirare.Fragment.CartFragment;
import com.beginning.attirare.Fragment.HomeFragment;
import com.beginning.attirare.Fragment.LocalFragment;
import com.beginning.attirare.Fragment.ProfileFragment;
import com.beginning.attirare.Fragment.PromoFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Fragment selectedFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new PromoFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    int id = menuItem.getItemId();
                    if (id==R.id.btn_homepage) {
                        selectedFragment = new HomeFragment();
                    } else if (id==R.id.btn_local) {
                        selectedFragment = new LocalFragment();
                    } else if (id==R.id.btn_promo) {
                        selectedFragment = new PromoFragment();
                    } else if (id==R.id.btn_cart) {
                        selectedFragment = new CartFragment();
                    } else if (id==R.id.btn_profile) {
                        selectedFragment = new ProfileFragment();
                    }

                    if(selectedFragment != null) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                selectedFragment).commit();
                    }

                    return true;
                }
            };
}
