package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerCan extends FragmentPagerAdapter {
    private int numOfTabs;

    public  PagerCan(FragmentManager fm, int numOfTabs){

        super(fm);
        this.numOfTabs = numOfTabs;
    }



    @Override
    public Fragment getItem(int position) {

        switch (position){

            case 0:
                return new registro2();
            case 1:
                return new consulta();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }


}
