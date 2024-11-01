package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class arrRotation { // 1961 : 숫자 배열 회전 - (수평 반전) 각 행의 원소 순서 바꾸기 오른쪽90도
    static int[][] arr;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++){
            int N=Integer.parseInt(br.readLine());
            arr=new int[N][N];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    arr[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            int[][] arr_90 = Rotation(arr);
            int[][] arr_180 = Rotation(arr_90);
            int[][] arr_270 = Rotation(arr_180);
            System.out.println("#"+tc);
            for(int i=0;i<N;i++){
                for(int j=0;j<arr.length;j++){
                    System.out.print(arr_90[i][j]);
                }
                System.out.print(" ");
                for(int j=0;j<arr.length;j++){
                    System.out.print(arr_180[i][j]);
                }
                System.out.print(" ");
                for(int j=0;j<arr.length;j++){
                    System.out.print(arr_270[i][j]);
                }
                System.out.println();
            }
        }
    }
    public static int[][] Rotation(int[][] arr){
        int[][] newarr=new int[arr.length][arr.length];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                newarr[i][j] = arr[arr.length-1-j][i];
            }
        }
        return newarr;
    }
}