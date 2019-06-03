// Author:  Jacob King, Yanbing Ren
// Student number: 300082223, 300059013
// Course: ITI1121 -B00
// Assignment: 03
// Part: 02





import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

// YOUR OTHER IMPORTS HERE IF NEEDED

/**
 * The class <b>GameController</b> is the controller of the game. It is a listener
 * of the view, and has a method <b>play</b> which computes the next
 * step of the game, and  updates model and view.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */


public class GameController implements ActionListener, ItemListener {

    // YOUR VARIABLES HERE

    private GameModel model;
    private GameView view;


    /**
     * Constructor used for initializing the controller. It creates the game's view 
     * and the game's model instances
     * 
     * @param width
     *            the width of the board on which the game will be played
     * @param height
     *            the height of the board on which the game will be played
     */
    public GameController(int width, int height) {

        // YOUR CODE HERE
        model = new GameModel(width, height);
        view = new GameView(model, this);//create a new graphical view of th game
        view.update();//update the view
    }

    /**
     * Callback used when the user clicks a button (reset, 
     * random or quit)
     *
     * @param e
     *            the ActionEvent
     */

    public void actionPerformed(ActionEvent e) {
        
        // YOUR CODE HERE
        if(e.getActionCommand().equals("Reset")){
            model.reset();//reset the board

        }
        if(e.getActionCommand().equals("Random")){
            model.randomize();//randomize the board
        }
        if(e.getActionCommand().equals("Quit")){
            System.exit(0);//quit the game;
        }
        if(e.getSource() instanceof GridButton){
            GridButton scr =(GridButton) e.getSource();
        // System.out.println(scr.getRow()+" row/ col "+scr.getColumn());
            model.click(scr.getRow(),scr.getColumn());
            scr.setState(model.isON(scr.getRow(),scr.getColumn()),true);
            
        }

        //update the view
        view.update();

    }

    /**
     * Callback used when the user select/unselects
     * a checkbox
     *
     * @param e
     *            the ItemEvent
     */

    public void  itemStateChanged(ItemEvent e){

        // YOU CODE HERE
        
        model.setSolution();// force the model to find a solution for the current board
        

        if(e.getStateChange() == ItemEvent.DESELECTED){
            //if user diselect check box , resume to normal display
            //DO SOMETHING
        }
        //update the graphical view
        view.update();
    }

    // YOUR OTHER METHODS HERE


    public GameModel getModel() {
        return model;
    }

    public GameView getView() {
        return view;
    }
}
