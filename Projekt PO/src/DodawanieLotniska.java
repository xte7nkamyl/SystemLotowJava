import Klasy.Klient_indywidualny;
import Klasy.Lotnisko;
import Klasy.System_lotniczy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DodawanieLotniska extends ZarzadzanieLotniskami{
    private JTextField nazwa;
    private JTextField miasto;
    private JButton anulujButton;
    private JButton dodajButton;
    private JPanel dodawanieLotniska;

    public DodawanieLotniska(System_lotniczy system_lotniczy) {
    super(system_lotniczy);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    setSize(500,200);
    setContentPane(dodawanieLotniska);
    setLocationRelativeTo(null);
    dodajButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dodajLotnisko();
        }
    });
        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    private void dodajLotnisko()
    {
        String nazwa = this.nazwa.getText();
        String miasto = this.miasto.getText();
        system_lotniczy.dodajLotnisko(new Lotnisko(nazwa,miasto));
        if(nazwa.isEmpty() && miasto.isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Uzupelnij pola", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            try {
                if (nazwa.matches("[a-zA-Z]+") && miasto.matches("[a-zA-Z]+")) {
                    system_lotniczy.dodajLotnisko(new Lotnisko(nazwa,miasto));
                }
                dispose();
            }
            catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(this,"Nieprawidłowy format .", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
