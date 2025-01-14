package Baekjoon.priority;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b2075_S3 { // 2075 Silver3 N번째 큰 수 Priority
    public static void main(String[] args) throws IOException {
        // PriorityQueue 정렬 방식
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder()); //우선 순위 큐
        // input -> pQ 추가
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                pQ.add(Integer.parseInt(st.nextToken()));
            }
        }
        System.out.println(pQ);
        // pQ 제거
        for(int i = 0; i < N-1; i++) {
            pQ.poll();
        }
        // N번째 큰 수
        System.out.println(pQ.poll());

        /* // 배열 정렬 방식
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] arr = new int[N*N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=i*N;j<(i*N)+N;j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(arr);
        System.out.println(arr[arr.length-N]);
        */
    }
}