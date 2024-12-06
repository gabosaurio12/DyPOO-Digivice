package mon.front;

import mon.model.Digimon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

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

        JButton backButton = new JButton("Volver");
        backButton.addActionListener(e -> dispose());

        JLabel nameLabel = new JLabel(digimon.getName(), JLabel.CENTER);

        topPanel.add(backButton, BorderLayout.WEST);

        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.add(nameLabel, BorderLayout.NORTH);

        try {
            ImageIcon image = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/" + digimon.getImageRoute())));
            Image imageScaled = image.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            ImageIcon imageResized = new ImageIcon(imageScaled);

            JLabel imageLabel = new JLabel(imageResized);
            imagePanel.add(imageLabel, BorderLayout.CENTER);
        } catch (NullPointerException e) {
            System.err.println("Error: La imagen no se encontró. Verificar ruta");
            JLabel errorLabel = new JLabel("Imagen no disponible");
            imagePanel.add(errorLabel);
        }

        JPanel infoPanel = new JPanel(new BorderLayout());

        JTable infoTable = createTable(getTableInfo(digimon));

        infoPanel.add(infoTable);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(imagePanel, BorderLayout.CENTER);
        mainPanel.add(infoPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private String[][] getTableInfo(Digimon digimon) {
        return new String[][]{
                {"Nivel", digimon.getLevel()},
                {"Tipo", digimon.getType()},
                {"Ataque Especial", digimon.getSpecialAttack()},
                {"Primera Aparición", digimon.getFirstAppearance()}
        };
    }

    private JTable createTable(String[][] info) {
        String[] columnNames = {"", ""};
        JTable table = new JTable(info, columnNames);
        table.setEnabled(false);

        return table;
    }
}
