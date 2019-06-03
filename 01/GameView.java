
// Author:  Jacob King, Yanbing Ren
// Student number: 300082223, 300059013
// Course: ITI1121 -B00
// Assignment: 03
// Part: 02


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// your other import here if needed

/**
 * The class <b>GameView</b> provides the current view of the entire Game. It extends
 * <b>JFrame</b> and lays out a matrix of <b>GridButton</b> (the actual game) and 
 * two instances of JButton. The action listener for the buttons is the controller.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

public class GameView extends JFrame {

    // your variables here
    private GameModel gameModel;
    private GameController gameController;
    private JLabel steps;
    GridButton [][] grid;

    /**
     * Constructor used for initializing the Frame
     * 
     * @param gameModel
     *            the model of the game (already initialized)
     * @param gameController
     *            the controller
     */

    public GameView(GameModel gameModel, GameController gameController) {
        super("Lights Out -- the ITI1121 version");

        
        JPanel panel = new JPanel(new GridLayout(gameModel.getHeight(),gameModel.getWidth()));
        steps = new JLabel("Number of steps" + gameModel.getNumberOfSteps());
        // YOUR CODE HERE
        grid= new GridButton[gameModel.getWidth()] [gameModel.getHeight()];
        JPanel buttonPanel = new JPanel(new GridLayout(4,1));

        for(int i = 0 ; i < gameModel.getHeight(); i++){
            for(int j =0; j< gameModel.getWidth();j++){
                grid[i][j] = new GridButton(j,i);
                grid[i][j].addActionListener(gameController);
                panel.add(grid[i][j]);
            }
        }
        add(panel,BorderLayout.CENTER);

        //create a new grid button of specified size

        this.gameController = gameController;
        this.gameModel = gameModel;
        JCheckBox solution = new JCheckBox("Solution");//make new check box soluiton
        solution.setSelected(false);
        //set check box to deselected
        solution.addItemListener(gameController);
        // add controller to item listener

        // JLabel NumberOfSteps = new JLabel("Number of Step: "+gameModel.getNumberOfSteps());
        //make a new label at the bottom of the screen
        JButton reset = new JButton("Reset");

        JButton random = new JButton("Random");

        JButton quit = new JButton("Quit");
        reset.addActionListener(gameController);
        random.addActionListener(gameController);
        quit.addActionListener(gameController);

        
        //make a new grid button according to the gameModel

        
        buttonPanel.add(reset);
        buttonPanel.add(random);
        buttonPanel.add(solution);
        
        buttonPanel.add(quit);
        add(buttonPanel,BorderLayout.EAST);
        add(steps,BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set up
        setSize(400,400);
        setVisible(true);
        //display window
    }

    /**
     * updates the status of the board's GridButton instances based 
     * on the current game model, then redraws the view
     */

    public void update(){

        // YOUR CODE HERE
        steps = new JLabel("Number of steps" + gameModel.getNumberOfSteps());

        add(steps,BorderLayout.SOUTH);
        for(int i =0; i< gameModel.getHeight(); i++){
            for(int j = 0; j< gameModel.getWidth();j++){
                if(grid[j][i].clicked()){
                    grid[j][i].setState(gameModel.isON(j,i),true);
                    if(j-1 >=0){
                        grid[j-1][i].setState(gameModel.isON(j-1,i),true);

                    }
                    if(i-1 >=0){
                        grid[j][i-1].setState(gameModel.isON(j,i-1),true);

                    }
                    if(j+1 <gameModel.getWidth()){
                        grid[j+1][i].setState(gameModel.isON(j+1,i),true);

                    }
                    if(i+1 <gameModel.getHeight()){
                        grid[j][i+1].setState(gameModel.isON(j,i+1),true);
                    }
                    
                }
               
            }
        }
        System.out.println(gameModel);

    }

    /**
     * returns true if the ``solution'' checkbox
     * is checked
     *
     * @return the status of the ``solution'' checkbox
     */

    public boolean solutionShown(){

        // YOUR CODE HERE
        return false;
    }

}
