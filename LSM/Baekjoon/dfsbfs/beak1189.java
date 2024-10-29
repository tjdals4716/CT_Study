package Baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak1189 { // 1189 컴백홈 dfs
    //왔던길 체크하며 집으로 돌아갈때 K번의 걸음으로 돌아가게되는 경우의 수
    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,-1,0,1};
    static int R,C,K,cnt=0,result=0;
    static boolean[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new boolean[R][C];
        for(int i=0;i<R;i++){
            String line = br.readLine();
            for(int j=0;j<C;j++){
                if(line.charAt(j)!='T'){
                    arr[i][j] = true;
                }
            }
        }
        dfs(0,R-1); // 시작지점 0,R-1
        System.out.println(result);
    }
    private static void dfs(int x, int y) {
        arr[y][x] = false; //현재 위치:false 거리:1증가
        cnt++;
        if(!arr[0][C-1]&&cnt==K){ // 현재 위치가 집이고 집까지의 거리가 cnt=K일 경우
            result++;
        }else if(arr[0][C-1]&&cnt<K){ // 현재위치가 집이아니고 거리가 K미만일때
            for(int c=0;c<4;c++){ // 방향전환
                if(OverCheck(x+dx[c],y+dy[c])) { // 배열Over 체크하고 그배열을 방문안했으면
                    int nx = x + dx[c];
                    int ny = y + dy[c];
                    dfs(nx,ny); // 다음 길로 진입
                }
            }
        }
        arr[y][x]=true; //해당노드 나갈때 다시 true 로 변경
        cnt--;
    }
    private static boolean OverCheck(int x, int y) { // 배열넘어가는것과 다음칸을 방문안했을때 true
        return x>=0&&x<C&&y>=0&&y<R&&arr[y][x];
    }
}
