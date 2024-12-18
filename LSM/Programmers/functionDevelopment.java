package Programmers;

import java.util.ArrayList;

public class functionDevelopment { // 기능개발
    public static void main(String[] args) {
//        int[] progresses = {93, 30, 55};
        int[] progresses = {95, 90, 99, 99, 80, 99};
//        int[] speeds = {1, 30, 5};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        System.out.println(solution(progresses, speeds));
    }

    public static ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        int length = progresses.length;
        ArrayList<Integer> list = new ArrayList<>();
        int total=Integer.MIN_VALUE;
        int time;
        int cnt=0;
        for(int i=0;i<length;i++){ // progresses 돌기
            int val =100-progresses[i];
            // 시간 올림 계산 Math.ceil
            time= (int) Math.ceil((double)val/speeds[i]);

            // 시간 올림 계산 (더 빠름)
//            time=val/speeds[i]; //시간
//            if(val%speeds[i]!=0){ //나머지 있을때 시간++
//                time++;
//            }

            if(i==0) total=time; //시작 total 입력

            if(time<=total) cnt++; //작거나 같을때
            else{ //클 때
                total=time;
                list.add(cnt);
                cnt=1;
            }
        }
        list.add(cnt); // 마지막 list 추가
        return list;
    }
}