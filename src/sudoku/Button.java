
package sudoku;
import java.awt.*;
import javax.swing.JButton;
/**
 * The Button class is the buttons
 * within the main Sudoku game panel
 * where user GUI input occurs
 * @author bjl04
 */
public class Button extends JButton {
    
    public int display;
    public boolean isinitial;
    
    //Colours
    public Color filledColour = new Color(171,219,227);
    public Color blankColour = new Color(204,204,204);
    /**
    * This Button constructor creates a button for 
    * the Sudoku main board using its correct value
    * and if it is initially displayed
     * @param tile the correct value for the button
     * @param isinitial if the button value is displayed when game begins
    */           
    public Button(int tile , boolean isinitial) {
        
        this.setPreferredSize(new Dimension(100,100));
        this.setForeground(Color.white);
        this.setFont(new Font("SansSerif", Font.BOLD, 40));
        
        if (isinitial) {
            this.setText(String.valueOf(tile));
            this.setBackground(filledColour);
        }else {
            this.setBackground(blankColour);
        }
        this.isinitial = isinitial;
    }
    /**
    * This method is used to set the
    * display of a Sudoku button
    * @param input The current input value 
    */       
    public void setdisplay(int input){
        display = input;
        this.setForeground(Color.yellow);
        this.setText(String.valueOf(display));
    } 
}
