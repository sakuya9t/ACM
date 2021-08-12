package LeetCode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q1531Test {
    @Test
    public void test1() {
        assertEquals(2, new Q1531().getLengthOfOptimalCompression("aabbaa", 2));
    }

    @Test
    public void test2() {
        assertEquals(3, new Q1531().getLengthOfOptimalCompression("aaaabbbb", 3));
        assertEquals(4, new Q1531().getLengthOfOptimalCompression("aaabcccd", 2));
    }

    @Test
    public void test3() {
        assertEquals(2, new Q1531().getLengthOfOptimalCompression("aaaaaaaaaaa", 2));
    }

    @Test
    public void test4() {
        assertEquals(4, new Q1531().getLengthOfOptimalCompression("aabaabbcbbbaccc", 6));
    }
}
