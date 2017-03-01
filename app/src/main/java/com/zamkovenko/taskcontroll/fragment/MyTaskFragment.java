package com.zamkovenko.taskcontroll.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zamkovenko.taskcontroll.R;
import com.zamkovenko.taskcontroll.adapter.TaskAdapter;
import com.zamkovenko.taskcontroll.manager.TaskManager;
import com.zamkovenko.taskcontroll.model.Task;

import java.util.ArrayList;

/**
 * User: EvgeniyJames
 * Date: 28.02.2017
 */

public class MyTaskFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_tasks, container, false);

        ListView listView = (ListView) view.findViewById(R.id.task_list);

        ArrayList<Task> tasks = TaskManager.GetInstance().GetMyTasks();

        ArrayAdapter arrayAdapter = new TaskAdapter(tasks, getActivity());
        listView.setAdapter(arrayAdapter);

        return view;
    }

}
