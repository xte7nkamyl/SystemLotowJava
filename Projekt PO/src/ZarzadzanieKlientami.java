import Klasy.Klient;
import Klasy.System_lotniczy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZarzadzanieKlientami extends MainInterface{
    protected JList listaKlientow;
    private JButton dodajPosrednikaFrimyButton;
    private JButton dodajKlientaIndywidualnegoButton;
    private JButton usunKlientaButton;
    private JButton wrocButton;
    private JScrollPane scroll;
    private JPanel zarzadzanieKlientami;
    private JButton odswierzListeKLientowButton;
    protected DefaultListModel<Klient> klientListModel;
    public ZarzadzanieKlientami(System_lotniczy system_lotniczy) {
    super(system_lotniczy);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    setSize(800,500);
    setContentPane(zarzadzanieKlientami);
    setLocationRelativeTo(null);

    klientListModel = new DefaultListModel<>();
    listaKlientow.setModel(klientListModel);

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
            }
        });
        odswierzListeKLientowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                klientListModel.removeAllElements();
                for (Klient klient: system_lotniczy.getKlienci())
                {
                    klientListModel.addElement(klient);
                }
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
    private void dodajKlientaPosrednika()
    {
        PosrednikFirmy posrednikFirmy = new PosrednikFirmy(system_lotniczy);
        posrednikFirmy.setVisible(true);
    }
private void dodajKlientaIndywidualnego()
{
    klientIndywidualny klientIndywidualny = new klientIndywidualny(system_lotniczy);
    klientIndywidualny.setVisible(true);
}
private void usunKlienta()
{
    int idx = listaKlientow.getSelectedIndex();
    klientListModel.remove(idx);
    system_lotniczy.usunKlient(idx);

}
}
