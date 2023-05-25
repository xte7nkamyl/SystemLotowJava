import Klasy.System_lotniczy;
import Klasy.Trasa;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZarzadzanieTrasami extends MainInterface{
    private JList listaTras;
    private JButton usunTraseButton;
    private JButton dodajTraseButton;
    private JButton odswiezListeButton;
    private JButton wrocButton;
    private JPanel zarzadzanieTrasami;
private DefaultListModel<Trasa> trasaListModel;
    public ZarzadzanieTrasami(System_lotniczy system_lotniczy) {
    super(system_lotniczy);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setSize(800,500);
    setLocationRelativeTo(null);
    setContentPane(zarzadzanieTrasami);
    setVisible(true);
    trasaListModel = new DefaultListModel<>();
    listaTras.setModel(trasaListModel);
    dodajTraseButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            DodajTrase dodajTrase = new DodajTrase(system_lotniczy);
            dodajTrase.setVisible(true);
        }
    });
        wrocButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        odswiezListeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trasaListModel.removeAllElements();
                for (Trasa trasa: system_lotniczy.getTrasy())
                    trasaListModel.addElement(trasa);
            }
        });
        usunTraseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usunTrase();
            }
        });
    }
    private void usunTrase(){
        int idx = listaTras.getSelectedIndex();
        trasaListModel.remove(idx);
        system_lotniczy.usunTrasa(idx);
    }
}
