package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class parsing22233 { //22233 Silver3 파싱
    // 사용한 키워드를 내 키워드 사전에서 제거하면서 총 남은 키워드 갯수 구하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<N;i++){
            map.put(br.readLine(),1);
        }
        int cnt=map.size();
        for(int i=0;i<M;i++) {
            String[] str = br.readLine().split(",");
            for (String a : str) {
                cnt--;
                map.remove(a);
            }
            System.out.println(cnt);
        }
    }
}
