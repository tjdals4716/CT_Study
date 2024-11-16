package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw20955 { //20955 XY문자열
    // 1. 제일 뒤에 'X'를 붙인다.
    // 2. 뒤집은 다음 제일 뒤에 'Y'를 붙인다.
    // 위의 조건을 통해 주어진 문자열이 완성될 수 있는지
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb,E;
        sb = new StringBuilder();
        E = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String S = br.readLine(); //초기상태
            E.append(br.readLine()); //후기상태
            for(int i=E.length()-1;i>=S.length();i--){
                if(E.charAt(i)=='Y'){
                    E.deleteCharAt(i); //X,Y delete
                    E.reverse(); // Y일 경우 뒤집기
                }else{
                    E.deleteCharAt(i); //X,Y delete
                }
            }
            String result = "No";
            if(S.contentEquals(E)){
                result="Yes";
            }
            sb.append("#").append(tc).append(" ").append(result).append("\n");
            E.setLength(0);
        }
        System.out.print(sb);
    }
}