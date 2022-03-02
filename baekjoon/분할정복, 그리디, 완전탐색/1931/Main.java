import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static Point[] points;
    static int N;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\evergreen\\Documents\\hello-spring\\untitled\\src\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        points = new Point[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i] = new Point(Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()));
        }
        Arrays.sort(points);
        long res = 0;
        long finish = 0;
        for (int i = 0; i < N; i++) {
            long start = points[i].start;
            long end = points[i].end;
            if(start >= finish){
                finish = end;
                res++;
            }
        }
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }

}
class Point implements Comparable<Point>{
    long start;
    long end;
    public Point(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Point o) {
        int res = Long.compare(end,o.end);
        if(res == 0){
            return Long.compare(start,o.start);
        }else{
            return res;
        }
    }
}
