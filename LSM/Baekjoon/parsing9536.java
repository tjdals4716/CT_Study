package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class parsing9536 { // 9536 Silver3 문자열 파싱
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++) {
            String goes = " "+br.readLine()+" ";
            String input;
            while((input = br.readLine()) != null) {
                if(input.equals("what does the fox say?")){
                    if(' '==goes.charAt(0)){
                        goes = goes.substring(1);
                    }
                    if(' '==goes.charAt(goes.length()-1)){
                        goes = goes.substring(0,goes.length()-1);
                    }
                    System.out.println(goes); //end
                    break;
                }

                input = " "+input.split(" goes ",0)[1]+" ";
                while(goes.contains(input)){
                    goes = goes.replaceAll(input," ");
                }
            }
        }

    }
}
