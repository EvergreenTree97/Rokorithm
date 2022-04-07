import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        input = new int[3];
        input[0] = Integer.parseInt(st.nextToken());
        input[1] = Integer.parseInt(st.nextToken());
        input[2] = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        boolean[][][] visit = new boolean[input[0] + 1][input[1] + 1][input[2] + 1];
        visit[0][0][input[2]] = true;
        set.add(input[2]);
        q.offer(new int[] { 0, 0, input[2] });

        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (now[0] == 0) {
                set.add(now[2]);
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j)
                        continue;
                    int[] next = solve(now, i, j);
                    if (!visit[next[0]][next[1]][next[2]]) {
                        visit[next[0]][next[1]][next[2]] = true;
                        q.offer(next);
                    }
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>(set);
        Collections.sort(ans);
        StringBuilder sb = new StringBuilder();
        for (Integer i : ans) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    private static int[] solve(int[] now, int i, int j) {
        if (now[i] == 0 || now[j] == input[j]) {
            return now;
        }

        // from i to j;
        int[] next = now.clone();
        int tmp = input[j] - next[j];
        if (next[i] > tmp) {
            next[j] += tmp;
            next[i] -= tmp;
        } else {
            next[j] += next[i];
            next[i] = 0;
        }

        return next;
    }
}