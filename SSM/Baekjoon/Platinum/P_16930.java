package Baekjoon.Platinum;

import java.util.*;

// 백준 16930번 : 달리기
// 문제 설명 : N x M 크기의 체육관에서 K 만큼 점프하며 목적지까지 이동하는 문제이다. 시작점에서 목표 지점까지 최소 시간에 도달해야 하며, 점프는 최대 K 칸까지만 가능하다. 체육관은 벽(#)과 빈 칸(.)으로 이루어져 있으며 벽은 통과할 수 없다
// 입력 : 첫 번째 줄에 N, M, K가 주어진다. 그 다음 N개의 줄에 체육관 정보가 주어진다. 마지막 줄에는 시작 좌표와 목표 좌표가 주어진다
// 출력 : 시작 지점에서 목표 지점까지 최소 시간(칸 수)을 출력한다. 경로가 없다면 -1을 출력한다
// 풀이 : BFS(너비 우선 탐색)를 사용하여 최단 거리를 구하는 문제이다. 각 점에서 상하좌우 K 칸까지 이동할 수 있으므로, 점프 가능한 거리를 모두 검사하며 방문하지 않은 위치로 이동한다. 각 좌표를 방문했는지 확인하고, BFS 큐에 이동할 좌표와 현재 이동 거리를 저장한다
public class P_16930 {
    static int N, M, K;
    static char[][] gym;
    static int[][] dist;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        sc.nextLine(); // 개행 처리

        gym = new char[N][M];
        dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            gym[i] = line.toCharArray();
            Arrays.fill(dist[i], -1);
        }

        int startX = sc.nextInt() - 1;
        int startY = sc.nextInt() - 1;
        int endX = sc.nextInt() - 1;
        int endY = sc.nextInt() - 1;

        System.out.println(bfs(startX, startY, endX, endY));
    }

    static int bfs(int startX, int startY, int endX, int endY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        dist[startX][startY] = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];

            if (x == endX && y == endY) return dist[x][y];

            for (int d = 0; d < 4; d++) {
                for (int step = 1; step <= K; step++) {
                    int nx = x + dx[d] * step;
                    int ny = y + dy[d] * step;

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || gym[nx][ny] == '#') break;
                    if (dist[nx][ny] != -1 && dist[nx][ny] <= dist[x][y] + 1) break;

                    dist[nx][ny] = dist[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return -1;
    }
}
