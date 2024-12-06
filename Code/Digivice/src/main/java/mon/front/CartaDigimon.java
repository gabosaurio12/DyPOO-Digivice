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

        JPanel topPanel = new JPanel(new BorderLayout());

        JButton backButton = new JButton("Volver al menú");
        JLabel nameLabel = new JLabel(digimon.getName(), JLabel.CENTER);

        topPanel.add(backButton, BorderLayout.WEST);
        topPanel.add(nameLabel, BorderLayout.CENTER);

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

        JPanel infoPanel = new JPanel(new GridLayout(5,1));

        infoPanel.add(createInfoLine("Nivel ", digimon.getLevel()));
        infoPanel.add(createInfoLine("Tipo ", digimon.getType()));
        infoPanel.add(createInfoLine("Ataque ", digimon.getSpecialAttack()));
        infoPanel.add(createInfoLine("Primera Aparición ", digimon.getFirstAppearance()));

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(imagePanel, BorderLayout.CENTER);
        mainPanel.add(infoPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private JPanel createInfoLine(String label, String value) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel lbl = new JLabel(label);
        JLabel val = new JLabel(value);

        panel.add(lbl, BorderLayout.WEST);
        panel.add(val, BorderLayout.CENTER);

        return panel;
    }
}
