package com.zamkovenko.taskcontroll.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zamkovenko.taskcontroll.R;

/**
 * User: EvgeniyJames
 * Date: 28.02.2017
 */

@RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
public class WaitingTaskFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_wainting_tasks, container, false);

        getActivity().setTitle(getString(R.string.waiting_task_fragment));

        return view;
    }
}
