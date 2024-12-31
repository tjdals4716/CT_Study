package Programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class OpenChatRoom_L2 { // 오픈채팅방 LV2 HashMap, Stack 활용
    public static void main(String[] args) {

        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution(record)));
    }

    public static String[] solution(String[] record) {
        HashMap<String,String> map = new HashMap<>();
        Stack<String> stack = new Stack<>();
        Stack<String> stackUid = new Stack<>();

        int cnt=0;
        for(int i=0;i<record.length;i++){
            String[] S = record[i].split(" ");
            stack.push(S[0]); // 입장, 퇴장, 변경 list
            stackUid.push(S[1]); // uid 기록
            if(!(S[0].equals("Leave"))){
                map.put(S[1],S[2]); // 마지막 저장되는 이름 map
            }
            if(S[0].equals("Enter")||S[0].equals("Leave")) cnt++; //result 사이즈 체크
        }

        String[] result = new String[cnt]; // 입장, 퇴장 사이즈

        int length = stack.size();
        for(int i=0;i<length;i++){ // 모든 입장, 퇴장, 변경 확인
            String uid = stackUid.pop();
            switch (stack.pop()){
                case "Enter":
                    result[--cnt] = map.get(uid) + "님이 들어왔습니다.";
                    break;
                case "Leave":
                    result[--cnt] = map.get(uid) + "님이 나갔습니다.";
                    break;
                case "Change":
                    break;
            }
        }
        return result;
    }
}
