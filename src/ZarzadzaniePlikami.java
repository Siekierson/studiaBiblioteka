import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ZarzadzaniePlikami {
    private static final String PLIK_CZYTELNIKOW = "czytelnicy.dat";
    private static final String PLIK_KSIAZEK = "ksiazki.dat";
    private static final String PLIK_WYPOZYCZEN = "wypozyczenia.dat";

    public static void zapiszObiekt(String sciezka, Object obj) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(sciezka, true))) {
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Object> wczytajObiekty(String sciezka) {
        List<Object> obiekty = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(sciezka))) {
            while (true) {
                Object obj = ois.readObject();
                obiekty.add(obj);
            }
        } catch (EOFException e) {
            // Koniec pliku
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obiekty;
    }
    public static void zapiszWszystkieObiekty(String sciezka, List<Object> obiekty) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(sciezka))) {
            for (Object obj : obiekty) {
                oos.writeObject(obj);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
