package Programmers;

import java.util.HashMap;

public class Hash_L1 { // 완주하지 못한 선수 L1 Hash
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        System.out.println(solution(participant, completion));
    }

    public static String solution(String[] participant, String[] completion) {
        String answer ="";
        HashMap<String, Integer> map = new HashMap<>();
//        int length = completion.length;
//        for(int i=0; i<length; i++) {
//            map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
//            map.put(completion[i], map.getOrDefault(completion[i], 0) - 1);
//        }
//        map.put(participant[length],map.getOrDefault(participant[length],0) + 1);
        // S인 key 값이 처음일땐 0 아닐땐 +1 한다.
        for (String S : participant)
            map.put(S, map.getOrDefault(S, 0) + 1);
        //S인 key 의 value 를 -1한다.
        for (String S : completion)
            map.put(S, map.get(S) - 1);

        for (String S : map.keySet()) {
            if (map.get(S) == 1) {
                answer = S;
                break;
            }
        }
        return answer;

    }
}