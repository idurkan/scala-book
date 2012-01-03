package funcObjects;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;

/**
 * Created by IntelliJ IDEA.
 * User: idurkan
 * Date: 1/2/12
 * Time: 8:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class RationalTest {
    @Test
    public void testEquals() {
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(1, 2);

        assertEquals(r1, r2);

        Rational r3 = new Rational(3, 4);
        Rational r4 = new Rational(3, 4);

        assertEquals(r3, r4);

        Rational r5 = new Rational(3, 4);
        Rational r6 = new Rational(4, 3);

        assertFalse(r5.equals(r6));

        assertFalse(r5.equals(null));
    }

    @Test
    public void testAdd() {
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(3, 4);

        Rational result = r1.add(r2);

        assertEquals(new Rational(10, 8), result);
    }

    @Test
    public void testToString() {
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(3, 4);
        Rational r3 = new Rational(3, 1);

        assertEquals("1/2", r1.toString());
        assertEquals("3/4", r2.toString());
        assertEquals("3", r3.toString());
    }
}
