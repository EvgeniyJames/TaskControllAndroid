package com.zamkovenko.taskcontroll.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.zamkovenko.taskcontroll.R;
import com.zamkovenko.taskcontroll.dbhelper.TaskerDbHelper;
import com.zamkovenko.taskcontroll.fragment.FriendFragment;
import com.zamkovenko.taskcontroll.fragment.TaskDebugFragment;
import com.zamkovenko.taskcontroll.fragment.TaskFragment;
import com.zamkovenko.taskcontroll.manager.AccountManager;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {


    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        boolean isLogedIn = AccountManager.GetInstance().IsLogedIn();
        if (isLogedIn) {
            startActivity(new Intent(this, ContentActivity.class));
        } else {
            startActivity(new Intent(this, LoginActivity.class));
        }

    }

}
