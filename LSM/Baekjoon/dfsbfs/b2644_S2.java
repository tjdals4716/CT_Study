package Baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2644_S2 { // 2664 Silver2 촌수계산 S->E까지 간선의 최소 이동횟수 구하기
    static int N,M,A,B,s,e,result=0;
    static boolean[][] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 전체 사람 수
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken()); // A~B까지 촌수 계산
        M = Integer.parseInt(br.readLine()); // 부모,자식 관계의 개수
        arr = new boolean[N+1][N+1]; //간선
        visited = new boolean[N+1];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            arr[s][e] = arr[e][s] = true;
        }
        bfs();
        System.out.println(result);
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(A); // 시작지점
        visited[A] = true;
        while(!q.isEmpty()){
            int length = q.size();
            result++;
            for(int i=0;i<length;i++){
                int cur = q.poll();
                for(int j=1;j<=N;j++){
                    if(arr[cur][j]&&!visited[j]){ // 촌수 관계일때
                        q.offer(j);
                        visited[j] = true;
                        if(j==B) return;
                    }
                }
            }
        }
        result=-1; // 방문 안했을때 -1
    }
}