package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//구현중
public class sw11315 { // 11315 오목 판정
    static boolean[][] arr;
    static int[][] road = {{0, 1}, {-1, 0}, {1, 1}, {1, -1}};//오른쪽,아래,오른쪽아래,왼쪽아래
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < N; j++) {
                    if (s.charAt(j) == 'o') {
                        arr[i][j] = true;
                    }
                }
            }
            String answer = "NO";
            L1:
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j]) {
                        for (int way = 0; way < road.length; way++) {
                            int cnt = count(i, j, way);
                            if (cnt == 5) {
                                answer = "YES";
                                break L1;
                            }
                        }
                    }
                }
            }
            System.out.println("#" + tc + " " + answer);
        }
    }

    //가로 세로
    private static int count(int i, int j, int way) {
        int cnt = 1;
        int x = i, y = j;
        for (int w = 0; w < 4; w++) {
            x += road[way][0];
            y += road[way][1];
            if (x >= 0 && x < N && y >= 0 && y < N && arr[x][y]) {
                // 돌이 오목판 안에 있고, 돌이 존재한다면
                cnt++;
            } else {
                break;
            }
        }
        return cnt;
    }
}
