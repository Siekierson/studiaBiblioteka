import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Dodaj czytelnika");
            System.out.println("2. Dodaj książkę");
            System.out.println("3. Usuń czytelnika");
            System.out.println("4. Usuń książkę");
            System.out.println("5. Wypożycz książkę");
            System.out.println("6. Zwróć książkę");
            System.out.println("0. Wyjdź");

            int wybor = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
            switch (wybor) {
                case 1:
                    dodajCzytelnika();
                    break;
                case 2:
                    dodajKsiazke();
                    break;
                case 3:
                    usunCzytelnika();
                    break;
                case 4:
                    usunKsiazke();
                    break;
                case 5:
                    wypozyczKsiazke();
                    break;
                case 6:
                    zwrocKsiazke();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nieznana opcja!");
            }
        }
    }

    private static void dodajCzytelnika() {
        System.out.println("Podaj ID:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        System.out.println("Podaj imię:");
        String imie = scanner.nextLine();
        System.out.println("Podaj nazwisko:");
        String nazwisko = scanner.nextLine();
        Czytelnik czytelnik = new Czytelnik(id, imie, nazwisko);
        ZarzadzaniePlikami.zapiszObiekt("czytelnicy.dat", czytelnik);
        System.out.println("Czytelnik dodany.");
    }

    private static void dodajKsiazke() {
        System.out.println("Podaj ID:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        System.out.println("Podaj tytuł:");
        String tytul = scanner.nextLine();
        System.out.println("Podaj autora:");
        String autor = scanner.nextLine();
        Ksiazka ksiazka = new Ksiazka(id, tytul, autor);
        ZarzadzaniePlikami.zapiszObiekt("ksiazki.dat", ksiazka);
        System.out.println("Książka dodana.");
    }

    private static void usunCzytelnika() {
        System.out.println("Podaj ID czytelnika do usunięcia:");
        int id = scanner.nextInt();
        List<Object> czytelnicy = ZarzadzaniePlikami.wczytajObiekty("czytelnicy.dat");
        List<Object> pozostali = czytelnicy.stream()
                .filter(c -> ((Czytelnik) c).getId() != id)
                .collect(Collectors.toList());
        ZarzadzaniePlikami.zapiszWszystkieObiekty("czytelnicy.dat", pozostali);
        System.out.println("Czytelnik usunięty.");
    }

    private static void usunKsiazke() {
        System.out.println("Podaj ID książki do usunięcia:");
        int id = scanner.nextInt();
        List<Object> ksiazki = ZarzadzaniePlikami.wczytajObiekty("ksiazki.dat");
        List<Object> pozostale = ksiazki.stream()
                .filter(k -> ((Ksiazka) k).getId() != id)
                .collect(Collectors.toList());
        ZarzadzaniePlikami.zapiszWszystkieObiekty("ksiazki.dat", pozostale);
        System.out.println("Książka usunięta.");
    }

    private static void wypozyczKsiazke() {
        System.out.println("Podaj ID czytelnika:");
        int idCzytelnika = scanner.nextInt();
        System.out.println("Podaj ID książki:");
        int idKsiazki = scanner.nextInt();
        Date dataWypozyczenia = new Date();
        Wypozyczenie wypozyczenie = new Wypozyczenie(idCzytelnika, idKsiazki, dataWypozyczenia);
        ZarzadzaniePlikami.zapiszObiekt("wypozyczenia.dat", wypozyczenie);
        System.out.println("Książka wypożyczona.");
    }

    private static void zwrocKsiazke() {
        System.out.println("Podaj ID książki do zwrotu:");
        int idKsiazki = scanner.nextInt();
        List<Object> wypozyczenia = ZarzadzaniePlikami.wczytajObiekty("wypozyczenia.dat");
        for (Object o : wypozyczenia) {
            Wypozyczenie w = (Wypozyczenie) o;
            if (w.getIdKsiazki() == idKsiazki && w.getDataZwrotu() == null) {
                w.setDataZwrotu(new Date());
                break;
            }
        }
        ZarzadzaniePlikami.zapiszWszystkieObiekty("wypozyczenia.dat", wypozyczenia);
        System.out.println("Książka zwrócona.");
    }
}
