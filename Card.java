/**
* A data structure to represent a card with a suit and rank.
*
* @author Marcel Turcotte (marcel.turcotte@uottawa.ca)
*/

public class Card {

    // Usefull constants, used in Test.java
    
    public static final int DIAMOND = 0;
    public static final int CLUB = 1;
    public static final int HEART = 2;
    public static final int SPADE = 3;

    // Instance variables
    
    private int suit;
    private int rank;

    /**
    * A constructor that receives the initial values for the suit and the rank.
    *
    * @param suit the initial value for the instance variable suit
    * @param rank the initial value for the instance variable rank
    */

    public Card(int suit, int rank) {

        // pre-condition: suit and rank are valid
        
        this.suit = suit;
        this.rank = rank;
    }

    /**
    * Returns the value of the suit.
    * @return the value of the suit
    */

    public int getSuit() {
        return suit;
    }

    /**
    * Returns the value of the rank.
    * @return the value of the rank
    */

    public int getRank() {
        return rank;
    }

    // Helper method
    
    private String getSuitString() {

        if (true) { // during the debugging phase
            return Integer.toString(suit);
        }

        switch (suit) {
            case DIAMOND:
            return "Diamond";
            case CLUB:
            return "Club";
            case HEART:
            return "Hearth";
            case SPADE:
            return "Spade";
            default:
            return "Error";
        }

    }

    // Helper method

    private String getRankString() {

        if (true) { // during the debugging phase
            return Integer.toString(rank);
        }

        if (rank < 1) {
            return "Error";
        }

        switch (rank) {
            case 1:
            return "Ace";
            case 11:
            return "Jack";
            case 12:
            return "Queen";
            case 13:
            return "King";
            default:
            return Integer.toString(rank);
        }

    }

    /**
    * Overrides the method equals from the class Object. Compares this
    * card to the specified object. The result is true if and only if
    * the argument is not null and is a Card object that has the same
    * suit and rank as this one.
    *
    * @param object The object to compare this card against
    * @return true if the given object represents a Card equivalent to this card, false otherwise
    */

    public boolean equals(Object object) {

        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }

        Card other;
        other = (Card) object;

        return getRank() == other.getRank() && getSuit() == other.getSuit();
    }

    /**
    * Overrides the method toString from the class Object. Returns a
    * string representation for this card.
    *
    * @return a string representation for this card.
    */

    public String toString() {
        // return "Card {suit: "+getSuitString()+", rank: "+getRankString()+"}";
        return "{"+getSuitString()+","+getRankString()+"}";
    }

}
