package com.example.gamebaicao.ui.main;

import android.content.Context;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.gamebaicao.Fragment.Fra_May_May;
import com.example.gamebaicao.Fragment.Fra_Nguoi_May;
import com.example.gamebaicao.Fragment.Fra_TinhDiem;
import com.example.gamebaicao.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    int countTabItem;
    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = new Fragment();
        Log.d("HuuNguyen", String.valueOf(position));
        switch (position)
        {
            case 0:
                frag = new Fra_TinhDiem();
                break;
            case 1:
                frag = new Fra_May_May();
                break;
            case 2:
                frag = new Fra_Nguoi_May();
                break;
        }
        return frag;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 3;
    }
}