package com.zamkovenko.taskcontroll.fragment;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zamkovenko.taskcontroll.R;

/**
 * Author: yevgeniy.zamkovenko
 * Date: 26.02.2017
 */

@RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
public class TaskFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_tasks, container, false);

        getActivity().setTitle(getString(R.string.title_tasks));

        return view;
    }
}
