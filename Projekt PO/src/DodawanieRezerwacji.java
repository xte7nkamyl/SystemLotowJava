import Klasy.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
/**
 *klasa w ktore tworzone jest nowe okno z dodawaniem rezerwacji
 */
public class DodawanieRezerwacji extends ZarzadzanieRezerwacjami{
    private JComboBox listaKlientow;
    private JComboBox listaTras;
    private JComboBox listaSamolotow;
    private JButton dodajButton;
    private JButton anulujButton;
    private JPanel dodawanieRezerwacji;
    private JSpinner data;
    private DefaultComboBoxModel<Klient> klientComboBoxModel;
    private DefaultComboBoxModel<Trasa> trasaComboBoxModel;
    private DefaultComboBoxModel<Samolot> samolotDefaultComboBoxModel;
    /**
     * Konstruktor ktory tworzy nowe okno, ustawia jego domyslne wartosci i rozmiary dodaje funkcjonalnosci pod odpowiednie przyciski
     * @param system_lotniczy umozliwia uzyskanie dostepu do metod z klasy System_lotniczy
     */
public DodawanieRezerwacji(System_lotniczy system_lotniczy) {
    super(system_lotniczy);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    setSize(900,500);
    setContentPane(dodawanieRezerwacji);
    setLocationRelativeTo(null);
    klientComboBoxModel = new DefaultComboBoxModel<>();
    trasaComboBoxModel = new DefaultComboBoxModel<>();
    samolotDefaultComboBoxModel = new DefaultComboBoxModel<>();          //używamy DefaultComboBoxModel do dodania elementów do modelu listy.
    listaKlientow.setModel(klientComboBoxModel);                         //Następnie przekazujemy ten model do konstruktora JComboBox
    listaTras.setModel(trasaComboBoxModel);
    listaSamolotow.setModel(samolotDefaultComboBoxModel);
    for(Klient klient: system_lotniczy.getKlienci())
        klientComboBoxModel.addElement(klient);
    for (Trasa trasa: system_lotniczy.getTrasy())
        trasaComboBoxModel.addElement(trasa);
    for(Samolot samolot : system_lotniczy.getSamoloty())
        samolotDefaultComboBoxModel.addElement(samolot);
    SpinnerDateModel dateModel = new SpinnerDateModel();                 // uzywamy SpinnerDateModel w ktorym umieszczamy model kalendarza
    Calendar calendar = Calendar.getInstance();                          // nastepnie caly model do konstruktora Jspinner
    dateModel.setValue(calendar.getTime());
    data.setModel(dateModel);
    dodajButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dodajRezerwacje();
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
     * metoda ktora dodaje rezerwacje do listy z rezerwacjami
     */
public void dodajRezerwacje()
{
    Klient k = (Klient) listaKlientow.getSelectedItem();
    Trasa t = (Trasa) listaTras.getSelectedItem();
    Samolot s = (Samolot) listaSamolotow.getSelectedItem();
    SpinnerDateModel dataModel = (SpinnerDateModel) data.getModel();   //spinner jest referencją do JSpinner. Pobieramy model spinnera za pomocą metody getModel() i rzutujemy go na SpinnerDateModel
    Date selectedDate = (Date) dataModel.getValue();                   //następnie pobieramy wartość z modelu spinnera za pomocą metody getValue() która zwraca obiekt Date.
    LocalDateTime localDateTime = LocalDateTime.ofInstant(selectedDate.toInstant(), ZoneId.systemDefault()); //Na koniec konwertujemy wartość daty do obiektu LocalDateTime, korzystając z metody LocalDateTime.ofInstant().
    if(s.getZasieg() >= t.getOdleglosc())
    {system_lotniczy.dodajRezerwacje(new Rezerwacja(k,t,localDateTime,s));
    system_lotniczy.usunSamolot(s);}
    else {
        JOptionPane.showMessageDialog(this,"Zasieg samolotu jest mniejszy niz odleglosc trasy", "Błąd", JOptionPane.ERROR_MESSAGE);
        return;
    }
    JOptionPane.showMessageDialog(this,"Rezerwacja zostala dodana!");
}
    /**
     * Metoda ktora zamyka bierzace okno i wraca do poprzedniego
     */
private void anuluj()
{
    dispose();
    new ZarzadzanieRezerwacjami(system_lotniczy).setVisible(true);
}
}
