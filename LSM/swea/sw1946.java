package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw1946 { // 1946 : 간단한 압축 풀기 알파벳과 숫자를 입력받아 10개마다 개행 모두출력
    //입력하나마다 하나씩 StringBuilder에 추가하며 cnt를 세고 10이 되면 개행하며 초기화
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            sb.append("#").append(tc).append("\n");
            for (int i = 0; i < N; i++) {
                int cnt=10;
                StringTokenizer st = new StringTokenizer(br.readLine());
                char ch = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                for (int j = 0; j < num; j++) {
                    sb.append(ch);
                    cnt++;
                    if (cnt == 10) {
                        cnt = 0;
                        sb.append("\n");
                    }
                }
            }
            System.out.println(sb);
            sb.setLength(0);
        }
    }
}