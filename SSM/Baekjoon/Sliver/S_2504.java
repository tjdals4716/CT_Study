package Baekjoon.Sliver;

import java.util.Scanner;
import java.util.Stack;

// 백준 2504번 : 괄호의 값
// 문제 설명: 괄호 표현식의 값을 계산하는 문제이다. ()는 2, []는 3으로 간주하여 중첩된 괄호의 값을 계산한다
// 입력 : 올바른 괄호 문자열이 주어진다 (1 ≤ 문자열 길이 ≤ 30)
// 출력 : 괄호 문자열이 올바르면 값을 출력하고, 그렇지 않으면 0을 출력한다
// 풀이 : Stack을 이용하여 괄호의 짝을 맞추고 계산한다. temp 변수에 괄호가 중첩될 때마다 곱해져 값을 계산하며, 닫힌 괄호마다 조건에 맞는 값을 result에 더해준다
public class S_2504 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Stack<Character> stack = new Stack<>();
        int result = 0;
        int temp = 1;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '(') {
                stack.push(ch);
                temp *= 2;
            } else if (ch == '[') {
                stack.push(ch);
                temp *= 3;
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                }
                if (input.charAt(i - 1) == '(') result += temp;
                stack.pop();
                temp /= 2;
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                }
                if (input.charAt(i - 1) == '[') result += temp;
                stack.pop();
                temp /= 3;
            }
        }

        if (!stack.isEmpty()) result = 0;
        System.out.println(result);
    }
}
