package mon.front;

import mon.model.Digimon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * Esta clase gestiona la ventana editor una vez que el login
 * haya sido exitoso
 */

public class Editor extends JFrame {
    private final Digimon digimon;
    private final DigiManager manager;

    public Editor(DigiManager manager, Digimon digimon) {
        this.digimon = digimon;
        this.manager = manager;
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        placeComponent(panel);

        add(panel, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void placeComponent(JPanel panel){
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel nameLabel = new JLabel("Introduce el nuevo nombre de digimon:");
        JTextField nameField = new JTextField();

        panel.add(nameLabel);
        panel.add(nameField);

        JButton updateButton =new JButton("Actualizar");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDigimon(digimon.getId(), nameField.getText());
            }
        });

        panel.add(updateButton);
    }

    private void updateDigimon(int id, String newName){
        if(newName.isEmpty()){
            JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío");
            return;
        }

        try{
            manager.updateDigimon(id, newName);
            JOptionPane.showMessageDialog(this, "Digimon actualizado correctamente");
            dispose();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error actualizando el Digimon: " + e.getMessage());
        }
    }
}
