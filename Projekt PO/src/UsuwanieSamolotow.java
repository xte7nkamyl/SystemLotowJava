import Klasy.Samolot;
import Klasy.System_lotniczy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsuwanieSamolotow extends MainInterface{
    private JList listaSamolotow;
    private DefaultListModel<Samolot> samolotListModel;
    private JButton usunSamolotButton;
    private JButton wrocButton;
    private JPanel usuwanieSamoltow;
    private JScrollPane scroll;

    public UsuwanieSamolotow(System_lotniczy system_lotniczy) {
    super(system_lotniczy);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    setSize(800,500);
    setContentPane(usuwanieSamoltow);
    setLocationRelativeTo(null);
    samolotListModel = new DefaultListModel<>();
    listaSamolotow.setModel(samolotListModel);
    for(Samolot samolot: system_lotniczy.getSamoloty())
    {
        samolotListModel.addElement(samolot);
    }
    wrocButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    });
    usunSamolotButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
usunSamolot();
        }
    });
}
private void usunSamolot()
{
    int idex = listaSamolotow.getSelectedIndex();
    samolotListModel.remove(idex);
}
}
