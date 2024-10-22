package Baekjoon.Sliver;

import java.util.*;

// 그래프 DFS(깊이 우선 탐색), BFS(너비 우선 탐색) 탐색
// 방문할 수 있는 정점이 여러 개인 경우에는 번호가 작은 것을 먼저 방문
// 더 이상 방문할 수 있는 정점이 없는 경우 종료
// 정점 번호 : 1번 ~ N번
public class S_1260 {
    static ArrayList<Integer>[] graph; // 인접 리스트로 그래프 구현
    static boolean[] visited; // 방문 여부 체크 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 정점의 개수
        int M = sc.nextInt(); // 간선의 개수
        int V = sc.nextInt(); // 시작할 정점

        // 그래프 초기화
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);  // 양방향 간선이므로 양쪽에 추가
        }

        // 번호가 작은 순으로 방문하기 위해 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        // DFS 수행
        visited = new boolean[N + 1];  // 방문 여부 초기화
        dfs(V);
        System.out.println();  // 줄 바꿈

        // BFS 수행
        visited = new boolean[N + 1];  // 방문 여부 다시 초기화
        bfs(V);
    }

    // DFS (깊이 우선 탐색)
    public static void dfs(int node) {
        visited[node] = true;  // 현재 노드 방문 처리
        System.out.print(node + " ");  // 출력

        for (int next : graph[node]) {  // 인접한 노드들 탐색
            if (!visited[next]) {
                dfs(next);  // 방문하지 않은 노드라면 재귀 호출
            }
        }
    }

    // BFS (너비 우선 탐색)
    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;  // 시작 노드 방문 처리

        while (!queue.isEmpty()) {
            int node = queue.poll();  // 큐에서 노드 꺼내기
            System.out.print(node + " ");  // 출력

            for (int next : graph[node]) {  // 인접한 노드들 탐색
                if (!visited[next]) {
                    queue.add(next);  // 방문하지 않은 노드 큐에 추가
                    visited[next] = true;  // 방문 처리
                }
            }
        }
    }
}


