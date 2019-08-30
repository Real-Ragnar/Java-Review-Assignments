

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

    /**
     *
     * @param pos
     * @return card a specified position
     */
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
     *  "cards" is an object of arraylist class and it contains many cards
     */
    public void shuffle()
    {
        Collections.shuffle(cards);
    }

    /**
     * Deck deal(int n): removes a maximum of n cards from the end of this deck. The cards are returned in a new deck.
     */
    public Deck deal(int n)
    {
        Deck otherCards = new Deck();                   //empty deck
        while(n>0 && cards.size()>0)
        {
            otherCards.add(cards.remove(cards.size()-1));       //remove method returns the card at specified index
            n--;
        }
        return otherCards;
    }

    //boolean contains(Card card): returns true if and only if this deck contains the specified card.
    public boolean contains(Card card)
    {
        return cards.contains(card);
    }

    //boolean containsAll(Deck other): returns true if and only if this deck contains all the cards in the specified deck.
    public boolean containsAll(Deck other)
    {
        boolean valid = true;
        for(int i=0; i<other.size();i++)
        {
            if(!(cards.contains(other.get(i))))
            {
                valid = false;
            }
        }
        return valid;
    }

    /* boolean isKind(): returns true if and only if this deck is a discardable kind. Specifically, the method returns true if this
        deck has at least two cards and all the cards have the same rank. Otherwise, the method returns false.
     */
    public boolean isKind()
    {
        boolean valid = true;
        if(cards.size() >=2) {
            for (int i = 0; i < cards.size(); i++) {
                if (!(cards.get(0).getRank() == cards.get(i).getRank()))        //compare the first cards rank to the others....
                {
                    valid = false;
                }
            }
        }
        return valid;
    }

    /* boolean isSeq(): returns true if and only if this deck is a discardable sequence. Specifically, the method returns true
            if this deck has at least three cards, the cards all have the same suit, the cards form a sequence of consecutive ranks.
            Otherwise, the method returns false.
     */
    public boolean isSeq()
    {

        if (cards.size() < 3) {
            return false;
        }

        sortByRank();

        for (int i=1; i<cards.size(); i++) {

            Card a, b;

            a = cards.get(i-1);
            b = cards.get(i);

            if (a.getSuit() != b.getSuit()) {
                return false;
            }

            if (a.getRank()+1 != b.getRank()) {
                return false;
            }

        }

        return true;
    }

    /**
     *  void sortBySuit(): sorts the cards of this deck by suit.
     *  DIAMOND, CLUB, HEART, SPADE
     */
    public void sortBySuit()
    {
        ArrayList<Card> tempCards = new ArrayList<Card>();
        for(int j=0; j<4; j++) {
            for (int i = 0; i < cards.size(); i++) {
                if (cards.get(i).getSuit() == 0)           //diamond
                {
                    tempCards.add(cards.get(i));
                }
                else if (cards.get(i).getSuit() == 1)           //club
                {
                    tempCards.add(cards.get(i));
                }
                else if (cards.get(i).getSuit() == 2)           //heart
                {
                    tempCards.add(cards.get(i));
                }
                else if (cards.get(i).getSuit() == 3)           //spade
                {
                    tempCards.add(cards.get(i));
                }
            }
        }
        cards = tempCards;
    }


    //void sortByRank(): sorts the cards of this deck by rank.
    public void sortByRank()
    {
        ArrayList<Card> tempCards = new ArrayList<Card>();
        for(int i=0; i<cards.size(); i++)
        {
            for(int j=0; j<cards.size(); j++)
            {
                if(cards.get(j).getRank() == i)
                {
                    tempCards.add(cards.get(j));
                }
            }
        }
        cards=tempCards;

    }

    /*void print(): prints the content of this deck in two ways. First, the content is printed by suit. Next, the content is printed
    by rank. Please note that this method has a side effect, the order of the cards is not preserved. Consequently, the method
    should not be called on the main deck during a game!
     */
    public void print()
    {
        sortBySuit();
        for(int i=0; i<cards.size(); i++)
        {
            System.out.println(cards.get(i));
        }

        sortByRank();
        for(int j=0; j<cards.size(); j++)
        {
            System.out.println(cards.get(j));
        }
    }

    //String toString(): returns a string representation that contains all the cards in this deck.
    public String toString()
    {
        String out;
        out = "Deck [";

        for (int i=0; i<cards.size(); i++) {
            if (i>0) {
                out = out + ",";
            }
            out = out + cards.get(i);
        }

        out = out + "]";

        return out;
    }




}
