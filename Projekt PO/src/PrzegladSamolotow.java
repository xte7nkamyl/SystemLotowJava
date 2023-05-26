import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Klasy.Samolot;
import Klasy.System_lotniczy;

public class PrzegladSamolotow extends MainInterface{
    private DefaultListModel<Samolot> samolotListModel;
    private JButton wrocButton;
    private JPanel przegladSamolotow;
    private JList listaSamolotow;
    private JScrollPane Scroll;
    private JButton usunSamolotButton;

    public PrzegladSamolotow(System_lotniczy system_lotniczy)
    {
        super(system_lotniczy);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(800,500);
        setContentPane(przegladSamolotow);
        setLocationRelativeTo(null);
        samolotListModel = new DefaultListModel<>();
        listaSamolotow.setModel(samolotListModel);
for(Samolot samolot: system_lotniczy.getSamoloty())
    samolotListModel.addElement(samolot);

        wrocButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wroc();
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
        Samolot s = (Samolot) listaSamolotow.getSelectedValue();
        if(s != null)
        {
            samolotListModel.removeElement(s);
            system_lotniczy.usunSamolot(s);
            JOptionPane.showMessageDialog(this,"Samolot zostal usuniety!");
        }
        else {
            JOptionPane.showMessageDialog(this,"Wybierz samolot, ktory chcesz usunac", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void wroc()
    {
        this.dispose();
    }
}
