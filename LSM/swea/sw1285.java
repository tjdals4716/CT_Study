package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw1285 { // 1285 돌던지기
    // 음수->양수로 바꿔 정렬후 첫번째와 같은거출력
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] arr;
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N];
            int count=0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                arr[i] =Math.abs(Integer.parseInt(st.nextToken()));
            }
            Arrays.sort(arr);
            for(int i=0;i<N;i++){
                if(arr[0]==arr[i]){
                    count++;
                }
            }
            System.out.println("#"+tc+" "+arr[0]+" "+ count);

        }
    }
}