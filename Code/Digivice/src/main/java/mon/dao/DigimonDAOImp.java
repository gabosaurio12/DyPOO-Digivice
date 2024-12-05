package mon.dao;

import mon.model.Digimon;

import java.sql.SQLException;

public class DigimonDAOImp implements DigimonDAO {
    private final String tableName = "digimon";


    @Override
    public void addDigimon(Digimon digimon) throws SQLException {

    }

    @Override
    public Digimon readDigimon(int digimonID) throws SQLException {
        return null;
    }

    @Override
    public void editDigimon(int digimonID) throws SQLException {

    }

    @Override
    public void deleteDigimon(int digimonID) throws SQLException {

    }
}
