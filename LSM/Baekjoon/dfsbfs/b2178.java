package Baekjoon.dfsbfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2178 { //2178 Silver1 bfs 미로 탐색 도착지까지 최소거리
    static boolean[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int cnt=0,N,M;
    static Queue<Point> q = new LinkedList<>();
    static Queue<Point> q2 = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new boolean[N][M];
        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++) {
                if (s.charAt(j) == '1') {
                    arr[i][j]=true;
                }
            }
        }
        if(arr[0][0]) bfs();
        System.out.println(cnt+2);
    }

    private static void bfs() {
        q.add(new Point(0, 0));
        arr[0][0] = false;
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (onCheck(nx, ny)) {
                    q2.add(new Point(nx, ny));
                    if (nx == M - 1 && ny == N - 1) return;
                    arr[ny][nx] = false;
                }
            }
            if (q.isEmpty()){
                cnt++;
                q = q2;
                q2 = new LinkedList<>();
            }
        }
    }

    private static boolean onCheck(int x, int y) {
        return x>=0 && x<M && y>=0 && y<N && arr[y][x];
    }
}