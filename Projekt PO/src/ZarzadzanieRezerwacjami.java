import Klasy.Rezerwacja;
import Klasy.System_lotniczy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *klasa w ktore tworzone jest nowe okno z dodawaniem rezerwacji
 */
public class ZarzadzanieRezerwacjami extends MainInterface{
    private JButton wrocButton;
    private JButton dodajRezerwacjeButton;
    private JButton usunRezerwacjeButton;
    private JList listaRezerwacji;
    private JPanel zarzadzanieRezerwacjami;
    private DefaultListModel<Rezerwacja> rezerwacjaListModel;
    /**
     * Konstruktor ktory tworzy nowe okno, ustawia jego domyslne wartosci i rozmiary dodaje funkcjonalnosci pod odpowiednie przyciski
     * @param system_lotniczy umozliwia uzyskanie dostepu do metod z klasy System_lotniczy
     */
    public ZarzadzanieRezerwacjami(System_lotniczy system_lotniczy) {
    super(system_lotniczy);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setSize(900,600);
    setLocationRelativeTo(null);
    setContentPane(zarzadzanieRezerwacjami);
    setVisible(true);
    rezerwacjaListModel = new DefaultListModel<>();
    listaRezerwacji.setModel(rezerwacjaListModel);
        for(Rezerwacja rezerwacja: system_lotniczy.getRezerwacje())
            rezerwacjaListModel.addElement(rezerwacja);
    dodajRezerwacjeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        dodawanieRezerwacji();
        }
    });
        wrocButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainInterface mainInterface = new MainInterface(system_lotniczy);
                mainInterface.setVisible(true);
            }
        });
        usunRezerwacjeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usunRezerwacje();
            }
        });
    }

    /**
     * metoda otwiera kolejne okno z dodawaniem rezerwacji i zamyka bierzace
     */
    private void dodawanieRezerwacji()
    {
        DodawanieRezerwacji dodawanieRezerwacji = new DodawanieRezerwacji(system_lotniczy);
        dodawanieRezerwacji.setVisible(true);
        dispose();
    }

    /**
     * metoda ktora usuwa rezerwacje z listy rezerwacji
     */
    private void usunRezerwacje()
    {
        Rezerwacja r = (Rezerwacja) listaRezerwacji.getSelectedValue();
        if(r != null)
        {
            rezerwacjaListModel.removeElement(r);
            system_lotniczy.usunRezerwacje(r);
            JOptionPane.showMessageDialog(this,"Rezerwacja zostala usunieta!");
        }
        else {
            JOptionPane.showMessageDialog(this,"Wybierz rezerwacje, ktora chcesz usunac", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }
}
