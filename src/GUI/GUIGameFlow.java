package GUI;

/**
 * Created by david on 15/01/2018.
 */

import javafx.scene.paint.Color;
import javafx.stage.Stage;
import GameFiles.Logic;
import GameFiles.Player;
import GameFiles.Cell;

import java.util.Map;

public class GUIGameFlow {
    private Player P1, P2;
    private Player currentPlayer;
    private Map<Player, Color> playerColorMap;
    private boolean shouldContinue;
    private boolean previousDidNotMakeMove;
    private GUIBoard board;
    private Logic logic;

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public GUIGameFlow() {
        GUIGameInfo gameInfo = GUIGameInfo.getInstance();
        this.board = gameInfo.getBoard();
        this.logic = gameInfo.getLogic();
        this.P1 = gameInfo.getP1();
        this.P2 = gameInfo.getP2();
        this.currentPlayer = this.P1;
        this.shouldContinue = true;
        this.previousDidNotMakeMove = false;
        this.playerColorMap = gameInfo.getColors();
    }

    public Map<Player, Color> getColors() {
        return this.playerColorMap;
    }

    public void switchPlayers(Player currentPlayer) {
        if (currentPlayer == this.P1) {
            this.currentPlayer = this.P2;
        } else {
            this.currentPlayer = this.P1;
        }
    }

    public void makeMove(Cell cell) {
        //this.logic.getPossibleMoves(this.board.getBoard(), this.currentPlayer);
        this.currentPlayer.getPlayerMoves();
        boolean pMoves = this.currentPlayer.getPossibleMoveStatus();
        if(!pMoves){
            if(this.previousDidNotMakeMove) {
                this.shouldContinue = false;
                Stage stage = (Stage)this.board.getScene().getWindow();
                stage.close();
            }
            this.previousDidNotMakeMove = true;
            switchPlayers(this.currentPlayer);
            return;
        }
        for(Cell p : this.currentPlayer.getPossibleMoves().getMoves()){
            if(p.getX() == cell.getX() && p.getY() == cell.getY()){
                this.currentPlayer.setLastMove(cell.getX(), cell.getY());
                this.currentPlayer.playTurn();
                switchPlayers(this.currentPlayer);
                previousDidNotMakeMove = false;
                board.draw();
                break;
            }
        }
        if (this.logic.isBoardFull(this.board.getBoard())) {
            this.shouldContinue = false;
            Stage stage = (Stage)this.board.getScene().getWindow();
            stage.close();
        }
    }
}