package Programmers;

import java.util.Arrays;
import java.util.HashMap;

public class HashMap_Tree_L3 { // 다단계 칫솔 판매 LV3 노드 별 값이 주어질때 상위 노드로 10%씩 전달
    static HashMap<String, String> map = new HashMap<>(); // 하위노드, 상위노드 간선
    static HashMap<String, Integer> result = new HashMap<>(); // 결과 map
    static int referralMoney,enrollMoney;

    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};
        System.out.println(Arrays.toString(solution(enroll, referral, seller, amount)));
    }
    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        for(int i=0; i<enroll.length; i++) {
            map.put(enroll[i], referral[i]); // key: 판매원이름, value : 추천인이름
            result.put(enroll[i], 0); // 판매금 초기화
        }
        //돈 지급
        for(int i=0; i<seller.length; i++) {
            receivingMoney(seller[i],amount[i]*100);
        }
        // 출력
        for(int i=0; i<enroll.length; i++) {
            answer[i] = result.get(enroll[i]);
        }
        return answer;
    }

    // 돈 주기
    private static void receivingMoney(String node, int amount) {
        while(true){
            referralMoney = amount/10; // 추천인 10%
            enrollMoney = amount-(amount/10); // 판매원 90%

            // 금액 지급
            result.put(node,result.get(node)+enrollMoney); // 현재 노드 이름

            // 조건
            if(amount/10<1) break;// 10퍼센트 뺀값이 1보다 작을때
            if(map.get(node).equals("-")) break; // 추천인이 없을때 break;

            // 추천인 이름을 하위노드로 지정
            node=map.get(node);
            // 추천인의 이득 저장 10%
            amount=referralMoney;
        }
    }
}