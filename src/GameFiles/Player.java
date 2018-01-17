package GameFiles;

/**
 * Created by david on 09/01/2018.
 */
public interface Player {
    char getType();
    Cell getLastMove();
    void setLastMove(int i, int j);
    void printMoves();
    void playTurn();
    void getPlayerMoves();
    void setPossibleMove(PossibleMove pMove);
    PossibleMove getPossibleMoves();
    boolean getPossibleMoveStatus();
    boolean checkInput(String input);
    int getBoardSize();
    char getBoardValueAtIndexes(int i, int j);
    void showBoard();
    String toString();
    boolean printGUI();

}
