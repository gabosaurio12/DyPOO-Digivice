package mon.front;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Editor extends JFrame {

    private DigiManager manager;
    public Editor(DigiManager manager) {

        this.manager = manager;
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        placeComponent(panel);

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    private void placeComponent(JPanel panel){
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel idLabel = new JLabel("Introduce el id de digimon");

        JTextField idField = new JTextField(3);

        JLabel nameLabel = new JLabel("Introduce el nuevo nombre de digimon:");
        JTextField nameField = new JTextField(30);

        panel.add(idLabel);
        panel.add(idField);

        panel.add(nameLabel);
        panel.add(nameField);

        JButton updateButton =new JButton("Actualizar");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDigimon(idField.getText(), nameField.getText());
            }
        });

        panel.add(updateButton);
    }

    private void updateDigimon(String idText, String newName){
        if(idText.isEmpty() || newName.isEmpty()){
            JOptionPane.showMessageDialog(this, "El ID y el nombre no pueden estar vacíos");
            return;
        }

        try{
            int id = Integer.parseInt(idText);

            manager.updateDigimon(id, newName);
            JOptionPane.showMessageDialog(this, "Digimon actualizado correctamente");
            dispose();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error actualizando el Digimon: " + e.getMessage());
        } catch (NumberFormatException e) {
           JOptionPane.showMessageDialog(this, "El ID debe de ser un número valido");
        }

    }
}
