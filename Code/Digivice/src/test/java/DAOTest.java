import mon.dao.AdminUserDAOImp;
import mon.dao.DigimonDAOImp;
import mon.model.Digimon;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class DAOTest {
    @Test
    public void DigimonDAOTest() throws SQLException {
        DigimonDAOImp digiDAO = new DigimonDAOImp();

        String[] namesExpected = {"Koromon", "Agumon", "Greymon"};

        for (int i = 1; i < 4; i++) {
            Digimon digimon = digiDAO.readDigimon(i);
            assertEquals(namesExpected[i-1], digimon.getName(), "Los nombres deben ser iguales");
        }

        String[] namesNotExpected = {"Pikachu", "Charizard", "Francisco"};

        for (int i = 4; i < 7; i++) {
            Digimon digimon = digiDAO.readDigimon(i);
            assertNotEquals(namesNotExpected[i-4], digimon.getName());
        }
    }

    @Test
    public void AmdinUserDAOTest() throws SQLException {
        AdminUserDAOImp adminDAO = new AdminUserDAOImp();

        Map<String, String> fakeUsers = new HashMap<>();
        fakeUsers.put("Michael", "678578");
        fakeUsers.put("José", "superContraseña");
        fakeUsers.put("usuario", "contraseña");

        for (Map.Entry<String, String> i : fakeUsers.entrySet()) {
            assertFalse(adminDAO.authenticateUser(i.getKey(), i.getValue()));
        }
    }
}