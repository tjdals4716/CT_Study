package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1459_S3 { // 1459 Silver3 많은 조건 분기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long SX=0,SY=0,d_move,min_time=0,X,Y,W,S,D,right_move,left_move;
        X = Integer.parseInt(st.nextToken()); // X 종료지점
        Y = Integer.parseInt(st.nextToken()); // Y 종료지점
        W = Integer.parseInt(st.nextToken()); // 상하좌우 시간
        S = Integer.parseInt(st.nextToken()); // 대각 시간

        if(2*W>S){ // 대각시간이 우월할때
            d_move = Math.min(X,Y); // X,Y에서 갈수있는 대각이동 모두 이동
            min_time = d_move*S; // 대각이동 최대 * 시간
            SX=d_move; // 현재 위치
            SY=d_move;
            D = Math.max(X-SX,Y-SY);
            if(W>S){ // 직선이동보다 대각이동이 나을경우
                d_move=D/2; //2칸이동 거리 모두이동
                if(SX!=X) {
                    min_time+=2*d_move*S;
                    SX+=2*d_move;
                }
                if(SY!=Y) {
                    min_time+=2*d_move*S;
                    SY+=2*d_move;
                }
            }
        }
        // 나머지 직선거리 모두이동
        right_move = X-SX;
        left_move = Y-SY;
        min_time+=(right_move+left_move)*W;

        System.out.println(min_time);
    }
}