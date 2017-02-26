package com.zamkovenko.taskcontroll;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Author: yevgeniy.zamkovenko
 * Date: 26.02.2017
 */

public class NavigationDrawerItemClickListener implements ListView.OnItemClickListener  {

    Activity context;

    android.app.Fragment friendFragment;
    android.app.Fragment taskFragment;


    public NavigationDrawerItemClickListener(MainActivity activity) {
        context = activity;

        friendFragment = new FriendFragment();
        taskFragment = new TaskFragment();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        ((DrawerLayout) context.findViewById(R.id.drawer_layout)).closeDrawers();
        switch (position) {
            case 0:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    context.getFragmentManager().beginTransaction().replace(R.id.content_frame, friendFragment ).commit();
                }
                break;
            case 1:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    context.getFragmentManager().beginTransaction().replace(R.id.content_frame, taskFragment ).commit();
                }
                break;
            case 2:
                break;
            default:
                Log.d(this.getClass().getSimpleName(), "Forget to add new Listener?");
                break;
        }

    }
}
