package Programmers;

import java.io.IOException;

public class PCCE_9 { // 지폐접기 LV1
    public static void main(String[] args) throws IOException {
        int[] wallet = {50,50};
        int[] bill = {100,241};
        System.out.println(solution(wallet,bill));
    }
    public static int solution(int[] wallet, int[] bill) {
        int answer = 0;
        while(true){
            if((bill[0]<=wallet[0]&&bill[1]<=wallet[1])
                    || (bill[1]<=wallet[0]&&bill[0]<=wallet[1])) return answer;
            if(bill[0]>bill[1]){
                bill[0]/=2;
                answer++;
            }else{
                bill[1]/=2;
                answer++;
            }
        }
    }
}
