package kickstart2020F;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class QuestionA {
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
            int X = in.nextInt();
            int[] A = new int[N];
            for(int i = 0; i < N; i++) A[i] = in.nextInt();

            int[][] arr = new int[N][3];
            for(int i = 0; i < N; i++) {
                arr[i][0] = i + 1; // personId
                arr[i][1] = (int)Math.ceil(1.0 * A[i] / X);
            }

            Arrays.sort(arr, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
            StringBuilder res = new StringBuilder(String.format("Case #%s: ", testNumber));
            for(int[] r: arr) res.append(r[0]).append(" ");
            out.println(res.toString());
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
