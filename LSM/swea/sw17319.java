package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw17319 { // 17319 입력값에 대해 하나의 문자열을 2번 반복해서 만들수 있으냐 없느냐 판단 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++) {
            int N = Integer.parseInt(br.readLine());
            String S = br.readLine();
            String A = S.substring(0, S.length()/2);
            String B = S.substring(S.length()/2);
            if(A.equals(B)){
                System.out.println("#"+tc+" "+"Yes");
            }else{
                System.out.println("#"+tc+" "+"No");
            }
        }
    }
}