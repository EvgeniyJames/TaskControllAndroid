package com.zamkovenko.taskcontroll.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.zamkovenko.taskcontroll.R;
import com.zamkovenko.taskcontroll.adapter.TaskPagerAdapter;

/**
 * Author: yevgeniy.zamkovenko
 * Date: 26.02.2017
 */

@RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
public class TaskFragmentActivity extends FragmentActivity {

    private ViewPager m_viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_task_tabbed);

        setTitle(getString(R.string.my_task_fragment));

        TaskPagerAdapter taskPagerAdapter = new TaskPagerAdapter(getSupportFragmentManager(), 2);

        m_viewPager = (ViewPager) findViewById(R.id.pager);
        m_viewPager.setAdapter(taskPagerAdapter);
    }
}
