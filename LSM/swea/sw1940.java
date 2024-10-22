package swea;

import java.io.IOException;
import java.util.Scanner;

public class sw1940 {
    public static void main(String[] args)throws IOException { // 1940
        // 1초마다 가속,감속,그대로속도유지가 주어지고 총 이동거리 구하는 문제.
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N=sc.nextInt();
            int accel =0;
            int ms = 0,s,M=0;
            for (int i = 0; i < N; i++) {
                s = sc.nextInt(); //시간
                if(s!=0) {
                    ms = sc.nextInt(); //rc카의 속도
                }
                if (s == 1) { //가속 주어지면
                    accel+=ms;
                } else if (s == 2) { //감속 주어지면
                    accel-=ms;
                    if(accel<0) {accel=0;} // 가속도가 0밑으로 떨어지면
                }
                M+=accel; //가속,감속,현재속도유지 모두 현재 속도 를 미터에 더함
            }
            System.out.println("#"+tc+" "+M);
        }
    }
}
