package com.example.laptrinh.buoi12;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, AdapterView.OnItemClickListener {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private ViewPager viewPager;
    private ArrayList<TabItem> arr = new ArrayList<>();
    private PagerAdapter pagerAdapter;
    private TabLayout tabLayout;
    private ListView lvTab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupActionBar();
        initDrawerLayout();
        initViewpager();
        initView();
    }

    private void initView() {
        lvTab = (ListView) findViewById(R.id.lvTab);
        ArrayAdapter<TabItem> adapter = new ArrayAdapter<TabItem>
                (this,android.R.layout.simple_list_item_1,arr);
        lvTab.setAdapter(adapter);
        lvTab.setOnItemClickListener(this);
        lvTab.bringToFront();
        MainActivity.this.drawerLayout.requestLayout();
    }

    private void initViewpager() {
        arr.add(new TabItem("Conan"));
        arr.add(new TabItem("Dragon Ball"));
        arr.add(new TabItem("Doremon"));
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(),arr);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(this);

    }

    private void initDrawerLayout() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle
                (this,drawerLayout,null,R.string.open,R.string.close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                Toast.makeText(MainActivity.this,"Open",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                Toast.makeText(MainActivity.this,"Close",Toast.LENGTH_SHORT).show();
            }
        };
        drawerLayout.addDrawerListener(toggle);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    private void setupActionBar() {
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Toast.makeText(this,position+"",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        viewPager.setCurrentItem(i);
        drawerLayout.closeDrawers();
    }
}
