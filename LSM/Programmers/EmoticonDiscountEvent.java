package Programmers;

import java.util.Arrays;

public class EmoticonDiscountEvent { // 이모티콘 할인행사 dfs (max depth 도달 시 최대값 찾기)
    static int[] Rate = {40,30,20,10};
    static int maxPlus=0,maxSales=0;
    static int eLength,uLength;
    static int[] emoticonRates;
    public static void main(String[] args) {
        int[][] users = {{40, 10000}, {25, 10000}};
        int[] emoticons = {7000,9000};

        System.out.println(Arrays.toString(solution(users, emoticons)));
    }
    public static int[] solution(int[][] users, int[] emoticons) {
        uLength = users.length;
        eLength = emoticons.length;
        emoticonRates = new int[eLength];
        // 깊이가 emoticons 다 반영됐을때
        emoticonPriceSetting(0,users,emoticons);// 이모티콘 가격 설정 dfs
        return new int[] {maxPlus,maxSales};
    }

    private static void searchMaxResult(int[][] users, int[] emoticons) {
        int Plus = 0;
        int TotalPrice = 0;
        for(int[] user:users){
            int usersPrice =0;
            int rate = user[0];
            int price = user[1];
            for(int i=0;i<emoticonRates.length;i++){
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

    private static void emoticonPriceSetting(int depth, int[][] users, int[] emoticons) {
        if(depth==eLength) { // 가격 모두 설정됐을때
            searchMaxResult(users,emoticons);
            return;
        }
        for(int d: Rate){
            emoticonRates[depth] = d;
            emoticonPriceSetting(depth+1,users,emoticons);
        }
    }
}