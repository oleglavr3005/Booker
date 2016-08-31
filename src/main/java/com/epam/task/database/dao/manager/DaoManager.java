package com.epam.task.database.dao.manager;

import java.sql.Connection;
import java.sql.SQLException;

import com.epam.task.database.util.ConnectionManager;

public class DaoManager {

    private Connection connection;
//    private UserDao userDao;

    public DaoManager() {
    }

    private Connection getConnection(){
        try {
            if(this.connection == null || this.connection.isClosed()){
                this.connection = ConnectionManager.getConnection();
                if (connection == null) throw new NullPointerException("No connection.");
            }
        } catch (SQLException e) {
        	e.printStackTrace();
            throw new NullPointerException("No connection.");
        }
        return connection;
    }

//    public UserDao getUserDao() {
//        if (userDao == null) userDao = new UserDao(getConnection());
//        else userDao.setConnection(getConnection());
//        return userDao;
//    }

    public <T> T executeAndClose(DaoCommand<T> command){
        try{
            return command.execute();
        } finally {
            try {
                getConnection().close();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
        }
    }

    public void executeVoidAndClose(DaoVoidCommand command){
        try{
            command.execute();
        } finally {
            try {
                getConnection().close();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
        }
    }
}
