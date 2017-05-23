package com.example.gmore.lapag;


import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.example.gmore.lapag.LoginActivity;

import java.util.List;


public class initial_userActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private Button button_areceber;
    private Button button_entradas;
    private Button button_recebidas;
    private TextView score_view;
    private TextView score_value;
    private TextView areceber_text;
    private TextView proximo_recebimento_valor;
    private TextView proximo_recebimento_data;
    private boolean animation_chooser;
    private TableLayout tableLayout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Definir fontes
        Typeface dosis_bold = Typeface.createFromAsset(getAssets(), "Dosis-Bold.ttf");
        Typeface dosis_extra_bold = Typeface.createFromAsset(getAssets(), "Dosis-ExtraBold.ttf");
        Typeface dosis_extra_light = Typeface.createFromAsset(getAssets(), "Dosis-ExtraLight.ttf");
        Typeface dosis_light = Typeface.createFromAsset(getAssets(), "Dosis-Light.ttf");
        Typeface dosis_medium = Typeface.createFromAsset(getAssets(), "Dosis-Medium.ttf");
        Typeface dosis_regular = Typeface.createFromAsset(getAssets(), "Dosis-Regular.ttf");
        Typeface dosis_semi_bold= Typeface.createFromAsset(getAssets(), "Dosis-SemiBold.ttf");

        score_view = (TextView) findViewById(R.id.score_view);
        score_value = (TextView) findViewById(R.id.score);
        areceber_text = (TextView) findViewById(R.id.areceber_texto);
        proximo_recebimento_valor = (TextView) findViewById(R.id.proximo_recebimento_valor);
        proximo_recebimento_data = (TextView) findViewById(R.id.proximo_recebimento_data);
        tableLayout = (TableLayout) findViewById(R.id.tablelayout);

        score_value.setTypeface(dosis_bold);
        areceber_text.setTypeface(dosis_medium);
        proximo_recebimento_valor.setTypeface(dosis_semi_bold);
        proximo_recebimento_data.setTypeface(dosis_medium);
        // mais fontes aqui



        button_areceber = (Button) findViewById(R.id.areceber_button);
        button_areceber.setTypeface(dosis_bold);
        button_areceber.setOnClickListener(this);
        button_entradas = (Button) findViewById(R.id.button_entradas);
        button_entradas.setTypeface(dosis_bold);
        button_entradas.setOnClickListener(this);
        button_recebidas = (Button) findViewById(R.id.button_recebidas);
        button_recebidas.setTypeface(dosis_bold);
        button_recebidas.setOnClickListener(this);


        button_areceber.setBackgroundResource(R.drawable.button_rounded_corner_areceber);
        button_areceber.setTextColor(getResources().getColor(R.color.white));
        button_entradas.setBackgroundResource(R.drawable.not_clicked_button);
        button_recebidas.setBackgroundResource(R.drawable.not_clicked_button);
        button_entradas.setTextColor(getResources().getColor(R.color.faturado));
        button_recebidas.setTextColor(getResources().getColor(R.color.tranferido));


        LoginActivity loginActivity = new LoginActivity();



        List<Transactions> transactionsList = loginActivity.getTransactions();
        createTransactions(transactionsList);



// Now Set your animation




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



    }

    public void onClick(View v) {
        Animation fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        if (v.getId() == R.id.areceber_button) {
            if (animation_chooser == true){
                score_view.startAnimation(fadeInAnimation);
                score_value.startAnimation(fadeInAnimation);
                areceber_text.startAnimation(fadeInAnimation);
                proximo_recebimento_data.startAnimation(fadeInAnimation);
                proximo_recebimento_valor.startAnimation(fadeInAnimation);
            }

            Drawable areceber_drawable = getResources().getDrawable(R.drawable.areceber);

            button_areceber.setBackgroundResource(R.drawable.button_rounded_corner_areceber);
            button_areceber.setTextColor(getResources().getColor(R.color.white));
            button_entradas.setBackgroundResource(R.drawable.not_clicked_button);
            button_entradas.setTextColor(getResources().getColor(R.color.faturado));
            button_recebidas.setBackgroundResource(R.drawable.not_clicked_button);
            button_recebidas.setTextColor(getResources().getColor(R.color.tranferido));
            score_view.setCompoundDrawablesWithIntrinsicBounds(areceber_drawable, null, null, null);
            areceber_text.setText("À receber");
            score_view.setBackgroundColor(getResources().getColor(R.color.areceber));

            proximo_recebimento_data.setVisibility(View.VISIBLE);
            proximo_recebimento_valor.setVisibility(View.VISIBLE);
            animation_chooser = false;



        }
        if (v.getId() == R.id.button_entradas) {
            if (animation_chooser == true){
                score_view.startAnimation(fadeInAnimation);
                score_value.startAnimation(fadeInAnimation);
                areceber_text.startAnimation(fadeInAnimation);
                proximo_recebimento_data.startAnimation(fadeInAnimation);
                proximo_recebimento_valor.startAnimation(fadeInAnimation);
            }

            Drawable areceber_drawable = getResources().getDrawable(R.drawable.areceber);

            button_recebidas.setBackgroundResource(R.drawable.not_clicked_button);
            button_entradas.setTextColor(getResources().getColor(R.color.faturado));
            button_recebidas.setTextColor(getResources().getColor(R.color.tranferido));
            button_entradas.setBackgroundResource(R.drawable.button_rounded_corner);
            button_entradas.setTextColor(getResources().getColor(R.color.white));
            button_areceber.setBackgroundResource(R.drawable.not_clicked_button);
            button_recebidas.setBackgroundResource(R.drawable.not_clicked_button);
            button_areceber.setTextColor(getResources().getColor(R.color.areceber));
            button_recebidas.setTextColor(getResources().getColor(R.color.tranferido));
            // quando clicar nas entradas rodar função para atualizar valores
            score_view.setCompoundDrawablesWithIntrinsicBounds(areceber_drawable, null, null, null);
            score_view.setBackgroundColor(getResources().getColor(R.color.areceber));
            areceber_text.setText("À receber");
            proximo_recebimento_data.setVisibility(View.VISIBLE);
            proximo_recebimento_valor.setVisibility(View.VISIBLE);

            animation_chooser = false;

        }
        if (v.getId() == R.id.button_recebidas) {

            Drawable transferido_drawable = getResources().getDrawable(R.drawable.transferido);

            button_recebidas.setBackgroundResource(R.drawable.button_rounded_corner_transferido);
            button_recebidas.setTextColor(getResources().getColor(R.color.white));
            button_entradas.setBackgroundResource(R.drawable.not_clicked_button);
            button_areceber.setBackgroundResource(R.drawable.not_clicked_button);
            button_entradas.setTextColor(getResources().getColor(R.color.faturado));
            button_areceber.setTextColor(getResources().getColor(R.color.areceber));
            // quando clicar no recebidas rodar função para atualizar valores
            //animação
            score_view.startAnimation(fadeInAnimation);
            score_value.startAnimation(fadeInAnimation);
            areceber_text.startAnimation(fadeInAnimation);

            proximo_recebimento_data.setVisibility(View.GONE);

            proximo_recebimento_valor.setVisibility(View.GONE);
            score_view.setCompoundDrawablesWithIntrinsicBounds(transferido_drawable, null, null, null);
            score_view.setBackgroundColor(getResources().getColor(R.color.tranferido));
            areceber_text.setText("Recebido");
            animation_chooser = true;

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


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_pag) {
            // Handle the camera action
        } else if (id == R.id.nav_cale) {
            Intent intent = new Intent(this, calendarActivity.class);
            this.startActivity (intent);
        } else if (id == R.id.nave_fale) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void createTransactions(List<Transactions> transactionsList){
        TableLayout.LayoutParams tableParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.FILL_PARENT);
        TableRow.LayoutParams rowParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        for (int i = 0; i<transactionsList.size(); ++i){
            Transactions transaction = transactionsList.get(i+1);
            TableRow row = new TableRow(this);
            row.setLayoutParams(tableParams);
            TextView textView1 = new TextView(this);
            textView1.setLayoutParams(rowParams);
            textView1.setText(transaction.getData());

            TextView textView2 = new TextView(this);
            textView2.setLayoutParams(rowParams);
            textView2.setText(transactionsList.get(i).getName());

            ImageView imageView = new ImageView(this);

            if (!transaction.getStatus() == true){
                imageView.setImageResource(R.drawable.b_vermelha);
            }
            else{
                // colocar bola verde
                imageView.setImageResource(R.drawable.b_vermelha);
            }
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

            TextView textView3 = new TextView(this);
            textView3.setLayoutParams(rowParams);
            textView3.setText(transactionsList.get(i).getAmount());



        }
    }
}