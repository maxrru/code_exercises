

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BauernhofTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BauernhofTest
{
    private Bauernhof bauernho1;
    private Pferd pferd1;
    private Kuh kuh1;

    /**
     * Default constructor for test class BauernhofTest
     */
    public BauernhofTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        bauernho1 = new Bauernhof();
        pferd1 = new Pferd("derpy", "mylittlepony", 44, "lebend", "koppel, stall", "Heu", "nutztier, belustigung", 4, 20, "4C", 9, "borstig", "beige", "paarhufer", 90, 5);
        kuh1 = new Kuh("milka", "milkakuh", 7, "lebend", "koppel", "heu", "fleisch, milch", 4, 30, "55F", 9, "glatt", "lila weiss", "einzelhufer", 7, 90, 8);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
