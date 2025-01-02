import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class DodajPracownika extends JFrame {


    private JPanel main;
    private JButton zatwierdźButton;
    private JTextField nameInput;
    private JTextField inputSurname;
    private JComboBox comboBox;
    private JTextField ileznakow;
    private JCheckBox checkBoxMaleWielkie;
    private JCheckBox checkBoxCyfry;
    private JCheckBox checkBoxZnakiSpecjalne;
    private JButton generujHasłoButton;


    String genPassword = "";
    String zestawMaleWielkie = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM";
    String zestawCyfry = "1234567890";
    String zestawZnaki = "!@#$%^&*()_+-=";

    public DodajPracownika() throws HeadlessException {
        setContentPane(main);
        setVisible(true);
        setSize(800, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Dodaj pracownika");

        generujHasłoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String zestawDoGeneracji = "";
                genPassword = "";
                if (checkBoxMaleWielkie.isSelected()) {
                    zestawDoGeneracji = zestawDoGeneracji + zestawMaleWielkie;
                }
                if (checkBoxCyfry.isSelected()) {
                    zestawDoGeneracji = zestawDoGeneracji + zestawCyfry;
                }
                if (checkBoxZnakiSpecjalne.isSelected()) {
                    zestawDoGeneracji = zestawDoGeneracji + zestawZnaki;
                }
                Random random = new Random();
                for (int i = 0; i < Integer.parseInt(ileznakow.getText()); i++) {
                    genPassword = genPassword + zestawDoGeneracji.charAt(random.nextInt(zestawDoGeneracji.length() - 1));
                }

                JOptionPane.showMessageDialog(null, genPassword);

            }
        });
        zatwierdźButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Dane pracownika: " + nameInput.getText() + " " + inputSurname.getText() + " " + comboBox.getModel().getSelectedItem().toString() + " Hasło: " + genPassword);
            }
        });
    }
}
