package Data_Structure1.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class hashtable { //hash table 함수 key,value 관리
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++){
            int N = Integer.parseInt(br.readLine()); //입력 데이터 수 N
            Hashtable<String,String> ht = new Hashtable<>();
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                ht.put(st.nextToken(),st.nextToken()) ; //key data 추가
            }
            int Q = Integer.parseInt(br.readLine()); //검색할 데이터 수 Q
            for(int i=0;i<Q;i++){
                String selectkey = br.readLine();

                if(ht.get(selectkey)==null) { // key값으로 검색 => value반환
                    System.out.println("not find");
                }else{
                    System.out.println(ht.get(selectkey));
                }
            }
        }
    }
}
