package Baekjoon.Bronze;

import java.util.Arrays;
import java.util.Scanner;

// 백준 2309번 : 일곱 난쟁이
// 문제 설명 : 9명의 난쟁이 중에서 키의 합이 100이 되는 7명의 난쟁이를 찾아내는 문제
// 입력 : 9명의 키가 주어진다
// 출력 : 7명의 키를 오름차순으로 출력한다
public class B_2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] heights = new int[9];
        int total = 0;

        for (int i = 0; i < 9; i++) {
            heights[i] = sc.nextInt();
            total += heights[i];
        }

        Arrays.sort(heights);

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (total - heights[i] - heights[j] == 100) {
                    for (int k = 0; k < 9; k++) {
                        if (k != i && k != j) {
                            System.out.println(heights[k]);
                        }
                    }
                    return;
                }
            }
        }
    }
}

