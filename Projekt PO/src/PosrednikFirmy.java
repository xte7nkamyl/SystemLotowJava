import Klasy.Klient_indywidualny;
import Klasy.Posrednik_firmy;
import Klasy.System_lotniczy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *klasa w ktorej tworzone jest nowe okno z dodawaniem posrednika firmy
 */
public class PosrednikFirmy extends ZarzadzanieKlientami{
    private JTextField imie;
    private JTextField nazwisko;
    private JTextField pesel;
    private JTextField NazwaFirmy;
    private JTextField KRS;
    private JButton dodajButton;
    private JButton anulujButton;
    private JPanel dodawaniePosrednikaFirmy;
    /**
     * Konstruktor ktory tworzy nowe okno, ustawia jego domyslne wartosci i rozmiary dodaje funkcjonalnosci pod odpowiednie przyciski
     * @param system_lotniczy umozliwia uzyskanie dostepu do metod z klasy System_lotniczy
     */
    public PosrednikFirmy(System_lotniczy system_lotniczy)
{
    super(system_lotniczy);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    setSize(500,200);
    setContentPane(dodawaniePosrednikaFirmy);
    setLocationRelativeTo(null);
    dodajButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dodajPosrednikaFirmy();
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
     * metoda ktora dodaje posrednika firmy
     */
    private void dodajPosrednikaFirmy()
{
    String imie = this.imie.getText();
    String nazwisko = this.nazwisko.getText();
    String pesel = this.pesel.getText();
    String nazwaFirmy = this.NazwaFirmy.getText();
    String krs = this.KRS.getText();                           // pobieramy  wartosci z pol  JTextField
    if(imie.isEmpty() || nazwisko.isEmpty() || pesel.isEmpty() || nazwaFirmy.isEmpty() || krs.isEmpty()) ////Sprawdzamy wyjatek czy nie sa puste oraz czy zawieraja odpowiednie typy
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
            if (!nazwaFirmy.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(this,"Nieprawidłowy format Nazwa Firmy", "Błąd", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int peselInt = Integer.parseInt(pesel);
            int krsInt = Integer.parseInt(krs);
            system_lotniczy.dodajKlient(new Posrednik_firmy(imie,nazwisko,peselInt,nazwaFirmy,krsInt));
            JOptionPane.showMessageDialog(this,"Klient zostal dodany");
            anuluj();
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this,"Nieprawidłowy format Pesel lub KRS.", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }
}
    /**
     * Metoda ktora zamyka bierzace okno i wraca do poprzedniego
     */
    private void anuluj()
    {
        dispose();
        ZarzadzanieKlientami zarzadzanieKlientami = new ZarzadzanieKlientami(system_lotniczy);
        zarzadzanieKlientami.setVisible(true);
    }
}
