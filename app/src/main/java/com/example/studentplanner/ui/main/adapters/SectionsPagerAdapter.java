package com.example.studentplanner.ui.main.adapters;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.example.studentplanner.R;
import com.example.studentplanner.ui.activities.AssessmentsFragment;
import com.example.studentplanner.ui.activities.CoursesFragment;
import com.example.studentplanner.ui.activities.MainFragment;
import com.example.studentplanner.ui.activities.TermsFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_terms_text, R.string.tab_courses_text, R.string.tab_assessments_text
    };
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        switch(position){
            case 0:
                return TermsFragment.newInstance(position);
            case 1:
                return CoursesFragment.newInstance(position);
            case 2:
                return AssessmentsFragment.newInstance(position);
            default:
                return MainFragment.newInstance(position);
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }
}