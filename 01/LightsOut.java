// Author:  Jacob King, Yanbing Ren
// Student number: 300082223, 300059013
// Course: ITI1121 -B00
// Assignment: 03
// Part: 02



import java.util.ArrayList;


/**
 * The class <b>LightsOut</b> launches the game
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */
public class LightsOut {


     /**
     * default width of the game.
     */
    public static final int DEFAULT_WIDTH = 8;
     /**
     * default height of the game.
     */
    public static final int DEFAULT_HEIGTH = 8;


    // COMPLETE THE CLASS HERE (AS PER Q1)
    
/**
     * The method <b>solve</b> finds all the
     * solutions to the <b>Lights Out</b> game
     * for an initially completely ``off'' board
     * of size <b>widthxheight</b>, using a
     * Breadth-First Search algorithm.
     *
     * It returns an <b>ArrayList&lt;Solution&gt;</b>
     * containing all the valid solutions to the
     * problem.
     *
     * This version does not continue exploring a
     * partial solution that is known to be
     * impossible. It will also attempt to complete
     * a solution as soon as possible
     *
     * During the computation of the solution, the
     * method prints out a message each time a new
     * solution  is found, along with the total time
     * it took (in milliseconds) to find that solution.
     *
     * @param width
     *  the width of the board
     * @param height
     *  the height of the board
     * @return
     *  an instance of <b>ArrayList&lt;Solution&gt;</b>
     * containing all the solutions
     */
    public static ArrayList<Solution> solve(int width, int height){

        QueueImplementation<Solution> q  = new QueueImplementation<Solution>();
        ArrayList<Solution> solutions  = new ArrayList<Solution>();


        q.enqueue(new Solution(width,height));
        long start = System.currentTimeMillis();
        while(!q.isEmpty()){
            Solution s  = q.dequeue();
            if(s.isReady()){
                // by construction, it is successfull
                System.out.println("Solution found in " + (System.currentTimeMillis()-start) + " ms" );

                solutions.add(s);

            } else {
                boolean withTrue = s.stillPossible(true);
                boolean withFalse = s.stillPossible(false);
                if(withTrue && withFalse) {
                    Solution s2 = new Solution(s);
                    s.setNext(true);
                    q.enqueue(s);
                    s2.setNext(false);
                    q.enqueue(s2);
                } else if (withTrue) {
                    s.setNext(true);
                    if(s.finish()){
                        q.enqueue(s);
                    }
                } else if (withFalse) {
                    s.setNext(false);
                    if( s.finish()){
                        q.enqueue(s);
                    }
                }
            }
        }
        return solutions;
    }


    public static ArrayList<Solution> solve(GameModel model){

        QueueImplementation<Solution> q  = new QueueImplementation<Solution>();
        ArrayList<Solution> solutions  = new ArrayList<Solution>();
        // Solution temp = new Solution(model.getWidth(),model.getHeight());
        // make a new soluton based on model
        // for(int i =0; i<model.getHeight();i++){
        //     for(int j =0; j< model.getWidth();j++){
        //         temp.setNext(model.isON(i,j));
        //     }
        //  }

        q.enqueue(new Solution(model.getWidth(),model.getHeight()));
        long start = System.currentTimeMillis();
        while(!q.isEmpty()){
            Solution s  = q.dequeue();

                if(s.isReady()){

                     if(s.isSuccessful(model)){
                        System.out.println("Solution found in " + (System.currentTimeMillis()-start) + " ms" );

                        solutions.add(s);

                     }
                    // by construction, it is successfull
                }

            else {
                boolean withTrue = s.stillPossible(true,model);
                boolean withFalse = s.stillPossible(false,model);
                if(withTrue && withFalse) {
                    Solution s2 = new Solution(s);
                    s.setNext(true);
                    q.enqueue(s);
                    s2.setNext(false);
                    q.enqueue(s2);
                } 
                else if (withTrue) {
                    s.setNext(true);
                    if(s.finish(model)){
                        q.enqueue(s);
                    }
                } 
                else if (withFalse) {
                    s.setNext(false);
                    if(s.finish(model)){
                        q.enqueue(s);
                    }
                }
            }
        }
        return solutions;
    }

    public static Solution solveShortest(GameModel model){
        if(model == null){
            throw new NullPointerException("model is null");
        }


        ArrayList<Solution> shortSolutions = solve (model);

        Solution sizeHolder;

        Solution shortestSize = shortSolutions.get(0);

        for (int i = 0; i < shortSolutions.size(); i++){
            sizeHolder = shortSolutions.get(i);

            if (sizeHolder.getSize()<shortestSize.getSize()){
                shortestSize = sizeHolder;
            }
        }
        return (shortestSize);
    }

    
   /**
     * <b>main</b> of the application. Creates the instance of  GameController 
     * and starts the game. If two parameters width and height
     * are passed, they are used. 
     * Otherwise, a default value is used. Defaults values are also
     * used if the paramters are too small (less than 1).
     * 
     * @param args
     *            command line parameters
     */
     public static void main(String[] args) {
        int width   = DEFAULT_WIDTH;
        int height  = DEFAULT_HEIGTH;
 
        StudentInfo.display();

        if (args.length == 2) {
            try{
                width = Integer.parseInt(args[0]);
                if(width<1){
                    System.out.println("Invalid argument, using default...");
                    width = DEFAULT_WIDTH;
                }
                height = Integer.parseInt(args[1]);
                if(height<1){
                    System.out.println("Invalid argument, using default...");
                    height = DEFAULT_HEIGTH;
                }
            } catch(NumberFormatException e){
                System.out.println("Invalid argument, using default...");
                width   = DEFAULT_WIDTH;
                height  = DEFAULT_HEIGTH;
            }
        }
        GameController game = new GameController(width, height);
    }


}
