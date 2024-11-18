package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class beak1541 { //1541 Silver2 +,-로 이뤄진 식에 괄호를 씌워 제일 작은 수 구하기
    static String[] subS;
    static int result=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        subS = S.split("-"); // - 로 배열자르기
        result = plusOper(0); // 0번째는 항상 +이므로 result +=
        for(int i=1;i<subS.length;i++) { // -배열
            result-=plusOper(i); // 1~N번째는 항상 - 이므로 result-=
        }

        System.out.println(result);
    }

    private static int plusOper(int i) {
        int val=0;
        String[] P=subS[i].split("\\+"); // P: +배열
        for(int j=0;j<P.length;j++) {
            val+=Integer.parseInt(P[j]); //+배열 돌며 모든 수 더하기
        }
        return val;
    }

}