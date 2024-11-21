package Baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw1249  { //1249 bfs로 풀어보기
    static int[] dx ={1,0,0,-1};
    static int[] dy ={0,-1,1,0};
    static int[][] arr,sum;
    static boolean[][] visited;
    static int N,result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            sum = new int[N][N];
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < N; j++) {
                    arr[i][j] = s.charAt(j)-'0';
                }
            }
            sum[0][0]=0;
            result=Integer.MAX_VALUE;
            dfs(0,0);
            System.out.println("#"+tc+" "+result);
        }
    }
    private static void dfs(int x,int y) {
        if(x+y==N*2-2){ // 도착지
            result = Math.min(result,sum[y][x]);
            return;
        }
        if(result<=sum[y][x]) return; //현재위치의 값이 최소결과보다 작거나 같을때
        for (int c = 0; c < 4; c++) { //다음 배열 탐색
            int nx = x + dx[c];
            int ny = y + dy[c];
            if (ArrOverVisit(nx, ny)) { //배열넘는지
                int tmp = sum[y][x]+arr[ny][nx];
                if(!visited[ny][nx]||tmp<sum[ny][nx]) {
                    visited[y][x] = true;
                    sum[ny][nx]=tmp;
                    dfs(nx, ny);
                }
            }
        }
    }
    private static boolean ArrOverVisit(int x, int y) {
        return x>=0 && x<N && y>=0 && y<N;
    }

}
//================================================================
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class Solution { //1249 bfs로 풀어보기
//    static int[] dx ={1,0,0,-1};
//    static int[] dy ={0,-1,1,0};
//    static int[][] arr,sum;
//    static boolean[][] visited;
//    static int N,result;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine());
//        for(int tc=1;tc<=T;tc++) {
//            N = Integer.parseInt(br.readLine());
//            arr = new int[N][N]; //소요되는 비용
//            sum = new int[N][N]; //총합
//            visited = new boolean[N][N];//방문체크
//
//            for(int i=0;i<N;i++){ //배열의 위치까지 가는 최소비용
//                Arrays.fill(sum[i],Integer.MAX_VALUE);
//            }
//            for (int i = 0; i < N; i++) {
//                String s = br.readLine();
//                for (int j = 0; j < N; j++) {
//                    arr[i][j] = s.charAt(j)-'0';
//                }
//            }
//            sum[0][0]=0;
//            bfs(0,0);
//            System.out.println("#"+tc+" "+sum[N-1][N-1]);
//        }
//    }
//
//    private static void bfs(int x, int y) {
//        Queue<position2> q = new LinkedList<>();
//        q.offer(new position2(x,y)); //Queue에 생성자 초기화 해서 추가
//        while (!q.isEmpty()) {
//            position2 next = q.poll(); //클래스의 x,y값을 가지고있는 next
//            for(int c=0;c<4;c++){
//                int nx = next.x + dx[c];
//                int ny = next.y + dy[c];
//                if(ArrOverVisit(nx,ny)){
//                    if(sum[ny][nx]>arr[ny][nx]+sum[next.y][next.x]){
//                        //다음 총 비용 > 다음 비용 + 현재 총 비용
//                        // 작성하기 @@@@@@@@@@@@@@@@@@@@@@@@@@@
//                    }
//                }
//            }
//        }
//    }
//
//
//
//    private static class position2 { //생성자를 Queue에 넣기
//        int x,y;
//        position2(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//    private static boolean ArrOverVisit(int x, int y) {
//        return x>=0 && x<N && y>=0 && y<N;
//    }
//
//}