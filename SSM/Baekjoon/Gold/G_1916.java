package Baekjoon.Gold;

import java.util.*;

// 백준 1916번 : 최소 비용 구하기
// 문제 설명 : 도시 간 버스 요금이 주어졌을 때, 주어진 두 도시 사이의 최소 비용을 계산하는 문제이다
// 입력 : 첫 줄에는 도시의 개수 N과 버스의 개수 M이 주어진다. 이후 각 버스 정보가 시작 도시, 도착 도시, 비용 형태로 주어진다. 마지막 줄에는 출발점과 도착점이 주어진다
// 출력 : 출발점에서 도착점까지 가는 최소 비용을 출력한다
// 풀이 : 다익스트라 알고리즘을 사용하여 최단 경로를 찾는다
public class G_1916 {
    static class Node implements Comparable<Node> {
        int vertex, cost;

        Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int cost = sc.nextInt();
            graph.get(u).add(new Node(v, cost));
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        System.out.println(dijkstra(graph, start, end, N));
    }

    private static int dijkstra(List<List<Node>> graph, int start, int end, int N) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;
            int cost = current.cost;

            if (cost > dist[u]) continue;

            for (Node next : graph.get(u)) {
                int v = next.vertex;
                int nextCost = cost + next.cost;

                if (nextCost < dist[v]) {
                    dist[v] = nextCost;
                    pq.add(new Node(v, nextCost));
                }
            }
        }

        return dist[end];
    }
}
