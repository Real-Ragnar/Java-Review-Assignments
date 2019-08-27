import java.util.Random;

/**
 * In our game, each turn begins with the roll of die. In order to
 */

public class Die {

    // a pseudo-random number generator

    private static final Random generator = new Random();

    /**
     * The number of possible values for the die.
     */
    
    public static final int MAXVALUE = 6;

    // Instance variable
    
    private int value;

    /**
     * Initializes this Die.
     */
    
    public Die(){
        roll();
    }

    /**
     * Returns the current value of the die. Does not change the state
     * of the object.
     *
     * @return the current value of the die.
     */

    public int getValue() {
        return value;
    }

    /**
     * Randomly assigns a new value to this die. 
     *
     */

    public void roll() {
        value = generator.nextInt(MAXVALUE)+1;
    }

    /**
     * Overrides the method toString from the class Object. Returns a
     * String representation of the object.
     *
     * @return String representation of this die.
     */

    public String toString() {
        return "Die {value:"+value+"}";
    }

}
