// Author:  Jacob King, Yanbing Ren
// Student number: 300082223, 300059013
// Course: ITI1121 -B00
// Assignment: 03
// Part: 02

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.Color;
import javax.swing.*;

// YOUR IMPORT HERE

public class GridButton extends JButton {


    // YOUR VARIABLES HERE
    
    private boolean clicked;
    private int column, row;
    private ImageIcon on,off,solutionOn,solutionOff;//= new ImageIcon(GridButton.class.getResource("/Icons/Light-0.png"));
   

    /**
     * Constructor used for initializing a GridButton at a specific
     * Board location.
     * 
     * @param column
     *            the column of this Cell
     * @param row
     *            the row of this Cell
     */

    public GridButton(int column, int row) {
        super(new ImageIcon(GridButton.class.getResource("/Icons/Light-0.png")));
    on = new ImageIcon(GridButton.class.getResource("/Icons/Light-0.png"));
    off = new ImageIcon(GridButton.class.getResource("/Icons/Light-1.png"));
    solutionOn = new ImageIcon(GridButton.class.getResource("/Icons/Light-2.png"));
    solutionOff = new ImageIcon(GridButton.class.getResource("/Icons/Light-3.png"));
    Border emptyBorder = BorderFactory.createEmptyBorder(0, 0, 0, 0);
    setBorder(emptyBorder);
    clicked = false;
        // YOUR CODE HERE
    setBackground(Color.WHITE);
        this.row = row;
        this.column = column;
        setIcon(off);
    }

    // private ImageIcon makeIcon(){
    //     ImageIcon icon = new ImageIcon(
    // }

   /**
    * sets the icon of the button to reflect the
    * state specified by the parameters
    * @param isOn true if that location is ON
    * @param isClicked true if that location is
    * tapped in the model's current solution
    */ 
    public void setState(boolean isOn, boolean isClicked) {

        // YOUR CODE HERE
        this.clicked = isClicked;
        if(clicked){
            if(isOn){
                setIcon(on);
            }
            else{
                setIcon(off);
            }
        }

    }



    /**
     * Getter method for the attribute row.
     * 
     * @return the value of the attribute row
     */

    public int getRow() {
        // YOUR CODE HERE
        return row;
    }

    /**
     * Getter method for the attribute column.
     * 
     * @return the value of the attribute column
     */

    public int getColumn() {
        // YOUR CODE HERE
        return column;
    }


    public boolean clicked(){
        return clicked;
    }
}
    // YOUR OTHER METHODS HERE

