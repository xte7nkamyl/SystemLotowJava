import Klasy.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *klasa w ktorej tworzone jest nowe okno z dodawaniem samolotow
 */
public class DodawanieSamolotow extends SamolotyMenu{
    private JButton klasaEkonomicznaButton;
    private JPanel dodawanieSamolotow;
    private JButton anulujButton;
    private JButton klasaBiznesowaButton;
    private JButton klasaPierwszaButton;
    /**
     * Konstruktor ktory tworzy nowe okno, ustawia jego domyslne wartosci i rozmiary dodaje funkcjonalnosci pod odpowiednie przyciski
     * @param system_lotniczy umozliwia uzyskanie dostepu do metod z klasy System_lotniczy
     */
    public DodawanieSamolotow(System_lotniczy system_lotniczy) {
    super(system_lotniczy);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    setSize(300,200);
    setContentPane(dodawanieSamolotow);
    setLocationRelativeTo(null);
    anulujButton.addActionListener(new ActionListener() {
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
        klasaBiznesowaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                klasaBiznesowa();
            }
        });
        klasaPierwszaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                klasaPierwsza();
            }
        });
    }
    /**
     * metoda ktora dodaje samolot typu klasa ekonomiczna do listy z samolotami
     */
private void klasaEkonomiczna()
{
    system_lotniczy.dodajSamolot(new Klasa_ekonomiczna());
    JOptionPane.showMessageDialog(this,"Samolot typu [KlasaEkonomiczna] został dodany!");
}
    /**
     * metoda ktora dodaje samolot typu klasa bizensowa do listy z samolotami
     */
private void klasaBiznesowa()
{
    system_lotniczy.dodajSamolot(new Klasa_biznesowa());
    JOptionPane.showMessageDialog(this,"Samolot typu [KlasaBiznesowa] został dodany!");
}
    /**
     * metoda ktora dodaje samolot typu klasa pierwsza do listy z samolotami
     */
private void klasaPierwsza()
{
    system_lotniczy.dodajSamolot(new Klasa_pierwsza());
    JOptionPane.showMessageDialog(this,"Samolot typu [KlasaPierwsza] został dodany!");
}
    /**
     * Metoda ktora zamyka bierzace okno
     */
private void wroc()
{
    dispose();
}
}
