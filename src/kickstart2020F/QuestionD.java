package kickstart2020F;

import java.io.*;
import java.util.StringTokenizer;

public class QuestionD {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        int testCount = in.nextInt();
        for(int i = 0; i < testCount; i++) {
            solver.solve(i+1, in, out);
        }
        out.close();
    }

    public static class TaskC {

        void solve(int testNumber, InputReader in, PrintWriter out) {
            int N = in.nextInt();
            int M = in.nextInt();
            int K = in.nextInt();

            double[][] dp = new double[N][N+1];
            dp[0][1] = 1.0;
            for(int i = 0; i < N-1; i++) {
                for(int j = 1; j < N; j++) {
                    dp[i+1][j] += dp[i][j] * Math.min(1.0, 1.0 * j / M);
                    dp[i+1][j+1] += dp[i][j] * Math.max(0.0, 1.0 * (M-j) / M);
                }
            }

            out.println(String.format("Case #%s: %s", testNumber, 1.0 / dp[N-1][K]));
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
