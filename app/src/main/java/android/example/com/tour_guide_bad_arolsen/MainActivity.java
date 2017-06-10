package android.example.com.tour_guide_bad_arolsen;


import android.example.com.tour_guide_bad_arolsen.data.VirtualDataBase2;
import android.example.com.tour_guide_bad_arolsen.fragments.GenericFragment;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private String[] sectionTitles;
    private int currentPageIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sectionTitles = new String[]{
                getString(R.string.section_title_1), getString(R.string.section_title_2),
                getString(R.string.section_title_3), getString(R.string.section_title_4)};

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.top_nav_tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }


    @Override
    protected void onPause() {
        super.onPause();
        currentPageIndex = mViewPager.getCurrentItem();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewPager.setCurrentItem(currentPageIndex);
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return GenericFragment.newInstance(
                            new ArrayList<>(VirtualDataBase2.getHistoricalPlaces(MainActivity.this)));
                case 1:
                    return GenericFragment.newInstance(
                            new ArrayList<>(VirtualDataBase2.getGastronomyPlaces(MainActivity.this)));
                case 2:
                    return GenericFragment.newInstance(
                            new ArrayList<>(VirtualDataBase2.getRecreationPlaces(MainActivity.this)));
                case 3:
                    return GenericFragment.newInstance(
                            new ArrayList<>(VirtualDataBase2.getSportsPlaces(MainActivity.this)));
                default:
                    return GenericFragment.newInstance(
                            new ArrayList<>(VirtualDataBase2.getHistoricalPlaces(MainActivity.this)));
            }

        }

        @Override
        public int getCount() {
            // Show 4 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return sectionTitles[position];

        }


    }
}
