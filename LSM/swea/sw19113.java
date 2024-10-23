package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class sw19113 { // 19113 : 완전탐색 (특정값 수정하며)
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N+N];
            List<Integer> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N+N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for(int j=N+N-1;j>=0;j--){ // 배열의 마지막~0
                if(arr[j]!=0) { // 0이아니면
                    int num =arr[j] - (arr[j] / 4);
                    list.add(num);
                    for (int k =j-1; k >= 0; k--) {
                        if (arr[k] == num) {
                            arr[k] = 0;
                            arr[j]=0;
                            break;
                        }

                    }
                }
            }
            System.out.print("#"+tc+" ");
            for(int i=list.size()-1;i>=0;i--){
                System.out.print(list.get(i)+" ");
            }
            System.out.println();
        }

    }

}