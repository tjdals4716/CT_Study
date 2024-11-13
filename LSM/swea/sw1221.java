package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class sw1221 { //1221 0~9까지의 수를 영어로 표현하여 순서상관없이 입력받아서 정렬하기
    //0~9까지 배열 arr를 HashMap "Key"로 두고 문자("Key")가 들어올때 "Value"값 +1
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        String[] arr = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
        for(int tc=1;tc<=T;tc++) {
            st = new StringTokenizer(br.readLine());
            sb.append(st.nextToken()).append("\n");
            int N = Integer.parseInt(st.nextToken());
            HashMap<String,Integer> map = new HashMap<String,Integer>();
            for(int i=0;i<arr.length;i++) {
                map.put(arr[i], 0);
            }
            String S = "";
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                S = st.nextToken();
                map.put(S,map.get(S)+1);
            }
            for(int i=0;i<arr.length;i++) {
                int val=map.get(arr[i]);
                for(int j=0;j<val;j++) {
                    sb.append(arr[i]).append(" ");
                }
            }
            System.out.println(sb);
            sb.setLength(0);
        }
    }
}