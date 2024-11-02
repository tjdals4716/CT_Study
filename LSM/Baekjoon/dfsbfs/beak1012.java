package Baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak1012 { // 1012 상하좌우 이어진 무리의 갯수
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static boolean[][] arr;
    static int M,N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); //가로길이
            N = Integer.parseInt(st.nextToken()); //세로길이
            int K = Integer.parseInt(st.nextToken()); //배추의 수
            arr = new boolean[N][M];
            for(int i=0;i<K;i++){ //배추가 있는 곳 체크(true)
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[y][x] = true;
            }
            int cnt=0;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(arr[i][j]){
                        dfs(j,i);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
    private static void dfs(int x, int y) {
        arr[y][x] = false;
        for(int c=0;c<4;c++){
            if(Rotation(x+dx[c],y+dy[c])){ // Rotation = 배열크기 체크 and 체크할배열 true(배추)확인
                dfs(x+dx[c],y+dy[c]);
            }
        }
    }
    private static boolean Rotation(int x, int y) {
        return x>=0 && x<M && y>=0 && y<N&&arr[y][x];
    }
}
