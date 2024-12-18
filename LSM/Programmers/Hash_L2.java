package Programmers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Hash_L2 { // 할인 행사 L2 HashMap
    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3,2,2,2,1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        System.out.println(solution(want,number,discount));
    }

    public static int solution(String[] want, int[] number, String[] discount) {
        int cnt=0;
        Queue<String> q = new LinkedList<>();
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<want.length;i++){
            map.put(want[i],number[i]);
        }

        for (String D : discount) { // discount
            q.add(D); // 할인 day 마다 add
            for(String W : map.keySet()){
                if(W.equals(D)){
                    map.put(W,map.get(W)-1);
                    break;
                }
            }
            L1:
            if(q.size()==10){
                String val = q.poll();
                for(Integer N : map.values()){ // number
                    if(N!=0) {
                        if(map.get(val)!=null){
                            map.put(val,map.get(val)+1);
                        }
                        break L1;
                    }
                }
                cnt++;
                map.put(val,map.get(val)+1);
            }
        }
        return cnt;
    }
}