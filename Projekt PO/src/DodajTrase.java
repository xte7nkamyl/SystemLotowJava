import Klasy.Lotnisko;
import Klasy.System_lotniczy;
import Klasy.Trasa;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 */

/**
 *klasa w ktorej tworzone jest nowe okno z dodawaniem trasy
 */
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

    /**
     * Konstruktor ktory tworzy nowe okno, ustawia jego domyslne wartosci i rozmiary dodaje funkcjonalnosci pod odpowiednie przyciski
     * @param system_lotniczy umozliwia uzyskanie dostepu do metod z klasy System_lotniczy
     */
    public DodajTrase(System_lotniczy system_lotniczy) {
    super(system_lotniczy);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    setSize(500,200);
    setContentPane(dodajTrase);
    setLocationRelativeTo(null);

    lotniskoComboBoxModel1 = new DefaultComboBoxModel<>();
        lotniskoComboBoxModel2 = new DefaultComboBoxModel<>();
    for(Lotnisko lotnisko: system_lotniczy.getLotniska())    //używamy DefaultComboBoxModel do dodania elementów do modelu listy.
    {lotniskoComboBoxModel1.addElement(lotnisko);            //Następnie przekazujemy ten model do konstruktora JComboBox
        lotniskoComboBoxModel2.addElement(lotnisko);
    }
        lotniskoP.setModel(lotniskoComboBoxModel1);
        lotniskoK.setModel(lotniskoComboBoxModel2);
    dodajButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dodajTrase();
        }
    });
    anulujButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            wroc();
        }
    });

    }

    /**
     * metoda ktora dodaje trase do listy z trasami
     */
    private void dodajTrase()
{
    String odleglosc = this.odleglosc.getText();
    String czasLotu = this.czasLotu.getText();
    Lotnisko p = (Lotnisko) lotniskoP.getSelectedItem();  // pobieramy  wartosci z pol  JTextField oraz JComboBox
    Lotnisko k = (Lotnisko) lotniskoK.getSelectedItem();

    if(odleglosc.isEmpty() || czasLotu.isEmpty())          //Sprawdzamy wyjatek czy nie sa puste oraz czy zawieraja odpowiednie typy
    {
        JOptionPane.showMessageDialog(this,"Uzupelnij pola", "Błąd", JOptionPane.ERROR_MESSAGE);
    }
    else
    {
        try {
            int odlegloscInt = Integer.parseInt(odleglosc);
            int czasLotuInt = Integer.parseInt(czasLotu);
            system_lotniczy.dodajTrasa(new Trasa(odlegloscInt,p,k,czasLotuInt));
            JOptionPane.showMessageDialog(this,"Trasa zostala dodana!");
            wroc();
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this,"Nieprawidłowy format odleglosc lub czas lotu.", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }
}

    /**
     * Metoda ktora zamyka bierzace okno i wraca do poprzedniego
     */
    private void wroc()
{
    dispose();
    new ZarzadzanieTrasami(system_lotniczy).setVisible(true);
}
}
