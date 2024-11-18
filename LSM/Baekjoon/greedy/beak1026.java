package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class beak1026 { //1026 Silver4 A[..N] x B[..N] 값이 최소인 경우
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        int[] A = new int[N];
        Integer[] B = new Integer[N];
        StringTokenizer stA = new StringTokenizer(br.readLine());
        StringTokenizer stB = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            A[i]= Integer.parseInt(stA.nextToken());
            B[i]= Integer.parseInt(stB.nextToken());
        }
        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());
        int result=0;
        for(int i=0;i<N;i++){
            result +=A[i]*B[i];
        }
        System.out.println(result);
    }
}