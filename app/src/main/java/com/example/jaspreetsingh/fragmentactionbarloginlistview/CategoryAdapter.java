package com.example.jaspreetsingh.fragmentactionbarloginlistview;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by jaspreet.singh on 3/19/2018.
 */

/**
 * {@link CategoryAdapter} is a {@link FragmentPagerAdapter} that can provide the layout for
 * each list item based on a data source.
 */
public class CategoryAdapter extends FragmentPagerAdapter {

    /** Context of the App */
    private Context mContext;

    /**
     * Create a new {@link CategoryAdapter} object.
     *
     * @param fm is the fragment manager that will keep each fragment's state in the adapter
     *           across swipes.
     */
    public CategoryAdapter (Context context, FragmentManager fm)  {
        super(fm);
        mContext = context;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0)  {
            return new HomeFragment();
        } else {
            return new HistoryFragment();
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 2;
    }

    public CharSequence getPageTitle(int postion)   {
        if (postion==0) {
            return mContext.getString(R.string.category_home);
        }
        else    {
            return mContext.getString(R.string.category_history);
        }
    }
}
