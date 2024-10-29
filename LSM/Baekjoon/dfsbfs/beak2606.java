package Baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class beak2606 { // 2606 바이러스 방문체크 bfs로 구하기
    static int node;
    static int cnt=0;
    static boolean[][] arr;
    static boolean[] visited;
    static Queue<Integer> q = new LinkedList<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine());//컴퓨터의 수
        int N = Integer.parseInt(br.readLine()); // 네트워크 연결 수
        arr = new boolean[node+1][node+1];
        visited = new boolean[node+1];
        for(int i=1;i<=N;i++){ // 네트워크 = true
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] =arr[b][a]= true;
        }
        bfs(1);
        System.out.println(cnt);
    }
    private static void bfs(int start) {
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) { // q 가 비어있지않으면
            start=q.poll();
            for(int i=1;i<=node;i++){ // 노드
                if(arr[start][i]&&!visited[i]){ // 네트워크 있으면 && 방문안했으면
                    q.add(i); //다 넣기
                    visited[i] = true; //방문 처리
                    cnt++;
                }
            }
        }
    }
}