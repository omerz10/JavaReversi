package GameFiles;

/**
 * Created by david on 09/01/2018.
 */
public interface Logic {
    void getPossibleMoves(Board board, Player player);
    void getEmptyCell(Board board, int i, int j, int k, int n, char playerID, PossibleMove pMove);
    int switchCells(Board board, int i, int j, Player player);
    boolean isBoardFull(Board board);

}
