package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw19185 { // 19185 년도에따른 육십갑자 출력
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        String[] ten;
        String[] twelve;
        for(int tc=1;tc<=T;tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); // 2개의문자열
            int n = Integer.parseInt(st.nextToken()); // 문자열의 갯수
            int m = Integer.parseInt(st.nextToken()); // 문자열의 갯수
            ten = new String[n];
            twelve = new String[m];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++) { // n개 문자열
                ten[i] = st.nextToken();
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<m;i++) { // m개 문자열
                twelve[i] = st.nextToken();
            }
            sb.append("#").append(tc);
            int Q = Integer.parseInt(br.readLine()); // 년도를 입력하는 횟수
            for(int i=0;i<Q;i++) {
                int Y = Integer.parseInt(br.readLine()); // 년도
                int idxten=(Y % n)-1;
                int idxtwelve=(Y % m)-1;
                if(idxten<0){ // -1이 나올경우
                    idxten+=n;
                }
                if(idxtwelve<0){ // -1이 나올경우
                    idxtwelve+=m;
                }
                sb.append(" ").append(ten[idxten]).append(twelve[idxtwelve]); //육십갑자 스트링빌더에 넣기
            }
            System.out.println(sb);
            sb.setLength(0);
        }
    }
}