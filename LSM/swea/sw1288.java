package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw1288 { // 1288  1~?*N 0~9까지의 숫자를 모두 봤으면 i*N 출력
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        boolean[] arr;
        for (int tc = 1; tc <= T; tc++) {
            String N = br.readLine();
            arr = new boolean[10];
            String val = "0";
            int count =0;
            while(count<10){
                val=String.valueOf(Integer.parseInt(val)+Integer.parseInt(N));
                for(int i=0;i<val.length();i++){
                    arr[Integer.parseInt(String.valueOf(val.charAt(i)))]=true;
                }
                count=0;
                for(int i=0;i<10;i++){
                    if(arr[i]){
                        count++;
                    }else{
                        break;
                    }
                }
            }
            System.out.println("#"+tc+" "+val);
        }
    }
}