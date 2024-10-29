package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw16800 { // 16800 곱셈표에서 최소 몇 번을 움직여야 N의 수를 만들수있을까
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            long N = Long.parseLong(br.readLine());
            long S = (int) Math.sqrt(N);
            long value = Long.MAX_VALUE;
            if (Math.sqrt(N) == S) { // 제곱근이 정수일때
                value = S + S - 2;
            } else if (N == 1) { // 1일때
                value=0;
            } else { //나머지 수
                for (long i = S; i >=1; i--) { //제곱근이하의 수
                    if (N % i == 0){ //
                        value=Math.min(value,(N/i)+i-2); //
                    }
                }
            }
            System.out.println("#"+tc+" "+value);
        }
    }
}