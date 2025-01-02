import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame {
    private JPanel home;
    private JButton dodajPracownika;
    private JButton nadajPrzesylkeButton;

    public Home() {
        setContentPane(home);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setVisible(true);
        setTitle("GRANDE INF04");

        dodajPracownika.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DodajPracownika();
            }
        });
        nadajPrzesylkeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NadajPrzesylke();
            }
        });
    }
}
