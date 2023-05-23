import Klasy.Klient;
import Klasy.Klient_indywidualny;
import Klasy.System_lotniczy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class klientIndywidualny extends ZarzadzanieKlientami{
    private JPanel dodawanieKlientow;
    private JTextField imie;
    private JTextField pesel;
    private JTextField nazwisko;
    private JButton dodajButton;
    private JButton anulujButton;
public klientIndywidualny(System_lotniczy system_lotniczy) {
    super(system_lotniczy);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    setSize(500,200);
    setContentPane(dodawanieKlientow);
    setLocationRelativeTo(null);
    dodajButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dodajKlientaIndywidualengo();

        }
    });
    anulujButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        dispose();
        }
    });
}
private void dodajKlientaIndywidualengo()
{
    String imie = this.imie.getText();
    String nazwisko = this.nazwisko.getText();
    String pesel = this.pesel.getText();
    int peselInt = Integer.parseInt(pesel);
    Klient_indywidualny klientIndywidualny = new Klient_indywidualny(imie,nazwisko,peselInt);
    system_lotniczy.dodajKlient(klientIndywidualny);

    dispose();
}
}
