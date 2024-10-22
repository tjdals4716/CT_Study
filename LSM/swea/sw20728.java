package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw20728 { // 20728 nCr에서 x-y의 최소값 구하기
    //이해 못한 문제
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st,st1;
        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++) {
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            arr= new long[N];
            st1 = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++){
                arr[i]=Integer.parseInt(st1.nextToken());
            }
            Arrays.sort(arr);
            long min=0,max=0,result=0;
            for(int i=0;i<=N-K;i++){
                min = arr[i];
                max = arr[K-1+i];
                result=Math.min(max-min,result);
            }
            System.out.println("#"+tc+" "+result);
        }
    }
}
