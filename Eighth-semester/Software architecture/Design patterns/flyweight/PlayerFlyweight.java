import java.util.HashMap;
import java.util.Map;

public class PlayerFlyweight {
    Map<String, Player> players = new HashMap<String, Player>();
    Player temp = null;

    
    public Player createPlayer(String type) {
        if (players.containsKey(type)) {
            players.get(type).action();
            return players.get(type);
        }

        switch(type){
            case "Attacker":
                System.out.println("\nAttacker Created");
                temp = new Attacker();
                break;
            case "Defender":
                System.out.println("\nDefender Created");
                temp = new Defender();
                break;
            default:
                System.out.println("\nInvalid player type");
        }

        players.put(type, temp);
        temp.action();
        return temp;
    }
}
