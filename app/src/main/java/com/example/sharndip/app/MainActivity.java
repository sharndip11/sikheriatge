package com.example.sharndip.app;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    private ListView navList;
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;

    //Animation fade_in, fade_out;
    //ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //carousel
        //viewFlipper = (ViewFlipper) this.findViewById(R.id.backgroundViewFlipper1);

        //fade_in = AnimationUtils.loadAnimation(this,
                //android.R.anim.fade_in);
        //fade_out = AnimationUtils.loadAnimation(this,
                //android.R.anim.fade_out);

        //viewFlipper.setInAnimation(fade_in);
        //viewFlipper.setOutAnimation(fade_out);

        //Automatique
        //viewFlipper.setAutoStart(true);
        //viewFlipper.setFlipInterval(5000);
        //viewFlipper.startFlipping();

        //...............................

        //menu
        drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);

        navList = (ListView)findViewById(R.id.navList);
        ArrayList<String> navArray = new ArrayList<String>();
        navArray.add("Home");
        navArray.add("Gursikh Jeevan");
        navArray.add("Histoire");
        navArray.add("Fakre Kaum");
        navArray.add("Gurdwara");
        navArray.add("Biographies");
        navArray.add("FAQ");
        navArray.add("Quizz");
        navArray.add("Actualité");
        navArray.add("Caricatures");
        navList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,navArray);
        navList.setAdapter(adapter);
        navList.setOnItemClickListener(this);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.openDrawer,R.string.closeDrawer);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_launcher);
        actionBar.setDisplayHomeAsUpEnabled(true);

        fragmentManager = getSupportFragmentManager();

        loadSelection(0);

    }

    private void loadSelection(int i){

        navList.setItemChecked(i,true);

        switch (i) {
            case 0:
                HomeFragment homeFragment = new HomeFragment();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentHolder,homeFragment);
                fragmentTransaction.commit();
                break;

            case 1:
                GursikhJeevanFragment gursikhJeevanFragment = new GursikhJeevanFragment();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentHolder,gursikhJeevanFragment);
                fragmentTransaction.commit();
                break;

            case 2:
                HistoireFragment histoireFragment = new HistoireFragment();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentHolder,histoireFragment);
                fragmentTransaction.commit();
                break;

            case  3:
                FakreKaumFragment fakreKaumFragment = new FakreKaumFragment();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentHolder,fakreKaumFragment);
                fragmentTransaction.commit();
                break;

            case 4:
                GurdwaraFragment gurdwaraFragment = new GurdwaraFragment();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentHolder,gurdwaraFragment);
                fragmentTransaction.commit();
                break;

            case 5:
                BiographiesFragment biographiesFragment = new BiographiesFragment();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentHolder,biographiesFragment);
                fragmentTransaction.commit();
                break;

            case 6:
                FaqFragment faqFragment = new FaqFragment();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentHolder,faqFragment);
                fragmentTransaction.commit();
                break;

            case 7:
                QuizzFragment quizzFragment = new QuizzFragment();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentHolder,quizzFragment);
                fragmentTransaction.commit();
                break;

            case 8:
                ActualiteFragment actualiteFragment = new ActualiteFragment();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentHolder,actualiteFragment);
                fragmentTransaction.commit();
                break;

            case 9:
                CaricaturesFragment caricaturesFragment = new CaricaturesFragment();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentHolder,caricaturesFragment);
                fragmentTransaction.commit();
                break;

        }

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            if (drawerLayout.isDrawerOpen(navList)){
                drawerLayout.closeDrawer(navList);
            }else {
                drawerLayout.openDrawer(navList);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        loadSelection(position);

        drawerLayout.closeDrawer(navList);
    }
}
