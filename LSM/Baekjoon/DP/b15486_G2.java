package Baekjoon.DP;

import java.util.Scanner;

public class b15486_G2 { // DP Gold2 주식매수(동기방식) 최대 수익 구하기
    static int arr[][];
    static int dp[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        arr = new int[N+2][2];
        dp = new int[N+2];
        for(int i=1;i<N+1;i++){
            arr[i][0]=sc.nextInt(); //기간
            arr[i][1]=sc.nextInt(); //금액
        }
        int max = -1;
        for(int i=1;i<=N+1;i++){
            if(max < dp[i]){
                max = dp[i];
            }
            int nxt = i + arr[i][0];
            if(nxt<N+2){
                dp[nxt]=Math.max(dp[nxt],max +arr[i][1]);
            }
        }
        System.out.println(dp[N+1]);
    }
}