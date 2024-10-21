package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class sw1954 { //1954 : 2차원배열 순회 하며 좌표(4방향 탐색) + 델타 delta
    static int[][] arr;
    static int[] dr = { 0,1,0,-1}; //행 위 오른쪽 아래 왼쪽
    static int[] dc = {1,0,-1,0}; //열 위 오른쪽 아래 왼쪽
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            int value=1;
            int N = sc.nextInt();
            arr = new int[N][N];
            int dIdx=0; //방향 인덱스
            int r=0,c=0; //시작좌표
            for(int i=1;i<=N*N;i++){
                arr[r][c]=i;
                if(r+dr[dIdx]>=N||r+dr[dIdx]<0||c+dc[dIdx]>=N || c+dc[dIdx]<0 // 위 오른쪽 아래 왼쪽 순으로 배열의 끝
                        ||arr[r+dr[dIdx]][c+dc[dIdx]]!=-0) { // 그 자리에 숫자가 입력되어 있는지
                    dIdx = (dIdx+1)%4; //방향전환
                }
                r+=dr[dIdx];
                c+=dc[dIdx];
            }
            System.out.println("#" + tc);
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
}
