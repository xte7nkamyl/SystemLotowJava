import Klasy.Lotnisko;
import Klasy.System_lotniczy;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *klasa w ktore tworzone jest nowe okno z dodawaniem Lotniska
 */
public class DodawanieLotniska extends ZarzadzanieLotniskami{
    private JTextField nazwa;
    private JTextField miasto;
    private JButton anulujButton;
    private JButton dodajButton;
    private JPanel dodawanieLotniska;

    /**
     * Konstruktor ktory tworzy nowe okno, ustawia jego domyslne wartosci i rozmiary dodaje funkcjonalnosci pod odpowiednie przyciski
     * @param system_lotniczy umozliwia uzyskanie dostepu do metod z klasy System_lotniczy
     */
    public DodawanieLotniska(System_lotniczy system_lotniczy) {
    super(system_lotniczy);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    setSize(500,200);
    setContentPane(dodawanieLotniska);
    setLocationRelativeTo(null);
    dodajButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dodajLotnisko();
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
     * metoda ktora dodaje lotnisko do listy zawierajacej lotniska
     */
    private void dodajLotnisko()
    {
        String nazwa = this.nazwa.getText();
        String miasto = this.miasto.getText();               // pobieramy  wartosci z pol  JTextField oraz JComboBox
        if(nazwa.isEmpty() && miasto.isEmpty())              //Sprawdzamy wyjatek czy nie sa puste oraz czy zawieraja odpowiednie typy
        {
            JOptionPane.showMessageDialog(this,"Uzupelnij pola", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
                if (nazwa.matches("[a-zA-Z]+") && miasto.matches("[a-zA-Z]+")) {
                    system_lotniczy.dodajLotnisko(new Lotnisko(nazwa,miasto));
                    JOptionPane.showMessageDialog(this,"Lotnisko zostalo dodane!");
                    anuluj();
                }else {
                    JOptionPane.showMessageDialog(this,"Nieprawidłowy format Nazwa lub Miasto.", "Błąd", JOptionPane.ERROR_MESSAGE);
            }

        }
    }
    /**
     * Metoda ktora zamyka bierzace okno i wraca do poprzedniego
     */
    private void anuluj()
    {
        dispose();
        new ZarzadzanieLotniskami(system_lotniczy).setVisible(true);
    }
}
