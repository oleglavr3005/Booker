package com.epam.task.database.dao.manager;

public interface DaoCommand<T> {
    T execute();
}
