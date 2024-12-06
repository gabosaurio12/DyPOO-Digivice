package mon.digivice;

import mon.front.CartaDigimon;
import mon.model.Digimon;

public class Main {
    public static void main(String[] args) {
        Digimon digimon = new Digimon();
        digimon.setName("Agumon");
        digimon.setId(1);
        digimon.setImageRoute("/images/agumon.jpg");
        digimon.setType("Lagarto");
        digimon.setLevel("Infante");
        digimon.setSpecialAttack("Flama Bebé");
        digimon.setFirstAppearance("Digimon Adventure");

        CartaDigimon digivice = new CartaDigimon(digimon);
    }
}
