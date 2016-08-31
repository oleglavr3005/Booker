package com.epam.task.database.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionManager {
    public static Connection getConnection() {
        try {
            return ConnectionManagerHelper.DATA_SOURCE_INSTANCE.getConnection();
        } catch (SQLException e) {
            throw new NullPointerException("Fail while create connection.");
        }
    }

    private static class ConnectionManagerHelper {
        private static final DataSource DATA_SOURCE_INSTANCE = initDataSource();

        private static DataSource initDataSource() {
            try {
                Context initialContext = new InitialContext();
                Context environmentContext = (Context) initialContext.lookup("java:comp/env");
                String dataResourceName = "jdbc/booking";
                return (DataSource) environmentContext.lookup(dataResourceName);
            } catch (NamingException e) {
                throw new NullPointerException("Fail while data source initialization.");
            }
        }
    }
}
