package Baekjoon.Sliver;

import java.util.Scanner;

// 백준 1292번 : 쉽게 푸는 문제
// 문제 설명 : 각 숫자가 자신과 동일한 수만큼 반복되는 수열에서 A번째부터 B번째까지의 합을 구하는 문제
// 입력 : 두 정수 A와 B가 주어진다
// 출력 : A번째 숫자부터 B번째 숫자까지 합을 출력한다
public class S_1292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        int[] arr = new int[1001];  // 최대 1000까지 수열 저장
        int index = 1;

        for (int i = 1; index <= 1000; i++) {
            for (int j = 0; j < i && index <= 1000; j++) {
                arr[index++] = i;
            }
        }

        int sum = 0;
        for (int i = A; i <= B; i++) {
            sum += arr[i];
        }

        System.out.println(sum);
    }
}
