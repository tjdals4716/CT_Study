package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw2805 { // 2805 농작물 수확하기 NxN 에서 마름모 최대크기의 범위에 들어가는 값의 합 출력
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++) {
            int N =Integer.parseInt(br.readLine());
            int result =0;
            int s=0;
            for(int i=0;i<N;i++) {
                String S =br.readLine();
                for (int j = N / 2 - s; j <= N / 2 + s; j++) {
                    result += S.charAt(j)-'0';
                }
                if(N/2>i) s++; // y축의 중앙지점 갈때까지 ++
                else s--;  // y축의 중앙에서 내려올때 --
            }
            System.out.println("#"+tc+" "+result);
        }
    }
}