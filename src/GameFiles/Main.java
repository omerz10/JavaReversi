package GameFiles;

/**
 * Created by david on 13/01/2018.
 */
public class Main {
    public static void main(String[] args) {
        Board board = new Board(8);
        Logic logic = new GenericLogic();
        Player P1 = new HumanPlayer('X', board, logic);
        Player P2 = new HumanPlayer('O', board, logic);
        Game game = new Game(P1, P2);
        GameFlow gameFlow = new GameFlow(game);
        gameFlow.play();
    }
}
