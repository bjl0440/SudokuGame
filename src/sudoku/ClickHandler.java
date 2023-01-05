
package sudoku;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Clickhandler class inherits Action Listener
 * to implement user clicking and actions
 * @author Brian Liu
 */

public class ClickHandler implements ActionListener {
    private final Sudoku game;
    /**
    * The ClickHandler constructor takes in 
    * an instance of the game to link with
    * ActionListener to perform actions
     * @param game the Sudoku game you want to be implemented
    */
    public ClickHandler(Sudoku game){
        this.game = game;
    }
    /**
     * The actionPerformed method detects 
     * user clicking input and and does an 
     * action depending on the object clicked
     * @param ae ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (!game.checkWin()){ // Game immunable after win
            if(ae.getSource() instanceof PadButton) {
                PadButton pb = (PadButton)ae.getSource();
                game.setInput(pb.getNumber());
            } else if (ae.getSource() instanceof Button && game.getInput() != 0) {
                Button b = (Button)ae.getSource();
                if (!b.isinitial){ //initial buttons immutable
                    b.setdisplay(game.getInput());
                    b.setBackground(b.filledColour);
                    if (game.getInput() == -1){ //"erasing" value
                        b.setBackground(b.blankColour);
                        b.setText(" ");
                    }
                    if (game.checkWin()) {
                        game.Win();
                    }
                }
            } else if (ae.getSource() instanceof EraseButton) {
                game.setInput(-1);// Set to -1 but not displayed

            }
        }    
    }
}
    