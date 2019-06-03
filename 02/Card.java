// Author: Jacob King
// Student number: 300082223
// Course: ITI 1121 - B
// Assignment: 1
// Question: 2.2 Card

public class Card {

    // Sets the suit of the cards to a constant value
    public static final int DIAMOND = 0; // The suit DIAMOND is set to 0
    public static final int CLUB = 1; // The suit CLUB is set to 1
    public static final int HEART = 2; // The suit HEART is set to 2
    public static final int SPADE = 3; // The suit SPADE is set to 3

    // Declare a value to store the suit of the card
    private int suit;

    // Declare a value to store the rank of the card
    private int rank;


        /**
        * A constructor method for card.
        * Sets the value for suit and rank.
        *
        * @param givenRank int for the rank.
        * @param givenSuit int for the suit.
        *
        */
        public Card (int givenSuit, int givenRank){
            suit = givenSuit;
            rank = givenRank;
        }

        /**
        * A method for returning the suit of the stored card to other classes.
        *
        * @return suit.
        */
        public int getSuit(){
            return(suit);
        }

        /**
        * A method for returning the rank of the stored card to other classes.
        *
        * @return rank
        */
        public int getRank(){
            return(rank);
        }

        /**
        * A method for returning a boolean of the comparison of two card objects.
        * True if the suit and rank of the objects are the same, false otherwise.
        *
        * @param other object of the class card.
        * @return false if there is no value in object, return the boolean of the card objects equal
        */
        public boolean equals (Card other) {

            // First check if the other stared card has a value assigned, if not return false
            if (other == null){
                return false;
            }

            // Return true of false if the card objects match
            return ((suit == other.suit)&&(rank == other.rank));
        }

        /**
        * A method for returning a string representation of a card object.
        *
        * @return a string representation of a card object ie. ({1,10}).
        */
        public String toString() {
            return ("{" + suit + "," + rank + "}");
        }
}
