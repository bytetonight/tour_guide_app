package android.example.com.tour_guide_bad_arolsen;

import android.example.com.tour_guide_bad_arolsen.data.VirtualDataBase;
import android.example.com.tour_guide_bad_arolsen.fragments.GastronomyFragment;
import android.example.com.tour_guide_bad_arolsen.fragments.HistoricalFragment;
import android.example.com.tour_guide_bad_arolsen.fragments.RecreationFragment;
import android.example.com.tour_guide_bad_arolsen.fragments.SportsFragment;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

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
                    return HistoricalFragment.newInstance(VirtualDataBase.Poi.Historical);
                case 1:
                    return GastronomyFragment.newInstance(VirtualDataBase.Poi.Gastronomy);
                case 2:
                    return RecreationFragment.newInstance(VirtualDataBase.Poi.Recreational);
                case 3:
                    return SportsFragment.newInstance(VirtualDataBase.Poi.Sports);
                default: return HistoricalFragment.newInstance(VirtualDataBase.Poi.Historical);
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
