package GUI;

import GameFiles.Cell;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * Created by david on 13/01/2018.
 */
public class GUICell extends Rectangle {
    private Cell cell;
    private Circle circle;
    private GUIBoard board;

    private CellListener cellListener;

    // pass a map of 'X' to color + 'O' to color for draw() function to decide
    // add a member of Circle in composition, and make it draw according to the map
    public GUICell(double width, double height, Paint fill, Cell cell) {
        this.circle = new Circle((int) (cell.getX() + width), (int) (cell.getY() + height), (int) (width / 2), fill);
        GUIGameInfo gameInfo = GUIGameInfo.getInstance();
        this.board = gameInfo.getBoard();
        this.cell = cell;
        this.cellListener = GUIGameInfo.getInstance().getListener();
    }

    public void draw() {

        if (this.cell.getVal() == 'X') {
            this.setFill(Color.BLACK);
        } else if (this.cell.getVal() == 'O') {
            this.setFill(Color.WHITE);
        }

        this.board.getChildren().remove(this);
        this.board.add(this, this.cell.getX(), this.cell.getY());
        this.board.add(this.circle, (int) (this.circle.getCenterX()), (int) (this.circle.getCenterY()));
    }

    public void notifyListener(){
        //System.out.println("Cell pressed: " + this.cell.getX() + " " + this.cell.getY());
        this.cellListener.notifyGame(cell);
    }
}
