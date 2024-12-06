package mon.front;

import mon.model.Digimon;

import javax.swing.*;
import java.awt.*;

public class CartaDigimon extends JFrame {
    private final Digimon digimon;

    public CartaDigimon(Digimon digimon) {
        this.digimon = digimon;

        setTitle("Digivice");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);

        initComponents();
        setVisible(true);
    }

    public void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel searchPanel = new JPanel(new BorderLayout());
        JTextField searchBar = new JTextField("Buscar Digimon");
        searchPanel.add(searchBar, BorderLayout.CENTER);

        JPanel imagePanel = new JPanel(new BorderLayout());

        try {
            ImageIcon image = new ImageIcon(getClass().getResource(digimon.getImageRoute()));
            Image imageScaled = image.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            ImageIcon imageResized = new ImageIcon(imageScaled);

            JLabel imageLabel = new JLabel(imageResized);
            imagePanel.add(imageLabel, BorderLayout.CENTER);
        } catch (NullPointerException e) {
            System.err.println("Error: La imagen no se encontró. Verificar ruta");
            JLabel errorLabel = new JLabel("Imagen no disponible");
            imagePanel.add(errorLabel);
        }

        mainPanel.add(searchPanel, BorderLayout.NORTH);
        mainPanel.add(imagePanel, BorderLayout.CENTER);

        add(mainPanel);
    }
}
