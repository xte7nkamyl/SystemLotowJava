import Klasy.Rezerwacja;
import Klasy.System_lotniczy;
import Klasy.Trasa;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZarzadzanieRezerwacjami extends MainInterface{
    private JButton button1;
    private JButton dodajRezerwacjeButton;
    private JButton usunRezerwacjeButton;
    private JButton odswierzListeButton;
    private JList listaRezerwacji;
    private JPanel zarzadzanieRezerwacjami;
    private DefaultListModel<Rezerwacja> rezerwacjaListModel;

    public ZarzadzanieRezerwacjami(System_lotniczy system_lotniczy) {
    super(system_lotniczy);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setSize(900,500);
    setLocationRelativeTo(null);
    setContentPane(zarzadzanieRezerwacjami);
    setVisible(true);
    rezerwacjaListModel = new DefaultListModel<>();
    listaRezerwacji.setModel(rezerwacjaListModel);
    dodajRezerwacjeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        dodawanieRezerwacji();
        }
    });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        odswierzListeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rezerwacjaListModel.removeAllElements();
                for(Rezerwacja rezerwacja: system_lotniczy.getRezerwacje())
                    rezerwacjaListModel.addElement(rezerwacja);
            }
        });
        usunRezerwacjeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usunRezerwacje();
            }
        });
    }
    private void dodawanieRezerwacji()
    {
        DodawanieRezerwacji dodawanieRezerwacji = new DodawanieRezerwacji(system_lotniczy);
        dodawanieRezerwacji.setVisible(true);
    }
    private void usunRezerwacje()
    {
        int idx = listaRezerwacji.getSelectedIndex();
        rezerwacjaListModel.remove(idx);
        system_lotniczy.usunRezerwacje(idx);
    }
}
