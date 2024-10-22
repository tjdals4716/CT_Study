package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class sw9611 { // 9611 : Set함수 .retain 교집합을 이용해 YES는 남기고 NO는 .remove시키는 방법
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            Set<Integer> possibleNum = new HashSet<>(); //가능한 숫자 집합
            for (int i = 0; i < 10; i++) {
                possibleNum.add(i);
            }
            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);
                int c = Integer.parseInt(input[2]);
                int d = Integer.parseInt(input[3]);
                String response = input[4];
                //Arrays.aslist 대신 Set add a,b,c,d 받아서 비교하는게 더 빠를듯?
                if (response.equals("YES")) {
                    possibleNum.retainAll(Arrays.asList(a, b, c, d));
                } else {
                    Arrays.asList(a, b, c, d).forEach(possibleNum::remove);
                }
            }
            int guessedNum = possibleNum.iterator().next(); //유일한 숫자 가져오기
            System.out.println("#" + tc + " " + guessedNum);
        }
    }
}

//알고리즘없는 메모리,시간 고려안한 망구현 1.8배 더 걸림 커질수록 더 걸림
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        for (int tc = 1; tc <= T; tc++) {
//            int[] arr;
//            int n = sc.nextInt();
//            arr= new int[]{n, n, n, n, n, n, n, n, n, n};
//            for(int i=1;i<=n;i++){
//                int a=sc.nextInt();
//                int b=sc.nextInt();
//                int c=sc.nextInt();
//                int d=sc.nextInt();
//                String s=sc.nextLine();
//                if(s.equals(" YES")){
//                    arr[a]++;
//                    arr[b]++;
//                    arr[c]++;
//                    arr[d]++;
//                }else{
//                    arr[a]--;
//                    arr[b]--;
//                    arr[c]--;
//                    arr[d]--;
//                }
//            }
//            int[] newarr = arr.clone();
//            Arrays.sort(newarr);
//            for (int j=0;j<arr.length;j++) {
//                if (newarr[arr.length - 1] ==arr[j]) {
//                    System.out.println("#" + tc + " " + j);
//                    break;
//                }
//            }
//        }
//    }
//}
