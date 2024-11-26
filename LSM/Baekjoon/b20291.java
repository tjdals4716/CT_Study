package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b20291 { //20291 Silver3 파싱 Hashmap && Treemap 두가지 방식 구현
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String,Integer> map = new TreeMap<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            String S = br.readLine();
            String[] A=S.split("\\.");
            map.put(A[1], map.getOrDefault(A[1],0) + 1);
        }
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }
        System.out.println(sb);



//        HashMap<String,Integer> map = new HashMap<>();
//        StringBuilder sb = new StringBuilder();
//        int N = Integer.parseInt(br.readLine());
//        for(int i=0;i<N;i++){
//            String S = br.readLine();
//            String[] A=S.split("\\.");
//            if(map.containsKey(A[1])){
//                map.put(A[1],map.get(A[1])+1);
//            }else{
//                map.put(A[1],1);
//            }
//        }
//        List<String> list = Arrays.asList(map.keySet().toArray(new String[0]));
//        Collections.sort(list);
//        for(int i=0;i<list.size();i++) {
//            sb.append(list.get(i)).append(" ").append(map.get(list.get(i))).append("\n");
//        }
//        System.out.println(sb);
    }
}