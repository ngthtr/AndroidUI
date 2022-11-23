package com.example.orderfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;

import com.example.orderfood.nav_bot.ExploreFragment;
import com.example.orderfood.nav_bot.FollowFragment;
import com.example.orderfood.nav_bot.PersonalFragment;
import com.example.orderfood.nav_bot.RadioFragment;
import com.example.orderfood.nav_bot.ZingChartFragment;
import com.example.orderfood.nav_left.BuyVipFragment;
import com.example.orderfood.nav_left.CodeVipFragment;
import com.example.orderfood.nav_left.ListCareFragment;
import com.example.orderfood.nav_left.ListHiddenFragment;
import com.example.orderfood.nav_left.ListPreventFragment;
import com.example.orderfood.nav_left.SaveCostFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView mBottomNavigationView;
    private PersonalFragment mPersonalFragment = new PersonalFragment();
    private ExploreFragment mExploreFragment = new ExploreFragment();
    private ZingChartFragment mZingChartFragment = new ZingChartFragment();
    private RadioFragment mRadioFragment = new RadioFragment();
    private FollowFragment mFollowFragment = new FollowFragment();

    private DrawerLayout mNavLeftLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private ListCareFragment mListCareFragment = new ListCareFragment();
    private ListHiddenFragment mListHiddenFragment = new ListHiddenFragment();
    private ListPreventFragment mListPreventFragment = new ListPreventFragment();
    private BuyVipFragment mBuyVipFragment = new BuyVipFragment();
    private SaveCostFragment mSaveCostFragment = new SaveCostFragment();
    private CodeVipFragment mCodeVipFragment = new CodeVipFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
        mBottomNavigationView = findViewById(R.id.nav_bot);
        mBottomNavigationView.setOnNavigationItemSelectedListener(this);
        mBottomNavigationView.setSelectedItemId(R.id.personal);

        mNavLeftLayout = findViewById(R.id.nav_left_layout);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mNavLeftLayout,
                R.string.nav_left_open, R.string.nav_left_open);

        mNavLeftLayout.addDrawerListener(mActionBarDrawerToggle);
        mActionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView mNavLeft = findViewById(R.id.nav_left);
        mNavLeft.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (mActionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (mNavLeftLayout.isDrawerOpen(GravityCompat.START)) {
            mNavLeftLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.personal:
                replaceFragment(R.id.frame_nav_bot, mPersonalFragment);
                return true;
            case R.id.explore:
                replaceFragment(R.id.frame_nav_bot, mExploreFragment);
                return true;
            case R.id.zing_chart:
                replaceFragment(R.id.frame_nav_bot, mZingChartFragment);
                return true;
            case R.id.radio:
                replaceFragment(R.id.frame_nav_bot, mRadioFragment);
                return true;
            case R.id.follow:
                replaceFragment(R.id.frame_nav_bot, mFollowFragment);
                return true;
            case R.id.list_care:
                replaceFragment(R.id.frame_nav_bot, mListCareFragment);
                mNavLeftLayout.closeDrawer(GravityCompat.START, false);
                return true;
            case R.id.list_hidden:
                replaceFragment(R.id.frame_nav_bot, mListHiddenFragment);
                mNavLeftLayout.closeDrawer(GravityCompat.START, false);
                return true;
            case R.id.list_prevent:
                replaceFragment(R.id.frame_nav_bot, mListPreventFragment);
                mNavLeftLayout.closeDrawer(GravityCompat.START, false);
                return true;
            case R.id.buy_vip:
                replaceFragment(R.id.frame_nav_bot, mBuyVipFragment);
                mNavLeftLayout.closeDrawer(GravityCompat.START, false);
                return true;
            case R.id.save_cost:
                replaceFragment(R.id.frame_nav_bot, mSaveCostFragment);
                mNavLeftLayout.closeDrawer(GravityCompat.START, false);
                return true;
            case R.id.code_vip:
                replaceFragment(R.id.frame_nav_bot, mCodeVipFragment);
                mNavLeftLayout.closeDrawer(GravityCompat.START, false);
                return true;
        }
        return false;
    }

    private void replaceFragment(int resId, Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(resId, fragment).commit();
    }
}