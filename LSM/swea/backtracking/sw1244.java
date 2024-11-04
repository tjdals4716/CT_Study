package swea.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw1244 { // 1244 n번의 교환횟수로 제일 큰값 찾기
    //백트래킹 사용 dfs를 나올때 원상복구하며 n번의 교환후 값이 최대값인지 판단
    static char arr[];
    static int M;
    static String result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String N = st.nextToken(); // 숫자
            M = Integer.parseInt(st.nextToken()); // 교환횟수
            arr = N.toCharArray();

            result="";
            back(0,0);
            System.out.println("#"+tc+" "+result);
        }
    }
    private static void back(int depth,int count) {
        if(count==M){
            String current = new String(arr);
            if(current.compareTo(result)>0) { // 만들어진 숫자가 result보다 크면
                result = current; // result 초기화
            }
            return;
        }
        for(int i=depth;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                swap(i,j);
                back(i,count+1);
                swap(i,j); //원상복구
            }
        }
    }

    private static void swap(int i,int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}