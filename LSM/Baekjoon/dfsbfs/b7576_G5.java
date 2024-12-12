package Baekjoon.dfsbfs;

import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b7576_G5 { // 7576 Gold5 토마토 bfs 배열탐색
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static int M,N,day=-1,cnt;
    static int[][] box; //상자
    static Queue<Point> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        M = Integer.parseInt(st.nextToken());//x
        N = Integer.parseInt(st.nextToken());//y
        box = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1){
                    q.offer(new Point(j,i));
                } else if(box[i][j] == 0){
                    cnt++;
                }
            }
        }
        bfs();
        if(cnt!=0) {day=-1;}
        bw.write(String.valueOf(day));
        bw.flush();
        bw.close();
    }

    private static void bfs() {
        while(!q.isEmpty()){ //모든 전이가 끝날때까지
            int size = q.size();
            day++;
            for(int i=0;i<size;i++){ //q 길이
                Point p = q.poll();
                for(int n=0;n<4;n++){ //방향 전환
                    int nx = p.x + dx[n];
                    int ny = p.y + dy[n];
                    if(nx>=0&&ny>=0&&nx<M&&ny<N&&box[ny][nx] == 0){ //배열 오버 익지않은 토마토 체크
                        q.offer(new Point(nx,ny));
                        box[ny][nx]=1;
                        cnt--;
                    }
                }
            }
        }
    }
}