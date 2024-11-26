package Programmers;

public class ArrSearch { // 10번 / 공원
    static boolean[][] arr;
    static int result=-1;

    public static void main(String[] args) {
        String[][] park = {
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}
        };
        int[] mats = {5,3,2};
        System.out.println(solution(mats,park));
    }

    public static int solution(int[] mats, String[][] park) {
        arr = new boolean[park.length][park[0].length];
        for(int i=0;i<park.length;i++){
            for(int j=0;j<park[0].length;j++){
                if(park[i][j].equals("-1")){
                    arr[i][j]=true;
                }
            }
        }
        for(int k=0;k<mats.length;k++){
            int N = mats[k];
            for(int i=0;i<=park.length-N;i++){
                for(int j=0;j<=park[0].length-N;j++){
                    if(arr[i][j]){
                        visitable(i,j,N);
                    }
                }
            }
        }

        return result;
    }
    public static void visitable(int y,int x,int N){
        for(int i=y;i<y+N;i++){
            for(int j=x;j<x+N;j++){
                if(!arr[i][j]){
                    return;
                }
            }
        }
        result=Math.max(result,N);
    }
}