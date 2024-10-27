package swea;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class sw9940 { // 9940 순열 중복체크
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {

            String s = "Yes";
            int n = sc.nextInt();
            String[] arr = new String[n];
            for(int i=0;i<n;i++){
                arr[i]= sc.next();
            }
            Arrays.sort(arr);
            for(int i=0;i<n-1;i++){
                if(arr[i].equals(arr[i+1])){
                    s = "No";
                    break;
                }
            }
            System.out.println("#"+tc+" "+s);
        }
    }
}
