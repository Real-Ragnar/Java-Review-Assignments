import java.util.Comparator;

/**
 * Implements a java.util.Comparator, used by Collections.sort. Sorts
 * by rank, then by suit. The visibiity of the class is package.
 * 
 * @author Marcel Turcotte (marcel.turcotte@uottawa.ca)
 */

class ComparatorByRank implements Comparator<Card> {

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

        // pre-condition: a != null && b != null

        int result;

        if (a.getRank() < b.getRank()) {
            result = -1;
        } else if (a.getRank() == b.getRank()) {
            if (a.getSuit() < b.getSuit()) {
                result = -1;
            } else if (a.getSuit() == b.getSuit()) {
                result = 0;
            } else {
                result = 1;
            }
        } else {
            result = 1;
        }
        
        return result;

    }

}
