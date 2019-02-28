
import com.nsa.cm6123.assessment.monopoly.board.Board;
import com.nsa.cm6123.assessment.monopoly.player.Player;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {

    ArrayList<String> tokens = new ArrayList<>(Arrays.asList("TopHat","Dog","Car","BattleShip"));
    ArrayList<Player> players = new ArrayList<>();
    final int width = 5;
    final int length = 5;

    public void generatePlayers() {
        Board board = new Board(width, length);
        for (int i = 0; i < 4; i++) {
            String playerToken = tokens.get(i);
            Player player = new Player(playerToken);
            players.add(player);
        }
    }

    public ArrayList<Player> getPlayers(){
        return players;
    }
}

