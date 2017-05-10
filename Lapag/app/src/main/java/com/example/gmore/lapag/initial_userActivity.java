package com.example.gmore.lapag;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;


import org.w3c.dom.Text;

import java.util.ArrayList;

import static com.example.gmore.lapag.R.drawable.button_rounded_corner_areceber;

public class initial_userActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private TextView nome_usuario_menu;
    private Button button_areceber;
    private Button button_entradas;
    private Button button_recebidas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        nome_usuario_menu = (TextView) findViewById(R.id.nome_usuario_menu);
        button_areceber = (Button) findViewById(R.id.areceber_button);
        button_areceber.setOnClickListener(this);
        button_entradas = (Button) findViewById(R.id.button_entradas);
        button_entradas.setOnClickListener(this);
        button_recebidas = (Button) findViewById(R.id.button_recebidas);
        button_recebidas.setOnClickListener(this);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    public void onClick(View v) {
        if (v.getId() == R.id.areceber_button) {
            button_areceber.setBackgroundResource(R.drawable.button_rounded_corner_areceber);
            button_areceber.setTextColor(getResources().getColor(R.color.white));
            button_entradas.setBackgroundResource(R.drawable.not_clicked_button);
            button_recebidas.setBackgroundResource(R.drawable.not_clicked_button);
            button_entradas.setTextColor(getResources().getColor(R.color.faturado));
            button_recebidas.setTextColor(getResources().getColor(R.color.tranferido));

        }
        if (v.getId() == R.id.button_entradas) {
            button_entradas.setBackgroundResource(R.drawable.button_rounded_corner);
            button_entradas.setTextColor(getResources().getColor(R.color.white));
            button_areceber.setBackgroundResource(R.drawable.not_clicked_button);
            button_recebidas.setBackgroundResource(R.drawable.not_clicked_button);
            button_areceber.setTextColor(getResources().getColor(R.color.areceber));
            button_recebidas.setTextColor(getResources().getColor(R.color.tranferido));

        }
        if (v.getId() == R.id.button_recebidas) {
            button_recebidas.setBackgroundResource(R.drawable.button_rounded_corner_transferido);
            button_recebidas.setTextColor(getResources().getColor(R.color.white));
            button_entradas.setBackgroundResource(R.drawable.not_clicked_button);
            button_areceber.setBackgroundResource(R.drawable.not_clicked_button);
            button_entradas.setTextColor(getResources().getColor(R.color.faturado));
            button_areceber.setTextColor(getResources().getColor(R.color.areceber));



        }
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.initial_user, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
