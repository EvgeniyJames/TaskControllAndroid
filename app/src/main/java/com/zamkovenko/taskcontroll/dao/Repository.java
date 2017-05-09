package com.zamkovenko.taskcontroll.dao;

import com.zamkovenko.taskcontroll.model.Task;

import java.util.List;

/**
 * User: Yevgeniy Zamkovenko
 * Date: 08.04.2017
 */

public interface Repository<T> {

    List<T> getAll();

    T getById(String id);

    void insert(T task);

}
