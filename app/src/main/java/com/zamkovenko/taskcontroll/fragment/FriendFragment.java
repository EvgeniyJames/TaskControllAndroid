package com.zamkovenko.taskcontroll.fragment;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zamkovenko.taskcontroll.R;
import com.zamkovenko.taskcontroll.adapter.FriendAdapter;
import com.zamkovenko.taskcontroll.manager.FriendManager;
import com.zamkovenko.taskcontroll.model.Friend;

import java.util.ArrayList;

/**
 * Author: yevgeniy.zamkovenko
 * Date: 26.02.2017
 */

@RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
public class FriendFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_friends, container, false);

        Activity context = getActivity();
        context.setTitle(getString(R.string.title_friends));

        ListView listView = (ListView) view.findViewById(R.id.friends_list);

        ArrayList<Friend> friends = FriendManager.GetInstance().GetFriends();

        ArrayAdapter arrayAdapter = new FriendAdapter(friends, getActivity());
        listView.setAdapter(arrayAdapter);

        return view;
    }
}
