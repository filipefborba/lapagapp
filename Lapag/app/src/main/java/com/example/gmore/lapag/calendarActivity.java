package com.example.gmore.lapag;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class calendarActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_calendar);
        setSupportActionBar(toolbar);

        //Definir fontes
        Typeface dosis_bold = Typeface.createFromAsset(getAssets(), "Dosis-Bold.ttf");
        Typeface dosis_extra_bold = Typeface.createFromAsset(getAssets(), "Dosis-ExtraBold.ttf");
        Typeface dosis_extra_light = Typeface.createFromAsset(getAssets(), "Dosis-ExtraLight.ttf");
        Typeface dosis_light = Typeface.createFromAsset(getAssets(), "Dosis-Light.ttf");
        Typeface dosis_medium = Typeface.createFromAsset(getAssets(), "Dosis-Medium.ttf");
        Typeface dosis_regular = Typeface.createFromAsset(getAssets(), "Dosis-Regular.ttf");
        Typeface dosis_semi_bold= Typeface.createFromAsset(getAssets(), "Dosis-SemiBold.ttf");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_calendar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_calendar);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_pag) {
            Intent intent = new Intent(this, initial_userActivity.class);
            this.startActivity (intent);
        } else if (id == R.id.nav_cale) {
            Intent intent = new Intent(this, calendarActivity.class);
            this.startActivity (intent);
        } else if (id == R.id.nave_fale) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_calendar);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_calendar);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View v) {

    }
}