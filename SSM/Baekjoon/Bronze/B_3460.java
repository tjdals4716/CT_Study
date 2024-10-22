package Baekjoon.Bronze;

import java.util.Scanner;

// 백준 3460번 : 이진수
// 문제 설명 : 양의 정수 n이 주어졌을 때, n을 이진수로 변환한 뒤 그 이진수에서 1이 나타나는 위치를 모두 출력하는 문제. 위치는 0부터 시작
// 입력 : 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스마다 양의 정수 n이 주어진다 (1 ≤ n ≤ 1,000,000)
// 출력 : 각 테스트 케이스마다 n을 이진수로 변환했을 때, 1이 나타나는 위치를 모두 출력
public class B_3460 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();  // 테스트 케이스의 개수

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();  // 각 테스트 케이스의 정수 n
            String binary = Integer.toBinaryString(n);  // n을 이진수 문자열로 변환

            // 이진수에서 1의 위치를 찾기
            for (int j = 0; j < binary.length(); j++) {
                if (binary.charAt(binary.length() - 1 - j) == '1') {
                    System.out.print(j + " ");
                }
            }
            System.out.println();  // 테스트 케이스마다 출력 후 줄바꿈
        }
    }
}
