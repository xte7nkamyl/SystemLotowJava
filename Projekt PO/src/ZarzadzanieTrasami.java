import Klasy.System_lotniczy;
import Klasy.Trasa;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *klasa w ktore tworzone jest nowe okno z zarzadzaniem trasami
 */
public class ZarzadzanieTrasami extends MainInterface{
    protected JList listaTras;
    private JButton usunTraseButton;
    private JButton dodajTraseButton;
    private JButton wrocButton;
    private JPanel zarzadzanieTrasami;
    protected DefaultListModel<Trasa> trasaListModel;

    /**
     * Konstruktor ktory tworzy nowe okno, ustawia jego domyslne wartosci i rozmiary dodaje funkcjonalnosci pod odpowiednie przyciski
     * @param system_lotniczy umozliwia uzyskanie dostepu do metod z klasy System_lotniczy
     */
    public ZarzadzanieTrasami(System_lotniczy system_lotniczy) {
    super(system_lotniczy);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setSize(815,500);
    setLocationRelativeTo(null);
    setContentPane(zarzadzanieTrasami);
    setVisible(true);
        trasaListModel = new DefaultListModel<>();   //używamy DefaultListModel do dodania elementów do modelu listy.
        trasaListModel.removeAllElements();          //Następnie przekazujemy ten model do konstruktora Jlist
        for (Trasa trasa: system_lotniczy.getTrasy())
            trasaListModel.addElement(trasa);
        listaTras.setModel(trasaListModel);
    dodajTraseButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new DodajTrase(system_lotniczy).setVisible(true);
            dispose();
        }
    });
        wrocButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MainInterface(system_lotniczy).setVisible(true);
            }
        });
        usunTraseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usunTrase();
            }
        });
    }

    /**
     * metoda ktora usuwa trase z listy tras
     */
    private void usunTrase(){
        Trasa t = (Trasa) listaTras.getSelectedValue();
        if(t == null)
        {
            JOptionPane.showMessageDialog(this,"Wybierz trase, ktora chcesz usunac", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
        else {
            trasaListModel.removeElement(t);
            system_lotniczy.usunTrasa(t);
            JOptionPane.showMessageDialog(this,"Trasa zostala usunieta!");
        }
    }
}
