package mon.dao;

import mon.model.Digimon;

import java.sql.SQLException;

public interface DigimonDAO {
    public void addDigimon(Digimon digimon) throws SQLException;

    public Digimon readDigimon(int digimonID) throws SQLException;

    public void editDigimon(int digimonID) throws SQLException;

    public void deleteDigimon(int digimonID) throws SQLException;
}
