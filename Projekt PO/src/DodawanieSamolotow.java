import Klasy.Klasa_ekonomiczna;
import Klasy.Samolot;
import Klasy.System_lotniczy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DodawanieSamolotow extends MainInterface{
    private JButton klasaEkonomicznaButton;
    private JPanel dodawanieSamolotow;
    private JButton wrocButton;
public DodawanieSamolotow(System_lotniczy system_lotniczy) {
    super(system_lotniczy);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    setSize(800,500);
    setContentPane(dodawanieSamolotow);
    setLocationRelativeTo(null);
    wrocButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            wroc();
        }
    });
    klasaEkonomicznaButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            klasaEkonomiczna();

        }
    });
}
private void klasaEkonomiczna()
{
    Samolot samolot = new Klasa_ekonomiczna();
    system_lotniczy.dodajSamolot(samolot);
}
private void wroc()
{
    dispose();
}
}
