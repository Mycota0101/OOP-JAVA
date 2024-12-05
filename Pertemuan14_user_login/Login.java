import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login {
    // Data username dan password yang valid
    private final String USERNAME = "hapid123";
    private final String PASSWORD = "pass";

    // Komponen GUI
    private JTextField txtUsername;
    private JPasswordField txtPassword;

    public static void main(String[] args) {
        Login app = new Login();
        app.go();
    }

    public void go() {
        // Membuat frame
        JFrame frame = new JFrame("Login Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Membuat panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10)); // Layout grid 3 baris x 2 kolom

        // Komponen GUI
        JLabel lblUsername = new JLabel("Username:");
        JLabel lblPassword = new JLabel("Password:");
        txtUsername = new JTextField(20);
        txtPassword = new JPasswordField(20);
        JButton btnLogin = new JButton("Login");
        JButton btnCancel = new JButton("Cancel");

        // Menambahkan action listener untuk tombol Login
        btnLogin.addActionListener(new LoginListener());

        // Menambahkan action listener untuk tombol Cancel
        btnCancel.addActionListener(new CancelListener());

        // Menambahkan komponen ke panel
        panel.add(lblUsername);
        panel.add(txtUsername);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(btnLogin);
        panel.add(btnCancel);

        // Menambahkan panel ke frame
        frame.getContentPane().add(panel, BorderLayout.CENTER);

        // Mengatur ukuran frame dan menampilkannya
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null); // Menampilkan frame di tengah layar
        frame.setVisible(true);
    }

    // Inner class untuk menangani tombol Login
    private class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String inputUsername = txtUsername.getText();
            String inputPassword = new String(txtPassword.getPassword()); // Mengubah password menjadi String

            if (USERNAME.equals(inputUsername) && PASSWORD.equals(inputPassword)) {
                JOptionPane.showMessageDialog(null, "Login Granted!");
            } else {
                JOptionPane.showMessageDialog(null, "Login Denied!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Inner class untuk menangani tombol Cancel
    private class CancelListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            txtUsername.setText(""); // Mengosongkan field username
            txtPassword.setText(""); // Mengosongkan field password
            txtUsername.requestFocus(); // Mengarahkan kursor ke field username
        }
    }
}
