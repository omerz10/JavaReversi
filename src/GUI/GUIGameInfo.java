package GUI;

import GameFiles.GenericLogic;
import GameFiles.HumanPlayer;
import GameFiles.Logic;
import GameFiles.Player;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by david on 13/01/2018.
 */
public class GUIGameInfo {
    private static GUIGameInfo ourInstance = new GUIGameInfo();

    public static GUIGameInfo getInstance() {
        return ourInstance;
    }

    private Player P1;
    private Player P2;
    private HashMap<Player, Color> playerColorMap;
    private GUIBoard guiBoard;
    private Logic logic;
    private GUIGameFlow game;
    private CellListener listener;

    private GUIGameInfo() {
        this.guiBoard = new GUIBoard();
        this.logic = new GenericLogic();
        this.P1 = new HumanPlayer('X', this.guiBoard.getBoard(), this.logic);
        this.P2 = new HumanPlayer('O', this.guiBoard.getBoard(), this.logic);
        this.playerColorMap = new HashMap<>();
    }
    /*
    public GUIGameFlow getGame() {
        return this.game;
    }
    */

    public void setGame(Color player1Color, Color player2Color) {
        this.game = new GUIGameFlow();
        this.listener = new CellListener(game);
        this.playerColorMap.put(this.P1, player1Color);
        this.playerColorMap.put(this.P2, player2Color);
    }

    public Map<Player, Color> getColors() {
        return this.playerColorMap;
    }

    public CellListener getListener() {
        return listener;
    }

    /*
    public void setListener(CellListener listener) {
        this.listener = listener;
    }
    */

    public Player getP1() {
        return this.P1;
    }
    public Player getP2() {
        return this.P2;
    }



    public GUIBoard getBoard() {
        return this.guiBoard;
    }

    public void setBoard(GUIBoard board) {
        this.guiBoard = board;
    }

    public int getS() {

        return 7;
    }

    public Logic getLogic() {
        return this.logic;
    }

}
