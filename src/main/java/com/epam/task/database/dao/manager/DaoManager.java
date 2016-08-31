package com.epam.task.database.dao.manager;

import java.sql.Connection;
import java.sql.SQLException;

import com.epam.task.database.dao.FeedbackDao;
import com.epam.task.database.dao.HotelDao;
import com.epam.task.database.dao.OrderDAO;
import com.epam.task.database.dao.RoomDao;
import com.epam.task.database.dao.UserDao;
import com.epam.task.database.util.ConnectionManager;

public class DaoManager {

    private Connection connection;
    private UserDao userDao;
    private RoomDao roomDao;
    private FeedbackDao feedbackDao;
    private OrderDAO orderDAO;
    private HotelDao hotelDao;
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

    public UserDao getUserDao() {
        if (userDao == null) userDao = new UserDao(getConnection());
        else userDao.setConnection(getConnection());
        return userDao;
    }

    public RoomDao getRoomDao() {
        if (roomDao == null) roomDao = new RoomDao(getConnection());
        else roomDao.setConnection(getConnection());
        return roomDao;
    }

    public FeedbackDao getFeedbackDao() {
    	if (feedbackDao == null) feedbackDao = new FeedbackDao(getConnection());
        else feedbackDao.setConnection(getConnection());
        return feedbackDao;
	}
    
    public OrderDAO getOrderkDao() {
    	if (orderDAO == null) orderDAO = new OrderDAO(getConnection());
        else orderDAO.setConnection(getConnection());
        return orderDAO;
	}
    
    public HotelDao getHotelDao(){
    	if(hotelDao == null) hotelDao = new HotelDao(getConnection());
    	else hotelDao.setConnection(getConnection());
    	return hotelDao;
    }
    
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
