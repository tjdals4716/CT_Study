package Baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b3187 { // 3187 Silver1 양치기꿍
    //dfs 구현, 방문 체크, 양과 늑대 수 출력
    static char[][] arr;
    static int R,C,k,v,wolf,sheep;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String a = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = a.charAt(j);
                if (arr[i][j] != '#') {
                    visited[i][j] = true;
                }
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (visited[i][j]) {
                    k = 0;
                    v = 0;
                    dfs(i, j);
                    if (k > v) {
                        sheep += k;
                    } else {
                        wolf += v;
                    }
                }
            }
        }
        System.out.println(sheep + " " + wolf);
    }
    public static void dfs(int y , int x) {
        visited[y][x] = false;
        if (arr[y][x] == 'k') {
            k++;
        }
        if (arr[y][x] == 'v') {
            v++;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < C && ny >= 0 && ny < R) {
                if (visited[ny][nx]) {
                    dfs(ny, nx);
                }
            }
        }
    }
}
