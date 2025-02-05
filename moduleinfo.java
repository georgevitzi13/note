package ergasia.trivia;

public class moduleinfo {
    public static void main(String[] args) {
        // Δημιουργία ρυθμίσεων παιχνιδιού
        GameSettings settings = new GameSettings("9", "multiple", 5, "medium");

        // Δημιουργία και εκκίνηση του παιχνιδιού
        Game game = new Game(settings);
        game.start();
    }
}
