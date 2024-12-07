package mon.front;

import mon.model.Digimon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainWindow extends JFrame{
    private final DigiManager manager = new DigiManager();
    private JList<String> digimonList;

    public MainWindow() {
        try {
            setUpUI();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setUpUI() throws SQLException {
        setTitle("Lista de Digimones");
        setSize(400,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        List <Digimon> digimonData = manager.readAllDigimons();

        Set<String> digimonNamesSet = new HashSet<>();
        for (Digimon digimon : digimonData) {
            digimonNamesSet.add(digimon.getName());
        }

        String [] digimonNames = digimonNamesSet.toArray(new String[0]);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.clear();
        for (String name : digimonNames) {
            listModel.addElement(name);
        }

        digimonList = new JList<>(listModel);
        digimonList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        digimonList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2){
                    int selectedIndex = digimonList.getSelectedIndex();
                    if(selectedIndex != -1){
                        Digimon selectedDigimon = digimonData.get(selectedIndex);
                        new CartaDigimon(selectedDigimon).setVisible(true);
                    }
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(digimonList);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}
