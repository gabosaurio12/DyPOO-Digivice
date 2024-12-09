package mon.front;

import mon.dao.DigimonDAOImp;
import mon.model.Digimon;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

/**
 * Esta clase es la conexión entre el frontend y el backend
 */

public class DigiManager extends JFrame {
    public final DigimonDAOImp digiDao = new DigimonDAOImp();

    public List<Digimon> readAllDigimons() throws SQLException {
        return digiDao.readAllDigimon();
    }


    public void updateDigimon(int id, String nuevoNombre) throws SQLException{
        Digimon digi = new Digimon(id, nuevoNombre);
        digiDao.editDigimonName(digi);
    }

}
