package com.perfectproperties.app.ppc_app.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.perfectproperties.app.ppc_app.Fragment.AboutUsFragment;
import com.perfectproperties.app.ppc_app.Fragment.HiringFrament;
import com.perfectproperties.app.ppc_app.Fragment.HomeFragment;
import com.perfectproperties.app.ppc_app.Fragment.NewsFragment;
import com.perfectproperties.app.ppc_app.Fragment.PartnerFragment;
import com.perfectproperties.app.ppc_app.Fragment.SettingFragment;
import com.perfectproperties.app.ppc_app.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private TextView toolbar_title;
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Controls();
        addEvents();
        loadSelection(R.id.nav_home);
    }

    private void Controls() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar_title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        /*ImageView img= (ImageView) toolbar.findViewById(R.id.imgback);
        img.setVisibility(View.GONE);
*/

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);

        fragmentManager = getSupportFragmentManager();
        //loadSelection(R.id.nav_home);

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_home:
                loadSelection(id);
                break;
            case R.id.nav_hiring:
                loadSelection(id);
                break;
            case R.id.nav_news:
                loadSelection(id);
                break;
            case R.id.nav_partner:
                loadSelection(id);
                break;
            case R.id.nav_aboutus:
                loadSelection(id);
                break;
            case R.id.nav_setting:
                loadSelection(id);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void addEvents() {
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void loadSelection(int id) {
        switch (id) {
            case R.id.nav_home:
                toolbar_title.setText(R.string.item_home);
                fragmentTransaction = fragmentManager.beginTransaction();
                HomeFragment homeFragment = new HomeFragment();
                fragmentTransaction.replace(R.id.fragment_home_page, homeFragment).commit();
                //Toast.makeText(this, "Hello 1", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_hiring:
                toolbar_title.setText("Tuyen Dung");
                fragmentTransaction = fragmentManager.beginTransaction();
                HiringFrament hiringFrament = new HiringFrament();
                fragmentTransaction.replace(R.id.fragment_home_page, hiringFrament).commit();
                break;
            case R.id.nav_news:
                toolbar_title.setText("Tin Tuc");
                fragmentTransaction = fragmentManager.beginTransaction();
                NewsFragment newsFragment = new NewsFragment();
                fragmentTransaction.replace(R.id.fragment_home_page, newsFragment).commit();
                break;
            case R.id.nav_partner:
                toolbar_title.setText("Doi Tac");
                fragmentTransaction = fragmentManager.beginTransaction();
                PartnerFragment partnerFragment = new PartnerFragment();
                fragmentTransaction.replace(R.id.fragment_home_page, partnerFragment).commit();
                break;
            case R.id.nav_aboutus:
                toolbar_title.setText("Ve Cong Ty");
                fragmentTransaction = fragmentManager.beginTransaction();
                AboutUsFragment aboutUsFragment = new AboutUsFragment();
                fragmentTransaction.replace(R.id.fragment_home_page, aboutUsFragment).commit();
                break;
            case R.id.nav_setting:
                toolbar_title.setText("Tuy Chinh");
                fragmentTransaction = fragmentManager.beginTransaction();
                SettingFragment settingFragment = new SettingFragment();
                fragmentTransaction.replace(R.id.fragment_home_page, settingFragment).commit();
                break;
        }
    }
}
