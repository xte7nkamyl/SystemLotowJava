import Klasy.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *klasa w ktore tworzone jest nowe okno z zarzadzaniem lotniskami
 */
public class ZarzadzanieLotniskami extends MainInterface{
    private JList listaLotnisk;
    private JButton dodajLotnsikoButton;
    private JButton usunLotniskoButton;
    private JPanel zarzadzanieLotniskami;
    private JButton wrocButton;
    private DefaultListModel<Lotnisko> lotniskoListModel;
    /**
     * Konstruktor ktory tworzy nowe okno, ustawia jego domyslne wartosci i rozmiary dodaje funkcjonalnosci pod odpowiednie przyciski
     * @param system_lotniczy umozliwia uzyskanie dostepu do metod z klasy System_lotniczy
     */
    public ZarzadzanieLotniskami(System_lotniczy system_lotniczy) {
        super(system_lotniczy);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(800,530);
        setContentPane(zarzadzanieLotniskami);
        setLocationRelativeTo(null);
        lotniskoListModel = new DefaultListModel<>();
        listaLotnisk.setModel(lotniskoListModel);
        for(Lotnisko lotnisko: system_lotniczy.getLotniska())
            lotniskoListModel.addElement(lotnisko);

    dodajLotnsikoButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dodajLotniska();
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
        usunLotniskoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usunLotnisko();
            }
        });
    }

    /**
     * metoda ktora tworzy nowe okno z dodawaniem lotniska i zamyka bierzace
     */
    private void dodajLotniska()
    {
        DodawanieLotniska dodawanieLotniska = new DodawanieLotniska(system_lotniczy);
        dodawanieLotniska.setVisible(true);
        dispose();
    }

    /**
     * metoda ktora usuwa lotnisko z listy lotnisk
     */
    private void usunLotnisko()
    {
        Lotnisko l = (Lotnisko) listaLotnisk.getSelectedValue();
        if(l != null)
        {
            lotniskoListModel.removeElement(l);
            system_lotniczy.usunLotnisko(l);
            JOptionPane.showMessageDialog(this,"Lotnisko zostalo usuniete!");
        }
        else {
            JOptionPane.showMessageDialog(this,"Wybierz lotnisko, ktore chcesz usunac", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }
}
