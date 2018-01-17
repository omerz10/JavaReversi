package GameFiles;

import GUI.Menu;

/**
 * Created by david on 13/01/2018.
 */
public class GameInfo {

    private static GameInfo instance = new GameInfo();

    public static GameInfo getInstance() {
        return instance;
    }

    private Player P1;
    private Player P2;
    private Board board;
    private Logic logic;

    public GameInfo() {
        this.logic = new GenericLogic();
        this.board = new Board(Menu.BOARD_SIZE);
        this.P1 = new HumanPlayer('X', this.board, this.logic);
        this.P2 = new HumanPlayer('O', this.board, this.logic);
    }


    public Player getP1() {
        return this.P1;
    }

    public Player getP2() {
        return this.P2;
    }


    public Board getBoard() {
        return this.board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Logic getLogic() {
        return logic;
    }

    public void setLogic(Logic logic) {
        this.logic = logic;
    }

}

