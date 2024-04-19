# Program do zarządzania biblioteką - dokumentacja


## Funkcjonalność

Program pozwala na wykonanie następujących operacji:
- **Dodawanie czytelnika:** Możliwość zapisu nowego czytelnika do systemu.
- **Dodawanie książki:** Możliwość dodania nowej książki do zbiorów biblioteki.
- **Usuwanie czytelnika:** Usunięcie istniejącego czytelnika z systemu.
- **Usuwanie książki:** Usunięcie książki ze zbiorów biblioteki.
- **Wypożyczanie książki:** Rejestracja wypożyczenia książki przez czytelnika.
- **Zwrot książki:** Rejestracja zwrotu wypożyczonej książki.

Dane są przechowywane w plikach binarnych, co umożliwia zachowanie informacji między sesjami programu.

## Wymagania Systemowe

- Java 8 lub nowsza
- Dostęp do terminala lub wiersza poleceń
- opcjonalnie program jetbrains intellij 

## Instalacja

1. Upewnij się, że masz zainstalowaną Javę. Można ją pobrać i zainstalować ze strony [Oracle](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
2. Pobierz pliki źródłowe programu do jednego katalogu.
3. Otwórz terminal lub wiersz poleceń i przejdź do katalogu z plikami.
4. Skompiluj program za pomocą polecenia:
javac Czytelnik.java Ksiazka.java Wypozyczenie.java ZarzadzaniePlikami.java Main.java

5. Uruchom program poleceniem:
java Main

## Przykład Użycia

Uruchom program i postępuj zgodnie z instrukcjami wyświetlanymi w konsoli. Wybierz odpowiednią opcję z menu głównego, aby wykonać żądaną operację.

Dodaj czytelnika
Dodaj książkę
Usuń czytelnika
Usuń książkę
Wypożycz książkę
Zwróć książkę
Wyjdź
