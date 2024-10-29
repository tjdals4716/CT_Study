package Baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak11123 { // 11123 양이 겹쳐있으면 무리로 카운트 dfs로 총 무리수
    static int cnt =0,H,W;
    static boolean[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0}; // 순서대로 위 오른쪽 아래 왼쪽
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());//테스트케이스
        for(int tc=1;tc<=T;tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            arr= new boolean[H][W];
            for(int i=0;i<H;i++) { // y축
                String S = br.readLine();
                for(int j=0;j<W;j++) { // x축
                    if(S.charAt(j)=='#'){
                        arr[i][j]=true;
                    }
                }
            }
            cnt=0;
            for(int i=0;i<H;i++) {
                for(int j=0;j<W;j++) {
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
        arr[y][x] = false; // 방문했을시 false

        for (int c = 0; c < 4; c++) { //x,y 위 오른쪽 아래 왼쪽 이동
            int nx = x + dx[c];
            int ny = y + dy[c];
            if (Over(nx, ny)) { //범위를 넘어가는지 체크
                if (arr[ny][nx]) { //다음방문할곳의 값이 true일때
                    dfs(nx, ny);
                }
            }
        }
    }
    private static boolean Over(int x, int y) {
        return x>=0 && x<W && y>=0 && y<H;
    }
}