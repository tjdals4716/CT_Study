package Programmers;

import java.util.Arrays;

public class EmoticonDiscountEvent { // 이모티콘 할인행사 dfs (max depth 도달 시 최대값 찾기)
    static int[] Rate = {40,30,20,10}; // 비율
    static int maxPlus=0,maxSales=0; // 결과
    static int[] emoticonRates;
    public static void main(String[] args) {
        int[][] users = {{40, 10000}, {25, 10000}};
        int[] emoticons = {7000,9000};

        System.out.println(Arrays.toString(solution(users, emoticons)));
    }
    public static int[] solution(int[][] users, int[] emoticons) {
        emoticonRates = new int[emoticons.length];
        // 깊이가 emoticons 다 반영됐을때
        emoticonRateSetting(0,users,emoticons);// 이모티콘 비율 설정 dfs
        return new int[] {maxPlus,maxSales};
    }

    private static void searchMaxResult(int[][] users, int[] emoticons) {
        int Plus = 0;
        int TotalPrice = 0;
        for(int[] user:users){
            int usersPrice =0;
            int rate = user[0];
            int price = user[1];
            for(int i=0;i<emoticonRates.length;i++){ // 세팅된 비율로 반영
                if(rate<=emoticonRates[i]){
                    usersPrice+=emoticons[i]*(100-emoticonRates[i])/100;
                }
                if(usersPrice>=price){
                    Plus++;
                    usersPrice=0;
                    break;
                }
            }
            TotalPrice+=usersPrice;
        }
        if(Plus>maxPlus){
            maxPlus = Plus;
            maxSales = TotalPrice;
        }else if(Plus==maxPlus){
            maxSales = Math.max(maxSales,TotalPrice);
        }
    }

    private static void emoticonRateSetting(int depth, int[][] users, int[] emoticons) {
        if(depth==emoticons.length) { // 모든 비율 세팅됐을때
            searchMaxResult(users,emoticons);
            return;
        }
        for(int d: Rate){ //비율 전체탐색
            emoticonRates[depth] = d; 
            emoticonRateSetting(depth+1,users,emoticons);
        }
    }
}