package iitropar.zeitgeist18;

import android.content.Intent;
import android.os.Bundle;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;


public class ScheduleDay extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int dayNumber ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_day);




        Intent intent = getIntent();
        dayNumber = intent.getExtras().getInt("dayNumber");
        if (dayNumber == 1) {

            getSupportActionBar().setTitle("Day 1");
        }
        else if (dayNumber == 2) {

            getSupportActionBar().setTitle("Day 2");
        }
        else if (dayNumber == 3) {

            getSupportActionBar().setTitle("Day 3");
        }
        else if(dayNumber == 4) {

            getSupportActionBar().setTitle("Day 4");
        }
        getSupportActionBar().setElevation(0);
        viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);


        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        Bundle bundle = new Bundle();
        bundle.putInt("eventDay", dayNumber);
        bundle.putInt("eventType", 1);
        ScheduleCompFragment scheduleCompFragment = new ScheduleCompFragment();
        scheduleCompFragment.setArguments(bundle);

        Bundle bundle2 = new Bundle();
        bundle2.putInt("eventDay", dayNumber);
        bundle2.putInt("eventType", 2);
        ScheduleConcertsFragment scheduleConcertsFragment = new ScheduleConcertsFragment();
        scheduleConcertsFragment.setArguments(bundle2);

        Bundle bundle3 = new Bundle();
        bundle3.putInt("eventDay", dayNumber);
        bundle3.putInt("eventType", 3);
        ScheduleInformalsFragment scheduleInformalsFragment = new ScheduleInformalsFragment();
        scheduleInformalsFragment.setArguments(bundle3);


        adapter.addFragment(scheduleCompFragment,"COMPETITIONS" );
        adapter.addFragment(scheduleConcertsFragment, "CONCERTS");
        adapter.addFragment(scheduleInformalsFragment, "INFORMAL");

        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


}
