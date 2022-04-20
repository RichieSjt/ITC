public class Main {
    public static void main(String[] args) {
        PlayerFlyweight playerFactory = new PlayerFlyweight();

        // Creating 5 players with the role of attackers
        for (int i = 0; i < 5; i++) {
            playerFactory.createPlayer("Attacker");
        }
        // Creating 5 players with the role of defenders
        for (int i = 0; i < 5; i++) {
            playerFactory.createPlayer("Defender");
        }
    }
}
