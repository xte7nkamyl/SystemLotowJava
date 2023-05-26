import Klasy.System_lotniczy;
import Klasy.Trasa;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

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

    public GeneratorLotow(System_lotniczy system_lotniczy) {
        super(system_lotniczy);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1300,600);
        setLocationRelativeTo(null);
        setContentPane(generatorLotow);
        setVisible(true);
        SpinnerDateModel dateModel = new SpinnerDateModel();
        Calendar calendar = Calendar.getInstance();
        dateModel.setValue(calendar.getTime());
        data.setModel(dateModel);
        SpinnerNumberModel numberModel = new SpinnerNumberModel(1,1,2,1);
        czestotliwosc.setModel(numberModel);
        trasaListModel = new DefaultComboBoxModel<>();
        listaTras.setModel(trasaListModel);
        for (Trasa trasa: system_lotniczy.getTrasy())
            trasaListModel.addElement(trasa);
        wrocButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainInterface mainInterface = new MainInterface(system_lotniczy);
                mainInterface.setVisible(true);
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
                PrzegladLotow przegladLotow = new PrzegladLotow(system_lotniczy);
                przegladLotow.setVisible(true);
                dispose();
            }
        });
    }
    private void generujLot()
    {
        Trasa t = (Trasa) listaTras.getSelectedItem();
        SpinnerDateModel dataModel = (SpinnerDateModel) data.getModel();
        Date selectedDate1 = (Date) dataModel.getValue();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(selectedDate1.toInstant(), ZoneId.systemDefault());
        int czestotliwosc = (Integer) this.czestotliwosc.getValue();
        system_lotniczy.generatorLotowDlatrasy(t,localDateTime,czestotliwosc);
        JOptionPane.showMessageDialog(this,"Lot zostal wygenerowany!");
    }
}
