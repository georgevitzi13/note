package ergasia.trivia;

public class Main {
    public static void main(String[] args) {
        // Δημιουργία ρυθμίσεων παιχνιδιού (GameSettings)
        GameSettings settings = new GameSettings("9", "multiple", 10, "medium"); 
        // Κατηγορία: 9 (General Knowledge), Τύπος: multiple choice, 10 ερωτήσεις, Δυσκολία: medium

        // Εκκίνηση του παιχνιδιού με τις ρυθμίσεις
        Game game = new Game(settings);
        game.start();
    }
}
