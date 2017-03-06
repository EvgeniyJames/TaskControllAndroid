package com.zamkovenko.taskcontroll.presenter;

import com.zamkovenko.taskcontroll.view.TaskView;

/**
 * User: EvgeniyJames
 * Date: 06.03.2017
 */

public class TaskPresenter implements Presenter {

    private TaskView m_taskView;

    public void setTaskView(TaskView taskView) {
        m_taskView = taskView;
    }


    @Override
    public void Initialize() {

    }
}
