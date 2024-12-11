package Programmers;

public class packOfCards {
    public static void main(String[] args) {
        String[] cards1 = {"i","drink","water"};
        String[] cards2 = {"want","to"};
        String[] goal = {"i","want","to","drink","water"};
        System.out.println(solution(cards1, cards2, goal));
    }

    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        int length_c1 = 0;
        int length_c2 = 0;
        String result="Yes";
        //gaol 앞에서부터 하나씩 문자열 가져옴
        for (String S : goal) {
            // c1길이 && c1과 비교 , c2길이 && c2와 비교
            if (length_c1 != cards1.length && cards1[length_c1].equals(S)) {
                length_c1++;
            } else if (length_c2 != cards2.length && cards2[length_c2].equals(S)) {
                length_c2++;
            } else {
                result = "No";
                break;
            }
        }
        return result;
    }
}