package com.zamkovenko.taskcontroll.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.zamkovenko.taskcontroll.contract.TaskContract;
import com.zamkovenko.taskcontroll.dao.Repository;
import com.zamkovenko.taskcontroll.model.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * User: EvgeniyJames
 * Date: 06.03.2017
 */

public class TaskerDbHelper extends SQLiteOpenHelper implements Repository<Task> {

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";

    private static final String SQL_CREATE_TASK =
            "CREATE TABLE " + TaskContract.TaskEntry.TABLE_NAME + " (" +
                    TaskContract.TaskEntry._ID + " INTEGER PRIMARY KEY," +
//                    TaskContract.TaskEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
                    TaskContract.TaskEntry.COLUMN_NAME_TITLE + TEXT_TYPE +
            " )";

    private static final String SQL_DELETE_TASK =
            "DROP TABLE IF EXISTS " + TaskContract.TaskEntry.TABLE_NAME;

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Task.db";

    private static final String SQL_SELECT_ALL = "SELECT  * FROM " + TaskContract.TaskEntry.TABLE_NAME;

    private static TaskerDbHelper sInstance;

    private TaskerDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized TaskerDbHelper getInstance(Context context) {

        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new TaskerDbHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_TASK);
    }

    public void InsertTask(Task task) {

        SQLiteDatabase database = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TaskContract.TaskEntry.COLUMN_NAME_TITLE, task.getTitle());

        database.insert(TaskContract.TaskEntry.TABLE_NAME, null, values);
    }

    public List<Task> GetAllTask() {
        List<Task> list = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        try {

            Cursor cursor = db.rawQuery(SQL_SELECT_ALL, null);
            try {
                if (cursor.moveToFirst()) {
                    do {
                        Task task = new Task(cursor.getString(1));
                        list.add(task);
                    } while (cursor.moveToNext());
                }

            } finally {
                try { cursor.close(); } catch (Exception ignore) {}
            }

        } finally {
            try { db.close(); } catch (Exception ignore) {}
        }

        return list;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_TASK);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    @Override
    public List<Task> getAll() {
        return GetAllTask();
    }

    @Override
    public Task getById(String id) {
        return GetAllTask().get(0);
    }


    @Override
    public void insert(Task task) {
        InsertTask(task);
    }
}
