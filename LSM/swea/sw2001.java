package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw2001 { //2001 : nxn칸의 mxm파리채로 파리 최대로 잡는 수arrSearch_nxn
    static int arr[][];
    static int tc,n,m,num,max;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        tc = Integer.parseInt(br.readLine());
        for(int i=1;i<=tc;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new int[n][n];
            for(int x=0;x<n;x++){
                st = new StringTokenizer(br.readLine()," ");
                for(int y=0;y<n;y++){
                    arr[y][x]=Integer.parseInt(st.nextToken());
                }
            }
            max= Integer.MIN_VALUE;
            for(int x=0;x<=n-m;x++){ // x축
                for(int y=0;y<=n-m;y++){ //y축
                    for(int w=x;w<m+x;w++) {
                        for (int h = y; h < m+y; h++) {
                            num += arr[w][h];
                        }
                    }
                    max = Math.max(max, num);
                    num=0;
                }
            }
            System.out.println("#"+i+" "+max);
        }

    }

}