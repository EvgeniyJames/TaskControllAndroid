package com.zamkovenko.taskcontroll.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.zamkovenko.taskcontroll.R;
import com.zamkovenko.taskcontroll.asynctask.SimpleRequest;
import com.zamkovenko.taskcontroll.dbhelper.TaskerDbHelper;
import com.zamkovenko.taskcontroll.model.Task;
import com.zamkovenko.taskcontroll.service.NewTaskCreatorDelayed;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

import static com.zamkovenko.taskcontroll.contract.TaskContract.TaskEntry.TABLE_NAME;

/**
 * User: EvgeniyJames
 * Date: 06.03.2017
 */

public class TaskDebugFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.layout_task_creator_debug, container, false);

        Button btnStartService = (Button) view.findViewById(R.id.btn_start_service);
        Button btnStopService = (Button) view.findViewById(R.id.btn_stop_service);
        final Button btnAddFakeTask = (Button) view.findViewById(R.id.btn_add_fake_task);
        Button btnClearTaskDb = (Button) view.findViewById(R.id.btn_clear_task_db);
        Button btnSendRequest = (Button) view.findViewById(R.id.btn_send_request);

        final TaskerDbHelper dbHelper = TaskerDbHelper.getInstance(getContext());

        btnClearTaskDb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.getWritableDatabase().execSQL("delete from "+ TABLE_NAME);
            }
        });

        btnAddFakeTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Task task = new Task("Task: " + new Date(System.currentTimeMillis()));
                dbHelper.InsertTask(task);
            }
        });

        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                context.startService(new Intent(context, NewTaskCreatorDelayed.class));
            }
        });

        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                context.stopService(new Intent(context, NewTaskCreatorDelayed.class));
            }
        });

        btnSendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new SimpleRequest().execute();
            }
        });

        getActivity().setTitle(getString(R.string.task_creator_debug));

        return view;

    }

}
