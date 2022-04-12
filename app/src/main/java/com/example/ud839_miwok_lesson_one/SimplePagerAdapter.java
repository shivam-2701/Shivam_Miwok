package com.example.ud839_miwok_lesson_one;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SimplePagerAdapter extends FragmentPagerAdapter {
    private String tabTitles[]={"NUMBERS","FAMILY","COLORS","PHRASES"};
    public SimplePagerAdapter(FragmentManager fm){
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:return new NumbersFragment();
            case 1:return new FamilyFragment();
            case 2:return new ColorsFragment();
            case 3:return new PhrasesFragment();
            default:return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
