import Klasy.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class DodawanieRezerwacji extends ZarzadzanieRezerwacjami{
    private JComboBox listaKlientow;
    private JComboBox listaTras;
    private JComboBox listaSamolotow;
    private JButton dodajButton;
    private JButton anulujButton;
    private JPanel dodawanieRezerwacji;
    private JSpinner data;
    private DefaultComboBoxModel<Klient> klientComboBoxModel;
    private DefaultComboBoxModel<Trasa> trasaComboBoxModel;
    private DefaultComboBoxModel<Samolot> samolotDefaultComboBoxModel;
public DodawanieRezerwacji(System_lotniczy system_lotniczy) {
    super(system_lotniczy);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    setSize(900,500);
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
    SpinnerDateModel dateModel = new SpinnerDateModel();
    Calendar calendar = Calendar.getInstance();
    dateModel.setValue(calendar.getTime());
    data.setModel(dateModel);
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
public void dodajRezerwacje()
{
    Klient k = (Klient) listaKlientow.getSelectedItem();
    Trasa t = (Trasa) listaTras.getSelectedItem();
    Samolot s = (Samolot) listaSamolotow.getSelectedItem();
    SpinnerDateModel dataModel = (SpinnerDateModel) data.getModel();
    Date selectedDate = (Date) dataModel.getValue();
    LocalDateTime localDateTime = LocalDateTime.ofInstant(selectedDate.toInstant(), ZoneId.systemDefault());
    //SpinnerDateModel spinnerModel = (SpinnerDateModel) data.getModel();
    //Date selectedDate = spinnerModel.getDate();
    //Instant instant = selectedDate.toInstant();
    //LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    system_lotniczy.dodajRezerwacje(new Rezerwacja(k,t,localDateTime,s));
    dispose();

}
}
