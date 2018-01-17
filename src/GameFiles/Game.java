package GameFiles;

import java.util.Scanner;

/**
 * Created by david on 09/01/2018.
 */
public class Game {
    // privates
    private Player P1, P2;
    private Board board;
    private int scoreP1, scoreP2;
    private Player lastPlayer;

    /*
     * constructor
     * construct GameFiles.Game by the first player and the board
     */

    public Game(Player P1, Player P2) {
        this.P1 = P1;
        this.P2 = P2;
    }

    /**
     * returns of the input is correct.
     * if so, it calls function for switching cells values (flipping to the other player).
     @param p player reference
     @return true if moves exist
     */
    public boolean playOneMove(Player p) {
        //String userInput; // stores user input
        boolean pMoves;

        // get possible moves for GameFiles.Player..
        p.getPlayerMoves();

        // check if there are any moves at all ?
        pMoves = p.getPossibleMoveStatus();

        // print msg to terminal..
        System.out.println(p.getType() + ": It's your move.");

        // Are there are possible moves for GameFiles.Player?
        if (pMoves) {
            // print GUI and take input here if needed... (GameFiles.HumanPlayer only)
            if (p.printGUI()) {

                String userInput;

                System.out.print("Your possible moves: ");

                p.printMoves();

                System.out.print("\nPlease enter your move row, col: ");

                // run loop until gets correct input for possible move
                while (true) {
                    Scanner reader = new Scanner(System.in);  // Reading from System.in
                    userInput = reader.nextLine(); // Scans the next token of the input as an int
                    //wrong input
                    if (!p.checkInput(userInput)) {
                        System.out.print("\nWrong input! Please enter your move row, col: ");
                    }
                    // true input
                    else {
                        p.playTurn();
                        break;
                    }
                }
            } else {
                p.playTurn();
            }

            // now assign p to lastPlayer ptr for future reference..
            this.lastPlayer = p;
            // return
            return true;
        } else {
            // print msg to user to press any key and "eat" the next char..
            System.out.println("No possible moves. Play passes back to the other player. Press any key to continue.");
            // no moves for GameFiles.Player, return false..
            return false;
        }
    }


    /**
     Gets the first player's reference, for use of functions inside of player - wasn't used much if at all...

     @return GameFiles.Player reference
     */
    public Player getP1() {
        return this.P1;
    }

    /**
     Gets the first player's reference, for use of functions inside of player - wasn't used much if at all...
     @return GameFiles.Player reference
     */
    public Player getP2() {
        return this.P2;
    }


    /**
     Updates the player scores in the end of the game - for displaying reasons...
     */
    public void updatePlayerScores() {
        int countP1 = 0, countP2 = 0;
        // run through the board, and update players' scores..
        for (int i = 0; i < this.lastPlayer.getBoardSize(); i++) {
            for (int j = 0; j < this.lastPlayer.getBoardSize(); j++) {
                if (this.lastPlayer.getBoardValueAtIndexes(i, j) == this.P1.getType()) {
                    countP1++;
                } else if (this.getLastPlayer().getBoardValueAtIndexes(i, j) == this.P2.getType()) {
                    countP2++;
                }
            }
        }
        this.scoreP1 = countP1;
        this.scoreP2 = countP2;
    }

    /**
     Get player 1's score
     @return value
     */
    public int getP1Score() {
        return this.scoreP1;
    }

    /**
     Get player 2's score
     @return value
     */
    public int getP2Score() {
        return this.scoreP2;
    }

    /**
     * Get last player
     * @return last GameFiles.Player which was played
     */
    public Player getLastPlayer() {
        return this.lastPlayer;
    }
}
