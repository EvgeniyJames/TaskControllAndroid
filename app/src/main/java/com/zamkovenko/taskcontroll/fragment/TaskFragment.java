package com.zamkovenko.taskcontroll.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zamkovenko.taskcontroll.R;
import com.zamkovenko.taskcontroll.adapter.TaskPagerAdapter;

/**
 * Author: yevgeniy.zamkovenko
 * Date: 26.02.2017
 */

@RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
public class TaskFragment extends Fragment {

    private ViewPager m_viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.layout_task_tabbed, container, false);

        getActivity().setTitle(R.string.tasks);

        TaskPagerAdapter taskPagerAdapter = new TaskPagerAdapter(getActivity().getSupportFragmentManager(), 2);

        m_viewPager = (ViewPager) view.findViewById(R.id.pager);
        m_viewPager.setAdapter(taskPagerAdapter);

        return view;
    }
}
