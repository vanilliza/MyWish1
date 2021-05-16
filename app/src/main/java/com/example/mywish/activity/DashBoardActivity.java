package com.example.mywish.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.GravityCompat;
import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mywish1.R;
import com.example.mywish1.adapter.NavigationAdapter;
import com.example.mywish1.fragment.CheckInFragment;
import com.example.mywish1.fragment.MessageFragment;
import com.example.mywish1.fragment.ProfileFragment;
import com.example.mywish1.fragment.RecordWishFragment;
import com.example.mywish1.fragment.WishesFragment;
import com.example.mywish1.fragment.WritewishFragment;
import com.example.mywish1.interfaces.GetFragmentPosition;
import com.google.android.material.navigation.NavigationView;

import java.util.LinkedHashMap;

public class DashBoardActivity extends AppCompatActivity implements View.OnClickListener, GetFragmentPosition, DialogInterface.OnClickListener {

    public static DrawerLayout drawer;
    NavigationView navigationView;
    ImageView iv_menu;
    RecyclerView rv_navigation, rv_navigationtwo;
    LinkedHashMap<Integer, String> naviData;
    LinkedHashMap<Integer, String> navidatatwo;
    private Fragment fragment;
    Button btn_login, btn_logout;
    FrameLayout container;
    NestedScrollView nsv_navigation;
    int drawerpos;
    Context context;
    TextView tv_loginmsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
    }

    private void init() {
        context = DashBoardActivity.this;
        naviData = new LinkedHashMap<Integer, String>();
        navidatatwo = new LinkedHashMap<Integer, String>();

        drawer = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigation_view);
        navigationView = findViewById(R.id.navigation_view);
        iv_menu = findViewById(R.id.iv_menu);
        rv_navigation = findViewById(R.id.rv_navigation);




        iv_menu = findViewById(R.id.iv_menu);
        nsv_navigation = findViewById(R.id.nsv_navigation);
        nsv_navigation.setNestedScrollingEnabled(true);

        iv_menu.setOnClickListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        naviData.put(R.drawable.ic_profile, getResources().getString(R.string.profile));
        naviData.put(R.drawable.ic_writewish, getResources().getString(R.string.write_wish));
        naviData.put(R.drawable.ic_recordwish, getResources().getString(R.string.record_wish));
        naviData.put(R.drawable.ic_wishlist, getResources().getString(R.string.wishes));
        naviData.put(R.drawable.ic_checkin, getResources().getString(R.string.checkin));
        naviData.put(R.drawable.ic_message, getResources().getString(R.string.message));
        naviData.put(R.drawable.ic_logout, getResources().getString(R.string.logout));

        rv_navigation.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        NavigationAdapter navigationAdapter = new NavigationAdapter(getApplicationContext(), naviData, this);
        rv_navigation.setAdapter(navigationAdapter);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_menu:
                if (!drawer.isDrawerOpen(GravityCompat.START))
                    drawer.openDrawer(GravityCompat.START);
                else
                    drawer.closeDrawer(GravityCompat.END);
                break;
        }
    }


    public void closeDrawer() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    public void setitemposition(int i) {
        this.drawerpos = i;
        switch (i) {
            case 0:
                ProfileFragment fragment = new ProfileFragment();
                loadFragment(fragment);
                break;


            case 1:
                WritewishFragment writewishFragment = new WritewishFragment();
                loadFragment(writewishFragment);
                break;

            case 2:
                RecordWishFragment recordwishFragment = new RecordWishFragment();
                loadFragment(recordwishFragment);
                break;
            case 3:
                WishesFragment wishesFragment = new WishesFragment();
                loadFragment(wishesFragment);
                break;
            case 4:
                CheckInFragment checkinFragment = new CheckInFragment();
                loadFragment(checkinFragment);
                break;
            case 5:
                MessageFragment messageFragment = new MessageFragment();
                loadFragment(messageFragment);
                break;
            case 6:
                logoutDialog(this, this);
                break;

        }
        closeDrawer();
    }


    public void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public static void logoutDialog(final Context context, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(context);
        } else {
            builder = new AlertDialog.Builder(context);
        }

        builder.setTitle("Logout !")
                .setMessage("Are you sure you want to Logout ?")
                .setIcon(R.drawable.ic_logout)
                .setPositiveButton(android.R.string.yes, onClickListener)
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }

                }).show();

    }