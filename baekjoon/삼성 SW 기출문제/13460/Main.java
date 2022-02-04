import java.awt.*;
import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 미로찾기이므로 bfs 사용 */
/* 이미 갔던 경로에 이동하지 않기 위해 visited[][] 사용 */
public class Main {
    static int dx[] = {-1, 0 ,1 ,0};
    static int dy[] = {0, -1, 0, 1};
    static boolean visited[][];
    static char map[][];
    static int N, M;
    static int max;
    static Bead hole, red, blue;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\evergreen\\Documents\\hello-spring\\untitled\\src\\input.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[M][N];
        visited = new boolean[M][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[j][i] = s.charAt(j);
                if(map[j][i] == 'B') blue = new Bead(j,i,'B',0);
                else if(map[j][i] == 'R') red = new Bead(j,i,'R',0);
                else if(map[j][i] == 'O') hole = new Bead(j,i,'O',10);
            }
        }
        bw.write(String.valueOf(bfs()));
        bw.flush();
        bw.close();
    }
    static int bfs() {
        Queue<Bead> redQueue = new LinkedList<>();
        Queue<Bead> blueQueue = new LinkedList<>();
        redQueue.offer(red); blueQueue.offer(blue);
        while (!redQueue.isEmpty() && !blueQueue.isEmpty()){
            //1. 체크인
            Bead r = redQueue.poll();
            Bead b = blueQueue.poll();

            //2. 목적지인가?
            if(map[r.x][r.y] == 'O' && map[b.x][b.y] =='O'){ //동시에 도착하는 경우
                max = -1;
                continue;
            }else if(map[r.x][r.y] == 'O' && r.count <= 10){ //R만 도착하는 경우
                return b.count;
            }else if(map[b.x][b.y] == 'O'){ //blue가 먼저 도착하는 경우
                max= -1;
                continue;
            }
            else if(r.count > hole.count) return max = -1; //카운트가 초과된 경우

            //3. 연결된 곳 순회
            for(int i = 0 ; i < 4; i++){
                Bead red, blue;
                switch (i){
                    case 0: //왼쪽으로 이동할 떄
                        if(r.x < b.x){ //빨간구슬이 왼쪽이면 빨간 구슬 먼저 이동
                            if(!moveAvailable(r.x,r.y,dx[i],dy[i],b.x,b.y,r.color) &&
                                    !moveAvailable(b.x,b.y,dx[i],dy[i],r.x,r.y,b.color)) continue;
                            red = moveBead(r.x,r.y,dx[i],dy[i],r.count,r.color,b.x,b.y);
                            blue = moveBead(b.x,b.y,dx[i],dy[i],b.count,b.color,red.x,red.y);
                        }else{ //파란 구슬이 왼쪽이면 파란 구슬 왼쪽으로 이동
                            if(!moveAvailable(r.x,r.y,dx[i],dy[i],b.x,b.y,r.color) &&
                                    !moveAvailable(b.x,b.y,dx[i],dy[i],r.x,r.y,b.color)) continue;
                            blue = moveBead(b.x,b.y,dx[i],dy[i],b.count,b.color,r.x,r.y);
                            red = moveBead(r.x,r.y,dx[i],dy[i],r.count,r.color,blue.x, blue.y);
                        }
                        break;
                    case 1: //위쪽 구슬이 먼저
                        if(r.y < b.y){ //빨간구슬 먼저
                            if(!moveAvailable(r.x,r.y,dx[i],dy[i],b.x,b.y,r.color) &&
                                    !moveAvailable(b.x,b.y,dx[i],dy[i],r.x,r.y,b.color)) continue;
                            red = moveBead(r.x,r.y,dx[i],dy[i],r.count,r.color,b.x,b.y);
                            blue = moveBead(b.x,b.y,dx[i],dy[i],b.count,b.color,red.x,red.y);
                        }else{ //파란 구슬 먼저
                            if(!moveAvailable(r.x,r.y,dx[i],dy[i],b.x,b.y,r.color) &&
                                    !moveAvailable(b.x,b.y,dx[i],dy[i],r.x,r.y,b.color)) continue;
                            blue = moveBead(b.x,b.y,dx[i],dy[i],b.count,b.color,r.x,r.y);
                            red = moveBead(r.x,r.y,dx[i],dy[i],r.count,r.color,blue.x, blue.y);
                        }
                        break;
                    case 2: //오른쪽 구슬이 먼저
                        if(r.x > b.x){ //빨간구슬 먼저
                            if(!moveAvailable(r.x,r.y,dx[i],dy[i],b.x,b.y,r.color) &&
                                    !moveAvailable(b.x,b.y,dx[i],dy[i],r.x,r.y,b.color)) continue;
                            red = moveBead(r.x,r.y,dx[i],dy[i],r.count,r.color,b.x,b.y);
                            blue = moveBead(b.x,b.y,dx[i],dy[i],b.count,b.color,red.x,red.y);
                        }else{ //파란 구슬 먼저
                            if(!moveAvailable(r.x,r.y,dx[i],dy[i],b.x,b.y,r.color) &&
                                    !moveAvailable(b.x,b.y,dx[i],dy[i],r.x,r.y,b.color)) continue;
                            blue = moveBead(b.x,b.y,dx[i],dy[i],b.count,b.color,r.x,r.y);
                            red = moveBead(r.x,r.y,dx[i],dy[i],r.count,r.color,blue.x, blue.y);
                        }
                        break;
                    default: //아래래 구슬이 먼저
                        if(r.y > b.y){ //빨간구슬 먼
                            if(!moveAvailable(r.x,r.y,dx[i],dy[i],b.x,b.y,r.color) &&
                                    !moveAvailable(b.x,b.y,dx[i],dy[i],r.x,r.y,b.color)) continue;
                            red = moveBead(r.x,r.y,dx[i],dy[i],r.count,r.color,b.x,b.y);
                            blue = moveBead(b.x,b.y,dx[i],dy[i],b.count,b.color,red.x,red.y);
                        }else{ //파란 구슬 먼저
                            if(!moveAvailable(r.x,r.y,dx[i],dy[i],b.x,b.y,r.color) &&
                                    !moveAvailable(b.x,b.y,dx[i],dy[i],r.x,r.y,b.color)) continue;
                            blue = moveBead(b.x,b.y,dx[i],dy[i],b.count,b.color,r.x,r.y);
                            red = moveBead(r.x,r.y,dx[i],dy[i],r.count,r.color,blue.x, blue.y);
                        }
                        break;
                }
                redQueue.offer(red);
                blueQueue.offer(blue);
            }
        }
        return -1; //더 이상 움직일 곳이 없음
    }
    static Bead moveBead(int curX, int curY, int dx, int dy,int count, char color, int enemyX, int enemyY){
        int nextX = curX;
        int nextY = curY;
        while(true){
            if(map[nextX+dx][nextY+dy] == 'O'){
                return new Bead(nextX+dx,nextY+dy,'O',count+1);
            }else if(map[nextX+dx][nextY+dy] == '#' || (nextX+dx == enemyX) && (nextY+dy == enemyY)){
                return new Bead(nextX,nextY,color,count+1);
            }
            nextX = nextX + dx;
            nextY = nextY + dy;
        }
    }
    static boolean moveAvailable(int nextX, int nextY,int dx,int dy,int enemyX, int enemyY,char color){
        if(map[nextX+dx][nextY+dy] == '#' || ((nextX+dx == enemyX) && (nextY+dy == enemyY))){
            return false;
        }
        return true;
    }
}
class Bead{
    int x,y;
    char color;
    int count;
    public Bead(int x, int y, char color, int count) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.count = count;
    }
}