import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuadraticEquationTest {

    @Test
    public void twoRootsTest() {
        QuadraticEquation eq = new QuadraticEquation(2, -11, 5);
        assertTrue(eq.hasRoots());
        assertFalse(eq.sameRoots());
        assertEquals(5, eq.firstRoot(), QuadraticEquation.PRECISION);
        assertEquals(0.5, eq.secondRoot(), QuadraticEquation.PRECISION);
        System.out.println(eq);

    }

    @Test
    public void equalRootsTest() {
        QuadraticEquation eq = new QuadraticEquation(-4, 12, -9);
        assertTrue(eq.hasRoots());
        assertTrue(eq.sameRoots());
        assertEquals(1.5, eq.firstRoot(), QuadraticEquation.PRECISION);
        System.out.println(eq);

    }

    @Test
    public void noRootTest() {
        QuadraticEquation eq = new QuadraticEquation(1, -3, 4);
        System.out.println(eq);

    }

    @Test
    public void noRootsTest() {
        QuadraticEquation eq = new QuadraticEquation(1, -3, 4);
        assertFalse(eq.hasRoots());
        System.out.println(eq);

    }

}