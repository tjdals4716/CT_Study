package Baekjoon.Bronze;

import java.util.Scanner;

// 백준 10870번 : 피보나치 수 5
// 문제 설명 : 피보나치 수열에서 n번째 피보나치 수를 구하는 문제
// 입력 : n (0 ≤ n ≤ 20)
// 출력 : n번째 피보나치 수를 출력
public class B_10870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibonacci(n));
    }

    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
