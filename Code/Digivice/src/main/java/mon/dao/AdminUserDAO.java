package mon.dao;

import mon.model.AdminUser;

import java.sql.SQLException;

public interface AdminUserDAO {
    boolean authenticateUser(AdminUser user) throws SQLException;
}
