package com.example.mywish1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;

import com.example.mywish1.R;

import static com.example.mywish1.activity.DashBoardActivity.drawer;


public class WishesFragment extends Fragment implements View.OnClickListener{

    private ImageView iv_menu;

    public WishesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_wishes, container, false);
        init(v);
        return v;
    }

    private void init(View v) {
        iv_menu = v.findViewById(R.id.iv_menu);
        iv_menu.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_menu:
                if (!drawer.isDrawerOpen(GravityCompat.START))
                    drawer.openDrawer(GravityCompat.START);
                else
                    drawer.closeDrawer(GravityCompat.END);
                break;
        }
    }
}