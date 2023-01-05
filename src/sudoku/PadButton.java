
package sudoku;

import java.awt.*;
import javax.swing.JButton;

/**
* The Padbutton class is the buttons
* for the side panel which allows for   
* user input selection
*
* @author Brian Liu
* @version 1.0
* @since 2021-011-29
*/
public class PadButton extends JButton {
    
    private final int padnumber;
    
    /**
    * The padbutton constructor creates a
    * pad button used for user input using 
    * its assigned number value
    * @param number the number represented by the button
    *  
    */        
    public PadButton(int number) {
        this.setPreferredSize(new Dimension(100,100));
        this.setBackground(new Color(115, 255, 184));
        this.setForeground(Color.white);
        this.setText(String.valueOf(number));
        this.setFont(new Font("Dialog", Font.BOLD, 45));
        padnumber = number;
    }
    /**
    * Gets and returns the Pad Number
    * @return pad button number
    */    
    public int getNumber(){
        return padnumber;
    }
}
