package Programmers;

public class Song_17683_L2 { // [3차]방금그곡 melody
    public static void main(String[] args) {

        String m = "ABCABC";
        String[] musicinfos = {"12:00,12:10,HI,ABC", "12:30,12:39,BYE,ABC", "12:50,13:00,BYE,ABC"};

        System.out.println(solution(m,musicinfos));
    }

    public static String solution(String m, String[] musicinfos) {
        String answer="(None)";
        int result=0, minute;
        String melody;
        for(String musicinfo :musicinfos){
            String[] info = musicinfo.split(",");

            // Tokenizer
            melody = setTokenizer(info[3]);
            m = setTokenizer(m);

            // 재생 시간
            String[] start = info[0].split(":");
            String[] end = info[1].split(":");
            minute = (Integer.parseInt(end[0])*60 + Integer.parseInt(end[1]))
                    - (Integer.parseInt(start[0])*60 + Integer.parseInt(start[1]));
            // 재생된 멜로디
            StringBuilder playedMelody = new StringBuilder();
            for(int i=0;i<minute;i++){
                playedMelody.append(melody.charAt(i%melody.length()));
            }
            String S = playedMelody.toString();

            // 원곡의 반복에 멜로디가 없을때
            if(!S.contains(m)) continue;
            // 시간 비교
            if(result < minute){
                result = minute;
                answer = info[2];
            }
        }
        return answer;
    }
    static String[][] tokens = {{"A#","a"},{"B#","b"},{"C#","c"},{"D#","d"},{"E#","e"},{"F#","f"},{"G#","g"}};
    public static String setTokenizer(String s){
        for(String[] token:tokens){
            s = s.replace(token[0], token[1]);
        }
        return s;
    }
}