package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw1220 { //1220 교착상태 찾는 함수 구현
    static int[][] arr;
    static int cnt,T;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int tc=1;tc<=10;tc++) {
            T = Integer.parseInt(br.readLine());
            arr = new int[T][T];
            for(int i=0;i<T;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<T;j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append("#").append(tc).append(" ").append(getCnt()).append("\n");
        }
        System.out.print(sb);
    }

    private static int getCnt() { //교착상태인 갯수 카운트하는 함수
        cnt=0;
        for(int i=0;i<T;i++){ //y축 탐색
            boolean n=false; //N극 존재여부
            boolean s=false; //S극 존재여부
            for(int j=0;j<T;j++){
                if(arr[j][i]==1){ //1=n극
                    n=true;
                    s=false; //이전의 s극값 초기화
                }
                if(arr[j][i]==2){ //2=s극
                    s=true;
                }
                if(n&&s){
                    cnt++;
                    n=false;
                    s=false;
                }
            }
        }
        return cnt;
    }
}