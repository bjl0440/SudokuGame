
package sudoku;

import java.awt.*;
import javax.swing.JButton;

/**
 * The Button class is the erase button
 * used to erase user input on the Sudoku
 * board and inherits from JButton
 * @author bjl04
 */
public class EraseButton extends JButton {
    /**
    * The EraseButton constructor creates 
    * the erase button 
    */    
    public EraseButton() {
        this.setPreferredSize(new Dimension(100,300));
        this.setBackground(new Color(251, 191, 255));
        this.setFont(new Font("Dialog", Font.BOLD, 30));
        this.setForeground(Color.white);
        this.setText("erase");
    }   
}
