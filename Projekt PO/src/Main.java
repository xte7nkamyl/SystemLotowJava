import java.util.Scanner;
import Klasy.*;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        boolean pom = true;// zeby zakonczyc petle glowne
        boolean pom2 = true;// zeby zakonczyc petle srodkowe
        boolean pom3 = true;// zeby zakonczyc petle srodkowe2
        int iloscmiejsc;
        double zasieg;
        Samolot samolot1 = new Klasa_biznesowa();

        System_lotniczy systemlotniczy = new System_lotniczy();

        while (pom) {//petla glowna
            pom2 = true;
            System.out.println("Menu:");
            System.out.println("1.Zarzadzanie samolotami ");
            System.out.println("2.Zarzadzanie klientami ");
            System.out.println("3.Zarzadzanie trasami ");
            System.out.println("4.Zarzadzanie lotniskami ");
            System.out.println("5.Rezerwacja biletów");
            System.out.println("0.Wyjdz");
            int x = scan.nextInt();

            switch (x) {//glowny switch
                case 1:

                    while (pom2) {
                        pom3 = true;// zeby odswiezyc wartosc pom3 jesli wczesniej zmieni sie na false
                        System.out.println("Zarzadzanie samolotami");
                        System.out.println("1.Dodaj samolot");
                        System.out.println("2.Usun samolot");
                        System.out.println("3.Wyswietl samoloty");
                        System.out.println("0.cofnij");
                        x = scan.nextInt();//zmienna
                        switch (x)//switch 2 rzedu
                        {
                            case 1:
                                while (pom3) {
                                    System.out.println("Dodawanie samolotu");
                                    System.out.println("Wybierz samolot:");
                                    System.out.println("1.Klasa biznesowa");
                                    System.out.println("2.Klasa ekonomiczna");
                                    System.out.println("3.Klasa pierwsza");
                                    System.out.println("0.cofnij");
                                    x = scan.nextInt();
                                    switch (x) {
                                        case 1:

                                            System.out.println("Dodano samolotu klasy biznesowej");
                                            systemlotniczy.dodajSamolot(samolot1);


                                            break;
                                        case 2:
                                            System.out.println("Dodawanie samolotu klasy ekonomicznej");
                                            break;
                                        case 3:
                                            System.out.println("Dodawanie samolotu klasy ekonomicznej");
                                            break;
                                        case 0:
                                            pom3 = false;
                                            break;
                                        default:
                                            System.out.println("Podano zla wartosc!");
                                            break;

                                    }
                                }


                                break;
                            case 2:
                                System.out.println("Usuwanie samolotu");
                                ///////////
                                break;
                            case 3:
                                System.out.println("Samoloty:");
                                ///////
                                break;
                            case 0:
                                pom2 = false;
                                break;
                            default:
                                System.out.println("Podano zla wartosc!");
                                break;


                        }

                    }
                    break;
                case 2:
                    while (pom2) {
                        System.out.println("Zarzadzanie klientami");
                        System.out.println("1.Dodaj klienta");
                        System.out.println("2.Usun klienta");
                        System.out.println("3.Wyswietl liste klientow");
                        System.out.println("0.cofnij");
                        x = scan.nextInt();//zmienna
                        switch (x)//switch 2 rzedu
                        {
                            case 1:
                                System.out.println("Dodawanie klientow");
                                /////////////////////////
                                break;
                            case 2:
                                System.out.println("Usuwanie klientow");
                                ///////////
                                break;
                            case 3:
                                System.out.println("Klienci:");
                                ///////
                                break;
                            case 0:
                                pom2 = false;
                                break;
                            default:
                                System.out.println("Podano zla wartosc!");
                                break;


                        }

                    }
                    break;
                case 3:
                    while (pom2) {

                        System.out.println("Zarzadzanie trasami");
                        System.out.println("1.Dodaj trase");
                        System.out.println("2.Usun trase");
                        System.out.println("3.Wyswietl trasy");
                        System.out.println("0.cofnij");
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
                                System.out.println("Trasy:");
                                ///////
                                break;
                            case 0:
                                pom2 = false;
                                break;
                            default:
                                System.out.println("Podano zla wartosc!");
                                break;


                        }

                    }
                    break;
                case 4:
                    while (pom2) {

                        System.out.println("Zarzadzanie lotniskami");
                        System.out.println("1.Dodaj lotnisko");
                        System.out.println("2.Usun lotnisko");
                        System.out.println("3.Wyswietl lotniska");
                        System.out.println("0.cofnij");
                        x = scan.nextInt();//zmienna
                        switch (x)//switch 2 rzedu
                        {
                            case 1:
                                System.out.println("Dodawanie lotniska");
                                /////////////////////////
                                break;
                            case 2:
                                System.out.println("Usuwanie lotniska");
                                ///////////
                                break;
                            case 3:
                                System.out.println("Lotniska:");
                                ///////
                                break;
                            case 0:
                                pom2 = false;
                                break;
                            default:
                                System.out.println("Podano zla wartosc!");
                                break;


                        }

                    }
                    break;
                case 5:
                    System.out.println("Rezerwacja biletow");
                    break;
                case 0:
                    pom = false;
                    break;
                default:
                    System.out.println("Podano zla wartosc!");
                    break;

            }
        }
    }
}

