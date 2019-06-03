//Author : Yanbing Ren, Jacob King
//Student number : 300059013,300082223
//Course: ITI1121 - B
//Assignment : 1
//Qustion: 2.3 Deck


/**

this is class <code>Game</code>
it runs rummy's card game
*/

public class Game{


	private Deck main,hand; // Declare Deck objects main and hand.

	private Die die; // Declare Die object die.

	private int round,dieValue; // Declare int variables round, dieValue


	/**
	* A constructor for the class Game.
    * It intalizes the main hand of playing cards using the Deck class, along with the players hand.
    * It also intalizes the die to the Die class
	*
	* @param rank accept an int of rank, the amount of ranks to play with.
	*/
	public Game(int rank){
		main = new Deck(rank); // Create a new Deck object
		hand = new Deck(); // Create a new Deck object

		die = new Die(); // Create a new Die object

	}

	/**
	* A run method for the class game.
    * This method deals with the functions of the game.
	* It deals the players and with seven cards from the end of main and prints the players hand
	* sorted by rank and by then by suit.
	* The function roles the die, if the die is anything but the value
	* of one, then n amount of cards get added to the playrs hand and removed from the last values of main.
	* then the player is asked to remove any 3+ sequence of cards or 2+ of a kind.
	* The player enters ether of the two, and the program checks what type of meld it is
	* and if its in the deck. if it is found then the program removes the cards,
	* if not found it notifys the user and does nothing.
	* If a one is rolled then the user is asked to discard any one card.
	* the die keeps being rolled after the selected deletion of cards.
	* if there are no more cards in the main deck then a one is rolled each time to allow the user to remove
	* remaing cards untill no more cards remain in the player hands.
	* A winning output is printed displaying the amount of rounds (ie rolls) it took the player to finish.
	*/
	public void play(){

		main.shuffle(); // Shuffle the deck.

		hand.addAll(main.deal(7)); // Deal 7 cards (from the end of main) to the players hand.

		round = 0; // Intalize/reset the round counter as 0

		// While the player still has cards in their hand.
		while (hand.hasCards() ){

			round ++; // Increase round by one.

			hand.print(); // Print the hand in two ways.

			// If there is cards in the main deck.
			if(main.hasCards()){

			System.out.println("Rolling the die!"); // Output to the user that the die is being rolled.

			die.roll(); // Roll the dice

			dieValue = die.getValue(); // Get value of die from the Die class and store it in dieValue.
			}

			// Else if the player has no more melds in their hand , set the die to 0.
			else{
				dieValue = 1; // Set the dieValue to 1 if the main deck is out of cards.
			}

			System.out.println("The die has value "+dieValue); // Output to the user the value of the die

			// If dieValue is one.
			if(dieValue == 1){

				// Output the users hand in two ways.
				while (hand.hasCards()){

					System.out.println("Discard any card of your choosing."); // Output to the user to discard any card.

					System.out.println("Which card would you like to discard?"); // Output to the user what card to discard.

					Card c = Utils.readCard(); // Use the scanner class in the class Utils and set it to object of Card.

					// If the users hand contains object of Cards c.

					if (hand.contains(c)){

						hand.remove(c);//remove object c from user hand.
						break;
						
					}

					// Else if the users hand does not contain object of Cards c.
					else{

						System.out.println("Cannot discard this card!"); // Output to the user that the cards can not be discarded.
					}
				}
			}

			// Else if dieValue is not one.
			else{

				System.out.println("Adding (up to) "+dieValue+" cards to your hand."); // Output to the user the amount of cards that will be added to their hand.

				// If the dieValue is greater then the amount of card in the main deck.
				if (dieValue >= main.size()){

					hand.addAll(main.deal(main.size()));} // Deal the remaing amount of card in the deck main to the users hand.

				// Else if the dieValue is not greater then the amount of card in the main deck.
				else{

					hand.addAll(main.deal(dieValue)); // Deal the dieValue of cards to the users hand from main
				}

				hand.print(); // Print the hand in two ways.

				// Get input from user true/false(yes/no)
				boolean input = Utils.readYesOrNo("Do you  have a sequences of three or more cards of the same suit or two or more of a kind?"); // Use the scanner class in the class Utils to ask if the user has a meld.

				// While the imput is true.
				while(input){

					// Read a set of cards from user
					Deck meld = Utils.readCards("Which 3+ sequence or 2+ of a kind would you like to discard?"); // Use the scanner class in the class Utils and set it to an object of Cards.

					// If the Meld is a kind, or a sequence and the users hand contains all.
					if ((meld.isSeq() || meld.isKind()) && hand.containsAll(meld)){

						hand.removeAll(meld); // Discard the meld from the users hand.
						hand.print(); // Print the hand in two ways.
					}

					// Else if the cards are not found in the hand or is not a sequence or kind.
					else{

						System.out.println("Cannot discard those cards!"); // Output to the user that the cards can not be discarded.
					}

					// Keep asking the user if they have a sequence or kinds.
					input = hand.hasCards() && Utils.readYesOrNo("Do you  have a sequences of three or more cards of the same suit or two or more of a kind?");
				}
			}
		}

	System.out.println("Congratulations! Game completed in "+round+" rounds!!!"); // Once no cards are left, output to the user that they won in n rounds.
	}
}
