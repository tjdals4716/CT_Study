package Baekjoon.Sliver;

import java.util.Scanner;

// 문제 설명 : 서로 다른 자연수들의 합이 S인 경우, 자연수의 개수를 최대화하는 문제이다
// 입력 : 하나의 자연수 S가 주어진다
// 출력 : S를 만드는 데 필요한 서로 다른 자연수들의 최대 개수를 출력한다
// 풀이 : 서로 다른 자연수들의 합을 최대화하기 위해선, 가장 작은 자연수부터 차례로 더해가면서 합이 S를 넘지 않도록 한다. 자연수 1, 2, 3, ...를 순서대로 더해가며, 이 합이 S를 넘지 않는 한에서 최대 개수를 구한다
// 예를 들어 S = 15인 경우 : 1 + 2 + 3 + 4 + 5 = 15로 합이 딱 맞고, 총 5개의 수로 이루어져 있다
public class S_1789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long S = sc.nextLong();
        long sum = 0;
        int count = 0;

        for (int i = 1; ; i++) {
            if (sum + i > S) {
                break;
            }
            sum += i;
            count++;
        }

        System.out.println(count);
    }
}
