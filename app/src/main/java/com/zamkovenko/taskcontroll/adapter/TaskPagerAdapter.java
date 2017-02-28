package com.zamkovenko.taskcontroll.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.zamkovenko.taskcontroll.fragment.MyTaskFragment;
import com.zamkovenko.taskcontroll.fragment.WaitingTaskFragment;

/**
 * User: EvgeniyJames
 * Date: 28.02.2017
 */

public class TaskPagerAdapter extends FragmentStatePagerAdapter {

    private int m_tabsCount;

    public TaskPagerAdapter(FragmentManager fm, int tabsCount) {
        super(fm);
        m_tabsCount = tabsCount;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new MyTaskFragment();
                break;
            case 1:
                fragment = new WaitingTaskFragment();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return m_tabsCount;
    }
}
