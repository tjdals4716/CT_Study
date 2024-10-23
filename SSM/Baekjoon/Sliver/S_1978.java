package Baekjoon.Sliver;

import java.util.Scanner;

// 백준 1978번 : 소수 찾기
// 문제 설명 : 주어진 N개의 수에서 소수가 몇 개인지 찾는 문제
// 입력 : 첫째 줄에 자연수 N이 주어지고, 그 다음 줄에 N개의 수가 주어진다
// 출력 : 소수의 개수를 출력한다
public class S_1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (isPrime(num)) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
