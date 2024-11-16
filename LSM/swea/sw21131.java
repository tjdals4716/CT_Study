package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw21131 { //21131 NxN배열에서 임의의 ixi배열 전치 하며 기존의 형태로 돌리기
    //현재값의 상태가 전치 상태에 따라 다르게 체크해야함.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) { //첫번째줄 ->배열에 주입
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for(int i = 1; i < N; i++) { //나머지 줄
                br.readLine();
            }
            boolean transposition =false; //전치상태체크 ture=전치 false=비전치
            int cnt=0;
            for(int i=N-1;i>=1;i--) {
                if(arr[i]!=i+1 && !transposition){ //비전치상태 - 비정상값
                    transposition = true; //전치상태전환
                    cnt++;
                }else if(arr[i]==i+1 && transposition){ //전치상태 - 정상값
                    transposition = false; //비전치상태전환
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }
}