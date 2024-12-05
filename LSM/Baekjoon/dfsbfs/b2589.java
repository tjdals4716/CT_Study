package Baekjoon.dfsbfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2589 { // 2589 Gold5 bfs 최단 거리(최소)로 이동하는 시간(최대) 구하기
    static int[] dx={1,0,-1,0};
    static int[] dy={0,1,0,-1};
    static boolean[][] arr,visit;
    static int result=0,L,W;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken()); //세로
        W = Integer.parseInt(st.nextToken()); //가로
        arr=new boolean[L][W];
        for(int i=0;i<L;i++){
            String S = br.readLine();
            for(int j=0;j<W;j++){
                if(S.charAt(j)=='L')arr[i][j]=true;
            }
        }
        for(int i=0;i<L;i++){
            for(int j=0;j<W;j++){
                if(arr[i][j]){
                    visit = new boolean[L][W];
                    result=Math.max(result,bfs(i,j));
                }
            }
        }
        System.out.println(result);
    }
    private static int bfs(int y, int x) {
        visit[y][x]=true;
        int cnt=-1; //시작지점을 바로 +1해주기때문 방문할곳이없을땐 0이 나온다.
        Queue<Point> q=new LinkedList<>();
        q.add(new Point(x,y));
        while (!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                Point p = q.poll();
                for (int n = 0; n < 4; n++) { // 4방탐색
                    int nx = p.x + dx[n];
                    int ny = p.y + dy[n];
                    if (nx >= 0 && nx < W && ny >= 0 && ny < L && !visit[ny][nx] && arr[ny][nx]) { //배열 오버와 방문 가능 체크
                        q.add(new Point(nx, ny));
                        visit[ny][nx] = true;
                    }
                }
            }
            cnt++;
        }
        return cnt;
    }
}