package Baekjoon.Sliver;

import java.util.Arrays;
import java.util.Scanner;

// 백준 2693번 : N번째 큰 수
// 문제 설명 : 10개의 수가 주어졌을 때, 그 중 3번째로 큰 수를 구하는 문제
// 입력 : 첫째 줄에 테스트 케이스의 개수 T가 주어집니다. 각 테스트 케이스는 10개의 정수가 주어진다
// 출력 : 각 테스트 케이스마다 3번째로 큰 수를 출력한다
public class S_2693 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int[] arr = new int[10];
            for (int i = 0; i < 10; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            System.out.println(arr[7]);  // 3번째로 큰 수는 정렬 후 7번째 인덱스
        }
    }
}
