package com.example.user.test2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 10.07.2017.
 */

public class TestAdapter extends FragmentStatePagerAdapter {

    private List<String> titles = new ArrayList<>();



    public TestAdapter(FragmentManager fm) {
        super(fm);
        setTitles();
    }

    private void setTitles(){
        titles.add("Test");
        titles.add("List");
        titles.add("Title");
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 1) {
            return new EventFragment();
        }
        return new TestFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }
}
