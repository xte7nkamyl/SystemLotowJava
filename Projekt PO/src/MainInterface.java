
import Klasy.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainInterface extends JFrame {
    protected System_lotniczy system_lotniczy;
    private JButton wyjdzButton;
    private JPanel mainPanel;
    private JButton generatorLotow;
    private JButton zarzadzajTrasamiButton;
    private JButton zarzadzajLotniskamiButton;
    private JButton zarzadzajSamolotamiButton;
    private JButton zarzadzajKlientamiButton;
    private JButton zarzadzanieRezerwacjamiButton;

    public MainInterface(System_lotniczy system_lotniczy)
    {
        this.system_lotniczy = system_lotniczy;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800,500);
        setLocationRelativeTo(null);
        setContentPane(mainPanel);
        setVisible(true);


        zarzadzajSamolotamiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               zarzadzajSamolotami();
            }
        });
        zarzadzajKlientamiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zarzadzajKlientami();
            }
        });
        zarzadzajLotniskamiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zarzadzajLotniskami();
            }
        });
        zarzadzajTrasamiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            zarzadzajTrasami();
            }
        });
        zarzadzanieRezerwacjamiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            zarzadzajRezerwacjami();
            }
        });
        generatorLotow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generatorLotow();
            }
        });
        wyjdzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ZapisOdczytSystemu.zapisz(system_lotniczy, "SystemLotow.txt");
            }
        });
    }
private void zarzadzajRezerwacjami()
{
    ZarzadzanieRezerwacjami zarzadzanieRezerwacjami = new ZarzadzanieRezerwacjami(system_lotniczy);
    zarzadzanieRezerwacjami.setVisible(true);
    dispose();
}
    protected void zarzadzajTrasami()
    {
        ZarzadzanieTrasami zarzadzanieTrasami = new ZarzadzanieTrasami(system_lotniczy);
        zarzadzanieTrasami.setVisible(true);
        dispose();
    }
    private void zarzadzajLotniskami()
    {
        ZarzadzanieLotniskami zarzadzanieLotniskami = new ZarzadzanieLotniskami(system_lotniczy);
        zarzadzanieLotniskami.setVisible(true);
        dispose();
    }
    private void zarzadzajKlientami()
    {
        ZarzadzanieKlientami zarzadzanieKlientami = new ZarzadzanieKlientami(system_lotniczy);
        zarzadzanieKlientami.setVisible(true);
        dispose();
    }
    private void zarzadzajSamolotami()
    {
        SamolotyMenu samolotyMenu = new SamolotyMenu(system_lotniczy);
        samolotyMenu.setVisible(true);
    }
    private void generatorLotow()
    {
        GeneratorLotow generatorLotow = new GeneratorLotow(system_lotniczy);
        generatorLotow.setVisible(true);
        dispose();
    }
    public static void main(String[] args)
    {
        System_lotniczy system_lotniczy = new System_lotniczy();
        ZapisOdczytSystemu zapisOdczyt= new ZapisOdczytSystemu();
        ZapisOdczytSystemu.odczytaj(system_lotniczy, "SystemLotow.txt");
        MainInterface main = new MainInterface(system_lotniczy);

    }
}
