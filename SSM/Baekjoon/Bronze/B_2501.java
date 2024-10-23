package Baekjoon.Bronze;

import java.util.Scanner;

// 백준 2501번 : 약수 구하기
// 문제 설명 : 자연수 n이 주어졌을 때, n의 약수들 중 k번째로 작은 수를 구하는 문제. 만약 k번째 약수가 존재하지 않으면 0을 출력
// 입력 : 첫째 줄에 두 개의 자연수 n과 k가 주어진다 (1 ≤ n ≤ 10,000, 1 ≤ k ≤ n)
// 출력 : 첫째 줄에 n의 약수들 중 k번째로 작은 수를 출력. 만약 k번째 약수가 없다면 0을 출력
public class B_2501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  // 자연수 n
        int k = sc.nextInt();  // k번째 약수

        int count = 0;  // 약수의 개수를 셀 변수

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {  // i가 n의 약수라면
                count++;  // 약수의 개수 증가
            }

            if (count == k) {  // k번째 약수를 찾은 경우
                System.out.println(i);  // 해당 약수를 출력하고 종료
                return;
            }
        }

        // 약수의 개수가 k보다 적은 경우
        System.out.println(0);  // 0을 출력
    }
}
