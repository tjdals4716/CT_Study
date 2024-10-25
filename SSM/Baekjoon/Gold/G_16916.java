package Baekjoon.Gold;

import java.util.Scanner;

// 백준 16916번 : 부분 문자열
// 문제 설명 : 문자열 S가 주어질 때, P가 S의 부분 문자열인지 확인하는 문제이다
// 입력 : 첫째 줄에 문자열 S, 둘째 줄에 문자열 P가 주어진다
// 출력 : P가 S의 부분 문자열이면 1, 아니면 0을 출력한다
// 풀이 : 문자열 검색 알고리즘 중 KMP 알고리즘을 사용해 효율적으로 부분 문자열을 탐색한다
public class G_16916 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        String P = sc.nextLine();
        System.out.println(KMP(S, P) ? 1 : 0);
    }

    public static boolean KMP(String S, String P) {
        int[] lps = computeLPSArray(P);
        int i = 0, j = 0;

        while (i < S.length()) {
            if (S.charAt(i) == P.charAt(j)) {
                i++; j++;
            }
            if (j == P.length()) return true;
            else if (i < S.length() && S.charAt(i) != P.charAt(j)) {
                if (j != 0) j = lps[j - 1];
                else i++;
            }
        }
        return false;
    }

    public static int[] computeLPSArray(String P) {
        int[] lps = new int[P.length()];
        int length = 0, i = 1;
        while (i < P.length()) {
            if (P.charAt(i) == P.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) length = lps[length - 1];
                else lps[i++] = 0;
            }
        }
        return lps;
    }
}
