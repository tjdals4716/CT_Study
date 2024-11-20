package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1010 { // 1010 Silver5 DP문제 N<=M 다리를 놓을때 겹치지않고 중복안되는경우의수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int result = 1;
            for (int i = 1; i <= N; i++) {
                result = result * (M - i + 1) / i;
            }
            System.out.println(result);
        }
    }
}