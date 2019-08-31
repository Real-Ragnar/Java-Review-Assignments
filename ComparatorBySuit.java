import java.util.Comparator;

/**
 * Implements a java.util.Comparator, used by Collections.sort. Sorts
 * by suit, then by rank. The visibiity of the class is package.
 * 
 * @author Marcel Turcotte (marcel.turcotte@uottawa.ca)
 */

class ComparatorBySuit implements Comparator<Card> {

    /**
     * Compares two cards for order order. Returns a negative integer,
     * zero, or a positive integer as the first card is less than,
     * equal to, or greater than the other card.
     *
     * @param a one of the two cards
     * @param b one of the two cards
     * @return a ternary result for the comparison of two cards
     */
    
    public int compare(Card a, Card b) {

        if (a.getSuit() < b.getSuit()) {
            return -1;
        }

        if (a.getSuit() == b.getSuit()) {
            if (a.getRank() < b.getRank()) {
                return -1;
            } else if (a.getRank() == b.getRank()) {
                return 0;
            } else {
                return 1;
            }
        }

        return 1;

    }

}
