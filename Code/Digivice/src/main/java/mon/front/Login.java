package mon.front;

import mon.dao.AdminUserDAOImp;
import mon.model.Digimon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class Login extends JFrame {
    private final Digimon digimon;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel messageLabel;

    public Login(Digimon digimon) {
        this.digimon = digimon;
        setTitle("Login");
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();

        setLocationRelativeTo(null);
        setVisible(true);
        pack();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));

        usernameField = new JTextField();
        passwordField = new JPasswordField();
        messageLabel = new JLabel("", SwingConstants.CENTER);
        messageLabel.setForeground(Color.RED);

        JButton loginButton = new JButton("Iniciar Sesión");
        loginButton.addActionListener(new LoginAction());

        panel.add(new JLabel("User:", SwingConstants. CENTER));
        panel.add(usernameField);
        panel.add(new JLabel("Password:", SwingConstants.CENTER));
        panel.add(passwordField);

        add(panel, BorderLayout.CENTER);
        add(loginButton, BorderLayout.SOUTH);
        add(messageLabel, BorderLayout.NORTH);
    }

    public class LoginAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            try {
                if (new AdminUserDAOImp().authenticateUser(username, password)) {
                    messageLabel.setText("Inicio de sesión exitoso");
                    JOptionPane.showMessageDialog(Login.this, "Bienvenido " + username);
                    dispose();
                    new Editor(new DigiManager(), digimon);
                } else {
                    messageLabel.setText("Usuario o contraseña incorrectos");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
