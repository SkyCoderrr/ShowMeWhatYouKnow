
// Author:  Jacob King, Yanbing Ren
// Student number: 300082223, 300059013
// Course: ITI1121 -B00
// Assignment: 03
// Part: 02
// UPDATE THIS FILE AS REQUIRED

/**
 * The class <b>Solution</b> is used
 * to store a (partial) solution to the game
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */
public class Solution {


    /**
     * our board. board[i][j] is true is in this
     * solution, the cell (j,i) is tapped
     */
    private boolean[][] board;

    /**
     *  width of the game
     */
    private int width;

    /**
     * height of the game
     */
    private int height;

    /**
     * how far along have we constructed that solution.
     * values range between 0 and height*width-1
     */
    private int currentIndex;

   



    /**
     * Constructor. Creates an instance of Solution
     * for a board of size <b>widthxheight</b>. That
     * solution does not have any board position
     * value explicitly specified yet.
     *
     * @param width
     *  the width of the board
     * @param height
     *  the height of the board
     */
    public Solution(int width, int height) {

        this.width = width;
        this.height = height;
        
        board = new boolean[height][width];
        currentIndex = 0;

    }


   /**
     * Constructor. Creates an instance of Solution
     * wich is a deep copy of the instance received
     * as parameter.
     *
     * @param other
     *  Instance of solution to deep-copy
     */
     public Solution(Solution other) {

        this.width = other.width;
        this.height = other.height;
        this.currentIndex = other.currentIndex;

        board = new boolean[height][width];

        for(int i = 0; i < currentIndex; i++){
            board[i/width][i%width] = other.board[i/width][i%width];
        }

    }


    /**
     * returns <b>true</b> if and only the parameter
     * <b>other</b> is referencing an instance of a
     * Solution which is the ``same'' as  this
     * instance of Solution (its board as the same
     * values and it is completed to the same degree)
     *
     * @param other
     *  referenced object to compare
     */

    public boolean equals(Object other){

        if(other == null) {
            return false;
        }
        if(this.getClass() != other.getClass()) {
            return false;
        }

        Solution otherSolution = (Solution) other;

        if(width != otherSolution.width ||
            height != otherSolution.height ||
            currentIndex != otherSolution.currentIndex) {
            return false;
        }

        for(int i = 0; i < height ; i++){
            for(int j = 0; j < width; j++) {
                if(board[i][j] != otherSolution.board[i][j]){
                    return false;
                }
            }
        }

        return true;

    }


    /**
    * returns <b>true</b> if the solution
    * has been entirely specified
    *
    * @return
    * true if the solution is fully specified
    */
    public boolean isReady(){
        return currentIndex == width*height;
    }

    /**
    * specifies the ``next'' value of the
    * solution.
    * The first call to setNext specifies
    * the value of the board location (1,1),
    * the second call specifies the value
    *  of the board location (1,2) etc.
    *
    * If <b>setNext</b> is called more times
    * than there are positions on the board,
    * an error message is printed out and the
    * call is ignored.
    *
    * @param nextValue
    *  the boolean value of the next position
    *  of the solution
    */
    public void setNext(boolean nextValue) {

        if(currentIndex >= width*height) {
            System.out.println("Board already full");
            return;
        }

       

        board[currentIndex/width][currentIndex%width] = nextValue;
        currentIndex++;
    }

    /**
    * returns <b>true</b> if the solution is completely
    * specified and is indeed working, that is, if it
    * will bring a board of the specified dimensions
    * from being  entirely ``off'' to being  entirely
    * ``on''.
    *
    * @return
    *  true if the solution is completely specified
    * and works
    */
    public boolean isSuccessful(){

        if(currentIndex < width*height) {
            System.out.println("Board not finished");
            return false;
        }

        for(int i = 0; i < height ; i++){
            for(int j = 0; j < width; j++) {
                if(!oddNeighborhood(i,j)){
                    return false;
                }
            }
        }
        return true;
    }



    /**
    @param int row, column
    * the row and the column to be clicked
    * it flips the state of the cell at board[row][col] and its neighbours
    * @author Yanbing Ren
    */


    private void click(int row, int column){//if board[i][j] is true, flip it and all its neighbours
            
            if(row >= height || column >= width){
                throw new IllegalArgumentException("invalid value");
            }
            this.board[row][column] = !this.board[row][column];//flip i,j 

            if(row -1 >=0 && row-1 <this.width){
                this.board[row-1][column] = !this.board[row-1][column];
            }
            if(row+1 < this.height){
                this.board[row+1][column] = !this.board[row+1][column];
            }
            if(column-1 >=0 ){
                this.board[row][column-1] = !this.board[row][column-1];
            }
            if(column+1 < this.width){
                this.board[row][column+1] = !this.board[row][column+1];
            }
        }    
    /**
    @param GameModel model, the model solution is based on
    * check if the current solution solve the model
    * @author Yanbing Ren
    */

    public boolean isSuccessful(GameModel model){
        // this method returns true if the solution is completely specified 
        // and is indeed working, that is,
        //  if it will bring a board of the specified dimensions from the state 
        //     specified by the GameModel instance model to being entirely “on”.

        // System.out.println("current width "+ width+",  current height "+ height);
        if(currentIndex < width*height) {
            System.out.println("Board not finished");
            return false;
        }

        Solution s = new Solution(model.getWidth(),model.getHeight());
         for(int i =0; i<s.height;i++){
            for(int j =0; j< s.width;j++){
                s.board[i][j] = model.isON(i,j);
            }
        }
        for(int i =0; i<s.height;i++){
            for(int j =0; j< s.width;j++){
                if(this.board[i][j]){
                    s.click(i,j);
                }
            }
        }
        for(int i = 0; i < s.height ; i++){
            for(int j = 0; j < s.width; j++) {
                if(!s.board[i][j]){
                    return false;
                }
            }
        }
        return true;
    }


   /**
    * checks if board[i][j] and its neighborhood
    * have an odd number of values ``true''
    */

   /**
    * this method ensure that add <b>nextValue</b> at the
    * currentIndex does not make the current solution
    * impossible. It assumes that the Solution was
    * built with a series of setNext on which
    * stillPossible was always true.
    * @param nextValue
    *         The boolean value to add at currentIndex
    * @return true if the board is not known to be
    * impossible (which does not mean that the board
    * is possible!)
    */
    public boolean stillPossible(boolean nextValue) {
        //assume starting with a completely off board

        if(currentIndex >= width*height) {
            System.out.println("Board already full");
            
            return false;
        }

        int i = currentIndex/width;
        int j = currentIndex%width;

        boolean before = board[i][j];
        boolean possible = true;

        board[i][j] = nextValue;

        if((i > 0) && (!oddNeighborhood(i-1,j))){
            possible = false;
        }
        if(possible && (i == (height-1))) {
            if((j > 0) && (!oddNeighborhood(i,j-1))){
                possible = false;
            }
            if(possible && (j == (width-1))&& (!oddNeighborhood(i,j))){
                possible = false;
            }
        }
        board[i][j] = before;
        return possible;
    }

       /**
    * this method ensure that add <b>nextValue</b> at the
    * currentIndex does not make the current solution
    * impossible. It assumes that the Solution was
    * built with a series of setNext on which
    * stillPossible was always true.
    * @param nextValue
    *         The boolean value to add at currentIndex
    * @param model
    *         The gameModel to check
    * @return true if the board is not known to be
    * impossible (which does not mean that the board
    * is possible!)
    */

    public boolean stillPossible(boolean nextValue, GameModel model){
        // System.out.println(currentIndex+"??????????");
        if(this.currentIndex >= width*height){
            System.out.println("Board already full");
            return false;
        }
        Solution s = new Solution(model.getWidth(),model.getHeight());
        for(int m =0; m<s.height;m++){
            for(int n =0; n< s.width;n++){
                s.board[m][n] = model.isON(m,n);  
            }
        }
        // System.out.println(s);

        //cophy model into a solution

         for(int m =0; m<s.height;m++){
            for(int n =0; n< s.width;n++){
               if(this.board[m][n]){
                    s.click(m,n);
               }
            }
        }
        s.currentIndex = this.currentIndex;
        int i = s.currentIndex/s.width;
        int j = s.currentIndex%s.width;
        
        if(nextValue){
            s.click(i,j);
        }
        for(int k=0; k< s.currentIndex-width;k++){
            if(!s.board[k/width][k%width]){
                return false;
            }
        }

        return true;
    }

    /**
    * this method attempts to finish the board.
    * It assumes that the Solution was
    * built with a series of setNext on which
    * stillPossible was always true. It cannot
    * be called if the board can be extended
    * with both true and false and still be
    * possible.
    *
    * @return true if the board can be finished.
    * the board is also completed
    */
     public boolean finish (){


         int i = currentIndex/width;
         int j = currentIndex%width;

 /*
         if(i == 0 && height > 1) {
             System.out.println("First line incomplete, can't proceed");
             return false;
         }
 */

         while(currentIndex < height*width) {
             if(i < height - 1 ) {
                 setNext(!oddNeighborhood(i-1,j));
                 i = currentIndex/width;
                 j = currentIndex%width;
             } else { //last raw
                 if(j == 0){
                     setNext(!oddNeighborhood(i-1,j));
                 } else {
                    if((height > 1) && oddNeighborhood(i-1,j) != oddNeighborhood(i,j-1)){
                      return false;
                    }
                    setNext(!oddNeighborhood(i,j-1));
                 }
                 i = currentIndex/width;
                 j = currentIndex%width;
             }
         }
         if(!oddNeighborhood(height-1,width-1)){
             return false;
         }
         // here we should return true because we could
         // successfully finish the board. However, as a
         // precaution, if someone called the method on
         // a board that was unfinishable before calling
         // the method, we do a complete check

         if(!isSuccessful()) {
             System.out.println("Warning, method called incorrectly");
             return false;
         }

         return true;
     }

  /**
    * this method attempts to finish the board.
    * It assumes that the Solution was
    * built with a series of setNext on which
    * stillPossible was always true. It cannot
    * be called if the board can be extended
    * with both true and false and still be
    * possible.
    *
    * @return true if the board can be finished. given the model
    * the board is also completed
    * @author Yanbing Ren
    */



     public boolean finish(GameModel model){
        if(this.currentIndex >= width*height){
            System.out.println("Board already full");
            return false;
        }
        Solution s = new Solution(model.getWidth(),model.getHeight());
        for(int m =0; m<s.height;m++){
            for(int n =0; n< s.width;n++){
                s.board[m][n] = model.isON(m,n);  
            }
        }
        s.currentIndex = this.currentIndex;
        int i = s.currentIndex/s.width;
        int j = s.currentIndex%s.width;


        while(!s.isReady()){
            if(s.stillPossible(true,model)){
                s.click(i,j);
            }
            currentIndex++;
            i = s.currentIndex/s.width;
            j = s.currentIndex%s.width;

        }
        return s.isSuccessful(model);

     }


     private boolean oddNeighborhood(int i, int j) {

            if(i < 0 || i > height - 1 || j < 0 || j > width - 1) {
                return false;
            }

            int total = 0;
            if(board[i][j]){
                total++;
            }
            if((i > 0) && (board[i-1][j])) {
                total++;
            }
            if((i < height -1 ) && (board[i+1][j])) {
                total++;
            }
            if((j > 0) && (board[i][j-1])) {
                total++;
            }
            if((j < (width - 1)) && (board[i][j+1])) {
                total++;
            }
            return (total%2)== 1 ;
        }

        public int getSize(){
            int counter = 0;
            //assume current solution is succuessful 
            for(int i=0; i< height; i++){
                for(int j=0; j<width; j++){
                    if(board[i][j]){
                        counter ++;
                    }
                }
            }
            return(counter);
        }

    /**
     * returns a string representation of the solution
     *
     * @return
     *      the string representation
     */
    public String toString() {
        StringBuffer out = new StringBuffer();
        out.append("[");
        for(int i = 0; i < height; i++){
            out.append("[");
            for(int j = 0; j < width ; j++) {
                if (j>0) {
                    out.append(",");
                }
                out.append(board[i][j]);
            }
            out.append("]"+(i < height -1 ? ",\n" :""));
        }
        out.append("]");
        return out.toString();
    }

    public boolean get(int i, int j){
        return board[i][j];
    }

}
