package com.mdp.musikkita;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bnvMusik;
    private ActionBar judulBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        judulBar = getSupportActionBar();
        judulBar.setTitle("Musik");
        bukaFragment(new MusicFragment());

        bnvMusik = findViewById(R.id.bnv_musik);
        bnvMusik.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment Fr;
                switch (item.getItemId())
                {
                    case R.id.menu_musik:
                        bukaFragment(new MusicFragment());
                        judulBar.setTitle("Music");
                        return true;
                    case R.id.menu_album:
                        bukaFragment(new AlbumFragment());
                        judulBar.setTitle("Album");
                        return true;

                    case R.id.menu_artis:
                        bukaFragment(new ArtistFragment());
                        judulBar.setTitle("Artis");
                        return true;
                }



                return false;
            }
        });

    }
    private void bukaFragment(Fragment Fr)
    {
        FragmentManager Fm = getSupportFragmentManager();
        FragmentTransaction Ft = Fm.beginTransaction();
        Ft.replace(R.id.fl_container, Fr);
        Ft.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_atas, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menu_about)
        {
            startActivity(new Intent(MainActivity.this,AboutActivity.class));
            judulBar.setTitle("About");
        }
        else if (item.getItemId() == R.id.menu_help)
        {
            startActivity(new Intent(MainActivity.this,HelpActivity.class));
            judulBar.setTitle("Help");
        }
        return super.onOptionsItemSelected(item);
    }
}