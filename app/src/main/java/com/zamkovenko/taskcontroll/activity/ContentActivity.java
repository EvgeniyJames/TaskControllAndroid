package com.zamkovenko.taskcontroll.activity;

import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.zamkovenko.taskcontroll.R;
import com.zamkovenko.taskcontroll.dbhelper.TaskerDbHelper;
import com.zamkovenko.taskcontroll.fragment.FriendFragment;
import com.zamkovenko.taskcontroll.fragment.TaskDebugFragment;
import com.zamkovenko.taskcontroll.fragment.TaskFragment;

public class ContentActivity extends AppCompatActivity {

    private DrawerLayout m_drawerLayout;
    private ListView m_drawerList;

    private FriendFragment m_friendFragment;
    private TaskFragment m_taskFragment;
    private TaskDebugFragment m_taskDebugFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        String[] menuNames = getResources().getStringArray(R.array.navigatioin_menus);

        m_drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        m_drawerList = (ListView) findViewById(R.id.left_drawer);

        // Set the adapter for the list view
        m_drawerList.setAdapter(new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item, menuNames));
        // Set the list's click listener
        m_drawerList.setOnItemClickListener(new NavigationDrawerItemClickListener());

        m_friendFragment = new FriendFragment();
        m_taskFragment = new TaskFragment();
        m_taskDebugFragment = new TaskDebugFragment();

        SelectFragment(new TaskFragment());

        TaskerDbHelper.getInstance(this);
    }
    private class NavigationDrawerItemClickListener implements ListView.OnItemClickListener {

        @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            m_drawerLayout.closeDrawers();
            switch (position) {
                case 0:
                    SelectFragment(m_friendFragment);
                    break;
                case 1:
                    SelectFragment(new TaskFragment());
                    break;
                case 2:
                    SelectFragment(m_taskDebugFragment);
                    break;
                default:
                    Log.d(this.getClass().getSimpleName(), "Forget to add new Listener?");
                    Toast.makeText(ContentActivity.this, "Forget to add new Listener?" , Toast
                            .LENGTH_SHORT).show();
                    break;
            }
        }
    }

    private void SelectFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment)
                .commit();
    }
}
