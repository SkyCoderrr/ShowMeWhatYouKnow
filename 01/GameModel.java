// Author:  Jacob King, Yanbing Ren
// Student number: 300082223, 300059013
// Course: ITI1121 -B00
// Assignment: 03
// Part: 02


public class GameModel {
    // Your code here
    private int width;
    private int height;
    private boolean board[][];
    private int numOfClicks = 0;
    private boolean solveCalled= false;
    private Solution s;

    public GameModel (int width, int height){
        if(width<=0 || height <=0){
            throw new IllegalArgumentException("Values for width or height not allowed");
        }
        this.width = width;
        this.height = height;
        board = new boolean[height][width];//# of rows,(h), # of columns (w)
        numOfClicks = 0;
        solveCalled = false;
    }

    public int getWidth (){
        return (width);
    }

    public int getHeight (){
        return (height);
    }

    public boolean isON(int i, int j){//width(row), height(column)
        if(i<0 || j<0 || j>= width || i>= height){
            throw new IllegalArgumentException("Invalid values for row or column");
        }
      
        return board[i][j];
    }

    public void reset(){
        board  = new boolean[height][width];
        numOfClicks = 0;

    }

    public void set(int i, int j, boolean value){//column, row
        if(i<0 || j<0 || i>= width || j>= height){
            throw new IllegalArgumentException("Invalid values for row or column");
        }

        board[j][i] = value;

    }

    public String toString(){
        StringBuffer output = new StringBuffer("[");
        for(int i =0; i< height; i++){
            output.append("[");
            for (int j =0; j < width ; j++){
                output.append(board[i][j]);
                if(j != width-1){
                    output.append(", ");
                }
            }
            output.append("]");
            if(i != height-1){
                output.append(", \n");

            }
            
        }

        output.append("]");
        return output.toString();
    }


      public void click(int i, int j){//if board[i][j] is true, flip it and all its neighbours
            
            numOfClicks ++;

            board[i][j] = !board[i][j];//flip i,j 

            if(i -1 >=0 && i-1 <width){
                board[i-1][j] = !board[i-1][j];
            }
            if(i+1 < width){
                board[i+1][j] = !board[i+1][j];

            }
            if(j-1 >=0 ){
                board[i][j-1] = !board[i][j-1];
            }
            if(j+1 < height){
                board[i][j+1] = !board[i][j+1];
            }
        }





 public int getNumberOfSteps(){
        return numOfClicks;

    }


    public boolean isFinished(){
        for(int i = 0; i < this.height;i++){
            for(int j = 0; j<this.width;j++){
                if(!board[i][j]){
                    return false;
                }
            }
        }
        return true;

    }

    public void randomize(){

    }


    public void setSolution(){
        //

        s = new Solution(LightsOut.solveShortest(this));
        // find the solution for the current board
        solveCalled = true;

    }

    public boolean solutionSelects(int i, int j){
        if(solveCalled){
            return s.get(i,j);
        }
        else{
            return false;
        }
        
    }











        
}
