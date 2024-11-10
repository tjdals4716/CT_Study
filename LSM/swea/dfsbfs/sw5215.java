package swea.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw5215 { // 5215 햄버거 다이어트
    // dfs 조합구현
    static int[] M,K;
    static int L,kal,N,result,score;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //재료의 수
            L = Integer.parseInt(st.nextToken()); // 제한 칼로리
            M = new int[N];
            K = new int[N];
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                M[i] = Integer.parseInt(st.nextToken());
                K[i] = Integer.parseInt(st.nextToken());
            }
            result=0;
            score =0;
            kal=0;
            for(int i=0;i<N;i++) {
                dfs(i);
            }
            System.out.println("#"+tc+" "+result);
        }
    }

    private static void dfs(int depth) {
        score+=M[depth];//맛점수
        kal+=K[depth];//현재 총 칼로리
        if(kal<=L) { // 칼로리가 제한 칼로리보다 작거나 같을때
            result=Math.max(result,score);
            for(int i=depth;i<N-1;i++) { // 범위만큼 돌면서
                dfs(i+1);
            }
        }
        //현재 총 칼로리가 제한칼로리 넘어가면
        score -= M[depth];
        kal -= K[depth];
    }
}