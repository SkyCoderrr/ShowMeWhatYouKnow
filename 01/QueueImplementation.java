// Author:  Jacob King, Yanbing Ren
// Student number: 300082223, 300059013
// Course: ITI1121 -B00
// Assignment: 03
// Part: 02



import java.util.ArrayList;

public class QueueImplementation<E> implements Queue<E> {

 // YOUR CODE HERE
    private ArrayList<E> solutions;

    public QueueImplementation() {
        solutions = new ArrayList<E>();

    }

    public boolean isEmpty() {
        return (solutions.isEmpty());
    }

    public void enqueue( E o ) {
        if(o ==null){
            throw new NullPointerException("O is null");
        }
        else{
            solutions.add(o);

        }

    }

    public E dequeue() {
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty, cannot dequeue");
        }
        return (solutions.remove(0));
    }
}
