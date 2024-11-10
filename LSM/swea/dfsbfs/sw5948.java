package swea.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw5948 { // 5948 dfs 7개중3개선택한 값들중 5번째로 큰값
    //solve 깊이3일때 누적값 배열체크
    static int[] arr;
    static boolean[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++) {
            arr = new int[7];
            result = new boolean[301];//1~100까지의 수 7개중 3개를뽑은 값 체크
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<7;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            solve(0,0,0);

            int val=0;
            int count=5;
            for(int i=300;i>=0;i--){
                if(result[i])count--;
                if(count==0) {
                    val=i;
                    break;
                }
            }
            System.out.println("#"+tc+" "+val);
        }
    }

    private static void solve(int start, int depth, int sum) {
        if(depth==3){
            result[sum] = true;
            return;
        } //깊이3일때의 값 체크
        for(int i=start;i<7;i++) {
            solve(i+1,depth+1,arr[i]+sum);
        }
    }
}

/*          set함수로 중복제거 후 list함수에 넣고 오름차순 정렬후 size-5 5번째로 큰 수 출력
            int[] arr = new int[7];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<7;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Set<Integer> set = new HashSet<>();
            for(int i=0;i<5;i++) {
                for(int j=i+1;j<6;j++) {
                    for(int k=j+1;k<7;k++) {
                        set.add(arr[i]+arr[j]+arr[k]);
                    }
                }
            }
            List<Integer> list = new ArrayList<>(set);

            Collections.sort(list);
            System.out.println("#"+tc+" "+list.get(list.size()-5));*/
