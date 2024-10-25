package Baekjoon.Gold;

import java.util.Scanner;

// 백준 14719번 : 빗물
// 문제 설명 : 벽으로 이루어진 2차원 공간에서 빗물이 고일 수 있는 최대 양을 계산하는 문제이다
// 입력 : 첫 줄에 공간의 세로 길이 H와 가로 길이 W가 주어진다. 두 번째 줄에는 각 위치의 벽 높이가 주어진다
// 출력 : 고일 수 있는 빗물의 총량을 출력한다
// 풀이 : 각 위치에서 좌우의 최대 높이를 찾고, 그 중 작은 값을 기준으로 현재 위치에 고일 수 있는 빗물의 양을 계산한다
public class G_14719 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int W = sc.nextInt();
        int[] height = new int[W];

        for (int i = 0; i < W; i++) {
            height[i] = sc.nextInt();
        }

        int water = 0;

        for (int i = 1; i < W - 1; i++) {
            int leftMax = 0, rightMax = 0;
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            for (int j = i + 1; j < W; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            int minHeight = Math.min(leftMax, rightMax);
            if (minHeight > height[i]) {
                water += minHeight - height[i];
            }
        }

        System.out.println(water);
    }
}
