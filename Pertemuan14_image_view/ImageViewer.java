import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class ImageViewer {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ImageViewer().createAndShowGUI());
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Image Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(new JScrollPane(imageLabel), BorderLayout.CENTER);

        JButton btnLoadImage = new JButton("Load Image");
        panel.add(btnLoadImage, BorderLayout.SOUTH);

        btnLoadImage.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Select an Image");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "bmp"));

            int result = fileChooser.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try {
                    ImageIcon image = new ImageIcon(selectedFile.getAbsolutePath());
                    imageLabel.setIcon(image);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error loading image!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.getContentPane().add(panel);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
