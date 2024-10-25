package Baekjoon.Gold;

import java.util.*;

// 백준 2252번 : 줄 세우기
// 문제 설명 : 학생들의 키 순서를 비교한 정보가 주어질 때, 키 순서에 따라 줄을 세우는 문제이다
// 입력 : 첫 줄에 학생 수 N과 비교 횟수 M이 주어진다. 이후 M개의 줄에 두 학생의 비교 결과가 주어진다
// 출력 : 학생들을 키 순서에 따라 나열한 결과를 출력한다
// 풀이 : 위상 정렬을 이용하여 주어진 조건에 맞는 순서를 구한다
public class G_2252 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[N + 1];
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            inDegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);

            for (int neighbor : graph.get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) queue.add(neighbor);
            }
        }

        for (int student : result) {
            System.out.print(student + " ");
        }
    }
}
