package edu.up.cs301.pig;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.infoMsg.GameState;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        // TODO  You will implement this method
        PigGameState gameState = (PigGameState)info;
        if(this.playerNum != gameState.getPlayerTurn()) return;
        else{
            int randomChoice = (int)(Math.random()*100);
            while(randomChoice == 0){
                randomChoice = (int)(Math.random()*100);
            }
            if(randomChoice > 50){
                PigHoldAction holdAction = new PigHoldAction(this);
                game.sendAction(holdAction);
            }
            else if(randomChoice < 50){
                PigRollAction rollAction = new PigRollAction(this);
                game.sendAction(rollAction);
            }
        }
    }//receiveInfo

}
