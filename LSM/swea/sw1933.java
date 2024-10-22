package swea;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class sw1933 { // 1933 : 약수 알고리즘 axb=N이 되는수의 중복되는 부분을 없앤 알고리즘
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int N = sc.nextInt();
        int sqrt = (int) Math.sqrt(N); //제곱근을 구함
        for (int i = 1; i <= sqrt; i++) {
            if (N % i == 0) {
                if (Math.pow(i, 2) == N) {
                    list.add(i);
                } else {
                    list.add(i);
                    list.add(N / i);
                }
            }
        }
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
    }
}