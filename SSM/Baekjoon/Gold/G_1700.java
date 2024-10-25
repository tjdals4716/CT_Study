package Baekjoon.Gold;

import java.util.ArrayList;
import java.util.Scanner;

// 백준 1700번 : 멀티탭 스케줄링
// 문제 설명 : N개의 멀티탭을 가지고 M개의 전자기기를 사용해야 할 때, 멀티탭을 꽂았다 뽑는 최소 횟수를 계산한다
// 입력 : 첫 줄에 멀티탭의 개수 N과 전자기기의 사용 순서 길이 M이 주어진다. 둘째 줄에 M개의 전자기기의 사용 순서가 주어진다
// 출력 : 최소 뽑는 횟수를 출력한다
// 풀이 : 각 기기를 사용하기 위해 현재 멀티탭에 꽂힌 기기 중 나중에 사용되는 순서가 가장 늦은 기기를 뽑는 그리디 접근법을 사용한다
public class G_1700 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] devices = new int[K];

        for (int i = 0; i < K; i++) {
            devices[i] = sc.nextInt();
        }

        ArrayList<Integer> multitap = new ArrayList<>();
        int unplugs = 0;

        for (int i = 0; i < K; i++) {
            if (multitap.contains(devices[i])) {
                continue;
            }
            if (multitap.size() < N) {
                multitap.add(devices[i]);
                continue;
            }

            int removeIndex = -1;
            int maxFutureIndex = -1;

            for (int j = 0; j < multitap.size(); j++) {
                int currentDevice = multitap.get(j);
                int futureIndex = Integer.MAX_VALUE;

                for (int l = i + 1; l < K; l++) {
                    if (devices[l] == currentDevice) {
                        futureIndex = l;
                        break;
                    }
                }

                if (futureIndex > maxFutureIndex) {
                    maxFutureIndex = futureIndex;
                    removeIndex = j;
                }
            }

            multitap.remove(removeIndex);
            multitap.add(devices[i]);
            unplugs++;
        }

        System.out.println(unplugs);
    }
}
