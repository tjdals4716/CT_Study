package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw1206 {// 1206 View 현재칸에서 양쪽두칸의 조망권이 몇칸확보되는지
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N+1];
            int result=0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=2;i<N-2;i++){
                int sidemax = Math.max(arr[i-1],Math.max(arr[i-2],Math.max(arr[i+1],arr[i+2])));
                if(sidemax<arr[i]){//양쪽2칸내의 건물 큰값이 현재건물의 높이보다 작으면
                    result+=arr[i]-sidemax;
                }
            }
            System.out.println("#"+tc+" "+result);
        }
    }
}