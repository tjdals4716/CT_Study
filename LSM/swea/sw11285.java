package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw11285 { // 11285 다트 점수 출력
    //StringBuilder로 실행시간 단축
    //원점으로 부터 반지름만큼의 과녁 점수 체크
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++) {
            int N = Integer.parseInt(br.readLine());
            int c=0;
            for(int i=0;i<N;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                double a = Math.sqrt(x*x+y*y); //원점에서 맞춘곳까지의 거리
                int p=0;
                if(a<=200) { //과녁 안일때
                    p = 10-(int)a/20; //p번째 과녁
                    if(a%20==0&&p!=10) p++; //경계선에 맞춘경우 +1 , a가 20이하일때
                    c+=p;
                }
            }
            sb.append("#").append(tc).append(" ").append(c).append("\n");
        }
        System.out.print(sb);
    }
}