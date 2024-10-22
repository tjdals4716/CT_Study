package swea;

import java.io.IOException;
import java.util.Scanner;

public class sw1945 { // 1945 : 소인수분해 소인수들만의 곱으로 나타낼때 특정 수의 횟수를 출력
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] arr = {2,3,5,7,11};
        int[] cnt;
        for(int tc=1;tc<=T;tc++) {
            int N=sc.nextInt();
            cnt = new int[5];
            for(int i=cnt.length-1;i>=0;i--) {
                while (N % arr[i] == 0) {
                    N/=arr[i];
                    cnt[i]++;
                    if(N==0){
                        break;
                    }
                }
            }
            System.out.print("#"+tc+" ");
            for(int i=0;i<5;i++){
                System.out.print(cnt[i]+" ");
            }
            System.out.println();
        }
    }
}