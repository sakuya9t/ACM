package kickstart2020F;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class QuestionC {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solver solver = new Solver();
        int testCount = in.nextInt();
        for(int i = 0; i < testCount; i++) {
            solver.run(i+1, in, out);
        }
        out.close();
    }

    public static class Solver {
        void run(int testNumber, InputReader in, PrintWriter out) {
            int[] posA = new int[2], posB = new int[2];
            int S = in.nextInt();
            posA[0] = in.nextInt();
            posA[1] = in.nextInt();
            posB[0] = in.nextInt();
            posB[1] = in.nextInt();
            int C = in.nextInt();
            int[][] construction = new int[C][2];
            for(int i = 0; i < C; i++) {
                construction[i][0] = in.nextInt();
                construction[i][1] = in.nextInt();
            }

            out.println(String.format("Case #%s: %s", testNumber, solve(S, posA, posB, construction)));
        }

        private int solve(int side, int[] posA, int[] posB, int[][] construction) {
            return 0;
        }
    }

    public static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
