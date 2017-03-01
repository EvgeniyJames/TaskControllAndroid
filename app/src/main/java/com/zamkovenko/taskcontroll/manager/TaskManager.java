package com.zamkovenko.taskcontroll.manager;

import com.zamkovenko.taskcontroll.model.Task;

import java.util.ArrayList;

/**
 * User: EvgeniyJames
 * Date: 01.03.2017
 */

public class TaskManager {

    private static TaskManager s_instance;

    private TaskManager(){

    }

    public static TaskManager GetInstance(){
        if (s_instance == null) {
            s_instance = new TaskManager();
        }
        return s_instance;
    }

    public ArrayList<Task> GetMyTasks() {
        ArrayList<Task> tasks = new ArrayList<>();

        tasks.add(new Task("Dog"));
        tasks.add(new Task("Pizza"));
        tasks.add(new Task("Wash"));
        tasks.add(new Task("Homework"));
        tasks.add(new Task("Lessons"));
        tasks.add(new Task("Flowers"));
        tasks.add(new Task("Stuff"));
        tasks.add(new Task("Left 4 Dead 3"));

        return tasks;
    }

}
