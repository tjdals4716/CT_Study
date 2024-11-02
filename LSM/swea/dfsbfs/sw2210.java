package swea.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class sw2210 {//2210
    static int[][] arr;
    static Set<String> result;
    static int[] selected;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[5][5];
        result = new HashSet<>();
        selected = new int[6];
        for(int i=0;i<5;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                dfs(0,i,j);
            }
        }
        System.out.println(result.size()+" ");

    }
    private static void dfs(int depth,int x,int y) {
        if(depth == 6){ // 깊이 6에 도달 시
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<6;i++){ //sb에 문자열로 다 넣기
                sb.append(selected[i]);
            }
            result.add(sb.toString()); //  Set함수에 넣어 중복제거
            return;
        }
        for(int d=0;d<4;d++){// 방향돌리기
            int nx = x + dx[d]; // 1. x좌표+ 2. x좌표-
            int ny = y + dy[d]; // 3. y좌표+ 4. y좌표-
            if(isValidPosition(nx,ny)){ // 좌표공간을 벗어나지 않을때
                selected[depth] = arr[nx][ny]; // 현재 깊이의 수 기록
                dfs(depth+1,nx,ny); // 재귀 함수
            }
        }
    }

    static boolean isValidPosition(int x,int y){
        return 0<=x && x<5 && 0<=y && y<5;
    }

}
