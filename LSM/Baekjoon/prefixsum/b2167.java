package Baekjoon.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2167 { //2167 Silver5 배열의 누적합
    //i,j ~ x,y 배열의 누적합을 dp 배열에서 포함되는부분의 최대값과- 포함안되는 부분의 값+ 중복되어 제거된 값
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st  = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][M+1];
        int[][] dp = new int[N+1][M+1];
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1;i<=N;i++){ //누적 합
            for(int j=1;j<=M;j++){
                dp[i][j] = arr[i][j]+ dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
            }
        }
        int K = Integer.parseInt(br.readLine());
        for(int cnt=0;cnt<K;cnt++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            //배열의 범위에따른 안들어가는 행열의 누적값 제거 후 겹치게제거된 [i-1] [j-1] 누적합 추가
            int sum = dp[x][y] -dp[i-1][y] - dp[x][j-1] + dp[i-1][j-1];
            System.out.println(sum);
        }
    }
}