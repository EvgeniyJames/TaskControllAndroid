package com.zamkovenko.taskcontroll.fragment;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.zamkovenko.taskcontroll.R;
import com.zamkovenko.taskcontroll.Utils;
import com.zamkovenko.taskcontroll.adapter.FriendAdapter;
import com.zamkovenko.taskcontroll.manager.AccountManager;
import com.zamkovenko.taskcontroll.model.User;
import com.zamkovenko.taskcontroll.service.FriendService;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author: yevgeniy.zamkovenko
 * Date: 26.02.2017
 */

public class FriendFragment extends Fragment {

    @BindView(R.id.friends_list)
    ListView m_friends;

    ArrayList<User> m_friendsList;

    FriendAdapter friendAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_friends, container, false);

        ButterKnife.bind(this, view);

        Activity context = getActivity();
        context.setTitle(getString(R.string.title_friends));

        m_friendsList = new ArrayList<>();

        friendAdapter = new FriendAdapter(m_friendsList, getActivity());
        m_friends.setAdapter(friendAdapter);

        OnRefreshFriendsClick(null);

        return view;
    }

    @OnClick(R.id.btn_refresh_friends)
    public void OnRefreshFriendsClick(View v) {

        Log.d("App", "click");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Utils.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FriendService service = retrofit.create(FriendService.class);
        Call<List<User>> friends = service.listFriends(AccountManager.GetInstance().GetToken(),
                AccountManager.GetInstance().getAccountId());
        friends.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                List<User> userList = response.body();

                m_friendsList.clear();
                m_friendsList.addAll(userList);

                friendAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.d("onFailure", t.toString());
            }
        });

    }
}
