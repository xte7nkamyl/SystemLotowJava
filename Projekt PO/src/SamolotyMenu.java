import Klasy.System_lotniczy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *klasa w ktore tworzone jest nowe okno z menuSamalotow
 */
public class SamolotyMenu extends MainInterface {

    private JPanel menuSamoloty;
    private JButton dodajSamolotButton;
    private JButton wrocButton;
    private JButton przegladajSamolotyButton;
    /**
     * Konstruktor ktory tworzy nowe okno, ustawia jego domyslne wartosci i rozmiary dodaje funkcjonalnosci pod odpowiednie przyciski
     * @param system_lotniczy umozliwia uzyskanie dostepu do metod z klasy System_lotniczy
     */
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

    /**
     * metoda ktora otwiera nowe okno z dodawaniem samolotow
     */
    private void dodawanieSamolotow()
    {
        new DodawanieSamolotow(system_lotniczy).setVisible(true);
    }
    /**
     * metoda ktora otowera nowe okno z przegladaniem samolotow
     */
    private void przegladSamolotow()
    {
        PrzegladSamolotow przegladSamolotow = new PrzegladSamolotow(system_lotniczy);
        przegladSamolotow.setVisible(true);
    }
    /**
     * metoda ktora zamyka bierzace okno
     */
    private void wroc()
    {
        this.dispose();
    }
}
