package com.zamkovenko.taskcontroll.dbhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.zamkovenko.taskcontroll.dao.Repository;
import com.zamkovenko.taskcontroll.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Yevgeniy Zamkovenko
 * Date: 08.04.2017
 */

public class FriendDbHelper extends SQLiteOpenHelper implements Repository<User> {

    private static final String DATABASE_NAME = "friends";
    private static final int DATABASE_VERSION = 1;
    ArrayList<User> friends;

    @Override
    public void onCreate(SQLiteDatabase db) {
        friends = new ArrayList<>();

        friends.add(new User("Francis", "+380965354234"));
        friends.add(new User("Bill", "+380965354234"));
        friends.add(new User("Louis", "+380965354234"));
        friends.add(new User("Zoey", "+380965354234"));
    }

    private FriendDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public List<User> getAll() {
        return friends;
    }

    @Override
    public User getById(String id) {

        for (User f :
                friends) {
            if (f.getName().equals(id)) {
                return f;
            }
        }

        return null;
    }

    @Override
    public void insert(User task) {

    }
}
