/**
 * The class Game implements the logic of the single player game of Rummy.
 * • An object of the class Game has two decks of cards, one is the main deck, whereas the second one represents the player’s
 * hand. An object of the class Game also has a die (reference to an object of the class Die).
 * • The class declares one constructor. This constructor has one parameter, which specifies the number of ranks for this
 * game. When a Game object is created, it also creates the main deck and the die.
 * • A Game object has only one public instance method, which is called play. The method implements the logic of the
 * game.
 */

public class Game {
    Deck mainDeck, playerHand;      //each object contains multiple card objects
    Die die;
    Utils util;
    public Game(int ranks)
    {
        mainDeck = new Deck(10);
        playerHand = new Deck();
        die = new Die();
        util = new Utils();
    }

    public void play()
    {
        mainDeck.shuffle();
        playerHand = mainDeck.deal(7);

        while(playerHand.size() >0)
        {
            die.roll();
            Card chosenCard;
            if(die.getValue() == 1)                                 //player discards any card he/she wants
            {
                boolean cardExists=false;
                chosenCard = util.readCard();
                while(!cardExists) {
                    if (playerHand.contains(chosenCard)) {
                        playerHand.remove(chosenCard);
                        cardExists = true;
                    } else {
                        System.out.println("Card not in hand, choose another ");
                        chosenCard = util.readCard();
                        cardExists=false;
                    }
                }

            }
            else                                                    //die rolled 2,3,4,5,6
            {
                if(die.getValue() < mainDeck.size())
                {
                    playerHand.add(mainDeck.deal(die.getValue()));      //dealing number of cards to player hand
                }
                else                                                    //deck size is smaller than die roll value, then deal entire deck
                {
                    playerHand.add(mainDeck.deal(mainDeck.size()));
                }
                System.out.println("Do you have any melds? ");
                if(util.readYesOrNo()==true)
                {

                }
            }

        }
    }

    public static void main(String[] args)
    {

    }

}
