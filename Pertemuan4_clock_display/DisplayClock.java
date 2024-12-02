import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DisplayClock extends JFrame {

    private JLabel timeLabel;

    public DisplayClock() {
        setTitle("Display Clock");
   
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 50));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(timeLabel);

        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        startClock();
    }

    public void startClock() {
        Timer timer = new Timer(1000, e -> updateClock());
        timer.start();
    }

    public void updateClock() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String currentTime = sdf.format(new Date());

        timeLabel.setText(currentTime);
    }

    public static void main(String[] args) {
        new DisplayClock();
    }
}
