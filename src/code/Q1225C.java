package code;

import java.io.*;
import java.util.*;

/**
 * Code-forces Submission Template.
 * Actual solution is in the taskC part.
 * Remove the package declaration when submission which is located in the first line.
 */
public class Q1225C {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(in, out);
        out.close();
    }

    public static class TaskC {
        void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int p = in.nextInt();

            for(int i = 0; ; i++){
                int rem = n - i * p;
                if(rem <= 0) break;

                int bits = Integer.bitCount(rem);
                if(i >= bits && i <= rem){
                    out.println(i);
                    return;
                }
            }
            out.println(-1);
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