package Baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b1966 { // 1966 Silver3 
    // Deque 사용하여 경우에 따라 맨앞의 값 맨 뒤로 이동 and 현재 위치 기억
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <=T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Integer[] arr = new Integer[N];
            st=new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }
            Deque<Integer> stack = new ArrayDeque<>(List.of(arr));
            Arrays.sort(arr,Collections.reverseOrder());
            int location=M; //위치 기억
            for(int i=0;i<arr.length;){ //큰 수 부터 삭감
                if(stack.peek()!=arr[i]){ // 큐의 값이 현재 우선순위인 값이 아닐때
                    int val = stack.pop();
                    stack.add(val); // 맨앞에서 맨뒤로 넘기기
                }else{ //큐의 값 == 우선순위의 값
                    stack.pop(); // 큐의 값 삭제
                    i++; // arr 다음 우선순위 탐색
                    if(location==0){ // 필요한 문서가 현재 pop 될때
                        System.out.println(i);
                        break;
                    }
                }
                if(location==0){ //현재 위치 기억
                    location=stack.size()-1;
                }else{
                    location--;
                }
            }
        }
    }
}
