package Baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class baek2508 { // 2508 2차원배열 특정 문자의 좌우 위아래 값 조회
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1;tc<=T;tc++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            char[][] arr = new char[r][c];

            for (int i = 0; i < r; i++) {
                String s = sc.next();
                for (int j = 0; j < c; j++) {
                    arr[i][j] = s.charAt(j);
                }
            }
            int count = 0;
            for (int i = 0; i < r; i++) { //열
                for (int j = 0; j < c; j++) { //행
                    if (j > 0 && j < c - 1) {// 행 검사
                        if (arr[i][j] == 'o' && arr[i][j - 1] == '>' && arr[i][j + 1] == '<')
                            count++;
                    }
                    if (i > 0 && i < r - 1) { // 열 검사
                        if (arr[i][j] == 'o' && arr[i - 1][j] == 'v' && arr[i + 1][j] == '^')
                            count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}