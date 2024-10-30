package Baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class beak1260 { // 1260 간단한 dfs,bfs 탐색 구현
    static int M,N;
    static boolean[][] arr;
    static boolean[] check;
    static Queue<Integer> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //정점의 수
        M = Integer.parseInt(st.nextToken()); //간선 수
        int V = Integer.parseInt(st.nextToken()); //시작 지점
        arr = new boolean[N+1][N+1];
        check = new boolean[N+1];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b]= arr[b][a] = true; //양방향
        }
        dfs(V);
        sb.append("\n");
        check = new boolean[N+1];
        bfs(V);
        System.out.println(sb);
    }
    private static void dfs(int start) { // 1 2 , 1 3 , 1 4 true
        check[start] = true;
        sb.append(start + " ");
        for (int i = 1; i <=N; i++) { // 제일 가깝고 숫자가 제일 낮은곳부터
            if (arr[start][i] &&!check[i]) {
                dfs(i);
            }
        }
    }
    private static void bfs(int start) {
        check[start] = true;
        q.add(start);
        while(!q.isEmpty()){
            start=q.poll();
            sb.append(start + " ");
            for(int i=1;i<=N;i++){
                if(arr[start][i] && !check[i]){
                    q.add(i);
                    check[i] = true;
                }
            }
        }
    }
}