import Klasy.System_lotniczy;
import Klasy.Trasa;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
/**
 *klasa w ktore tworzone jest nowe okno z generwaniem lotow
 */
public class GeneratorLotow extends MainInterface{
    private JButton generujLotButton;
    private JButton przegladajLotyButton;
    private JButton wrocButton;
    private JPanel generatorLotow;
    private JSpinner data;
    private JSpinner dataDo;
    private JComboBox listaTras;
    private JSpinner czestotliwosc;
    private DefaultComboBoxModel<Trasa> trasaListModel;
    /**
     * Konstruktor ktory tworzy nowe okno, ustawia jego domyslne wartosci i rozmiary dodaje funkcjonalnosci pod odpowiednie przyciski
     * @param system_lotniczy umozliwia uzyskanie dostepu do metod z klasy System_lotniczy
     */
    public GeneratorLotow(System_lotniczy system_lotniczy) {
        super(system_lotniczy);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1350,600);
        setLocationRelativeTo(null);
        setContentPane(generatorLotow);
        setVisible(true);
        SpinnerDateModel dateModel = new SpinnerDateModel();
        Calendar calendar = Calendar.getInstance();    // uzywamy SpinnerDateModel w ktorym umieszczamy model kalendarza
        dateModel.setValue(calendar.getTime());        // nastepnie caly model do konstruktora Jspinner
        data.setModel(dateModel);
        SpinnerNumberModel numberModel = new SpinnerNumberModel(1,1,2,1);
        czestotliwosc.setModel(numberModel);
        trasaListModel = new DefaultComboBoxModel<>();
        for (Trasa trasa: system_lotniczy.getTrasy())
            trasaListModel.addElement(trasa);
        listaTras.setModel(trasaListModel);
        wrocButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MainInterface(system_lotniczy).setVisible(true);
            }
        });
        generujLotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generujLot();
            }
        });

        przegladajLotyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PrzegladLotow(system_lotniczy).setVisible(true);
                dispose();
            }
        });
    }

    /**
     * Metoda ktora zamyka bierzace okno i wraca do poprzedniego
     */
    private void generujLot()
    {
        Trasa t = (Trasa) listaTras.getSelectedItem();
        SpinnerDateModel dataModel = (SpinnerDateModel) data.getModel(); //spinner jest referencją do JSpinner. Pobieramy model spinnera za pomocą metody getModel() i rzutujemy go na SpinnerDateModel
        Date selectedDate1 = (Date) dataModel.getValue();             //następnie pobieramy wartość z modelu spinnera za pomocą metody getValue() która zwraca obiekt Date.
        LocalDateTime localDateTime = LocalDateTime.ofInstant(selectedDate1.toInstant(), ZoneId.systemDefault()); //Na koniec konwertujemy wartość daty do obiektu LocalDateTime, korzystając z metody LocalDateTime.ofInstant()
        int czestotliwosc = (Integer) this.czestotliwosc.getValue();
        system_lotniczy.generatorLotow(t,localDateTime,czestotliwosc);
        JOptionPane.showMessageDialog(this,"Lot zostal wygenerowany!");
    }
}
