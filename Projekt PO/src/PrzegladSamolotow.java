import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import Klasy.Samolot;
import Klasy.System_lotniczy;

public class PrzegladSamolotow extends MainInterface{
    private DefaultListModel<Samolot> samolotListModel;
    private JButton wrocButton;
    private JPanel przegladSamolotow;
    private JList listaSamolotow;
    private JScrollPane Scroll;

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
{
    samolotListModel.addElement(samolot);
}
        wrocButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wroc();
            }
        });
    }

    private void wroc()
    {
        this.dispose();
    }
    /*private void wyswietlSamoloty()
    {
        samolotListModel = new DefaultListModel<>();
        for (Samolot samolot: system_lotniczy.getSamoloty())
        {
            samolotListModel.addElement(samolot);
        }
        samolotList = new JList<>();

        JOptionPane.showMessageDialog(this, samolotListModel.toArray(), "Lista Samolotów", JOptionPane.PLAIN_MESSAGE);

    }
*/
}
