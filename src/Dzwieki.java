import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dzwieki extends JFrame {
    private JPanel main;
    private JButton prev;
    private JButton next;
    private JButton pobierzButton;
    private JLabel downloads;
    private JLabel zespol;
    private JLabel song;
    private JLabel nrUtworow;
    private JLabel rok;
    ArrayList<Utwor> utwors;
    int indexAlbum = 0;

    public Dzwieki() throws HeadlessException, FileNotFoundException {
        setSize(1000, 300);
        setVisible(true);
        setTitle("MojeDźwięki, wykonał:0000000");
        setContentPane(main);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        utwors = wypenli();
        wstawDane(0);

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (indexAlbum == utwors.size() - 1) {
                    indexAlbum = 0;
                } else {
                    indexAlbum++;
                }
                wstawDane(indexAlbum);
            }
        });
        prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (indexAlbum == 0) {
                    indexAlbum = utwors.size() - 1;
                } else {
                    indexAlbum--;
                }
                wstawDane(indexAlbum);
            }
        });
        pobierzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                utwors.get(indexAlbum).downloadNumber++;
                wstawDane(indexAlbum);
            }
        });
    }

    ArrayList<Utwor> wypenli() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/Data.txt"));
        ArrayList<Utwor> albums = new ArrayList<Utwor>();
        while (scanner.hasNextLine()) {
            try {
                albums.add(new Utwor(scanner.nextLine(), scanner.nextLine(), Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine())));
                scanner.nextLine();
            } catch (RuntimeException ignored) {
            }
        }
        return albums;
    }

    void wstawDane(int index) {
        Utwor utwor = utwors.get(index);
        zespol.setText(utwor.artist);
        song.setText(utwor.album);
        nrUtworow.setText(String.valueOf(utwor.songsNumber) + "   utworów");
        rok.setText(String.valueOf(utwor.year));
        downloads.setText(String.valueOf(utwor.downloadNumber));
    }
}
