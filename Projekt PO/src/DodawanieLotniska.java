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
            anuluj();
        }
    });
        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                anuluj();
            }
        });
    }
    private void dodajLotnisko()
    {
        String nazwa = this.nazwa.getText();
        String miasto = this.miasto.getText();
        if(nazwa.isEmpty() && miasto.isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Uzupelnij pola", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
                if (nazwa.matches("[a-zA-Z]+") && miasto.matches("[a-zA-Z]+")) {
                    system_lotniczy.dodajLotnisko(new Lotnisko(nazwa,miasto));
                    JOptionPane.showMessageDialog(this,"Lotnisko zostalo dodane!");
                }else {
                    JOptionPane.showMessageDialog(this,"Nieprawidłowy format Nazwa lub Miasto.", "Błąd", JOptionPane.ERROR_MESSAGE);
            }

        }
    }
    private void anuluj()
    {
        dispose();
        ZarzadzanieLotniskami zarzadzanieLotniskami = new ZarzadzanieLotniskami(system_lotniczy);
        zarzadzanieLotniskami.setVisible(true);
    }
}
