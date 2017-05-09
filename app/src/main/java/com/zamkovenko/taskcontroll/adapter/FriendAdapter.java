package com.zamkovenko.taskcontroll.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.zamkovenko.taskcontroll.R;
import com.zamkovenko.taskcontroll.model.User;
import com.zamkovenko.taskcontroll.model.User;

import java.util.ArrayList;

/**
 * User: EvgeniyJames
 * Date: 28.02.2017
 */

public class FriendAdapter extends ArrayAdapter<User> {

    private Context m_context;
    private ArrayList<User> dataSet;

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
        TextView txtNumber;
    }

    public FriendAdapter(ArrayList<User> data, Context context) {
        super(context, R.layout.friend_item, data);
        this.dataSet = data;
        this.m_context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        User friend = getItem(position);
        ViewHolder viewHolder;
        Context context = getContext();

        if (convertView == null) {

            viewHolder = new ViewHolder();

            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.friend_item, parent, false);

            viewHolder.txtName = (TextView) convertView.findViewById(R.id.friend_item_name);
            viewHolder.txtNumber = (TextView) convertView.findViewById(R.id.friend_item_number);

            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        assert friend != null;
        viewHolder.txtName.setText(friend.getName());
        viewHolder.txtNumber.setText(friend.getNumber());

        return convertView;
    }
}
