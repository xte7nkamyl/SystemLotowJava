import Klasy.Klient;
import Klasy.Lot;
import Klasy.Rezerwacja;
import Klasy.System_lotniczy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrzegladLotow extends GeneratorLotow{
    private JList listaLotow;
    private JComboBox listaKlientow;
    private JButton dodajRezerwacjeButton;
    private JButton wrocButton;
    private JPanel loty;
    private DefaultListModel<Lot> lotListModel;
    private DefaultComboBoxModel<Klient> klientListModel;
public PrzegladLotow(System_lotniczy system_lotniczy) {
    super(system_lotniczy);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setSize(1200,700);
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
        }
    });
    wrocButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    });
}
private void dodajRezerwacje()
{
Lot l = (Lot) listaLotow.getSelectedValue();
Klient k = (Klient)  listaKlientow.getSelectedItem();
system_lotniczy.dodajRezerwacje(new Rezerwacja(k,l.getTrasa(),l.getCzasWylotu(),l.getSamolot()));
}
}
