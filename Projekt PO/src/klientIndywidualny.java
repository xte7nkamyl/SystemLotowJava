import Klasy.Klient;
import Klasy.Klient_indywidualny;
import Klasy.System_lotniczy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.invoke.StringConcatException;
/**
 *klasa w ktorej tworzone jest nowe okno z dodawaniem klienta indiwidualnego
 */
public class klientIndywidualny extends ZarzadzanieKlientami{
    private JPanel dodawanieKlientow;
    private JTextField imie;
    private JTextField pesel;
    private JTextField nazwisko;
    private JButton dodajButton;
    private JButton anulujButton;
    /**
     * Konstruktor ktory tworzy nowe okno, ustawia jego domyslne wartosci i rozmiary dodaje funkcjonalnosci pod odpowiednie przyciski
     * @param system_lotniczy umozliwia uzyskanie dostepu do metod z klasy System_lotniczy
     */
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
        anuluj();
        }
    });
}
    /**
     * metoda ktora dodaje klienta indywidualnego do listy z klientami
     */
private void dodajKlientaIndywidualengo()
{
    String imie = this.imie.getText();
    String nazwisko = this.nazwisko.getText();
    String pesel = this.pesel.getText();               // pobieramy  wartosci z pol  JTextField
    if(imie.isEmpty() || nazwisko.isEmpty() || pesel.isEmpty()) // //Sprawdzamy wyjatek czy nie sa puste oraz czy zawieraja odpowiednie typy
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
            JOptionPane.showMessageDialog(this,"Klient zostal dodany!");
            anuluj();
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this,"Nieprawidłowy format Pesel.", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }
}
    /**
     * Metoda ktora zamyka bierzace okno i wraca do poprzedniego
     */
private void anuluj()
{
    dispose();
    new ZarzadzanieKlientami(system_lotniczy).setVisible(true);
}
}
