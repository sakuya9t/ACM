package CodeForces;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Code-forces Submission Template.
 * Actual solution is in the taskC part.
 * Remove the package declaration when submission which is located in the first line.
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    public static class TaskC {

        void solve(int testNumber, InputReader in, PrintWriter out) {
            int inputNum = in.nextInt();
            String inputStr = in.next();
            System.out.println(testNumber);
            System.out.println(inputNum);
            System.out.println(inputStr);
            int res = 0;

            out.println(res);
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