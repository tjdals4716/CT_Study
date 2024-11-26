package Baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class b2667 { //2667 Silver1 단지 번호 붙이기
    // 배열에서 붙어있는 숫자 집합의 개수와 각 집합의 숫자
    static boolean[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int cnt=0,N;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new boolean[N][N];
        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<N;j++) {
                if (s.charAt(j) == '1') {
                    arr[i][j]=true;
                }
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(arr[i][j]){
                    cnt=0;
                    dfs(i,j);
                    list.add(cnt);

                }
            }
        }
        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for(int lists:list) {
            sb.append(lists).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int y,int x) {
        cnt++;
        arr[y][x] = false;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (onCheck(nx, ny)) {
                dfs(ny, nx);
            }
        }
    }

    private static boolean onCheck(int x, int y) {
        return x>=0 && x<N && y>=0 && y<N && arr[y][x];
    }
}