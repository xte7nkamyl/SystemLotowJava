import Klasy.Klient;
import Klasy.Lot;
import Klasy.Rezerwacja;
import Klasy.System_lotniczy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *klasa w ktore tworzone jest nowe okno z Przeglodem Lotow
 */
public class PrzegladLotow extends GeneratorLotow{
    private JList listaLotow;
    private JComboBox listaKlientow;
    private JButton dodajRezerwacjeButton;
    private JButton wrocButton;
    private JPanel loty;
    private JButton usunLotButton;
    private DefaultListModel<Lot> lotListModel;
    private DefaultComboBoxModel<Klient> klientListModel;
    /**
     * Konstruktor ktory tworzy nowe okno, ustawia jego domyslne wartosci i rozmiary dodaje funkcjonalnosci pod odpowiednie przyciski
     * @param system_lotniczy umozliwia uzyskanie dostepu do metod z klasy System_lotniczy
     */
public PrzegladLotow(System_lotniczy system_lotniczy) {
    super(system_lotniczy);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setSize(1300,700);
    setLocationRelativeTo(null);
    setContentPane(loty);
    setVisible(true);
    lotListModel = new DefaultListModel<>();
    listaLotow.setModel(lotListModel);
    for(Lot lot : system_lotniczy.getLoty())
        lotListModel.addElement(lot);
    klientListModel = new DefaultComboBoxModel<>();
    listaKlientow.setModel(klientListModel);
    for (Klient klient: system_lotniczy.getKlienci())
        klientListModel.addElement(klient);
    dodajRezerwacjeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        dodajRezerwacje();
        wroc();
        }
    });
    wrocButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            wroc();
        }
    });
    usunLotButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            usunLot();
        }
    });
}
    /**
     * metoda ktora dodaje rezerwacje na podstawie wygenerowanego lotu
     */
    private void dodajRezerwacje()
{
Lot l = (Lot) listaLotow.getSelectedValue();
Klient k = (Klient)  listaKlientow.getSelectedItem();
if(l != null)
{
    system_lotniczy.dodajRezerwacje(new Rezerwacja(k,l.getTrasa(),l.getCzasWylotu(),l.getSamolot()));
    system_lotniczy.usunSamolot(l.getSamolot());
    JOptionPane.showMessageDialog(this,"Rezerwacja zostala dodana!");
}
else{
    JOptionPane.showMessageDialog(this,"Wybierz lot, ktory chcesz zarezerwowac!", "Błąd", JOptionPane.ERROR_MESSAGE);
}

}
    /**
     * metoda ktora usuwa lot z listy lotow
     */
    private void usunLot()
{
    Lot l = (Lot) listaLotow.getSelectedValue();
    if(l != null)
    {
        lotListModel.removeElement(l);
        system_lotniczy.usunLot(l);
        JOptionPane.showMessageDialog(this,"Lot zostal usuniety!");
    }
    else
    {
        JOptionPane.showMessageDialog(this,"Wybierz lot, ktory chcesz usunac!", "Błąd", JOptionPane.ERROR_MESSAGE);
    }
}

    /**
     * metoda ktora zamyka bierzace okno i wraca do poprzedniego
     */
    private void wroc()
{
    dispose();
    GeneratorLotow generatorLotow = new GeneratorLotow(system_lotniczy);
    generatorLotow.setVisible(true);
}
}
