
package sudoku;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.*;
import javax.swing.border.Border;

/**
* <h1>Sudoku Game</h1>
* This program creates a game
* of Sudoku
* <p>
* @author Brian Liu
* @version 1.0
* @since 2021-02-05
*/
public class Sudoku extends JFrame {
    private int input;
    private Button[][] tiles = new Button[9][9];
    
    // Sudoku Puzzle Key Array
    private static int [][] puzzle = {
        {2,4,9,3,6,7,1,8,5},
        {7,8,1,9,5,4,2,6,3},
        {5,3,6,8,1,2,4,7,9},
        {3,1,2,6,8,5,9,4,7},
        {9,7,5,4,2,1,6,3,8},
        {4,6,8,7,3,9,5,1,2},
        {6,2,7,1,9,3,8,5,4},
        {1,9,4,5,7,8,3,2,6},
        {8,5,3,2,4,6,7,9,1}
        };
    
    // Sudoku Display Key Array
    private static boolean [][] key = {
        {false,false,false,true,true,false,false,false,true},
        {false,false,false,false,false,false,false,false,true},
        {true,true,true,false,false,false,true,true,true},
        {false,true,true,false,false,false,true,false,true},
        {true,true,false,true,false,true,false,false,false},
        {false,false,false,false,false,true,true,true,false},
        {false,true,false,false,false,true,false,false,false,},
        {false,true,true,true,false,false,true,false,false},
        {true,false,true,false,false,true,false,true,true}
    };
    
    // test key for demonstration
    private static boolean [][] tkey = {
        {false,true,true,true,true,true,true,true,true,},
        {true,true,true,true,true,true,true,true,true,},
        {true,true,true,true,true,true,true,true,true,},
        {true,true,true,true,true,true,true,true,true,},
        {true,true,true,true,true,true,true,true,true,},
        {true,true,true,true,true,true,true,true,true,},
        {true,true,true,true,true,true,true,true,true,},
        {true,true,true,true,true,true,true,true,true,},
        {true,true,true,true,true,true,false,true,true,},
    };
    /**
    * This method is used to create the 
    * Sudoku game's GUI
    */
    private void createGUI() {
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("Sudoku");
        
        // Game Colours
        Color backgroundColour = new Color(168, 230, 206);
        Color borderColour = new Color(255, 191, 191);
        
        this.getContentPane().setBackground(backgroundColour);
        Border border = BorderFactory.createLineBorder(borderColour);
        
        // Sudoku main game panel
        JPanel buttonPanel = new JPanel();
        GridLayout outerlayout = new GridLayout(3,3);
        GridLayout innerlayout = new GridLayout(3,3);
        ClickHandler clickhandler = new ClickHandler(this);
        buttonPanel.setLayout(outerlayout);
        
        // Forloop to create and arrange buttons in 3x3 of 3x3 panels
        // Outter 3x3 JPanel
        for (int outterrow = 0; outterrow < 3;outterrow++){
            for (int outtercol = 0; outtercol < 3;outtercol++){
                JPanel innerPanel = new JPanel();
                innerPanel.setLayout(innerlayout);
                // Inner 3x3 JPanel
                for (int innerrow = 0; innerrow < 3;innerrow++){
                    for (int innercol = 0; innercol < 3;innercol++){
                        int row = outterrow * 3 + innerrow;
                        int col = outtercol * 3 + innercol;
                        Button tile = new Button(puzzle[row][col],key[row][col]);
                        tile.addActionListener(clickhandler);
                        innerPanel.add(tile);
                        tiles[row][col] = tile; //adds button in 2d array in correct place
                    }
                }
                innerPanel.setBorder(border);
                buttonPanel.add(innerPanel);
            }
        }
        buttonPanel.setBorder(border);
        this.add(buttonPanel,BorderLayout.WEST);
        
        
        // Number Pad Panel Creation
        JPanel NumberPad = new JPanel(); 
        GridLayout padlayout = new GridLayout(3,3);
        NumberPad.setLayout(padlayout);
        
        // Creates and arranges numberpad buttons in 3x3 panel
        for (int i = 0; i < 3;i++){
            for (int j = 0; j < 3;j++){
                int num = i*3 + j + 1;
                PadButton pad = new PadButton(num);
                pad.addActionListener(clickhandler);
                pad.setBorder(border);
                NumberPad.add(pad);
            }
        }
        NumberPad.setBorder(border);
        this.add(NumberPad);
        
        // Creating Erase button 
        EraseButton clear = new EraseButton();
        clear.addActionListener(clickhandler);
        clear.setBorder(border);
        this.add(clear);
        
       // Overall Layout of panels within Sudoku GUI
        FlowLayout GUI = new FlowLayout();
        this.setLayout(GUI);
        this.pack();
        this.setVisible(true);
    }
    /**
    * Gets and returns the Input value
    * @return int current input value
    */
    public int getInput() {
      return input;
    }        
    /**
    * Sets the Current Input value
    * @param inputs the value to set input as
    */    
    public void setInput(int inputs) {
      this.input = inputs;
    }  
    /**
    * This method is used to check if 
    * the Sudoku game has been won by 
    * checking win status of every button
    * in the 2d list
    * 
    * @return boolean This returns game win status
    */    
    public boolean checkWin(){
        boolean win = true;
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if(tiles[i][j].display != puzzle[i][j] && !tiles[i][j].isinitial){
                    win = false;
                }
            }
        }
        return win;
    }
    /**
    * This method is used to create the 
    * winning screen 
    */        
    public void Win(){
        JFrame WinScreen = new JFrame();
        
        ImageIcon Steven = new ImageIcon(getClass().getResource("Steven.png"));
        JLabel image = new JLabel("GGEZ",Steven,SwingConstants.HORIZONTAL);    
        image.setForeground(Color.yellow);
        image.setFont(new Font("Dialog", Font.BOLD, 200));
        WinScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        WinScreen.setPreferredSize(new Dimension(1200, 800));
        WinScreen.add(image);
        WinScreen.getContentPane().setBackground(new Color(255, 140, 148));
        
        WinScreen.setVisible(true);
        WinScreen.pack();
    }
   /**
   * This is the main method which makes use of createGUI method
   * in creation of a Sudoku game
   * @param args Unused.
   */
    public static void main(String[] args) {
        Sudoku game = new Sudoku();
        game.createGUI();
    }
}
