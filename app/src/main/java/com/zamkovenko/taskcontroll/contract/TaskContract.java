package com.zamkovenko.taskcontroll.contract;

import android.provider.BaseColumns;

/**
 * User: EvgeniyJames
 * Date: 06.03.2017
 */

public final class TaskContract {
    public TaskContract() {
    }

    public static abstract class TaskEntry implements BaseColumns {

        public static final String TABLE_NAME = "tasks";

        public static final String COLUMN_NAME_TITLE = "title";
    }
}
