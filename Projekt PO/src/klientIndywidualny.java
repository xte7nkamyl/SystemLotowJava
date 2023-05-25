import Klasy.Klient;
import Klasy.Klient_indywidualny;
import Klasy.System_lotniczy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.invoke.StringConcatException;

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
            odswierzListeKlientow();
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
    if(imie.isEmpty() && nazwisko.isEmpty() && pesel.isEmpty())
    {
        JOptionPane.showMessageDialog(this,"Uzupelnij pola", "Błąd", JOptionPane.ERROR_MESSAGE);
    }
    else
    {
        try {
            if (!imie.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(this,"Nieprawidłowy format Imie", "Błąd", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!nazwisko.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(this,"Nieprawidłowy format Nazwisko", "Błąd", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int peselInt = Integer.parseInt(pesel);
            system_lotniczy.dodajKlient(new Klient_indywidualny(imie,nazwisko,peselInt));
            dispose();
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this,"Nieprawidłowy format Pesel.", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }
}
}
