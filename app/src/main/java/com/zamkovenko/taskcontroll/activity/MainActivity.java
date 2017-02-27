package com.zamkovenko.taskcontroll.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zamkovenko.taskcontroll.fragment.FriendFragment;
import com.zamkovenko.taskcontroll.R;
import com.zamkovenko.taskcontroll.fragment.TaskFragment;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout m_drawerLayout;
    private ListView m_drawerList;

    private FriendFragment m_friendFragment;
    private TaskFragment m_taskFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String [] menuNames = getResources().getStringArray(R.array.navigatioin_menus);

        m_drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        m_drawerList = (ListView) findViewById(R.id.left_drawer);
//
        // Set the adapter for the list view
        m_drawerList.setAdapter(new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item, menuNames));
        // Set the list's click listener
        m_drawerList.setOnItemClickListener(new NavigationDrawerItemClickListener());

        m_friendFragment = new FriendFragment();
        m_taskFragment = new TaskFragment();

    }

    public class NavigationDrawerItemClickListener implements ListView.OnItemClickListener  {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            m_drawerLayout.closeDrawers();
            switch (position) {
                case 0:
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                        getFragmentManager().beginTransaction().replace(R.id.content_frame, m_friendFragment )
                                .commit();
                    }
                    break;
                case 1:
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                        getFragmentManager().beginTransaction().replace(R.id.content_frame, m_taskFragment)
                                .commit();
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
}
