package LeetCode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q1000Test {
    @Test
    public void testExample1() {
        assertEquals(20, new Q1000().mergeStones(new int[]{3, 2, 4, 1}, 2));
    }

    @Test
    public void testExample2() {
        assertEquals(-1, new Q1000().mergeStones(new int[]{3, 2, 4, 1}, 3));
    }

    @Test
    public void testExample3() {
        assertEquals(25, new Q1000().mergeStones(new int[]{3, 5, 1, 2, 6}, 3));
    }

    @Test
    public void testExample4() {
        assertEquals(919, new Q1000().mergeStones(new int[]{25,68,35,62,52,57,35,83,40,51,30,20,51}, 7));
    }
}
