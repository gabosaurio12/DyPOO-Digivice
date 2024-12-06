package mon.dao;

import java.sql.SQLException;

public interface AdminUserDAO {
    boolean authenticateUser(String userName, String userPassword) throws SQLException;
}
