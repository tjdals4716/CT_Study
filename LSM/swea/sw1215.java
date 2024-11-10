package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw1215 { //1215 2차원배열로 가로세로 N개의 문자가 몇개의 회문이 나오는지 체크
    static String S;
    static int N,cnt;
    static StringBuilder s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int tc=1;tc<=10;tc++) {
            N = Integer.parseInt(br.readLine()); // 문자 길이 N 찾기
            char[][] arr = new char[8][8];
            cnt=0;
            for(int i=0;i<8;i++) { //
                S = br.readLine(); //행으로 받기
                arr[i] = S.toCharArray();
                check(S);
            }
            //열
            for(int i=0;i<8;i++) {
                s = new StringBuilder();
                for(int j=0;j<8;j++) {
                    s.append(arr[j][i]);
                }
                check(s.toString()); // 열로된 문자열
            }
            System.out.println("#"+tc+" "+cnt);
        }
    }

    private static void check(String s) { //문자열의 N개문자가 회문인지 체크
        for(int j=0;j<=s.length()-N;j++) {
            String a = s.substring(j,j+N);
            StringBuilder st = new StringBuilder(a);
            if(a.contentEquals(st.reverse())){
                cnt++;
            }
        }
    }
}