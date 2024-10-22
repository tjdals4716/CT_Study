package swea;

import java.io.IOException;
import java.util.Scanner;

public class sw7193 {
    public static void main(String[] args)throws IOException { // 7193
        // 페르마의 소정리(소수기준) + 뤼카의 정리가 맞는지 이해못했음.
        // 10진수 345의 값은 (3+4+5)%9 == 345%9 를 만족하는데
        // 모든 진법의 수가 위의 경우를 만족하는거 같다.
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1;tc<=T;tc++){
            int N = sc.nextInt();

            String X = sc.next();
            int sum=0;
            for(int i=0;i<X.length();i++){
                sum+=X.charAt(i)-'0';
            }
            System.out.println("#"+tc+" "+sum%(N-1));
        }
    }
}