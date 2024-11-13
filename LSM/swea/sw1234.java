package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class sw1234 { //1234 문자열을 하나씩받아 같은 숫자끼리 겹치면 삭제
    //Stack으로 peek()과 넣을값을 비교하여 겹치는 숫자 제거
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc=1;tc<=10;tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Stack<Character> stack = new Stack<>();
            st.nextToken();
            String N = st.nextToken();

            for(int i=0;i<N.length();i++) {
                if(stack.isEmpty()||stack.peek()!=N.charAt(i)){
                    stack.push(N.charAt(i));
                }else{ //q에 꺼낼값이 현재넣는 값과 같다면
                    stack.pop(); //삭제
                }
            }
            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            sb.reverse(); //꺼낸값 뒤집기
            System.out.println("#"+tc+" "+sb);
            sb.setLength(0);
        }
    }
}
