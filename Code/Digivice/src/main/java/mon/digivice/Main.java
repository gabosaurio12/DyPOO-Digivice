package mon.digivice;

import mon.dao.DigimonDAOImp;
import mon.front.CartaDigimon;
import mon.model.Digimon;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DigimonDAOImp digivice = new DigimonDAOImp();
        Digimon digimon = digivice.readDigimon(24);
        new CartaDigimon(digimon);
    }
}
