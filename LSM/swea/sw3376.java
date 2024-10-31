package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class sw3376 { // 3376
    //삼각형을 반시계방향으로 변의 길이만큼 이어 붙일때 N번째의 넓이는 몇배인가
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        List<Long> list = new ArrayList<Long>();
        list.add(1L);
        list.add(1L);
        list.add(1L);
        list.add(2L);
        list.add(2L);
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            if (N > list.size() - 1) {
                for (int i = list.size(); i <= N; i++) {
                    list.add(i,list.get(i-5)+list.get(i-1));
                }
            }
            System.out.println("#"+tc+" "+ list.get(N-1));
        }
    }
}