/**
* Starting point for your implementation of the class Deck.
*
* @author Marcel Turcotte (marcel.turcotte@uottawa.ca)
*/


//Author : Yanbing Ren
//Student number : 300059013
//Course: ITI1121 - B
//Assignment : 1
//Qustion: 2.3 Deck

import java.util.ArrayList;
import java.util.Collections;


public class Deck {

    private ArrayList<Card> cards;

    /**
    * A constructor for the class <code>Deck</code>. It creates the initial
    * <code>ArrayList</code> that will be used to store the cards of Otherwise
    * deck.
    */

    public Deck() {
        cards = new ArrayList<Card>();//this creates an empty deck
    }

    /**
    * A constructor for the class <code>Deck</code>. It creates the initial
    * <code>ArrayList</code> that will be used to store the cards of Otherwise
    * deck. The parameter specifies the number of ranks for the cards. Finally,
    * it also initializes this deck to contain 4 x n cards, where n is the value
    * of the parameter.
    *
    * @param range the number of ranks for the cards
    *
    */


    public Deck(int range) {//this constructor initialize the deck with range*4 cards

        // Complete the implementation of this constructor
        cards =  new ArrayList <Card>(range*4);
        for (int i = 0;i < 4;i++){
            for (int j = 1;j< range+1;j++){
            Card temp = new Card(i,j);
            this.add(temp);//add a new card to deck
            }
        }
    }


    /** A method <code> int size()</code> for class <code>Deck</code>
    * this method returns the size of deck
    * @return size of deck
    */
    public int size(){//return the number of cards in the deck
        return cards.size();

    }

    /** A method <code>boolean hasCards()</code> for class <code>Deck</code>
    * this method returns true if deck is not empty
    * @return <code>true</code> iff deck has at least one card
    *         <code>false</code> otherwise
    */


    public boolean hasCards(){// returns true if the deck has one or more cards
        return !(cards.isEmpty());
    }

    /**
    * A method get for the class <code>Deck</code>. It gets the card at a
    * specific postition in the deck
    *
    * @param pos    the index of the card in the deck
    * @return   <code>Card</code> the Card object at index pos
    */

    public Card get(int pos){// return the card at a specific position in the deck
        if (pos < 0 || pos >=this.size() ){//if the pos is invalid and can cause an exception
            throw new IndexOutOfBoundsException("Index out of range.");//throw a new expection
        }

        else{
            return cards.get(pos);//if no exception thrown, return the element at index pos
        }
    }


    /** A method addCard for class <code>Deck</code>
    * this method adds a card to the end of the deck
    *@param card the Card object to be added to deck
    */

    public void add(Card card){
        if (card != null){
            cards.add(card);
        }
    }

    /** A method addAll for the class <code>Deck</code>
    * this method add another Deck object to the end of this deck
    * then all elements in other would be removed
    * @param other the other Deck objective to be added
    */

    public void addAll(Deck other){
        if (other != null){
            for (int i =0;i<other.size();i++){
                this.add(other.get(i));
            }
            other.removeAll(other);
        }
    }

    /** A method removeLast for the class <code>Deck </code>
    * this method removes and returns  the last card in the deck
    * @return <code>Card<code/> returns the last card in the deck
    */

    public Card removeLast(){
        Card temp = this.get(this.size()-1);//get the last card in deck
        cards.remove(this.get(this.size()-1));//remove the last card in deck
        return temp;//return the last card in deck
    }


    /** A method removeFirst for the class <code>Deck </code>
    * this method removes and returns  the first card in the deck
    * @return <code>Card<code/> returns the first card in the deck
    */


    public Card removeFirst(){
        Card temp = this.get(0);//get the first card in the deck
        cards.remove(0);//get the first card in the deck
        return temp;//return the last card in the deck
    }

    /** A method remove for the class <code>Deck</code>
    * this method takes in  a Card object card
    * this method removes the first occurrence of a specified card
    * if it's present in deck , returns true
    * otherwise returns false
    * @param card the card to be removed from deck
    * @return <code>true</code> iff deck constains card;
              <code>false</code> otherwise
    */

    public boolean remove(Card card){
        int index = 0;
        if (card != null && this.contains(card)){//if deck contains card
            for (int i=0; i<this.cards.size();i++){
                if(this.cards.get(i).equals(card)){
                    index = i;
                    break;
                }
            }

            this.cards.remove(index);//remove the card from deck
            return true;
        }
        else{
            return false;
        }
    }

    /** A method removeAll for the class <code>Deck</code>
    * this method takes in a Deck object other
    * then it removes from this deck all the cards contained in deck other
    * it does not remove cards in other
    * @param other the other Deck that contains cards to be removed from this deck
    */

    public void removeAll(Deck other){
         for (int i = 0;i<other.size();i++){//for each card c in other
             if (this.contains(other.get(i))){//if c can be found in this deck
                 this.remove(other.get(i));//remove c from this deck
             }
         }


    }

    /** A method shuffle for the class <code>Deck</code>
    * this method takes in no parameter
    * it randomly shuffles all the cards in this deck
    */

    public void shuffle(){
        Collections.shuffle(this.cards);//randomly shuffle all the cards in ArrayList<Card>cards
    }

    /** A method deal for the class <code>Deck</code>
    * this method takes in an int n
    * where n is the number of cards to be removed from the end of this deck
    * it removes n cards from this deck
    * and returns a new Deck containing all the cards removed
    * @param n int, number of cards to be removed from the end of this deck
    * @return <code>Deck </code>, a new deck containing all the cards removed
    */

    public Deck deal(int n){
        Deck newDeck = new Deck();//create a new empty deck
        if (n <= this.size() && n>0){
            for (int i = 0; i<n;i++){//remove n cards from the end of deck
            newDeck.add(this.removeFirst ());
            }
        }
        return newDeck;
    }

    /** A method contains for the class <code>Deck</code>
    * this method takes in Card object card
    * returns true iff this deck contains a specific card
    * @param card a specific Card object
    * @return <code>true</code> iff this deck contains card
    *         <code>false</code> otherwise
    */

    public boolean contains(Card card){
        if (card != null){
            for (int i = 0; i< this.size();i++){
                if (this.get(i).equals(card)){
                    return true;
                }
            }
        }
            return false;
        }



    /** A method containsAll for the class <code>Deck</code>
    * this method takes in a Deck object other
    * returns true iff this deck contains all cards in other
    * @param other the other deck containing all cards to be examined
    * @return <code>true</code> iff this deck contains all cards in other
    *         <code>false</code> otherwise
    */
    public boolean containsAll(Deck other){
        if (other != null){
            for (int i=0; i<other.size();i++){//check each card in other
                if(!(this.contains(other.get(i)))){//if this deck does not contain a specific card
                    return false;
                }
            }
            return true;
        }
        else{
            return false;
        }
    }

    /** A method isKind for the class <code>Deck </code>
    * this method takes in no parameters
    * return true iff this deck is a discardable kind,
    * that is if this deck has at least two cards
    * and all the cards have the same rank
    * @return <code>true</code> iff this deck is a discardable kind
    *         <code>false</code> otherwise
    */

    public boolean isKind(){
        if (this.size()<2){
            return false;
        }
        int rank = this.get(0).getRank();
        for (int i =0;i<this.size();i++){
            if (this.get(i).getRank ()!= rank){
                return false;
            }
        }
        return true;
    }

    /** A method isMethod for the class <code>Deck</code>
    * this method takes in no parameters
    * return true iff this deck is a discardable sequenmce
    * that is if this deck has at least three cards
    * and cards all have the same suit
    * cards form a sequence consecutive ranks
    * @return <code>true</code> iff this deck is a sequence
    *         <code>false</code> otherwise
    */

    public boolean isSeq(){
        if (this.size() < 3){
            return false;
        }

        this.sortByRank();

        int suit = this.get(0).getSuit();
        for (int i = 0; i< cards.size()-1;i++){

            if (this.get(i).getSuit() != suit || this.get(i+1).getSuit() != suit
                || this.get(i).getRank() != this.get(i+1).getRank()-1 ){
                return false;
            }
        }
        return true;
    }

    /** A method sortBySuit for the class <code>Deck</code>
    * this method takes in no parameters
    * sorts this deck by suits
    */

    public void sortBySuit(){
        //take each card from cards and compare its suit to the next card
        for (int i = 0; i < this.size();i++){
            for (int j = 0;j < this.size()-1;j++){
                if (this.get(j).getSuit() > this.get(j+1).getSuit()){//if the suit of the jth card is greater
                    Collections.swap(cards,j,j+1); //swap the jth card with the next card
                }
                if(this.get(j).getSuit() == this.get(j+1).getSuit()){//if two cards are of same suit
                    if (this.get(j).getRank() > this.get(j+1).getRank()){//if the rank of the jth card is greater

                        Collections.swap(cards,j,j+1);//swap the jth card with the next card

                    }
                }
            }
        }
    }



    /** A method sortByRank for the class <code>Deck</code>
    * this method takes in no parameters
    * sorts this deck by ranks in ascending order
    */

    public void sortByRank(){
        for (int i = 0;i < cards.size();i++){
            for (int j = 0;j < cards.size()-1;j++){
                if (cards.get(j).getRank() > cards.get(j+1).getRank()){//if the suit of the jth card is greater
                    Collections.swap(cards,j,j+1);//swap the jth card with the next card
                }
                if(cards.get(j).getRank() == cards.get(j+1).getRank()){//if two cards are of same suit

                    if (cards.get(j).getSuit() > cards.get(j+1).getSuit()){//if the rank of the jth card is greater
                        Collections.swap(cards,j,j+1);//swap the jth card with the next card
                    }
                }
            }
        }
    }

    /** A method print for the class <code>Deck</code>
    * this method takes in no parameters
    * prints the contents of the deck twice
    * first the content is printed by suit
    * second , the content is printed by rank
    * note: should not be called by the main deck during a game
    */

    public void print(){
        System.out.println("Here is your new deck printed in two ways: ");

        this.sortBySuit();//first sort this deck by suit
        System.out.println(cards);//print the deck

        this.sortByRank();//second sort this deck by rank

        System.out.println(cards);//print the deck
    }


    /** A method toString for the class <code>Deck</code>
    * this method takes in no parameters
    * returns a string representation that contains all the cards in deck
    * @return a string repre. of deck
    */

    public String toString(){
        if (!this.hasCards()){
            return "Deck []";
        }
        String s = "";
        for (int i= 0;i<this.size();i++){
            if (i <this.size() - 1 ){
                s += this.get(i)+",";
            }
            else{
                s += this.get(i);

            }
        }
        return "Deck ["+ s+"]";
    }

}
