package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class sw7272 { // 7272 : 두문자를 알파벳의 구멍 수로 비교하여 같은지 체크
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        char[] nohole = {'C','E','F','G','H','I','J','K','L','M','N','S','T','U','V','W','X','Y','Z'};
        char[] onehole = {'A','D','O','P','Q','R'};
        HashMap<Character,Boolean> map = new HashMap<>();
        for(int i=0;i<nohole.length;i++){
            map.put(nohole[i],true);
        }
        for(int i=0;i<onehole.length;i++){
            map.put(onehole[i],false);
        }
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String A = st.nextToken();
            String B = st.nextToken();

            String result = "DIFF";
            L1 :
            if(A.length()==B.length()){

                for(int i=0;i<A.length();i++){
                    if(A.charAt(i)=='B'&&B.charAt(i)=='B'){
                    }else if(map.get(A.charAt(i))!=map.get(B.charAt(i))){
                        result = "DIFF";
                        break L1;
                    }
                }
                result = "SAME";
            }


            System.out.println("#"+tc+" "+result);
        }
    }
}