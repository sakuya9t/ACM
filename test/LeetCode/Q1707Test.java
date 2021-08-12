package LeetCode;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Q1707Test {
    @Test
    public void testCase1() {
        assertArrayEquals(new int[]{3, 3, 7}, new Q1707().maximizeXor(new int[]{0, 1, 2, 3, 4}, new int[][]{{3, 1}, {1, 3}, {5, 6}}));
    }

    @Test
    public void testCase2() {
        assertArrayEquals(new int[]{15, -1, 5}, new Q1707().maximizeXor(new int[]{5, 2, 4, 6, 6, 3}, new int[][]{{12, 4}, {8, 1}, {6, 3}}));
    }

    @Test
    public void testCase3() {
        assertArrayEquals(new int[]{1050219420,844498962,540190212,539622516,330170208},
                new Q1707().maximizeXor(new int[]{536870912,0,534710168,330218644,142254206},
                        new int[][]{{558240772,1000000000},{307628050,1000000000},{3319300,1000000000},{2751604,683297522},{214004,404207941}}));
    }

    @Test
    public void testCase4() {
        assertArrayEquals(new int[]{724120607,392309553,724485719,986546901,4703462},
                new Q1707().maximizeXor(new int[]{276205656,724382751,7152398,30269155,16818044},
                        new int[][]{{262144,1000000000},{118799209,548332365},{258632,1000000000},{299939530,1000000000},{2811880,10369929}}));
    }
}
