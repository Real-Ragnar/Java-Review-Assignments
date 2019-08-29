

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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
        return (cards.size() >0);
    }

    public Card get(int pos)
    {
        return cards.get(pos);      //get is a method of arraylists
    }

    /**
     * add method first ensures that there is sufficient space in the arraylist.
     * If list does not have space, then it grows the list by adding more spaces in underlying array.
     * Then it add the element to specific array index.
     * @param card
     */
    public void add(Card card)
    {
        cards.add(card);
    }

    /**
     * void addAll(Deck other): appends all the cards from other at the end of this deck. The cards are also removed from
     * other. Consequently, the deck designated by other is empty after the call.
     * @param other
     */
    public void addAll(Deck other)
    {
        for(int i = 0; i<other.size();i++)
        {
            cards.add(other.get(i));
            other.removeFirst();              //will remove the first card from object other, then the second card becomes the new first
        }
    }

    /**
     *  Card removeLast(): removes and returns the last card of this deck.
     * @return
     */
    public Card removeLast()
    {
        Card last = cards.get(cards.size() -1);
        cards.remove(cards.size() -1);
        return last;
    }

    /**
     * Card removeFirst(): removes and returns the first card of this deck.
     * @return
     */
    public Card removeFirst()
    {
        Card first = cards.get(0);
        cards.remove(0);
        return first;
    }

    /**
     * boolean remove(Card card): removes the first occurrence of the specified card from this deck, if it is present. Returns
     * true if and only if this deck contains the specified card.
     * @param card
     * @return
     */
    public boolean remove(Card card)
    {
        if(cards.remove(card))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     *  void removeAll(Deck other): removes from this deck all of its cards that are contained in the deck designated by the
     *  parameter other. The cards are not removed from the deck designated by other.
     * @param other
     */
    public void removeAll(Deck other)
    {
        for(int i=0; i<cards.size(); i++)
        {
            for(int j=0; j<other.size(); j++)
            {
                if(cards.get(i) == other.get(j))
                {
                    cards.remove(i);
                }
            }
        }
    }

    /**
     * void shuffle(): randomly permutes the cards.
     *===================================================================================================================
     */
    public void shuffle()
    {
        int value = 0;
        Random rand = new Random();
        for(int i=0; i<cards.size(); i++)
        {
            value = rand.nextInt(cards.size());    //random index from 0 to size-1
            Card insert = cards.get(value);         //obtaining the card at index, value

            cards.add(i, insert);                   //adding insert to the deck at index, i
        }

    }

    /**
     * Deck deal(int n): removes a maximum of n cards from the end of this deck. The cards are returned in a new deck.
     */
    public Deck deal(int n)
    {
        Deck otherCards = new Deck();                   //empty deck
        for(int i=cards.size()-1;i>=n; i--)
        {
            otherCards.add(cards.get(i);
            cards.remove(i);
        }
        return otherCards;
    }

    //boolean contains(Card card): returns true if and only if this deck contains the specified card.
    public boolean contains(Card card)
    {
        
    }

    //boolean containsAll(Deck other): returns trueif and only if this deck contains all the cards in the specified deck.

    /* boolean isKind(): returns true if and only if this deck is a discardable kind. Specifically, the method returns true if this
        deck has at least two cards and all the cards have the same rank. Otherwise, the method returns false.
     */

    /* boolean isSeq(): returns true if and only if this deck is a discardable sequence. Specifically, the method returns true
            if this deck has at least three cards, the cards all have the same suit, the cards form a sequence of consecutive ranks.
            Otherwise, the method returns false.
     */

    //void sortBySuit(): sorts the cards of this deck by suit.

    //void sortByRank(): sorts the cards of this deck by rank.

    /*void print(): prints the content of this deck in two ways. First, the content is printed by suit. Next, the content is printed
    by rank. Please note that this method has a side effect, the order of the cards is not preserved. Consequently, the method
    should not be called on the main deck during a game!
     */

    //String toString(): returns a string representation that contains all the cards in this deck.





}
