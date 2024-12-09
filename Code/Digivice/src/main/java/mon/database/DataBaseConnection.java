package mon.database;

import java.sql.*;

public class DataBaseConnection {
    private static DataBaseConnection instance;
    private Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3306/digimonDB";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    private DataBaseConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static DataBaseConnection getInstance() throws SQLException {
        if (instance == null || instance.getConnection().isClosed()) {
            instance = new DataBaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
