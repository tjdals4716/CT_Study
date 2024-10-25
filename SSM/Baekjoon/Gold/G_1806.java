package Baekjoon.Gold;

import java.util.Scanner;

// 백준 1806번 : 부분합
// 문제 설명 : 길이가 N인 수열과 정수 S가 주어질 때, 부분합이 S 이상이 되는 가장 짧은 연속 부분 수열의 길이를 구하는 문제이다
// 입력 : 첫 줄에 정수 N과 S가 주어집니다. 둘째 줄에 수열이 주어진다
// 출력 : 부분합이 S 이상이 되는 가장 짧은 연속 부분 수열의 길이를 출력한다. 만약 존재하지 않으면 0을 출력한다
// 풀이 : 투 포인터 방식을 사용하여 윈도우 크기를 최소화하면서 부분합이 S 이상이 되는 구간을 찾는다.
public class G_1806 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int left = 0, right = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        while (true) {
            if (sum >= S) {
                minLength = Math.min(minLength, right - left);
                sum -= arr[left++];
            } else if (right == N) {
                break;
            } else {
                sum += arr[right++];
            }
        }

        System.out.println(minLength == Integer.MAX_VALUE ? 0 : minLength);
    }
}
