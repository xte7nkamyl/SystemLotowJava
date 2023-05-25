import Klasy.System_lotniczy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneratorLotow extends MainInterface{
    private JList listaLotow;
    private JButton generujLotButton;
    private JButton dodajLotButton;
    private JButton odswierzListeButton;
    private JButton wrocButton;
    private JPanel generatorLotow;

    public GeneratorLotow(System_lotniczy system_lotniczy) {
        super(system_lotniczy);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800,600);
        setLocationRelativeTo(null);
        setContentPane(generatorLotow);
        setVisible(true);
        wrocButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        generujLotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
