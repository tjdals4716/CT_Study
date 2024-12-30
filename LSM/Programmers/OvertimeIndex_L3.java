package Programmers;

import java.util.Arrays;
import java.util.Collections;

public class OvertimeIndex_L3 { // 야근 지수 LV3
    public static void main(String[] args) {

        int n=3;
        int[] works = {1,1};
        System.out.println(solution(n,works));
    }

    public static long solution(int n, int[] works) {
        long answer = 0;
        int max = works[0];
        Arrays.sort(works); // Integer 타입 사용
        L1:
        while(n>0){ // 야근이 끝날때까지
            for(int i=works.length-1;i>=0;i--){
                if(n==0||max==0) break L1; // 일이 끝나거나 야근의 시간이 끝났을때
                if(works[i]==max){
                    works[i]--;
                    n--;
                }else{
                    max=works[works.length-1]; // 최대 시간 초기화
                }
            }
        }
        for(int i=0;i<works.length;i++){
            answer += (long) works[i]*works[i]; // 제곱 수 모두 더하기
        }
        return answer;
    }
}
