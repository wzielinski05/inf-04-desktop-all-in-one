import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NadajPrzesylke extends JFrame {
    private JPanel main;
    private JTextField ulicaInput;
    private JTextField kodInput;
    private JTextField MiastInput;
    private JButton zatwierdźButton;
    private JRadioButton pocztówkaRadioButton;
    private JRadioButton listRadioButton;
    private JRadioButton paczkaRadioButton;
    private JButton sprawdźCenęButton;
    private JLabel cena;
    private JLabel img;


    public NadajPrzesylke() throws HeadlessException {
        setContentPane(main);
        setTitle("Nadaj przesylke. PESEL:00000000000");
        setSize(800, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        sprawdźCenęButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pocztówkaRadioButton.isSelected()) {
                    cena.setText("Cena: 1zł");
                    img.setIcon(new ImageIcon("src/pocztowka.png"));
                } else if (listRadioButton.isSelected()) {
                    cena.setText("Cena: 1,5zł");
                    img.setIcon(new ImageIcon("src/list.png"));
                } else if (paczkaRadioButton.isSelected()) {
                    cena.setText("Cena: 10zł");
                    img.setIcon(new ImageIcon("src/paczka.png"));
                }
            }
        });
        zatwierdźButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String kodPocztowy = kodInput.getText();
                if (kodPocztowy.length() != 5) {
                    JOptionPane.showMessageDialog(null, "Nieprawidłowa liczba cyfr w kodzie pocztowym");
                    return;
                }
                try {
                    Integer.parseInt(kodPocztowy);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Kod pocztowy powienien się składać z samych cyfr");
                    return;
                }
                JOptionPane.showMessageDialog(null, "Dane przysyłki zostały wprowadzone");

            }
        });
    }
}
