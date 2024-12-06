package mon.digivice;

import mon.dao.DigimonDAO;
import mon.dao.DigimonDAOImp;
import mon.front.CartaDigimon;
import mon.model.Digimon;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DigimonDAOImp digivice = new DigimonDAOImp();
        Digimon digimon = digivice.readDigimon(8);

        CartaDigimon digicard = new CartaDigimon(digimon);
    }
}
