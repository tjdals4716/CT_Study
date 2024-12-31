package Baekjoon.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b16507_S1 { // 16507 Silver1 배열의 누적합 그리고 범위 내의 칸들의 평균 구하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int R,C,Q,r1,c1,r2,c2,sum,average;
        int[][] arr,dp;
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        arr = new int[R+1][C+1];
        dp = new int[R+1][C+1];
        for(int i=1;i<=R;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=C;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1;i<=R;i++){
            for(int j=1;j<=C;j++){
                dp[i][j] = arr[i][j] + dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1]; // DP : 0,0~i,j까지 총합
            }
        }
        for(int i=0;i<Q;i++){
            st = new StringTokenizer(br.readLine());
            r1 = Integer.parseInt(st.nextToken());
            c1 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());
            c2 = Integer.parseInt(st.nextToken());
            // dp 블럭내부 크기 구하기
            sum = dp[r2][c2] + dp[r1-1][c1-1] - dp[r2][c1-1] - dp[r1-1][c2];
            average=sum/((r2-r1+1)*(c2-c1+1)); // 블럭 내부의 평균 값
            sb.append(average).append("\n");
        }
        System.out.println(sb);
    }
}