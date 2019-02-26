package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

public class PigGameState extends GameState {

    private int playerTurn;
    private int player0Score;
    private int player1Score;
    private int runningTotal;
    private int currentDieValue;

    public PigGameState(){
        playerTurn = 0;
        player0Score = 0;
        player1Score = 0;
        runningTotal = 0;
        currentDieValue = 5;
    }

    public PigGameState (PigGameState org){
        this.playerTurn = org.playerTurn;
        this.player0Score = org.player0Score;
        this.player1Score = org.player1Score;
        this.runningTotal = org.runningTotal;
        this.currentDieValue = org.currentDieValue;
    }

    public int getPlayerTurn(){
        return playerTurn;
    }

    public int getPlayer0Score(){
        return player0Score;
    }

    public int getPlayer1Score(){
        return player1Score;
    }

    public int getRunningTotal(){
        return runningTotal;
    }

    public int getCurrentDieValue(){
        return currentDieValue;
    }

    public void setPlayerTurn(int playerTurn){
        this.playerTurn = playerTurn;
    }

    public void setPlayer0Score(int player0Score){
        this.player0Score = player0Score;
    }

    public void setPlayer1Score(int player1Score){
        this.player1Score = player1Score;
    }

    public void setRunningTotal(int runningTotal){
        this.runningTotal = runningTotal;
    }

    public void setCurrentDieValue(int currentDieValue){
        this.currentDieValue = currentDieValue;
    }
}
