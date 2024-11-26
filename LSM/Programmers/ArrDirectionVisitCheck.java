package Programmers;

public class ArrDirectionVisitCheck { //방문 길이
    // 배열간 넘어가는 방향을 체크하기 3차원배열로
    static boolean[][][] visit = new boolean[11][11][4];
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int x = 5,y=5,n,answer=0;
    static int[] D = {1,-1,1,-1};

    public static void main(String[] args) {
        String dirs = "ULURRDLLU";
        System.out.println(solution(dirs));
    }
    //제출 코드 solution
    public static int solution(String dirs) {
        for(int i=0;i<dirs.length();i++){
            switch(dirs.charAt(i)){
                case 'R':
                    n=0;
                    break;
                case 'L':
                    n=1;
                    break;
                case 'U':
                    n=2;
                    break;
                case 'D':
                    n=3;
                    break;
            }
            Check(x,y,n);
        }
        return answer;
    }
    public static void Check(int nx,int ny,int d){ //넘어가지는지와 방문가능한지 체크
        nx+=dx[d]; //다음 길로 이동
        ny+=dy[d];
        if(nx>=0 && nx<=10 && ny>=0 && ny<=10){ //배열 넘어가는지
            if(!visit[y][x][d]){ //가는 길을 방문 안햇을때
                answer++;
            }
            visit[y][x][d]=true; //현재 지점에서 방향 체크
            visit[ny][nx][d +D[d]]=true; //방문한 지점에서 돌아온 길 체크
            x=nx;
            y=ny;
        }
    }
}