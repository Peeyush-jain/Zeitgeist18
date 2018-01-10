package iitropar.zeitgeist18;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MyEvents extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_events);
        getSupportActionBar().setTitle("My Events");

        viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);


        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        MyEvents.ViewPagerAdapter adapter = new MyEvents.ViewPagerAdapter(getSupportFragmentManager());

        Bundle bundle = new Bundle();
        bundle.putInt("eventDay", 1);
        MyEventDayFragment day1 = new MyEventDayFragment();
        day1.setArguments(bundle);

        Bundle bundle1 = new Bundle();
        bundle1.putInt("eventDay", 2);
        MyEventDayFragment day2 = new MyEventDayFragment();
        day2.setArguments(bundle1);

        Bundle bundle2 = new Bundle();
        bundle2.putInt("eventDay", 3);
        MyEventDayFragment day3 = new MyEventDayFragment();
        day3.setArguments(bundle2);

        Bundle bundle3 = new Bundle();
        bundle3.putInt("eventDay", 4);
        MyEventDayFragment day4 = new MyEventDayFragment();
        day4.setArguments(bundle3);

        adapter.addFragment(day1,"Day 1" );
        adapter.addFragment(day2, "Day 2");
        adapter.addFragment(day3, "Day 3");
        adapter.addFragment(day4, "Day 4");

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
