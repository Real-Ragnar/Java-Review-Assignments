/** Runs all the tests using a textual runner.  This is the
 */

import junit.framework.Assert;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.rules.Timeout;
import org.junit.Rule;

public class DieJUnitTest extends TestCase {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested

    public void testGetValueIsValid() {

        Die d;
        int[] counts;

        d = new Die();
        counts = new int[6];

        for (int i=0; i<1000; i++) {
            int value;
            value = d.getValue();
            if (value < 1 || value > 6) {
                fail("not a valid value: " + Integer.toString(value));
            }
            counts[value-1] = counts[value-1] + 1;
            d.roll();
        }

    }

    public void testGetValueLoaded() {

        Die d;
        int[] counts;

        d = new Die();
        counts = new int[6];

        for (int i=0; i<1000; i++) {
            int value;
            value = d.getValue();
            if (value >= 1 || value <= 6) {
                counts[value-1] = counts[value-1] + 1;
            }
            d.roll();
        }

        for (int i=0; i<counts.length; i++) {
            if (counts[i] == 0) {
                fail("loaded die? ");
            }
        }

    }

    public void testValueIsNotStatic() {

        Die d1, d2;
        boolean conclusion;
        int count = 0;

        d1 = new Die();
        d2 = new Die();

        conclusion = d1.getValue() != d2.getValue();

        while (! conclusion) {
            d2.roll();
            count++;
            conclusion = d1.getValue() != d2.getValue();
            if (count == 1000) {
                fail("static variable?");
            }
        }

    }

    public void testToString() {

        Die d;
        String defaultStr;

        d = new Die();
        defaultStr = d.getClass().getName() + '@' + Integer.toHexString(d.hashCode());

        assertFalse( "does not override toString?", defaultStr.equals(d.toString()) );

    }


    /**
     * Runs the test suite using the textual runner.
     *
     * @param args reference to the array of values passed on the command line
     */

    public static void main( String[] args ) {
        TestSuite suite = new TestSuite();
        suite.addTestSuite( DieJUnitTest.class );
        junit.textui.TestRunner.run( suite );
    }

}
