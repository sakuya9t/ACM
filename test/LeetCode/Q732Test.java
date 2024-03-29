package LeetCode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q732Test {
    @Test
    public void test1() {
        int[][] intvs = {{10,20},{50,60},{10,40},{5,15},{5,10},{25,55}};
        int[] res = {1,1,2,3,3,3};
        run(intvs, res);
    }

    @Test
    public void test2() {
        int[][] intvs = {{28,46},{9,21},{21,39},{37,48},{38,50},{22,39},{45,50},{1,12},{40,50},{31,44}};
        int[] res = {1,1,2,3,4,5,5,5,5,6};
        run(intvs, res);
    }

    @Test
    public void test3() {
        int[][] intvs = {{28,36},{9,16},{71,79},{37,43},{88,94},{22,29},{95,100},{1,7},{40,48},{31,39},{5,12},{92,100},{54,59},{33,41},{2,7},
                {16,25},{57,66},{56,61},{63,68},{88,93},{99,100},{56,65},{5,13},{35,42},{69,74},{46,51},{39,44},{28,36},{78,87},{70,79},{91,99},
                {11,19},{41,46},{78,87},{67,73},{22,31},{4,10},{31,40},{54,62},{69,76},{36,41},{78,84},{40,46},{10,18},{4,11},{75,84},{86,94},
                {32,40},{34,39},{90,99},{8,13},{85,93},{24,29},{10,17},{10,18},{8,17},{1,9},{36,45},{42,50},{92,97},{22,29},{62,67},{70,77},{77,86},
                {74,81},{73,78},{47,52},{73,80},{24,29},{69,75},{69,77},{3,9},{34,41},{22,27},{3,9},{79,88},{34,40},{49,56},{42,48},{43,52}};
        int[] res = {1,1,1,1,1,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,4,4,4,4,4,5,5,5,5,5,5,5,5,5,5,5,6,6,6,6,6,7,7,7,7,7,7,8,8,8,8,8,8,8,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,10,10,10,10,11,11,11,11};
        run(intvs, res);
    }

    @Test
    public void test4() {
        int[][] intvs = {{97,100},{51,65},{27,46},{90,100},{20,32},{15,28},{60,73},{77,91},{67,85},{58,72},{74,93},{73,83},{71,87},{97,100},
        {14,31},{26,37},{66,76},{52,67},{24,43},{6,23},{94,100},{33,44},{30,46},{6,20},{71,87},{49,59},{38,55},{4,17},{46,61},{13,31},{94,100},
        {47,65},{9,25},{4,20},{2,17},{28,42},{26,38},{72,83},{43,61},{18,35}};
        int[] res = {1,1,1,2,2,3,3,3,3,3,3,4,5,5,5,5,5,5,6,6,6,6,6,6,6,6,6,6,6,7,7,7,7,8,9,9,9,9,9,10};
        run(intvs, res);
    }

    @Test
    public void test5() {
        int[][] intvs = {{47,50},{1,10},{27,36},{40,47},{20,27},{15,23},{10,18},{27,36},{17,25},{8,17},{24,33},{23,28},{21,27},{47,50},{14,21},{26,32},{16,21},{2,7},
                {24,33},{6,13},{44,50},{33,39},{30,36},{6,15},{21,27},{49,50},{38,45},{4,12},{46,50},{13,21}};
        int[] res = {1,1,1,1,1,2,2,2,3,3,3,4,5,5,5,5,5,5,6,6,6,6,6,6,7,7,7,7,7,7};
        run(intvs, res);
    }

    private void run(int[][] intvs, int[] res) {
        Q732 q = new Q732();
        for(int i = 0; i < intvs.length; i++) assertEquals(res[i], q.book(intvs[i][0], intvs[i][1]));
    }
}
