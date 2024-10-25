package Baekjoon.Gold;

import java.util.*;

// 백준 1197번 : 최소 스패닝 트리
// 문제 설명 : 가중치가 있는 무방향 그래프가 주어졌을 때, 모든 정점을 연결하는 최소 비용의 스패닝 트리(MST)를 찾는 문제이다
// 입력 : 첫 줄에 정점의 개수 V와 간선의 개수 E가 주어진다. 이후 E개의 간선 정보가 주어지며, 각각의 간선은 두 정점과 가중치로 표현된다
// 출력 : MST의 가중치 합을 출력한다
// 풀이 : 크루스칼 알고리즘을 사용하여 간선을 가중치 오름차순으로 정렬 후, 간선들을 하나씩 추가하며 MST를 만든다. 간선이 사이클을 만들지 않도록 유니온-파인드 자료구조를 활용한다.
public class G_1197 {
    static class Edge implements Comparable<Edge> {
        int u, v, weight;

        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int weight = sc.nextInt();
            edges.add(new Edge(u, v, weight));
        }

        Collections.sort(edges);

        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        int mstWeight = 0;
        for (Edge edge : edges) {
            if (find(edge.u) != find(edge.v)) {
                union(edge.u, edge.v);
                mstWeight += edge.weight;
            }
        }

        System.out.println(mstWeight);
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
        }
    }
}
