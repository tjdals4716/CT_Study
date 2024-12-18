package Programmers;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class Edittable_unfinish { // 표 편집 lv3 효율성 X
    public static void main(String[] args) throws IOException {

        int n=8;
        int k=2;
        String[] cmd={"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};

        StringBuilder sb = new StringBuilder();
        Stack<int[]> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,1);
        }
        LinkedList<Integer> list = new LinkedList<>(map.keySet());

        for(int i=0;i<cmd.length;i++){
            String[] S = cmd[i].split(" ");
            switch(S[0]) {
                case "U": // 행 위 이동
                    k -= Integer.parseInt(S[1]);
                    break;
                case "D": // 행 아래 이동
                    k += Integer.parseInt(S[1]);
                    break;
                case "C": // 삭제
                    stack.add(new int[]{k,list.remove(k)}); // k번째 삭제 key와 value
                    if (k == list.size()) { // 마지막일땐 행 위 이동
                        k--;
                    }
                    break;
                case "Z": // 되돌리기
                    int[] p = stack.pop();
                    if(p[0]<=k){
                        k++;
                    }
                    list.add(p[0],p[1]);
                    break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (!list.isEmpty()) {
                if (i == list.get(0)) {
                    sb.append("O");
                    list.remove(0);
                    continue;
                }
            }
            sb.append("X");
        }
        System.out.println(sb.toString());
    }
}