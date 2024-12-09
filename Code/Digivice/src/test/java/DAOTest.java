import mon.dao.AdminUserDAOImp;
import mon.dao.DigimonDAOImp;
import mon.model.AdminUser;
import mon.model.Digimon;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

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
            assertNotEquals(namesNotExpected[i-4], digimon.getName(), "La prueba será exitosa si los nombres son diferentes");
        }
    }

    @Test
    public void AmdinUserDAOTest() throws SQLException {
        AdminUserDAOImp adminDAO = new AdminUserDAOImp();

        AdminUser[] fakeUsers = {new AdminUser("Michael", "678578"),
                new AdminUser("José", "superContraseña"),
                new AdminUser("usuario", "contraseña")};

        for (int i = 0; i < 3; i++) {
            assertFalse(adminDAO.authenticateUser(fakeUsers[i]));
        }
    }
}