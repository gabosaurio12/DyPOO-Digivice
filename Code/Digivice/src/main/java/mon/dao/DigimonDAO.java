package mon.dao;

import mon.model.Digimon;

import java.sql.SQLException;

public interface DigimonDAO {
    void addDigimon(Digimon digimon) throws SQLException;

    Digimon readDigimon(int id) throws SQLException;

    void editDigimonName(Digimon digimon) throws SQLException;

    void deleteDigimon(Digimon digimon) throws SQLException;
}
