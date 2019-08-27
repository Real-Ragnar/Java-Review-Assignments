

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    // Uses an object of the class ArrayList to store cards

    private ArrayList<Card> cards;

    /**
     * Used when creating an empty deck.
     */

    public Deck() {
        cards = new ArrayList<Card>();
    }

    /**
     * The parameter speciﬁes the number of ranks for the cards. The
     * constructor initializes this deck to contain 4 × range cards, where
     * range is the value of the parameter.
     *
     * @param range the number of values for range
     */

    public Deck(int range) {

        // pre-condition: range is a valid value

        this(); // calls the constructor with no parameters

        for (int suit=0; suit<4; suit++) {
            for (int rank=1; rank<=range; rank++) {
                cards.add(new Card(suit, rank));
            }
        }

    }

    /**
     * Returns the number of cards in this deck.
     *
     * @return the number of cards in this deck.
     */

    public int size() {
        return cards.size();
    }

    public boolean hasCards()
    {
        if
    }
}
