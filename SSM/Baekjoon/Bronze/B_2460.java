package Baekjoon.Bronze;

import java.util.Scanner;

// 백준 2460번 : 지능형 기차 2
// 문제 설명 : 한 기차역에 10개의 정차역이 있다. 각 역에서 내리고 타는 인원의 수가 주어질 때, 기차 안에 있는 사람의 최댓값을 구하는 문제
// 입력 : 각 줄에 내린 사람 수와 탄 사람 수가 주어진다
// 출력 : 기차 안에 있는 사람의 최대 인원을 출력한다
public class B_2460 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = 0;
        int current = 0;

        for (int i = 0; i < 10; i++) {
            int off = sc.nextInt();  // 내린 사람 수
            int on = sc.nextInt();   // 탄 사람 수
            current = current - off + on;  // 현재 기차에 있는 사람 수
            if (current > max) {
                max = current;  // 최대값 갱신
            }
        }
        System.out.println(max);  // 기차 안의 최대 인원
    }
}
