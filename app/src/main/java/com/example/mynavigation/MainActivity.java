package com.example.mynavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

import Adapter.viewpager2Adapter;

public class MainActivity extends AppCompatActivity {
private Toolbar mToolbar;
private DrawerLayout mDrawerLayout;
private NavigationView mNavigationView;
private List<Fragment>mFragments = new ArrayList<>();
private TabLayout mTabLayout;
private ViewPager2 mViewPager2;
private List<String>mList1 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        mToolbar = findViewById(R.id.toolbar);
        mDrawerLayout = findViewById(R.id.draw);
        mNavigationView = findViewById(R.id.navigationView);
        mViewPager2 = findViewById(R.id.viewpager2);
        mTabLayout = findViewById(R.id.tablayout);
        init_0();
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        click();
    }
    private void init_0(){
        initPage();
        viewpager2Adapter adapter = new viewpager2Adapter(getSupportFragmentManager(),getLifecycle(),mFragments);
        mViewPager2.setAdapter(adapter);
        initTabLayout();
    }
    private void initTabLayout(){
        new TabLayoutMediator(mTabLayout, mViewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(mList1.get(position));
            }
        }).attach();
    }
    private void initPage(){
        mFragments.add(BlankFragment.newInstance("1","1"));
        mFragments.add(BlankFragment.newInstance("1","1"));
        mFragments.add(BlankFragment.newInstance("1","1"));
        mFragments.add(BlankFragment.newInstance("1","1"));
        mFragments.add(BlankFragment.newInstance("1","1"));
        mFragments.add(BlankFragment.newInstance("1","1"));
        mList1.add("1");
        mList1.add("2");
        mList1.add("3");
        mList1.add("4");
        mList1.add("5");
        mList1.add("6");
    }
    private void click(){
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.name){
                    Toast.makeText(MainActivity.this,"名字",Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:mDrawerLayout.openDrawer(GravityCompat.START);
            break;
        }
        return true;
    }
}