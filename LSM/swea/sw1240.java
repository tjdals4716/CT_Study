package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw1240 { //1240 암호코드 해독
    //문자열 암호의 존재여부탐색 문자열에 맞게 암호 해독하기
    static String[] arr = {"0001101","0011001","0010011","0111101","0100011","0110001","0101111","0111011","0110111","0001011"};
    static int result,sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); //세로크기
            int M = Integer.parseInt(st.nextToken()); //가로크기
            result=0;
            sum=0;
            boolean cnt = true;
            for(int i=0;i<N;i++) { //세로
                String S = br.readLine();
                if (S.contains("1")&&cnt) {
                    int lastIdx = S.lastIndexOf("1"); //마지막 1이있는 자리의 Idx 번호 저장
                    for (int j = 8; j >= 1; j--) { //j번째 자리의 암호코드(뒤에서부터 판별)
                        String B = S.substring(lastIdx - 6, lastIdx + 1); //lastIdx 부터 7개씩 자른문자열
                        lastIdx -= 7;
                        arrSerch(j,B); // 배열 탐색 (암호코드 해독)
                    }
                    cnt=false;
                }
            }
            sb.append("#").append(tc).append(" ");
            if(result%10==0){
                sb.append(sum);
            }else{
                sb.append(0);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void arrSerch(int i,String B) { //배열 탐색
        for (int j = 0; j <= 9; j++) {
            if (arr[j].equals(B)) { // 암호코드해석이 k일때
                if (i % 2 == 0) {
                    result += j;
                    sum += j;
                } else {
                    result += j*3;
                    sum += j;
                }
                break;
            }
        }
    }
}