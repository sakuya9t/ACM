package kickstart2020F;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class QuestionB {
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
            int K = in.nextInt();
            int[][] intvs = new int[N][2];
            for(int i = 0; i < N; i++) {
                intvs[i][0] = in.nextInt();
                intvs[i][1] = in.nextInt();
            }

            Arrays.sort(intvs, Comparator.comparingInt(a -> a[0]));

            int res = 0, start = 0;
            for(int[] intv: intvs) {
                int s = Math.max(start, intv[0]);
                if(s >= intv[1]) continue;

                int needed = (int)(Math.ceil(1.0 * (intv[1] - s) / K));
                res += needed;
                start = s + needed * K;
            }

            out.println(String.format("Case #%s: %s", testNumber, res));
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
