import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Objects;

public class Paszport extends JFrame {
    private JPanel main;
    private JTextField numInput;
    private JTextField nameInput;
    private JTextField SurnameInput;
    private JRadioButton niebieskieRadioButton;
    private JRadioButton zieloneRadioButton;
    private JRadioButton piwneRadioButton;
    private JButton OKButton;
    private JLabel photo;
    private JLabel finger;

    public Paszport() throws HeadlessException {
        setContentPane(main);
        setSize(800, 300);
        setVisible(true);
        setTitle("Wprowadzanie danych do paszportu. Wykonał: 00000000");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        photo.setIcon(new ImageIcon(new ImageIcon("src/000-zdjecie.jpg").getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT)));
        finger.setIcon(new ImageIcon(new ImageIcon("src/000-odcisk.jpg").getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT)));

        numInput.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                photo.setIcon(new ImageIcon(new ImageIcon("src/" + numInput.getText() + "-zdjecie.jpg").getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT)));
                finger.setIcon(new ImageIcon(new ImageIcon("src/" + numInput.getText() + "-odcisk.jpg").getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT)));
            }
        });
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!Objects.equals(nameInput.getText(), "") || !Objects.equals(SurnameInput.getText(), "")) {
                    String oczy = "";
                    if (niebieskieRadioButton.isSelected()) {
                        oczy = "niebieskie";
                    } else if (zieloneRadioButton.isSelected()) {
                        oczy = "zielone";

                    } else if (piwneRadioButton.isSelected()) {
                        oczy = "piwne";
                    }
                    JOptionPane.showMessageDialog(null, nameInput.getText() + " " + SurnameInput.getText() + " kolor oczu " + oczy);
                } else {
                    JOptionPane.showMessageDialog(null, "Wprowadź dane");
                }
            }
        });
    }
}
