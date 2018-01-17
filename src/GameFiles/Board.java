package GameFiles;

import java.util.Arrays;

/**
 * Created by david on 09/01/2018.
 */
public class Board {
    private int size;
    private Cell[][] cells;

    public Board(int size) {
        this.size = size;
        this.cells = new Cell[size][size];
        for (int j = 0; j < this.size; j++) {
            for (int k = 0; k < this.size; k++) {
                this.cells[j][k] = new Cell(j, k);
                if ((j == this.size / 2 - 1 && k == this.size / 2 - 1) || (j == this.size / 2 && k == this.size / 2)) {
                    cells[j][k].setVal('O');
                } else if ((j == this.size / 2 - 1 && k == this.size / 2)
                        || (j == this.size / 2 && k == this.size / 2 - 1)) {
                    cells[j][k].setVal('X');
                } else {
                    cells[j][k].setVal(' ');
                }
            }
        }

    }

    public Board(Board board) {
        this.size = board.size;
        this.cells = board.cells;
    }

    public int getSize() {
        return this.size;
    }

    public char getValueAtIndexes(int x, int y) {
        return this.cells[x][y].getVal();
    }

    public Cell getCellAtIndexes(int x, int y) {
        return this.cells[x][y];
    }

    public void setCell(int i, int j, char c) {
        cells[i][j].setVal(c);
    }

    public void show() { // TODO: change this to appropriate func for JavaFX

        // first line..
        System.out.print(" |");
        for (int i = 1; i <= this.size; i++) {
            System.out.print(" " + i + " |");
        }

        System.out.println();
        int n = 4 * size + 2;
        char[] chars = new char[n];
        Arrays.fill(chars, '-');
        String result = new String(chars);
        System.out.println(result);

        // rest of the board..
        for (int i = 0; i < this.size; i++) {
            System.out.print(i+1 + "|");
            for (int j = 0; j  < this.size; j++) {
                System.out.print(" " + this.cells[i][j].getVal() + " |");
            }
            System.out.println();
            System.out.println(result);
        }
    }


    public void copyBoardTo(Board dest) {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                dest.setCell(i, j, this.getValueAtIndexes(i, j));
            }
        }
    }

}
