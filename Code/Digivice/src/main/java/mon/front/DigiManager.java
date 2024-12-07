package mon.front;

import mon.dao.DigimonDAOImp;
import mon.model.Digimon;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class DigiManager extends JFrame {
    public final DigimonDAOImp digiDao = new DigimonDAOImp();

    public List<Digimon> readAllDigimons() throws SQLException {
        return digiDao.readAllDigimon();
    }


}
