package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw6900 { // 6900
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String[] vic;
        int[] win;
        String s;
        int result;
        for(int tc=1;tc<=T;tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            vic = new String[n];
            win = new int[n];
            for(int i=0;i<n;i++) {
                st = new StringTokenizer(br.readLine());
                vic[i] = st.nextToken();
                win[i] = Integer.parseInt(st.nextToken());
            }
            result=0;
            for(int j=0;j<m;j++) {
                s=br.readLine();
                for(int h=0;h<n;h++) {
                    for(int k=0;k<8;k++) {
                        if(vic[h].charAt(k)!='*'&&vic[h].charAt(k)!=s.charAt(k)) {
                            break;
                        }
                        if(k==7) {
                            result += win[h];
                        }
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
    }
}