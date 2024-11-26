package Baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b11724 { //11724 Silver2 방향없는 그래프 연결 요소의 갯수 구하기
    // dfs 방문안한곳만 모든 경우의 수를 본다.
    static boolean[][] arr;
    static boolean[] visit;
    static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new boolean[N+1][N+1];
        visit = new boolean[N+1];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a]= true;
        }
        for(int i=1;i<=N;i++) {
            if(!visit[i]) {
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    private static void dfs(int start) {
        visit[start] = true;
        for(int i=1;i<arr.length;i++) {
            if (arr[start][i] && !visit[i]) {
                dfs(i);
            }
        }
    }
}