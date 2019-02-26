package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {
    private PigGameState gameState;
    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        gameState = new PigGameState();

    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        if(gameState.getPlayerTurn() == playerIdx){
            return true;
        }
        return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        if(action instanceof PigHoldAction){
            int whoseTurn = gameState.getPlayerTurn();
            if(whoseTurn == 0){
                gameState.setPlayer0Score(gameState.getRunningTotal() + gameState.getPlayer0Score());
                gameState.setRunningTotal(0);
                if(playerNames.length > 1){
                    gameState.setPlayerTurn(1);
                }
                return true;
            }
            else {
                gameState.setPlayer1Score(gameState.getRunningTotal() + gameState.getPlayer1Score());
                gameState.setRunningTotal(0);
                if(playerNames.length > 1){
                    gameState.setPlayerTurn(0);

                }
                return true;
            }

        }
        else if(action instanceof PigRollAction){
            int whoseTurn = gameState.getPlayerTurn();
            int diceValue = (int)(Math.random()*6);
            while(diceValue == 0){
                diceValue = (int)(Math.random()*6);
            }
            gameState.setCurrentDieValue(diceValue);
            if(diceValue != 1){
                gameState.setRunningTotal(gameState.getRunningTotal() + gameState.getCurrentDieValue());
                return true;
            }
            else{
                gameState.setCurrentDieValue(0);
                //if(whoseTurn == 0){
                    if(playerNames.length > 1){
                        gameState.setPlayerTurn(1);
                    }
                //}
               // else {
                  //      if(playerNames.length > 1) {
                   //         gameState.setPlayerTurn(0);
                   //     }
                }
                return true;
            }

        return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        PigGameState copy = new PigGameState(gameState);
        p.sendInfo(copy);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        //TODO  You will implement this method
        if(gameState.getPlayerTurn() == 0) {
            if (gameState.getPlayer0Score() >= 50) {
                String endGame = playerNames[0] + "Won with a score of: " + gameState.getPlayer0Score();
                return endGame;
            }
        }
        else if(gameState.getPlayerTurn() == 1) {
            if (gameState.getPlayer1Score() >= 50) {
                String endGame1 = playerNames[1] + "Won with a score of: " + gameState.getPlayer1Score();
                return endGame1;
            }
        }
        return null;
    }

}// class PigLocalGame
