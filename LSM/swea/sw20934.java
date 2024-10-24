package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw20934 { // 20934 3개의 컵 1개의 방울 컵안에 넣고 섞었을때 경우의 수 정리
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            int K = Integer.parseInt(st.nextToken());
            int w=0,ans=0;
            for(int i=0;i<3;i++){
                if(S.charAt(i)=='o'){
                    w=i; //공의 위치 왼0 중1 오2
                }
            }
            if(K==0){ //공의 위치 출력
                ans =w;
            }else if(K>=1){
                if(K%2==0){ // 짝수 일때 경우의 수
                    if(w==1){ //중앙
                        ans=1;
                    }else{
                        ans=0;
                    }
                }else if(K%2==1){ // 홀수 일때 경우의 수
                    if(w==0||w==2){ //왼,오른쪽
                        ans=1;
                    }else{
                        ans=0;
                    }
                }
            }
            System.out.println("#"+tc+" "+ans);
        }
    }
}