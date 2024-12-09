package mon.dao;

import mon.database.DataBaseConnection;
import mon.model.AdminUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Esta clase maneja las operaciones CRUD de la base de datos
 * Proporciona metodos para autenticar al usuario
 */

public class AdminUserDAOImp implements AdminUserDAO {
    private final String tableName;

    public AdminUserDAOImp() {
        tableName = "user";
    }

    @Override
    public boolean authenticateUser(AdminUser user) throws SQLException {
        Connection connection = DataBaseConnection.getInstance().getConnection();
        String query = "SELECT * FROM " + tableName + "  WHERE user_name = ? AND user_password = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, user.getUserName());
        ps.setString(2, user.getUserPassword());
        ResultSet rs = ps.executeQuery();

        return rs.next();
    }
}
