package LeetCode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q1494Test {
    @Test
    public void test1() {
        int n = 12;
        int[][] dependencies = {{1,2},{1,3},{7,5},{7,6},{4,8},{8,9},{9,10},{10,11},{11,12}};
        int k = 2;
        assertEquals(6, new Q1494().minNumberOfSemesters(n, dependencies, k));
    }

    @Test
    public void test2() {
        int n = 4;
        int[][] dependencies = {{2,1},{3,1},{1,4}};
        int k = 2;
        assertEquals(3, new Q1494().minNumberOfSemesters(n, dependencies, k));
    }
}
