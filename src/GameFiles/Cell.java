package GameFiles;

/**
 * Created by david on 09/01/2018.
 */
public class Cell implements Comparable<Cell> {
    private char value;
    private int x;
    private int y;


    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public char getVal() {
        return this.value;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setVal(char val) {
        this.value = val;
    }

    public void setX(int x) {

        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int compareTo(Cell o) {
        return this.x - o.x;
    }

    public boolean equals(Cell o) {
        return (this.x == o.x && this.y == o.y);
    }
}
