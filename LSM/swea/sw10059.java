package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw10059 { // 10059 경우의 수 모두 확인
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String card = br.readLine();
            int one = Integer.parseInt(card.substring(0, 2));
            int two = Integer.parseInt(card.substring(2, 4));
            String result = "AMBIGUOUS";
            if (one > 12 && two > 12 || one == 0 && two == 0) {//one,two : 년
                result = "NA";
            } else if (1 <= two && two <= 12) {   // two : 월
                if (one > 12 || one == 0) {       // one : 년
                    result = "YYMM";
                } else {                      // one,two : 월
                    result = "AMBIGUOUS";
                }
            } else if (1 <= one && one <= 12) {   // one : 월
                if (two > 12 || two == 0) {       // two : 년
                    result = "MMYY";
                } else {                       //one,two : 월
                    result = "AMBIGUOUS";
                }
            }
            System.out.println("#" + tc + " " + result);


        }
    }
}