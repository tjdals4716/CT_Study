package swea;

import java.util.Scanner;

public class sw1948 {// 1948 : 두 날짜가 총 몇일인지 출력
    //날짜의 연도가 달라지는 일은 없다.(처음엔 다음 년도의 날짜도 경우의 수에 넣어서 계산해서 복잡했음)
    //문제를 읽어보고 몇월인지 while문만 돌려주고 Day를 더하거나 빼주면된다는 것을 알게됨.

    static int[] arr = {0,31,28,31,30,31,30,31,31,30,31,30,31}; //각 달의 마지막 날짜
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1;tc<=T;tc++) {
            int fMonth = sc.nextInt();
            int fDay = sc.nextInt();
            int sMonth = sc.nextInt();
            int sDay = sc.nextInt();
            int Dday = 0;
            while (fMonth<sMonth) {
                Dday+=arr[fMonth++];
            }
            Dday=Dday-fDay+sDay+1;
            System.out.println("#"+tc+" "+Dday);
        }
    }

}
