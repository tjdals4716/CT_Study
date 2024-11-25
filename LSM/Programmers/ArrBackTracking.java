package Programmers;

import java.io.IOException;
import java.util.Arrays;


public class ArrBackTracking { //공원 산책
    static int[][] dxy = {{1,0},{-1,0},{0,1},{0,-1}};
    static int x=0,y=0;
    static boolean route=true;
    public static void main(String[] args) throws IOException { //임의의 Test Case
        String[] park = {"OSO","OOO","OXO","OOO"};
        String[] routes = {"E 2","S 3","W 1"};
        System.out.println(Arrays.toString(solution(park, routes)));
    }
    public static int[] solution(String[] park, String[] routes) { //제출 solution
        for(int i=0;i<park.length;i++){ //시작 지점 찾기
            String str = park[i];
            for(int j=0;j<park[0].length();j++){
                if(str.charAt(j)=='S'){
                    x = j;
                    y = i;
                    break;
                }
            }
        }
        for (String s : routes) { // 주어진 방향과 이동 횟수받기
            String[] S = s.split(" ");
            int n = Integer.parseInt(S[1]); // 이동 횟수 저장
            route = true;
            int D = switch (S[0]) { // 방향 저장 (람다)
                case "E" -> 0;
                case "W" -> 1;
                case "S" -> 2;
                case "N" -> 3;
                default -> 0;
            };
            Check(D,n,park); // 방향, 이동 횟수, park배열
        }
        return new int[]{y,x};
    }

    public static void Check(int d, int n, String[] park){ //이동 가능한지 체크
        int nx=x;
        int ny=y;
        for(int i=0;i<n;i++) {
            nx += dxy[d][0]; //방향값 주입
            ny += dxy[d][1];
            if (nx < 0 || nx >= park[0].length() || ny < 0 || ny >= park.length) { //배열 Over할때
                route = false;
                return;
            }
            if(park[ny].charAt(nx) == 'X'){ // 이동할때 X인칸이 있을때
                route = false;
                return;
            }
        }
        x = nx; //배열이 있고 n회 만큼 d 방향으로 이동할 수 있을때
        y = ny;
    }
}


//제출 코드
/*
class Solution{
    static int[][] dxy = {{1,0},{-1,0},{0,1},{0,-1}};
    static int x=0,y=0;
    static boolean route=true;
    public static int[] solution(String[] park, String[] routes) {
        for(int i=0;i<park.length;i++){
            String str = park[i];
            for(int j=0;j<park[0].length();j++){
                if(str.charAt(j)=='S'){
                    x = j;
                    y = i;
                    break;
                }
            }
        }
        for (String s : routes) {
            String[] S = s.split(" ");
            int n = Integer.parseInt(S[1]);
            route = true;
            int D = switch (S[0]) {
                case "E" -> 0;
                case "W" -> 1;
                case "S" -> 2;
                case "N" -> 3;
                default -> 0;
            };
            Check(D,n,park);
        }
        return new int[]{y,x};
    }

    public static void Check(int d, int n, String[] park){
        int nx=x;
        int ny=y;
        for(int i=0;i<n;i++) {
            nx += dxy[d][0];
            ny += dxy[d][1];
            if (nx < 0 || nx >= park[0].length() || ny < 0 || ny >= park.length) {
                route = false;
                return;
            }
            if(park[ny].charAt(nx) == 'X'){
                route = false;
                return;
            }
        }
        x = nx;
        y = ny;
    }
}*/
