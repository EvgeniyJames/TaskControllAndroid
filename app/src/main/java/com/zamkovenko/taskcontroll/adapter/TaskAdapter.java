package com.zamkovenko.taskcontroll.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.zamkovenko.taskcontroll.R;
import com.zamkovenko.taskcontroll.model.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * User: EvgeniyJames
 * Date: 01.03.2017
 */

public class TaskAdapter extends ArrayAdapter<Task> {

    private List<Task> dataSet;
    private Context m_context;

    // View lookup cache
    private static class ViewHolder {
        TextView txtTheme;
    }

    public TaskAdapter(List<Task> data, Context context) {
        super(context, R.layout.task_item, data);
        dataSet = data;
        m_context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Task task = getItem(position);
        ViewHolder viewHolder;
        Context context = getContext();

        if (convertView == null) {

            viewHolder = new ViewHolder();

            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.task_item, parent, false);

            viewHolder.txtTheme = (TextView) convertView.findViewById(R.id.task_theme);

            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        assert task != null;
        viewHolder.txtTheme.setText(task.getTitle());

        return convertView;
    }
}
