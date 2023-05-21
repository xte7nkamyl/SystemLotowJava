import java.util.Iterator;
import java.util.Scanner;
import Klasy.*;



public class Main {
    public static void main(String[] args)
    {



        System_lotniczy systemlotniczy = new System_lotniczy();
        ZapisOdczytSystemu zapisOdczyt= new ZapisOdczytSystemu();
        ZapisOdczytSystemu.odczytaj(systemlotniczy, "SystemLotow.txt");
        Scanner scan = new Scanner(System.in);
        int x;



        while (true)
        {//petla glowna
            System.out.println("Menu:");
            System.out.println("1.Zarzadzanie samolotami ");
            System.out.println("2.Zarzadzanie klientami ");
            System.out.println("3.Zarzadzanie trasami ");
            System.out.println("4.Zarzadzanie lotniskami ");
            System.out.println("5.Zarzadzanie lotami ");
            System.out.println("6.Rezerwacja biletów");
            System.out.println("0.Wyjdz");
            x = scan.nextInt();

            switch (x)
            {//glowny switch
                case 1:

                    while (true)
                    {

                        System.out.println("Zarzadzanie samolotami");
                        System.out.println("1.Dodaj samolot");
                        System.out.println("2.Usun samolot");
                        System.out.println("3.Wyswietl samoloty");
                        System.out.println("0.cofnij");
                        x = scan.nextInt();//zmienna
                        switch (x)//switch 2 rzedu
                        {
                            case 1:
                                while(true)
                                {
                                    System.out.println("Wybierz samolot:");
                                    System.out.println("1.Klasa biznesowa");
                                    System.out.println("2.Klasa ekonomiczna");
                                    System.out.println("3.Klasa pierwsza");
                                    System.out.println("0.cofnij");
                                    x=scan.nextInt();
                                    switch(x)
                                    {
                                        case 1:
                                            systemlotniczy.dodajSamolot(new Klasa_biznesowa());
                                            System.out.println("Dodano samolot klasy biznesowej");
                                            break;
                                        case 2:
                                            systemlotniczy.dodajSamolot(new Klasa_ekonomiczna());
                                            System.out.println("Dodano samolot klasy ekonomicznej");
                                            break;
                                        case 3:
                                            systemlotniczy.dodajSamolot(new Klasa_pierwsza());
                                            System.out.println("Dodano samolot klasy pierwszej");
                                            break;
                                        case 0:
                                            break;
                                        default:
                                            System.out.println("Podano zla wartosc!");
                                            break;
                                    }
                                    if(x==0){
                                        break;
                                    }
                                }
                                x=99;

                                break;
                            case 2:

                                break;
                            case 3:
                                System.out.println("Samoloty:");
                                System.out.println(systemlotniczy.getSamoloty());
                                ///////
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Podano zla wartosc!");
                                break;
                        }
                        if(x==0){
                            break;

                        }

                    }
                    x=99;
                    break;
                case 2:
                    while (true)
                    {
                        System.out.println("Zarzadzanie klientami");
                        System.out.println("1.Dodaj klienta");
                        System.out.println("2.Usun klienta");
                        System.out.println("3.Wyswietl liste klientow");
                        System.out.println("0.cofnij");
                        x = scan.nextInt();//zmienna
                        String imie,nazwisko;
                        int pesel;
                        switch (x)//switch 2 rzedu
                        {
                            case 1:
                                System.out.print("Podaj imię: ");
                                imie = scan.next();
                                System.out.print("Podaj nazwisko: ");
                                nazwisko = scan.next();
                                System.out.println("Podaj pesel");
                                pesel = scan.nextInt();
                                systemlotniczy.dodajKlient(new Klient(imie,nazwisko,pesel));
                                System.out.println("Dodano Klienta: " + imie + " " + nazwisko + " " + pesel);
                                System.out.println("Dodawanie klientow");
                                /////////////////////////
                                break;
                            case 2:
                                System.out.println("Usuwanie klientow");
                                ///////////
                                break;
                            case 3:
                                System.out.println("Klienci:");
                                System.out.println(systemlotniczy.getKlienci());
                                ///////
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Podano zla wartosc!");
                                break;
                        }
                        if(x==0){
                            break;
                        }
                    }
                    x=99;
                    break;
                case 3:
                    while (true)
                    {

                        System.out.println("Zarzadzanie trasami");
                        System.out.println("1.Dodaj trase");
                        System.out.println("2.Usun trase");
                        System.out.println("3.Wyswietl trasy");
                        System.out.println("0.cofnij");
                        x = scan.nextInt();//zmienna
                        String poczatek,koniec,miasto;
                        int odleglosc,czaslotu;
                        Lotnisko p = null,k = null;
                        switch (x)//switch 2 rzedu
                        {
                            case 1:
                                System.out.println("Podaj odleglosc trasy w [km]: ");
                                odleglosc = scan.nextInt();
                                System.out.println("Podaj nazwe lotniska poczatkowego: ");
                                poczatek = scan.next();
                                System.out.println("Podaj nazwe miasta poczatkowego: ");
                                miasto = scan.next();
                                Iterator<Lotnisko> itr = systemlotniczy.getLotniska().listIterator();
                                while(itr.hasNext())
                                {
                                    Lotnisko l1 = itr.next();
                                    if(l1.getNazwa().equals(poczatek) && l1.getMiasto().equals(miasto))
                                        p = new Lotnisko(poczatek,miasto);
                                    break;
                                }
                                System.out.println("Podaj nazwe lotniska koncowego: ");
                                koniec = scan.next();
                                System.out.println("Podaj nazwe miasta poczatkowego: ");
                                miasto = scan.next();
                                while (itr.hasNext())
                                {
                                    Lotnisko l2 = itr.next();
                                    if(l2.getNazwa().equals(koniec) && l2.getMiasto().equals(miasto))
                                        k = new Lotnisko(koniec,miasto);
                                }
                                System.out.println("Podaj czas lotu: ");
                                czaslotu=scan.nextInt();
                                Trasa trasa=new Trasa(odleglosc,p,k,czaslotu);
                                systemlotniczy.dodajTrasa(trasa);
                                System.out.println("Dodawanie trasy");
                                p = null;
                                k = null;
                                /////////////////
                                break;
                            case 2:
                                System.out.println("Usuwanie trasy");
                                ///////////
                                break;
                            case 3:
                                System.out.println("Trasy:");
                                System.out.println(systemlotniczy.getTrasy());
                                ///////
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Podano zla wartosc!");
                                break;
                        }
                        if(x==0){
                            break;
                        }
                    }
                    x=99;
                    break;
                case 4:
                    while (true)
                    {

                        System.out.println("Zarzadzanie lotniskami");
                        System.out.println("1.Dodaj lotnisko");
                        System.out.println("2.Usun lotnisko");
                        System.out.println("3.Wyswietl lotniska");
                        System.out.println("0.cofnij");
                        x = scan.nextInt();//zmienna
                        String nazwa,miasto;
                        switch (x)//switch 2 rzedu
                        {
                            case 1:
                                System.out.println("Podaj nazwe lotniska: ");
                                nazwa = scan.next();
                                System.out.println("Podaj nazwe miasta: ");
                                miasto = scan.next();
                                systemlotniczy.dodajLotnisko(new Lotnisko(nazwa,miasto));
                                System.out.println("Dodano Lotnisko: " + nazwa + " " + miasto);
                                /////////////////////////
                                break;
                            case 2:
                                System.out.println("Usuwanie lotniska");
                                System.out.println("Podaj nazwe lotniska do usuniecia: ");
                                nazwa=scan.next();
                                Iterator<Lotnisko> itr = systemlotniczy.getLotniska().listIterator();
                                while (itr.hasNext())
                                {
                                    Lotnisko lotnisko = itr.next();
                                    if (lotnisko.getNazwa().equals(nazwa))
                                        System.out.println("Usunieto lotnsko");
                                        //systemlotniczy.usunLotnisko(lotnisko);
                                        itr.remove();
                                }

                                break;
                            case 3:
                                System.out.println("Lotniska:");
                                System.out.println(systemlotniczy.getLotniska());
                                ///////
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Podano zla wartosc!");
                                break;
                        }
                        if(x==0){
                            break;
                        }
                    }
                    x=99;
                    break;
                case 5:
                    while(true){
                        System.out.println("Zarzadzanie lotami");
                        System.out.println("1.Dodaj Lot");
                        System.out.println("2.Usun lot");
                        System.out.println("3.Wyswietl loty");
                        System.out.println("0.Cofnij");
                        x=scan.nextInt();
                        switch(x){
                            case 1:
                                System.out.println("Dodawanie lotu");
                                System.out.println("Podaj nazwe lotniska wylotu");
                                String nazwa1=scan.next();
                                System.out.println("Podaj nazwe lotniska wylotu");
                                String nazwa2=scan.next();
                                for(Trasa trasa: systemlotniczy.getTrasy() ){
                                    if(trasa.getLotnisko1().equals(nazwa1)&&trasa.getLotnisko2().equals(nazwa2));
                                }

                                break;
                            case 2:
                                System.out.println();
                                break;
                            case 3:
                                System.out.println();
                                break;
                            case 4:
                                break;
                        }

                    }
                    break;
                case 6:
                    System.out.println("Rezerwacja biletow");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Podano zla wartosc!");
                    break;

            }
            if(x==0){
                break;
            }
        }
        ZapisOdczytSystemu.zapisz(systemlotniczy, "SystemLotow.txt");
    }
}

