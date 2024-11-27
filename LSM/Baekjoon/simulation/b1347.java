package Baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1347 { // 1347 Silver2
    //미로 만들기 배열을 미리 설정 후 방문 포함하는 최소 사각형 배열만 출력
    static boolean[][] map = new boolean[101][101];
    static int[] dx = {0,-1,0,1};
    static int[] dy = {1,0,-1,0}; // 남, 서, 북, 동 시계방향
    static int right_x=50,top_y=50,left_x=50,bottom_y=50,x=50, y=50;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String r = br.readLine();
        int d=0;
        map[y][x]=true;
        for(int i=0;i<r.length();i++) {
            switch (r.charAt(i)){
                case 'R': // 시계
                    d=(d+1)%4;
                    break;
                case 'L': // 반시계
                    d=(d+3)%4;
                    break;
                case 'F': //전진
                    move(d);
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=top_y;i<=bottom_y;i++) {
            for(int j=left_x;j<=right_x;j++) {
                if(map[i][j]) {
                    sb.append('.');
                }else{
                    sb.append('#');
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static void move(int d) {
        x += dx[d];
        y += dy[d];
        map[y][x]=true; //방문한곳 체크

        // 사각형의 배열 출력을 위해서
        right_x=Math.max(right_x,x);
        top_y=Math.min(top_y,y);
        left_x=Math.min(left_x,x);
        bottom_y=Math.max(bottom_y,y);
    }
}
