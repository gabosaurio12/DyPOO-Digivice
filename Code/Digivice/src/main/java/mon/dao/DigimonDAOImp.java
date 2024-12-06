package mon.dao;

import mon.database.DataBaseConnection;
import mon.model.Digimon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DigimonDAOImp implements DigimonDAO  {
    private final String tableName = "digimon";

    @Override
    public void addDigimon(Digimon digimon) throws SQLException {
        Connection connection = DataBaseConnection.getInstance().getConnection();
        String query = "INSERT INTO " + tableName + " values (?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, digimon.getName());
        ps.setString(2, digimon.getFirstAppearance());
        ps.setString(3, digimon.getLevel());
        ps.setString(4, digimon.getType());
        ps.setString(5, digimon.getSpecialAttack());
        ps.setString(6, digimon.getImageRoute());

        ps.execute();
    }

    @Override
    public Digimon readDigimon(int id) throws SQLException {
        Connection connection = DataBaseConnection.getInstance().getConnection();
        String query = "SELECT digimon_id, digimon_name, first_appearance, level, type, special_attack, image_route FROM " + tableName + " WHERE digimon_id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Digimon digimon = new Digimon();
        if (rs.next()) {
            digimon.setId(rs.getInt(1));
            digimon.setName(rs.getString(2));
            digimon.setFirstAppearance(rs.getString(3));
            digimon.setLevel(rs.getString(4));
            digimon.setType(rs.getString(5));
            digimon.setSpecialAttack(rs.getString(6));
            digimon.setImageRoute(rs.getString(7));
        }
        return digimon;
    }

    @Override
    public void editDigimonName(Digimon digimon) throws SQLException {
        Connection connection = DataBaseConnection.getInstance().getConnection();
        String query = "UPDATE " + tableName + " SET digimon_name = ? WHERE digimon_id = ? ";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, digimon.getName());
        ps.setInt(2, digimon.getId());
        ps.executeUpdate();
    }

    @Override
    public void deleteDigimon(Digimon digimon) throws SQLException {
        Connection connection = DataBaseConnection.getInstance().getConnection();
        String query = "DELETE FROM " + tableName + " WHERE digimon_id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, digimon.getId());
        ps.executeUpdate();
    }
}
