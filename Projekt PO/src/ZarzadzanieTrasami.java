import Klasy.System_lotniczy;
import Klasy.Trasa;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZarzadzanieTrasami extends MainInterface{
    protected JList listaTras;
    private JButton usunTraseButton;
    private JButton dodajTraseButton;
    private JButton wrocButton;
    private JPanel zarzadzanieTrasami;
    protected DefaultListModel<Trasa> trasaListModel;

    public ZarzadzanieTrasami(System_lotniczy system_lotniczy) {
    super(system_lotniczy);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setSize(800,500);
    setLocationRelativeTo(null);
    setContentPane(zarzadzanieTrasami);
    setVisible(true);
        trasaListModel = new DefaultListModel<>();
        trasaListModel.removeAllElements();
        for (Trasa trasa: system_lotniczy.getTrasy())
            trasaListModel.addElement(trasa);
        listaTras.setModel(trasaListModel);
    dodajTraseButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            DodajTrase dodajTrase = new DodajTrase(system_lotniczy);
            dodajTrase.setVisible(true);
            dispose();
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
        usunTraseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usunTrase();
            }
        });
    }
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
