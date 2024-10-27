package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw13547 { //13547 팔씨름
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            boolean[] victory = new boolean[15]; //내가이기면 false
            int viccnt=0;
            String result = "NO";
            String A = br.readLine();
            for(int i=0;i<A.length();i++){
                if(A.charAt(i)=='x'){
                    victory[i]=true; //상대방이 이기면 true
                }
            }
            for(int i=0;i<15;i++){
                if(!victory[i]){
                    viccnt++;
                }
            }
            if(viccnt>=8){
                result ="YES";
            }
            System.out.println("#"+tc+" "+result);


        }
    }
}