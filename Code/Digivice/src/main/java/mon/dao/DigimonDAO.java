package mon.dao;

import mon.model.Digimon;

import java.sql.SQLException;
import java.util.List;

public interface DigimonDAO {
    Digimon readDigimon(int id) throws SQLException;

    void editDigimonName(Digimon digimon) throws SQLException;

    List<Digimon> readAllDigimon() throws SQLException;
}
