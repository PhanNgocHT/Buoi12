package com.example.laptrinh.buoi12;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.laptrinh.buoi12.fragment.FragmentConan;
import com.example.laptrinh.buoi12.fragment.FragmentDoremon;
import com.example.laptrinh.buoi12.fragment.FragmentDragonBall;

import java.util.ArrayList;

/**
 * Created by Lap trinh on 4/23/2017.
 */

public class PagerAdapter extends FragmentPagerAdapter{
    private ArrayList<TabItem> arrTab;
    public PagerAdapter(FragmentManager fm,ArrayList<TabItem> arrTab) {
        super(fm);
        this.arrTab = arrTab;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new FragmentConan();
                break;
            case 1:
                fragment = new FragmentDragonBall();
                break;
            case 2:
                fragment = new FragmentDoremon();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return arrTab.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return arrTab.get(position).getName();
    }
}
