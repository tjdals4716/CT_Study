package Baekjoon.Sliver;

import java.util.Scanner;

// 백준 14888번 : 연산자 끼워넣기
// 문제 설명 : N개의 정수와 +, -, *, / 연산자가 주어진다. 각 정수 사이에 연산자를 삽입하여 결과값을 계산할 때, 가능한 최대값과 최소값을 출력하는 문제이다
// 입력 : 첫 줄에 정수 N이 주어진다. (2 ≤ N ≤ 11), 둘째 줄에는 N개의 정수가 주어진다. (각 정수는 1 이상 100 이하), 셋째 줄에는 덧셈, 뺄셈, 곱셈, 나눗셈 연산자의 개수가 공백으로 구분되어 주어진다
// 출력 : 가능한 결과 중 최대값과 최소값을 차례로 출력한다
// 풀이 : DFS를 이용하여 모든 가능한 경우를 탐색하고, 각 연산의 결과를 계산한다. 깊이 우선 탐색을 통해 각 연산자를 사용한 결과를 재귀적으로 계산하고, 최종 값이 최대인지 최소인지를 비교하며 갱신한다
public class S_14888 {
    static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] numbers;
    static int[] operators = new int[4]; // +, -, *, /

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            operators[i] = sc.nextInt();
        }

        dfs(1, numbers[0]);

        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int depth, int result) {
        if (depth == N) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;

                if (i == 0) dfs(depth + 1, result + numbers[depth]);
                else if (i == 1) dfs(depth + 1, result - numbers[depth]);
                else if (i == 2) dfs(depth + 1, result * numbers[depth]);
                else if (i == 3) dfs(depth + 1, result / numbers[depth]);

                operators[i]++;
            }
        }
    }
}
