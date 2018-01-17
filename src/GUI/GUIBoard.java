package GUI;

import GameFiles.*;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.Map;

/**
 * Created by david on 13/01/2018.
 */

public class GUIBoard extends GridPane {

    private Map<Player, Color> playerColorMap;
    private Board board;
    private Logic logic;


    public GUIBoard() {
        GameInfo gameInfo = GameInfo.getInstance();

        this.logic = gameInfo.getLogic();
        this.board = gameInfo.getBoard();

        //this.playerColorMap =
    }

    public Board getBoard(){
        return this.board;
    }

    public void draw() {


        this.getChildren().clear();

        int height = (int) this.getPrefWidth();
        int width = (int) this.getPrefWidth();
        int cellHeight = height / Menu.BOARD_SIZE;
        int cellWidth = width / Menu.BOARD_SIZE;

        for (int i = 0; i < this.board.getSize(); i++) {
            for (int j = 0; j < this.board.getSize(); j++) {

                GUICell cell = new GUICell(cellWidth, cellHeight, Color.GREEN, this.board.getCellAtIndexes(i, j));
                cell.setOnMouseClicked((new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent event) {
                        //System.out.println("cell pressed");
                        cell.notifyListener();
                    }
                }));

                cell.setOnMouseEntered(e -> {

                    ColorAdjust colorAdjust = new ColorAdjust();
                    colorAdjust.setBrightness(0.0);

                    cell.setEffect(colorAdjust);

                    Timeline fadeInTimeline = new Timeline(
                            new KeyFrame(Duration.seconds(0),
                                    new KeyValue(colorAdjust.brightnessProperty(), colorAdjust.brightnessProperty().getValue(), Interpolator.LINEAR)),
                            new KeyFrame(Duration.seconds(1), new KeyValue(colorAdjust.brightnessProperty(), 0.3, Interpolator.LINEAR)
                            ));
                    fadeInTimeline.setCycleCount(1);
                    fadeInTimeline.setAutoReverse(false);
                    fadeInTimeline.play();

                });

                cell.setOnMouseExited(e -> {
                    ColorAdjust colorAdjust = new ColorAdjust();
                    colorAdjust.setBrightness(0.0);

                    cell.setEffect(colorAdjust);
                    Timeline fadeOutTimeline = new Timeline(
                            new KeyFrame(Duration.seconds(0),
                                    new KeyValue(colorAdjust.brightnessProperty(), colorAdjust.brightnessProperty().getValue(), Interpolator.LINEAR)),
                            new KeyFrame(Duration.seconds(1), new KeyValue(colorAdjust.brightnessProperty(), 0, Interpolator.LINEAR)
                            ));
                    fadeOutTimeline.setCycleCount(1);
                    fadeOutTimeline.setAutoReverse(false);
                    fadeOutTimeline.play();
                });

                cell.draw();
            }
        }
    }

    public Cell getCell(int i, int j) {
        return this.board.getCellAtIndexes(i, j);
    }
}