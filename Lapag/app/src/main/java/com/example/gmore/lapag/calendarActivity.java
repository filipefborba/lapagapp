package com.example.gmore.lapag;

import android.content.Context;
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
import android.widget.CalendarView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.text.SimpleDateFormat;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

public class calendarActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    CompactCalendarView compactCalendar;
    final Locale myLocale = new Locale("pt", "BR");
    final TimeZone timeZone = TimeZone.getTimeZone("America/Sao_Paulo");
    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMMM - yyyy", myLocale);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_calendar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(null);

        compactCalendar = (CompactCalendarView) findViewById(R.id.compactcalendar_view);
        compactCalendar.setUseThreeLetterAbbreviation(true);
        compactCalendar.setFirstDayOfWeek(Calendar.SUNDAY);

        // globally
        final TextView valor_total = (TextView)findViewById(R.id.valor_total);
        ;

        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                Context context = getApplicationContext();
                valor_total.setText("R$" + dateClicked);
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                toolbar.setTitle(dateFormatMonth.format(firstDayOfNewMonth));
            }
        });


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
        } else if (id == R.id.nav_perfil) {
            Intent intent = new Intent(this, profileActivity.class);
            this.startActivity (intent);
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
