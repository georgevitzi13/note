package ergasia.trivia;

public class GameSettings {
    private String category;
    private String type;
    private int amount;
    private String difficulty;

    public GameSettings(String category, String type, int amount, String difficulty) {
        this.category = category;
        this.type = type;
        this.amount = amount;
        this.difficulty = difficulty;
    }

    // Getters
    public String getCategory() { return category; }
    public String getType() { return type; }
    public int getAmount() { return amount; }
    public String getDifficulty() { return difficulty; }
}
