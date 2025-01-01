package Programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Subsequence { // 연속된 부분 수열의 합 LV2 부분 수열 최소 길이 구하기
    public static void main(String[] args) {
        int[] sequence = {2,2,2,2,2};
        int k=6;
        System.out.println(Arrays.toString(solution(sequence, k)));
    }
    public static int[] solution(int[] sequence, int k) {
        int[] answer = new int[2]; // 범위 기록 결과
        Queue<Integer> q = new LinkedList<>(); // Q 사용 OR sequence 의 길이 Start,End 길이로 가능.
        int sum=0, index=0, min = Integer.MAX_VALUE;
        for (int i : sequence) {
            if (sum <= k) { // 합이 k보다 작거나 같을때
                q.offer(i);
                sum += i;
            }
            while (sum > k) { // 합이 k보다 클때
                sum -= q.poll();
                index++;
            }
            if (sum == k && q.size() < min) { // 합이 k이고 길이가 min 보다 작을때(최소길이, index 우선 만족)
                answer[0] = index;
                answer[1] = index + q.size() - 1;
                min = q.size();
            }
        }
        return answer;
    }
}