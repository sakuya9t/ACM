package code;

import java.io.*;
import java.util.*;

/**
 * Code-forces Submission Template.
 * Actual solution is in the taskC part.
 * Remove the package declaration when submission which is located in the first line.
 */
public class Q1225B {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        int testNumber = in.nextInt();
        for(int i = 0; i < testNumber; i++)
            solver.solve(in, out);
        out.close();
    }

    public static class TaskC {

        void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int k = in.nextInt();
            int d = in.nextInt();
            Queue<Integer> queue = new LinkedList<>();
            Map<Integer, Integer> count = new HashMap<>();
            int min = d;
            for(int i = 0; i < d; i++){
                int p = in.nextInt();
                queue.offer(p);
                count.put(p, count.getOrDefault(p, 0) + 1);
            }
            min = Math.min(min, count.size());
            for(int i = d; i < n; i++){
                int p = in.nextInt();
                queue.offer(p);
                int r = queue.poll();
                count.put(r, count.getOrDefault(r, 0) - 1);
                if(count.get(r) <= 0) count.remove(r);
                count.put(p, count.getOrDefault(p, 0) + 1);
                min = Math.min(min, count.size());
            }

            int res = min;

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