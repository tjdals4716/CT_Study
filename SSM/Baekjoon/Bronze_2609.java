package Baekjoon;

import java.util.Scanner;

// 최대공약수, 최소공배수
public class Bronze_2609 {
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
