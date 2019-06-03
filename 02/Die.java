import java.util.Random;

// Author: Jacob King, Yanbing Ren
// Student number: 300082223
// Course: ITI 1121-B04
// Assignment: 1
// Question: 2.1 Die

public class Die{

    // Set the max value of the die to a constant of 6
    public static final int MAXVALUE = 6;

    // Intalize and declare an int generate
    private int generator; // Used to generate a random number

    // Intalize and declare an int die
    private int die; // Its used to store an object of Die


    /**
    * A constructor method for Die.
    * Sets the value for the oject die using a random value.
    *
    */
    public Die(){

        // Set random to a new random class
        Random generator = new Random();

        // Set the value of die to the random number generated from 1 to MAXVALUE(6).
        die = generator.nextInt(MAXVALUE) + 1;
    }

    /**
    * A method for returning the number of the die of the stored die to other classes.
    *
    * @return die
    */
    public int getValue(){
        return(die);
    }

    /**
    * A method for rolling the die
    * generates another random number which die is set to.
    *
    */
    public void roll(){

        // Set random to a new random class.
        Random generator = new Random();

        // Set the value of die to the random number generated from 1 to MAXVALUE(6).
        die = generator.nextInt(MAXVALUE) + 1;
    }


    /**
    * A method for returning a string representation of a die object.
    *
    * @return a string representation of the die object ie. ({4}).
    */
    public String toString() {
        return ("Die Value {" + die + "}");
    }
}
