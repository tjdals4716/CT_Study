package Baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class beak2583 { // 2583 영역 구하기 dfs
    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,1,0,-1};
    static boolean[][] arr;
    static int M,N,ex=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(st.nextToken()); //y
        N = Integer.parseInt(st.nextToken()); //x
        int K = Integer.parseInt(st.nextToken());
        arr = new boolean[M][N]; //[y][x]
        List<Integer> list = new ArrayList<>(K);
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()); //x~
            int y1 = Integer.parseInt(st.nextToken()); //y~
            int x2 = Integer.parseInt(st.nextToken()); //~x
            int y2 = Integer.parseInt(st.nextToken()); //~y
            for(int j=y1;j<y2;j++){
                for(int k=x1;k<x2;k++){
                    arr[j][k] = true;
                }
            }
        }
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(!arr[i][j]){
                    dfs(j,i); // 시작지점 x,y주기
                    list.add(ex); //배열에 분리된 구역의 넓이들 넣기
                }
                ex=0; // 공간의 넓이 초기화
            }
        }
        Collections.sort(list); // 오름차순 정리
        for(int i=0;i<list.size();i++){
            sb.append(list.get(i)).append(" ");
        }
        System.out.println(list.size() +"\n" + sb);
    }
    private static void dfs(int x, int y) {
        arr[y][x]=true;
        ex++;
        for(int c=0;c<4;c++){
            int nx = x+dx[c];
            int ny = y+dy[c];
            if(arrOver(nx,ny)&&!arr[ny][nx]){ // 배열 범위를 넘어가는지 + 다음배열이 false 인지
                dfs(nx,ny);
            }
        }
    }
    private static boolean arrOver(int x, int y) {
        return x>=0&&x<N&&y>=0&&y<M;
    }
}
