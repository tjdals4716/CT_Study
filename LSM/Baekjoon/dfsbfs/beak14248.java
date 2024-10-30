package Baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak14248 { //14248
    //개구리가 현재칸의 value만큼 좌or우 점프하여 배열을 넘어가지않게 방문할 수 있는 경우의 수 cnt출력
    static int[] arr;
    static boolean[] visit;
    static int s,cnt=0,max=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        arr=new int[N];
        visit=new boolean[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        s=Integer.parseInt(br.readLine());
        dfs(s-1);
        System.out.println(max);
    }

    private static void dfs(int start) {
        if(!visit[start]){ //처음 방문한 곳일때 cnt++
            cnt++;
        }
        visit[start]=true; //현재 위치 방문
        max = Math.max(max,cnt);
        if(arrOver(start+arr[start])){ //오른쪽 점프 돌이 있는지 체크
            dfs(start+arr[start]);
        }
        if(arrOver(start-arr[start])){ //왼쪽 점프 돌이 있는지 체크
            dfs(start-arr[start]);
        }
    }
    private static boolean arrOver(int start) {
        return start>=0&&start<arr.length;
    }

}
