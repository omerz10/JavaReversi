package GameFiles;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

/**
 * Created by david on 09/01/2018.
 */
public class PossibleMove {


    private Vector<Vector<Cell>> changeableCells;

    private Vector<Cell> moves;

    private boolean possible;

    public PossibleMove() {
        this.changeableCells = new Vector<Vector<Cell>>();
        this.moves = new Vector<Cell>();
        this.possible = false;
    }




    public Vector<Vector<Cell > > getChangeableCells() {
        return this.changeableCells;
    }

    public void addPossibleMove(Cell cell) {
        this.moves.add(cell);
    }
    public void addChangeableCells(Vector<Cell> cellVector) {
        this.changeableCells.add(cellVector);
    }
    public Vector<Cell > getMoves() {
        return this.moves;
    }

    public boolean isPossible() {
        return this.possible;
    }

    public void setPossible(boolean p) {
        this.possible = p;
    }


}
