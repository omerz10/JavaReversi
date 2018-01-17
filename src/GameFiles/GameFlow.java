package GameFiles;

/**
 * Created by david on 09/01/2018.
 */
public class GameFlow {
    private Game game;

    public GameFlow(Game g) {
        this.game = g;
    }

    public void play() {

        boolean endMovesForP1 = true, endMovesForP2 = true;

        // show board for the first time...
        this.game.getP1().showBoard();

        // stop when end moves for both P1 & P2
        while(endMovesForP1 && endMovesForP2) {

            // play move for P1
            endMovesForP1 = this.game.playOneMove(this.game.getP1());

            // print out the board
            this.game.getP1().showBoard();

            // print "last played msg.."
            lastPlayerMoveMsg(this.game.getLastPlayer(), endMovesForP1);

            // play move for P2
            endMovesForP2 = this.game.playOneMove(this.game.getP2());

            // print out the board
            this.game.getP2().showBoard();

            // print "last played msg.."
            lastPlayerMoveMsg(this.game.getLastPlayer(), endMovesForP2);

        } // end of game
        System.out.println("GameFiles.Game Over!");
        updateScores();
        showScores();
    }

    public void lastPlayerMoveMsg(Player lastPlayer, boolean playerMoves) {
        if (playerMoves) {
            // print "last player played..." msg here
            System.out.println(lastPlayer.getType() + " played (" + (lastPlayer.getLastMove().getX() + 1) + "," +
                    (lastPlayer.getLastMove().getY() + 1) + ")\n");
        } else {
            System.out.println("GameFiles.Player " + lastPlayer.getType() + " had no moves\n");
        }
    }

    public void updateScores() {
        this.game.updatePlayerScores();
    }

    public void showScores() {
        System.out.println("Final Score:\n" + this.game.getP1().getType()
                + ": " + this.game.getP1Score() + "\n" + this.game.getP2().getType()
                + ": " + this.game.getP2Score() + "\n");
        
        
        if (this.game.getP1Score() > this.game.getP2Score()) {
            System.out.println("GameFiles.Player " + this.game.getP1().getType() + " Won!");
        }
        if (this.game.getP2Score() > this.game.getP1Score()) {
            System.out.println("GameFiles.Player " + this.game.getP2().getType() + " Won!");
        }
        if (this.game.getP2Score() == this.game.getP1Score()) {
            System.out.println("It's a tie!");
        }
    }

}
