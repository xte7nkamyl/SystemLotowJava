import Klasy.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class DodawanieRezerwacji extends ZarzadzanieRezerwacjami{
    private JTextField godzina;
    private JTextField minuta;
    private JTextField dzien;
    private JTextField miesiac;
    private JTextField rok;
    private JComboBox listaKlientow;
    private JComboBox listaTras;
    private JComboBox listaSamolotow;
    private JButton dodajButton;
    private JButton anulujButton;
    private JPanel dodawanieRezerwacji;
    private DefaultComboBoxModel<Klient> klientComboBoxModel;
    private DefaultComboBoxModel<Trasa> trasaComboBoxModel;
    private DefaultComboBoxModel<Samolot> samolotDefaultComboBoxModel;
public DodawanieRezerwacji(System_lotniczy system_lotniczy) {
    super(system_lotniczy);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    setSize(500,400);
    setContentPane(dodawanieRezerwacji);
    setLocationRelativeTo(null);
    klientComboBoxModel = new DefaultComboBoxModel<>();
    trasaComboBoxModel = new DefaultComboBoxModel<>();
    samolotDefaultComboBoxModel = new DefaultComboBoxModel<>();
    listaKlientow.setModel(klientComboBoxModel);
    listaTras.setModel(trasaComboBoxModel);
    listaSamolotow.setModel(samolotDefaultComboBoxModel);
    for(Klient klient: system_lotniczy.getKlienci())
        klientComboBoxModel.addElement(klient);
    for (Trasa trasa: system_lotniczy.getTrasy())
        trasaComboBoxModel.addElement(trasa);
    for(Samolot samolot : system_lotniczy.getSamoloty())
        samolotDefaultComboBoxModel.addElement(samolot);
    dodajButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dodajRezerwacje();
        }
    });
    anulujButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    });
}
private void dodajRezerwacje()
{
    String godzina = this.godzina.getText();
    String minuta = this.minuta.getText();
    String dzien = this.dzien.getText();
    String miesiac = this.miesiac.getText();
    String rok = this.rok.getText();
    int godzinaInt = Integer.parseInt(godzina);
    int minutaInt = Integer.parseInt(minuta);
    int dzienInt = Integer.parseInt(dzien);
    int miesiacInt = Integer.parseInt(miesiac);
    int rokInt = Integer.parseInt(rok);
    Klient k = (Klient) listaKlientow.getSelectedItem();
    Trasa t = (Trasa) listaTras.getSelectedItem();
    Samolot s = (Samolot) listaSamolotow.getSelectedItem();
    LocalDateTime dateTime = LocalDateTime.of(rokInt,miesiacInt,dzienInt,godzinaInt,minutaInt);
    system_lotniczy.dodajRezerwacje(new Rezerwacja(k,t,dateTime,s));
    dispose();

}
}
