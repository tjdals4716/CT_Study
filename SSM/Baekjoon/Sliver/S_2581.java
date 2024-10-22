package Baekjoon.Sliver;

import java.util.Scanner;

// 백준 2581번 : 소수
// 문제 설명 : M 이상 N 이하의 자연수 중 소수인 것을 모두 찾아 소수들의 합과 최솟값을 구하는 문제
// 입력 : 두 자연수 M과 N이 주어진다
// 출력 : M 이상 N 이하의 소수들의 합과 그 중 최솟값을 출력합니다. 만약 소수가 없으면 -1을 출력한다
public class S_2581 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int i = M; i <= N; i++) {
            if (isPrime(i)) {
                sum += i;
                if (i < min) {
                    min = i;
                }
            }
        }

        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
