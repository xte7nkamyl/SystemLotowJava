import Klasy.Lotnisko;
import Klasy.System_lotniczy;
import Klasy.Trasa;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DodajTrase extends ZarzadzanieTrasami{
    private JTextField odleglosc;
    private JTextField czasLotu;
    private JComboBox lotniskoP;
    private JComboBox lotniskoK;
    private JButton dodajButton;
    private JButton anulujButton;
    private JPanel dodajTrase;
    private DefaultComboBoxModel<Lotnisko> lotniskoComboBoxModel1;
    private DefaultComboBoxModel<Lotnisko> lotniskoComboBoxModel2;

    public DodajTrase(System_lotniczy system_lotniczy) {
    super(system_lotniczy);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    setSize(500,200);
    setContentPane(dodajTrase);
    setLocationRelativeTo(null);
    lotniskoComboBoxModel1 = new DefaultComboBoxModel<>();
        lotniskoComboBoxModel2 = new DefaultComboBoxModel<>();
    lotniskoP.setModel(lotniskoComboBoxModel1);
    lotniskoK.setModel(lotniskoComboBoxModel2);
    for(Lotnisko lotnisko: system_lotniczy.getLotniska())
    {lotniskoComboBoxModel1.addElement(lotnisko);
    lotniskoComboBoxModel2.addElement(lotnisko);
    }
    dodajButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dodajTrase();
        }
    });
    anulujButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    });
}
private void dodajTrase()
{
    String odleglosc = this.odleglosc.getText();
    String czasLotu = this.czasLotu.getText();
    Lotnisko p = (Lotnisko) lotniskoP.getSelectedItem();
    Lotnisko k = (Lotnisko) lotniskoK.getSelectedItem();
    int odlegloscInt = Integer.parseInt(odleglosc);
    int czasLotuInt = Integer.parseInt(czasLotu);
    system_lotniczy.dodajTrasa(new Trasa(odlegloscInt,p,k,czasLotuInt));
    dispose();
}
}
