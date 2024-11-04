package swea.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw2814 { // 2814 최장경로 노드 최대 방문 횟수
    static int N,cnt,max;
    static boolean[][] arr;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //정점의 수
            int M = Integer.parseInt(st.nextToken()); //간선의 수
            arr= new boolean[N+1][N+1];
            check= new boolean[N+1];
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a][b] = arr[b][a] = true;
            }
            max=0;
            for (int i = 1; i <= N; i++) {
                dfs(i); //각 정점마다 시작
            }
            System.out.println("#"+tc+" " + max);
        }
    }
    private static void dfs(int start) {
        cnt++; //방문하면 카운트와 방문체크
        check[start] = true;
        max = Math.max(max,cnt); //현재까지 방문했을때 최대 방문노드면
        for(int i=1;i<=N;i++) { //모든 노드의 길 탐색
            if (arr[start][i]&&!check[i]) { // 간선이 존재하고 방문안했을때
                dfs(i);
            }
        }
        cnt--; //정점에서 나갈때 카운트와 방문 초기화
        check[start] = false;
    }
}