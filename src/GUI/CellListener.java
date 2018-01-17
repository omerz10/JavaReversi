package GUI;

/**
 * Created by david on 15/01/2018.
 */
import GameFiles.Cell;

public class CellListener {
    private GUIGameFlow game;

    public CellListener(GUIGameFlow game) {
        this.game = game;
    }

    public void notifyGame(Cell cell) {
        game.makeMove(cell);
    }
}
