package Baekjoon.dfsbfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class b17472_G1 { //알고리즘 부분만 공부해서 다시 풀어보기
    // 1. 지도 그리기
    // 2. 각 섬의 넘버링
    // 3. 각 섬을 이을 수 있는 다리의 최소 길이 구하기
    // 4. 다리에 대한 크루스칼 알고리즘

    // 크루스칼 알고리즘 ,최소 신장 트리(MST)
    static Queue<Point> q;
    static int[][] map,bridge;
    static boolean[][] visited,isBridge;
    static boolean[] visitedBridge;
    static int[] dx = {1,0,-1,0}, dy = {0,-1,0,1};
    static int N,M, num=1,islandNum,length,val,result=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M]; //지도 초기화
        visited = new boolean[N][M]; // 방문 초기화
        // 지도 그리기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                if(Objects.equals(st.nextToken(), "1")) {
                    map[i][j] = 1;
                }
            }
        }
        // 각 섬의 넘버링
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(map[i][j]==1&&!visited[i][j]) {
                    map[i][j] = num;
                    dfsNumbering(i,j);
                    num++; // 각섬의 넘버 변환
                }
            }
        }

        // 각 섬의 다리 길이 구하기 (간선 구하기, 최소 길이)
        bridge = new int[num][num]; // 간선 초기화
        isBridge = new boolean[num][num];
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(visited[i][j]) { // 방문 가능한곳
                    islandNum = map[i][j];
                    bfsBridge(i,j); //간선 구하기
                }
            }
        }


        // 다리에 대한 크루스칼 알고리즘(작성필요)
        for(int i=1;i<num;i++) {
            val=0;
            visitedBridge = new boolean[num];
            SearchBridge(1,i);
        }

        // 간선 출력
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<num;i++) {
            for(int j=0;j<num;j++) {
                sb.append(bridge[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);

        if(result==Integer.MAX_VALUE) {
            result=-1;
        }

        System.out.println(result);

        /*
        1 4
        1 0 0 1
*/
    }

    private static void SearchBridge(int depth,int start) {
        visitedBridge[start] = true;
        if(depth==num-1){ // 모든 노드 탐색했을때
            result = Math.min(result,val);
            return;
        }
        for(int i=start+1;i<num;i++) { // 다음 노트 탐색
            if(!visitedBridge[i]) {
                val+=bridge[start][i];
                SearchBridge(depth+1,i);
            }
        }
        visitedBridge[start] = false;
    }

    private static void bfsBridge(int y, int x) {
        q = new LinkedList<>();
        islandQAdd(y,x); // 섬의 좌표 q에 추가
        while(!q.isEmpty()) { // 현재 섬의 좌표를 다 돌기
            Point p = q.poll();
            for(int d =0;d<4;d++) { // 방향
                int nx = p.x;
                int ny = p.y;
                length=-1;
                while (true) { // 방향에 대한 길이 늘리기
                    nx += dx[d];
                    ny += dy[d];
                    length++; // 현재 길이

                    if (!overCheck(ny, nx)) break; // 배열오버시 현재 방향의 탐색 나가기
                    if (map[ny][nx] == islandNum) break; // 원시 섬일때
                    if (visited[ny][nx] && length > 1) { // 방문 가능하고 길이가 2이상일때

                        int nextIslandNum = map[ny][nx];
                        // 다리가 없을때 || 길이가 더 짧을때
                        if (bridge[islandNum][nextIslandNum] == 0 || bridge[islandNum][nextIslandNum] > length) {
                            // 양방향 길이 주입 && 다리의 존재여부체크
                            bridge[islandNum][nextIslandNum] = bridge[nextIslandNum][islandNum] = length;
                            isBridge[islandNum][nextIslandNum] = isBridge[nextIslandNum][islandNum] = true;
                        }
                        break;
                    }

                }
            }

        }
    }

    private static void dfsNumbering(int y, int x) { // 넘버링
        visited[y][x] = true;
        // 방향 전환
        for(int d=0;d<4;d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            //배열 오버체크&&섬유무 체크 && 방문 안했는지
            if(overCheck(ny,nx)&&map[ny][nx]==1&&!visited[ny][nx]) {
                map[ny][nx] = num;

                dfsNumbering(ny,nx);
            }
        }
    }
    private static boolean overCheck(int y,int x){ // 배열오버체크
        return x>=0&&y>=0&&x<M&&y<N;
    }

    private static void islandQAdd(int y, int x){
        boolean[][] check = visited;
        q.offer(new Point(x,y));
        for(int d=0;d<4;d++){
            int nx = x+dx[d];
            int ny = y+dy[d];
            if(overCheck(ny,nx)&&check[ny][nx]){ // 배열 오버체크 && 섬 방문가능한곳일때
                check[ny][nx] = false;
                islandQAdd(ny,nx);
                q.offer(new Point(nx,ny));
            }
        }
    }

}