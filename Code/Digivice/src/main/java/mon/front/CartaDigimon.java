package mon.front;

import mon.model.Digimon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * Representa una carta de Digimon
 * Cda carta tiene los datos y la imagen del Digimon
 *
 * @author Liz
 * @version 1.0
 */

public class CartaDigimon extends JFrame {
    private final Digimon digimon;

    public CartaDigimon(Digimon digimon) {
        this.digimon = digimon;

        setTitle(digimon.getName());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);

        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(173, 216, 230));

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(135, 205, 250));

        JButton backButton = new JButton("Volver");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MainWindow();
            }
        });

        JButton editButton  = new JButton("Editar");
        editButton.addActionListener(e -> openEditWindow());

        JLabel nameLabel = new JLabel(digimon.getName(), JLabel.CENTER);
        nameLabel.setFont(new Font("MonoSpaced", Font.BOLD, 18));
        nameLabel.setForeground(new Color(255, 165, 0));

        topPanel.add(backButton, BorderLayout.WEST);
		topPanel.add(editButton, BorderLayout.EAST);

        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.setBackground(new Color(240, 248, 255));
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
        infoPanel.setBackground(new Color(224,255,255));

        JTable infoTable = createTable(getTableInfo(digimon));
        infoTable.setFont(new Font("Monospaced", Font.PLAIN, 14));

        infoPanel.add(infoTable);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(imagePanel, BorderLayout.CENTER);
        mainPanel.add(infoPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    public void openEditWindow() {
        new Login(digimon);

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
