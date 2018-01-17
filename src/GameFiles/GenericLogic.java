package GameFiles;

import java.util.Vector;

public class GenericLogic implements Logic {
    public void getPossibleMoves(Board board, Player player) {

        int k, n; // indexes


        PossibleMove pMove = new PossibleMove(); // possible move struct

        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                k = i; n = j;

                //upper left
                if (i > 1 && j > 1) {
                    Vector<Cell> pCells = new Vector<>(); // temp Vector
                    Cell thisCell = new Cell(k, n);
                    pCells.add(thisCell);

                    while (board.getValueAtIndexes(i, j) == ' '
                    && board.getValueAtIndexes(k - 1, n - 1) != player.getType()
                    && board.getValueAtIndexes(k - 1, n - 1) != ' ' && k > 1 && n > 1) {
                        Cell newCell = new Cell(k - 1,n - 1);
                        pCells.add(newCell);
                        k--; n--;
                        if (board.getValueAtIndexes(k - 1, n - 1) == player.getType()) {
                            getEmptyCell(board, i, j, k - 1, n - 1, player.getType(), pMove);
                            pMove.addChangeableCells(pCells);
                        }
                    }
                    //pCells.clear();
                    k = i; n = j;
                }
                // up
                if (i > 1) {
                    Vector<Cell> pCells = new Vector<>(); // temp Vector
                    Cell thisCell = new Cell(k, n);
                    pCells.add(thisCell);
                    while (board.getValueAtIndexes(i, j) == ' '
                    && board.getValueAtIndexes(k - 1, n) != player.getType()
                    && board.getValueAtIndexes(k - 1, n) != ' ' && k > 1) {

                        Cell newCell = new Cell(k-1,n);
                        pCells.add(newCell);
                        k--;
                        if (board.getValueAtIndexes(k - 1, n) == player.getType()) {
                            getEmptyCell(board, i, j, k - 1, n, player.getType(), pMove);
                            pMove.addChangeableCells(pCells);
                        }
                    }
                    //pCells.clear();
                    k = i; n = j;
                }
                // upper right
                if (i > 1 && j < board.getSize() - 2 ) {
                    Vector<Cell> pCells = new Vector<>(); // temp Vector
                    Cell thisCell = new Cell(k, n);
                    pCells.add(thisCell);
                    while (board.getValueAtIndexes(i, j) == ' '
                    && board.getValueAtIndexes(k - 1, n + 1) != player.getType()
                    && board.getValueAtIndexes(k - 1, n + 1) != ' ' && k > 1
                    && n < (board.getSize() - 2)) {
                        Cell newCell = new Cell(k-1,n+1);
                        pCells.add(newCell);
                        k--; n++;
                        if (board.getValueAtIndexes(k - 1, n + 1) == player.getType()) {
                            getEmptyCell(board, i, j, k-1, n+1, player.getType(), pMove);
                            pMove.addChangeableCells(pCells);
                        }
                    }
                    //pCells.clear();
                    k = i; n = j;
                }
                // left
                if (j > 1) {
                    Vector<Cell> pCells = new Vector<>(); // temp Vector
                    Cell thisCell = new Cell(k, n);
                    pCells.add(thisCell);
                    while (board.getValueAtIndexes(i, j) == ' '
                    && board.getValueAtIndexes(k, n - 1) != player.getType()
                    && board.getValueAtIndexes(k, n - 1) != ' ' && n > 1) {

                        Cell newCell = new Cell(k,n-1);
                        pCells.add(newCell);
                        n--;
                        if (board.getValueAtIndexes(k, n - 1) == player.getType()) {
                            getEmptyCell(board, i, j, k, n-1, player.getType(), pMove);
                            pMove.addChangeableCells(pCells);
                        }
                    }
                    //pCells.clear();
                    k = i; n = j;
                }
                // right
                if (j < board.getSize() - 2) {
                    Vector<Cell> pCells = new Vector<>(); // temp Vector
                    Cell thisCell = new Cell(k, n);
                    pCells.add(thisCell);
                    while (board.getValueAtIndexes(i, j) == ' '
                    && board.getValueAtIndexes(k, n + 1) != player.getType()
                    && board.getValueAtIndexes(k, n + 1) != ' ' && n < (board.getSize() - 2)) {

                        Cell newCell = new Cell(k,n+1);
                        pCells.add(newCell);
                        n++;
                        if (board.getValueAtIndexes(k, n + 1) == player.getType()) {
                            getEmptyCell(board, i, j, k, n+1, player.getType(), pMove);
                            pMove.addChangeableCells(pCells);
                        }
                    }
                    //pCells.clear();
                    k = i; n = j;
                }
                // lower left
                if (i < board.getSize() - 2 && j > 1) {
                    Vector<Cell> pCells = new Vector<>(); // temp Vector
                    Cell thisCell = new Cell(k, n);
                    pCells.add(thisCell);

                    while (board.getValueAtIndexes(i, j) == ' '
                    && board.getValueAtIndexes(k + 1, n - 1) != player.getType()
                    && board.getValueAtIndexes(k + 1, n - 1) != ' '
                    && k < (board.getSize() -2) && n > 1) {
                        Cell newCell = new Cell(k+1,n-1);
                        pCells.add(newCell);
                        k++; n--;
                        if (board.getValueAtIndexes(k + 1, n - 1) == player.getType()) {
                            getEmptyCell(board, i, j, k+1, n-1, player.getType(), pMove);
                            pMove.addChangeableCells(pCells);
                        }
                    }
                    //pCells.clear();
                    k = i; n = j;
                }
                // down
                if (i < board.getSize() - 2) {
                    Vector<Cell> pCells = new Vector<>(); // temp Vector
                    Cell thisCell = new Cell(k, n);
                    pCells.add(thisCell);
                    while (board.getValueAtIndexes(i, j) == ' '
                    && board.getValueAtIndexes(k + 1, n) != player.getType()
                    && board.getValueAtIndexes(k + 1, n) != ' '
                    && k < (board.getSize() - 2)) {
                        Cell newCell = new Cell(k+1,n);
                        pCells.add(newCell);
                        k++;
                        if (board.getValueAtIndexes(k + 1, n) == player.getType()) {
                            getEmptyCell(board, i, j, k+1, n, player.getType(), pMove);
                            pMove.addChangeableCells(pCells);
                        }
                    }
                    //pCells.clear();
                    k = i; n = j;
                }
                // lower right
                if (i < board.getSize() - 2 && j < board.getSize() - 2) {
                    Vector<Cell> pCells = new Vector<>(); // temp Vector
                    Cell thisCell = new Cell(k, n);
                    pCells.add(thisCell);
                    while (board.getValueAtIndexes(i, j) == ' '
                    && board.getValueAtIndexes(k + 1, n + 1) != player.getType()
                    && board.getValueAtIndexes(k + 1, n + 1) != ' '
                    && k < (board.getSize() - 2) && n < (board.getSize() - 2)) {
                        Cell newCell = new Cell(k + 1,n + 1);
                        pCells.add(newCell);
                        k++; n++;
                        if (board.getValueAtIndexes(k + 1, n + 1) == player.getType()) {
                            getEmptyCell(board, i, j, k + 1, n + 1, player.getType(), pMove);
                            pMove.addChangeableCells(pCells);
                        }
                    }
                    //pCells.clear();
                }
            }
        }

        // any possible moves?
        if (!pMove.getMoves().isEmpty()) {
            pMove.setPossible(true);
        } else {
            pMove.setPossible(false);
        }
        player.setPossibleMove(pMove);
        //return (pMove);
    }

    public void getEmptyCell(Board board, int i, int j, int k, int n, char playerID, PossibleMove pMove) {
        // possible move for 'X'
        if (playerID == 'X' && board.getValueAtIndexes(k, n) == 'X') {
            //if (type == 'X' && board.getCells()[k][n].isValue('X')) {
            Cell cell = new Cell(i,j);
            pMove.addPossibleMove(cell);
        }
        // possible move for 'O'
        if (playerID == 'O' && board.getValueAtIndexes(k, n) == 'O') {
            //if (type == 'O' && board.getCells()[k][n].isValue('O')) {
            Cell cell = new Cell(i,j);
            pMove.addPossibleMove(cell);
        }

    }

    public int switchCells(Board board, int i, int j, Player player) {

        int x, y, u, w, z = 0;
        Cell cell = new Cell(i, j);
        int count = 0;

        // run through all Vectors of changeable cells
        for (int s = 0; s < (int) player.getPossibleMoves().getChangeableCells().size(); s++) {
            if (!player.getPossibleMoves().getChangeableCells().get(s).isEmpty() && cell.equals(player.getPossibleMoves().getChangeableCells().get(s).get(0))) {

                char firstCell = board.getValueAtIndexes(player.getPossibleMoves().getChangeableCells().get(s).get(0).getX()
                        , player.getPossibleMoves().getChangeableCells().get(s).get(0).getY());

                char secondCell = board.getValueAtIndexes(player.getPossibleMoves().getChangeableCells().get(s).get(1).getX()
                        , player.getPossibleMoves().getChangeableCells().get(s).get(1).getY());

                // if chosen move by user is in a specific Vector
                if (firstCell == ' ' && secondCell != player.getType()) {
                    count += player.getPossibleMoves().getChangeableCells().get(s).size() - 1;
                    // change all cells in the a specific Vector
                    for (int n = 1; n < (int) player.getPossibleMoves().getChangeableCells().get(s).size(); n++) {
                        z = s;
                        x = player.getPossibleMoves().getChangeableCells().get(s).get(n).getX();
                        y = player.getPossibleMoves().getChangeableCells().get(s).get(n).getY();
                        board.setCell(x, y, player.getType());
                    }
                    u = player.getPossibleMoves().getChangeableCells().get(z).get(0).getX();
                    w = player.getPossibleMoves().getChangeableCells().get(z).get(0).getY();
                    board.setCell(u, w, player.getType());
                    return count + 1;
                }
            }
        }
        return 0;
    }

    public boolean isBoardFull(Board board) {
        int count = 0;
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (board.getValueAtIndexes(i, j) != ' ') {
                    count++;
                }
            }
        }
        if (count == (board.getSize() * board.getSize())) {
            return true;
        } else {
            return false;
        }
    }
}