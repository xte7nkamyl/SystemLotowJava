import Klasy.Klient;
import Klasy.System_lotniczy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *klasa w ktore tworzone jest nowe okno z zarzadzaniem klientami
 */
public class ZarzadzanieKlientami extends MainInterface{
    private JList listaKlientow;
    private JButton dodajPosrednikaFrimyButton;
    private JButton dodajKlientaIndywidualnegoButton;
    private JButton usunKlientaButton;
    private JButton wrocButton;
    private JScrollPane scroll;
    private JPanel zarzadzanieKlientami;
    private DefaultListModel<Klient> klientListModel;
    /**
     * Konstruktor ktory tworzy nowe okno, ustawia jego domyslne wartosci i rozmiary dodaje funkcjonalnosci pod odpowiednie przyciski
     * @param system_lotniczy umozliwia uzyskanie dostepu do metod z klasy System_lotniczy
     */
    public ZarzadzanieKlientami(System_lotniczy system_lotniczy) {
    super(system_lotniczy);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    setSize(800,500);
    setContentPane(zarzadzanieKlientami);            //używamy DefaultListModel do dodania elementów do modelu listy.
    setLocationRelativeTo(null);                       //Następnie przekazujemy ten model do konstruktora Jlist
    klientListModel = new DefaultListModel<>();
    listaKlientow.setModel(klientListModel);
        for (Klient klient: system_lotniczy.getKlienci())
        {
            klientListModel.addElement(klient);
        }

    dodajKlientaIndywidualnegoButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
dodajKlientaIndywidualnego();
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
        usunKlientaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usunKlienta();
            }
        });
        dodajPosrednikaFrimyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dodajKlientaPosrednika();
            }
        });
    }

    /**
     * metoda ktora otwiea nowe okno z dodawaniem posrednika firmy i zamyka bierzace
     */
    private void dodajKlientaPosrednika()
    {
        PosrednikFirmy posrednikFirmy = new PosrednikFirmy(system_lotniczy);
        posrednikFirmy.setVisible(true);
        dispose();
    }
    /**
     * metoda ktora otwiea nowe okno z dodawaniem klienta indywidualnego i zamyka bierzace
     */
private void dodajKlientaIndywidualnego()
{
    klientIndywidualny klientIndywidualny = new klientIndywidualny(system_lotniczy);
    klientIndywidualny.setVisible(true);
    dispose();
}

    /**
     * metoda ktora usuwa klienta z listy klientow
     */
    private void usunKlienta()
{
   Klient k = (Klient) listaKlientow.getSelectedValue();
   if(k != null)
   {
       klientListModel.removeElement(k);
       system_lotniczy.usunKlient(k);
       JOptionPane.showMessageDialog(this,"Klient zostal usuniety!");
   }
   else{
       JOptionPane.showMessageDialog(this,"Wybierz Klienta, ktorego chcesz usunac", "Błąd", JOptionPane.ERROR_MESSAGE);
   }

}
}
