package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1018_S4 { // 1018 체스판 다시 칠하기 (브루트포스)
    static String[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //세로
        int M = Integer.parseInt(st.nextToken()); //가로
        arr = new String[N][M];
        for(int i=0;i<N;i++){
            String line = br.readLine();
            arr[i] = line.split("");
        }
        int result=Integer.MAX_VALUE;
        for(int i=0;i<N-7;i++){
            for(int j=0;j<M-7;j++){
                //BW, WB
                int B = chessboard(i, j, "B");
                int W =chessboard(i, j, "W");
                result= Math.min(result, Math.min(B,W));
            }
        }
        System.out.println(result);
    }
    public static int chessboard(int y, int x, String color ){
        int changeCnt = 0;
        for(int i=y;i<=y+7;i++){
            for(int j=x;j<=x+7;j++){
                if(!arr[i][j].equals(color)) {
                    changeCnt++;
                }
                color = colorChange(color);
            }
            color = colorChange(color);
        }
        return changeCnt;
    }
    public static String colorChange(String color){
        if(color.equals("B")) color="W";
        else if(color.equals("W")) color="B";
        return color;
    }
}
