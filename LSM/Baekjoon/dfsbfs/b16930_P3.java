package Baekjoon.dfsbfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b16930_P3 { // 16930 Platinum3 bfs 방향,이동범위,배열범위,가능한 길, 방문여부 and 방문time 체크
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1}; // 시계방향 회전
    static int[][] map;
    static int N,M,K,x1,y1,x2,y2,result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // y
        M = Integer.parseInt(st.nextToken()); // x
        K = Integer.parseInt(st.nextToken()); // 최대 개수
        map = new int[N][M];
        for(int i=0;i<N;i++){
            String S = br.readLine();
            for(int j=0;j<M;j++){
                if(S.charAt(j)=='.') {
                    map[i][j] = 0;
                }else{
                    map[i][j] = -1;
                }
            }
        }
        st=new StringTokenizer(br.readLine());
        y1=Integer.parseInt(st.nextToken())-1;
        x1=Integer.parseInt(st.nextToken())-1;
        y2=Integer.parseInt(st.nextToken())-1;
        x2=Integer.parseInt(st.nextToken())-1;

        bfs();
        System.out.println(result);
    }

    private static void bfs() {
        int time=0;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x1, y1));

        while(!q.isEmpty()) {
            int size = q.size();
            time++;
            for(int i=0;i<size;i++){
                Point p = q.poll();
                for (int n = 0; n < 4; n++) { //방향
                    int nx = p.x;
                    int ny = p.y;
                    for (int m = 1; m <= K; m++) { // 이동범위
                        nx += dx[n];
                        ny += dy[n];

                        //배열 오버 || 벽
                        if(overCheck(nx,ny) || map[ny][nx]==-1) break;
                        if(nx==x2 && ny==y2){
                            result=time;
                            return;
                        }

                        // 방문
                        if(map[ny][nx]==0){ //방문 안했을때
                            map[ny][nx]=time+1;
                            q.add(new Point(nx, ny));
                        }else if(map[ny][nx]==time+1){ // 이번 time 에 방문 했으면 길이 탐색 계속
                        }else{ // 방문 했지만 이번 time이 아니면 길이 탐색 종료
                            break;
                        }
                    }
                }
            }


        }
        result=-1; //목표에 도달하지 못했을때
    }

    private static boolean overCheck(int x , int y) {
        return x<0||x>=M||y<0||y>=N;
    }

    static class Point{
        int x,y;
        public Point(int x , int y) {
            this.x=x;
            this.y=y;
        }
    }
}
