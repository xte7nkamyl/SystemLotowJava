import Klasy.System_lotniczy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SamolotyMenu extends MainInterface {

    private JPanel menuSamoloty;
    private JButton dodajSamolotButton;
    private JButton wrocButton;
    private JButton przegladajSamolotyButton;

    public SamolotyMenu(System_lotniczy system_lotniczy)
    {
        super(system_lotniczy);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(800,500);
        setContentPane(menuSamoloty);
        setLocationRelativeTo(null);
        wrocButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wroc();
            }
        });

        przegladajSamolotyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                przegladSamolotow();
            }
        });
        dodajSamolotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dodawanieSamolotow();
            }
        });

    }
    private void dodawanieSamolotow()
    {
        new DodawanieSamolotow(system_lotniczy).setVisible(true);
    }
    private void przegladSamolotow()
    {
        PrzegladSamolotow przegladSamolotow = new PrzegladSamolotow(system_lotniczy);
        przegladSamolotow.setVisible(true);
    }
    private void wroc()
    {
        this.dispose();
    }
}
