package Baekjoon.Sliver;

import java.util.Scanner;

// 백준 2609번 : 최대공약수, 최소공배수
// 문제 설명 : 두 수의 최대공약수와 최소공배수를 구하는 문제
// 입력 : 두 정수 A와 B가 주어진다
// 출력 : 첫 번째 줄에 A와 B의 최대공약수, 두 번째 줄에 A와 B의 최소공배수를 출력한다
public class S_2609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        int gcd = gcd(A, B);  // 최대공약수 구하기
        int lcm = (A * B) / gcd;  // 최소공배수 구하기

        System.out.println(gcd);
        System.out.println(lcm);
    }

    // 유클리드 호제법을 사용한 최대공약수 구하기
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
