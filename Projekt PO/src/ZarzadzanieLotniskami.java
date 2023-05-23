import Klasy.Klient;
import Klasy.Lotnisko;
import Klasy.System_lotniczy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZarzadzanieLotniskami extends MainInterface{
    private JList listaLotnisk;
    private JButton dodajLotnsikoButton;
    private JButton usunLotniskoButton;
    private JButton odswierzListeButton;
    private JPanel zarzadzanieLotniskami;
    private JButton button1;
    private DefaultListModel<Lotnisko> lotniskoListModel;
    public ZarzadzanieLotniskami(System_lotniczy system_lotniczy) {
        super(system_lotniczy);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(800,530);
        setContentPane(zarzadzanieLotniskami);
        setLocationRelativeTo(null);
        lotniskoListModel = new DefaultListModel<>();
        listaLotnisk.setModel(lotniskoListModel);
    dodajLotnsikoButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dodajLotniska();
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
                lotniskoListModel.removeAllElements();
                for(Lotnisko lotnisko: system_lotniczy.getLotniska())
                {
                    lotniskoListModel.addElement(lotnisko);
                }
            }
        });
        usunLotniskoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usunLotnisko();
            }
        });
    }
    private void dodajLotniska()
    {
        DodawanieLotniska dodawanieLotniska = new DodawanieLotniska(system_lotniczy);
        dodawanieLotniska.setVisible(true);
    }
    private void usunLotnisko()
    {
        int idx = listaLotnisk.getSelectedIndex();
        lotniskoListModel.remove(idx);
        system_lotniczy.usunLotnisko(idx);
    }
}
