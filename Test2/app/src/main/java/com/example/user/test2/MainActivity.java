package com.example.user.test2;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager vp = (ViewPager) findViewById(R.id.vp);
        vp.setAdapter(new TestAdapter(getSupportFragmentManager()));

        TabLayout tl = (TabLayout) findViewById(R.id.tablayout);
        tl.setupWithViewPager(vp);
    }
}
