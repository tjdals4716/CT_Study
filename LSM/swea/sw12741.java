package swea;

import java.io.IOException;
import java.util.Scanner;

public class sw12741 {
    public static void main(String[] args)throws IOException { // 12741 겹치는 시간의 합
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1;tc<=T;tc++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            int cnt=0;
            for(int i=0;i<100;i++){

                if(a<=0&&c<=0){ // 두 전구가 켜진 시간이 지났을경우
                    if(b>0&&d>0){ // 두 전구의 켜진 시간이 1초이상남았을경우
                        cnt++;
                    }
                }
                a--;
                b--;
                c--;
                d--;
            }
            System.out.println("#"+tc+" "+cnt);
        }
    }
}