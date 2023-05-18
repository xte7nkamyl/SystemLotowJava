import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import Klasy.*;


public class Main {
    public static void main(String[] args)
    {
        System_lotniczy systemlotniczy = new System_lotniczy();
        ZapisOdczytSystemu zapisOdczyt= new ZapisOdczytSystemu();
        ZapisOdczytSystemu.odczytaj(systemlotniczy, "SystemLotow.txt");
        Scanner scan = new Scanner(System.in);

        String imie, nazwisko, nazwa, miasto;
        int pesel;
        int x;



        while (true)
        {//petla glowna
            System.out.println("Menu:");
            System.out.println("1. Zarządzanie samolotami ");
            System.out.println("2. Zarządzanie klientami ");
            System.out.println("3. Zarządzanie trasami ");
            System.out.println("4. Zarządzanie lotniskami ");
            System.out.println("5. Rezerwacja biletów");
            System.out.println("0. Wyjdź");
            x = scan.nextInt();

            switch (x)
            {//glowny switch
                case 1:

                    while (true)
                    {

                        System.out.println("Zarządzanie samolotami");
                        System.out.println("1. Dodaj samolot");
                        System.out.println("2. Usuń samolot");
                        System.out.println("3. Wyświetl samoloty");
                        System.out.println("0. Cofnij");
                        x = scan.nextInt();//zmienna
                        switch (x)//switch 2 rzedu
                        {
                            case 1:
                                while(true)
                                {
                                    System.out.println("Dodawanie samolotu");
                                    System.out.println("Wybierz samolot: ");
                                    System.out.println("1. Klasa biznesowa");
                                    System.out.println("2. Klasa ekonomiczna");
                                    System.out.println("3. Klasa pierwsza");
                                    System.out.println("0. Cofnij");
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
                                            System.out.println("Podano złą wartość!");
                                            break;

                                    }
                                    if(x==0){
                                        break;

                                    }
                                }
                                x=99;

                                break;
                            case 2:
                                System.out.println("Usuwanie samolotu");
                                ///////////
                                break;
                            case 3:
                                System.out.println("Samoloty: ");
                                System.out.println(systemlotniczy.getSamoloty());
                                ///////
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Podano złą wartość!");
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
                        System.out.println("Zarządzanie klientami");
                        System.out.println("1. Dodaj klienta");
                        System.out.println("2. Usuń klienta");
                        System.out.println("3. Wyświetl liste klientów");
                        System.out.println("0. Cofnij");
                        x = scan.nextInt();//zmienna
                        switch (x)//switch 2 rzedu
                        {
                            case 1:
                                System.out.print("Podaj imię: ");
                                imie = scan.next();
                                System.out.print("Podaj nazwisko: ");
                                nazwisko = scan.next();
                                System.out.println("Podaj numer PESEL");
                                pesel = scan.nextInt();
                                systemlotniczy.dodajKlient(new Klient(imie,nazwisko,pesel));
                                System.out.println("Dodano klienta: " + imie + " " + nazwisko + " " + pesel);
                                System.out.println("Dodawanie klientów");
                                /////////////////////////
                                break;
                            case 2:
                                System.out.println("Usuwanie klientow");
                                ///////////
                                break;
                            case 3:
                                System.out.println("Klienci: ");
                                System.out.println(systemlotniczy.getKlienci());
                                ///////
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Podano złą wartość!");
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

                        System.out.println("Zarządzanie trasami");
                        System.out.println("1. Dodaj trasę");
                        System.out.println("2. Usuń trasę");
                        System.out.println("3. Wyświetl trasy");
                        System.out.println("0. Cofnij");
                        x = scan.nextInt();//zmienna
                        switch (x)//switch 2 rzedu
                        {
                            case 1:
                                System.out.println("Dodawanie trasy");
                                /////////////////////////
                                break;
                            case 2:
                                System.out.println("Usuwanie trasy");
                                ///////////
                                break;
                            case 3:
                                System.out.println("Trasy: ");
                                ///////
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Podano złą wartość!");
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

                        System.out.println("Zarządzanie lotniskami");
                        System.out.println("1. Dodaj lotnisko");
                        System.out.println("2. Usuń lotnisko");
                        System.out.println("3. Wyświetl lotniska");
                        System.out.println("0. Cofnij");
                        x = scan.nextInt();//zmienna
                        switch (x)//switch 2 rzedu
                        {
                            case 1:
                                System.out.println("Podaj nazwę lotniska: ");
                                nazwa = scan.next();
                                System.out.println("Podaj nazwę miasta: ");
                                miasto = scan.next();
                                systemlotniczy.dodajLotnisko(new Lotnisko(nazwa,miasto));
                                System.out.println("Dodano Lotnisko: " + nazwa + " " + miasto);
                                /////////////////////////
                                break;
                            case 2:
                                System.out.println("Usuwanie lotniska");
                                System.out.println("Podaj nazwę lotniska do usunięcia: ");
                                nazwa=scan.next();
                                Iterator<Lotnisko> itr = systemlotniczy.getLotniska().listIterator();
                                while (itr.hasNext())
                                {
                                    Lotnisko lotnisko = itr.next();
                                    if (lotnisko.getNazwa().equals(nazwa))
                                        systemlotniczy.usunLotnisko(lotnisko);
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
                                System.out.println("Podano złą wartość!");
                                break;

                        }
                        if(x==0){
                            break;
                        }
                    }
                    x=99;
                    break;
                case 5:
                    System.out.println("Rezerwacja biletów");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Podano złą wartość!");
                    break;

            }
            if(x==0){
                break;
            }
        }
        ZapisOdczytSystemu.zapisz(systemlotniczy, "SystemLotow.txt");
    }
}

