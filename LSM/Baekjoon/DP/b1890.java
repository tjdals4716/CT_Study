package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1890 { // 1890 Silver1 DP 배열에 이동가능한 부분을 누적해가며 도착지 경우의 수 출력
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr= new int[N][N];
        long[][] visit = new long[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                visit[i][j] = 0;
            }
        }
        visit[0][0] = 1;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(visit[i][j]>0&&(i!=N-1||j!=N-1)) {
                    int move = arr[i][j];
                    if (j + move < N) { //x축
                        visit[i][j+move]+=visit[i][j];
                    }
                    if (i + move < N) { //y축
                        visit[i+move][j]+=visit[i][j];
                    }
                }
            }
        }
        System.out.println(visit[N-1][N-1]);
    }
}