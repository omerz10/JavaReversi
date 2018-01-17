package GameFiles;
/**

 * Created by david on 09/01/2018.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class HumanPlayer implements Player {
    private char type;
    private Board board;
    private Logic gameLogic;
    private PossibleMove possibleMove;
    private Cell lastMove;

    public HumanPlayer(char type, Board board, Logic gameLogic) {
        this.type = type;
        this.gameLogic = gameLogic;
        this.board = board;
    }

    @Override
    public char getType() {
        return this.type;
    }

    @Override
    public Cell getLastMove() {
        return this.lastMove;
    }


    public void setPossibleMove(PossibleMove pMove) {
        this.possibleMove = pMove;
    }

    @Override
    public void setLastMove(int i, int j) {
        this.lastMove = new Cell(i, j);
    }


    @Override
    public void printMoves() {

        Set<Cell> uniqueMoves = new HashSet<Cell>(this.possibleMove.getMoves());
        ArrayList<Cell> cellArrayList = new ArrayList<Cell>(uniqueMoves);
        Collections.sort(cellArrayList);

        for (Cell c : cellArrayList) {
            System.out.print("(" + (c.getX() + 1) + "," + (c.getY() + 1) + ")");
        }
        System.out.println();
    }

    @Override
    public void playTurn() {
        // flip the selection of the player...
        for (int i = 0; i < (int)this.possibleMove.getMoves().size(); i++) {
            if (this.lastMove.getX() == this.possibleMove.getMoves().get(i).getX()
            && this.lastMove.getY() == this.possibleMove.getMoves().get(i).getY()) {
                this.gameLogic.switchCells(this.board, this.lastMove.getX(), this.lastMove.getY()
                    , this);
            }
        }
    }

    @Override
    public void getPlayerMoves() {
        this.gameLogic.getPossibleMoves(this.board, this);
    }

    public PossibleMove getPossibleMoves() {
        return this.possibleMove;
    }
    @Override
    public boolean getPossibleMoveStatus() {
        return this.possibleMove.isPossible();
    }

    @Override
    public boolean checkInput(String userInput) {
        String[] input = userInput.split(" ");
        if (input.length == 2 && Character.isDigit(input[0].charAt(0))
                && Character.isDigit(input[1].charAt(0))) {
            for (int i = 0; i < this.possibleMove.getMoves().size(); i++) {
                Cell tempCell = new Cell(Character.getNumericValue(input[0].charAt(0)) - 1,
                        Character.getNumericValue(input[1].charAt(0)) - 1);
                if (tempCell.getX() == this.possibleMove.getMoves().get(i).getX()
                        && tempCell.getY() == this.possibleMove.getMoves().get(i).getY()) {
                    this.setLastMove(Character.getNumericValue(input[0].charAt(0)) - 1,
                            Character.getNumericValue(input[1].charAt(0)) - 1);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int getBoardSize() {
        return this.board.getSize();
    }

    @Override
    public char getBoardValueAtIndexes(int i, int j) {
        return this.board.getValueAtIndexes(i, j);
    }

    @Override
    public void showBoard() {
        this.board.show();
    }

    @Override
    public boolean printGUI() {
        return true;
    }
}
