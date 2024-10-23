package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw20019 { //20019 : 중간을 기준으로 문자열 잘라서 비교
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String s = br.readLine();
            int length = (s.length()-1)/2; //중간의 문자 번호
            String front = s.substring(0, length); //substring 문자열 나누기
            String back = s.substring(length+1);
            if(front.equals(back)) {
                System.out.println("#"+tc+" "+"YES");
            }else System.out.println("#"+tc+" "+"NO");
        }
    }
}