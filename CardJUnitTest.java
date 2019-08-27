/** Runs all the tests using a textual runner.  This is the
 */

import junit.framework.Assert;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.rules.Timeout;
import org.junit.Rule;

public class CardJUnitTest extends TestCase {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested

    public static void testGetSuit() {

        Card a;
        a = new Card(2, 7);
        assertEquals(2, a.getSuit());

    }

    public static void testGetSuitNotStatic() {

        Card a, b;
        a = new Card(2, 7);
        b = new Card(3, 7);
        assertEquals(2, a.getSuit());

    }

    public static void testGetRank() {

        Card a;
        a = new Card(2, 7);
        assertEquals(7, a.getRank());

    }

    public static void testGetRankNotStatic() {

        Card a, b;
        a = new Card(1, 2);
        b = new Card(3, 4);
        assertEquals(2, a.getRank());

    }

    public static void testEquals() {

        Card a, b;

        a = new Card(2, 7);
        b = new Card(2, 7);

        assertEquals(true, a.equals(b));

    }

    public static void testSuitEqualsButNotRank() {

        Card a, b;

        a = new Card(2, 7);
        b = new Card(3, 7);

        assertEquals(a.equals(b), false);

    }

    public static void testRankEqualsButNotSuit() {

        Card a, b;

        a = new Card(2, 7);
        b = new Card(3, 7);

        assertEquals(a.equals(b), false);

    }

    public static void testNotEquals() {

        Card a, b;

        a = new Card(2, 6);
        b = new Card(3, 7);

        assertEquals(a.equals(b), false);

    }

    public static void testNotEqualsNotACard() {

        Card a;

        a = new Card(2, 6);

        assertEquals(a.equals("Oups!"), false);

    }
    
    public static void testNotEqualsNull() {

        Card a;

        a = new Card(2, 6);

        assertEquals(a.equals(null), false);

    }
    
    /**
     * Runs the test suite using the textual runner.
     *
     * @param args reference to the array of values passed on the command line
     */

    public static void main( String[] args ) {
        TestSuite suite = new TestSuite();
        suite.addTestSuite( CardJUnitTest.class );
        junit.textui.TestRunner.run( suite );
    }

}
