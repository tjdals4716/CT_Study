package Baekjoon.Gold;

import java.util.Scanner;

// 백준 1062번 : 가르침
// 문제 설명 : 학생들에게 K개의 글자를 가르쳐야 할 때, 학생들이 최대한 많은 단어를 읽을 수 있도록 가르쳐야 하는 글자의 개수를 선택하는 문제이다. 기본적으로 학생들은 'a', 'n', 't', 'i', 'c' 다섯 글자를 알고 있으며, 추가로 최대 K개의 글자를 더 배울 수 있다
// 입력 : 첫 줄에는 단어의 개수 N과 추가로 가르칠 수 있는 글자의 수 K가 주어진다. 이어서 N개의 단어가 주어지는데, 각각 'anta'로 시작하고 'tica'로 끝난다
// 출력 : 학생들이 읽을 수 있는 단어의 최대 개수를 출력한다
// 풀이 : K가 5 미만이면 학생들이 읽을 수 있는 단어가 없기 때문에 바로 0을 출력한다. 'a', 'n', 't', 'i', 'c' 다섯 글자를 제외한 알파벳 중에서 K-5개를 선택하는 조합을 구하여 가능한 단어 수를 계산한다. DFS를 이용하여 조합을 구성하고, 각 조합이 가능한 단어 수를 업데이트하며 최댓값을 갱신한다
public class G_1062 {
    static int N, K;
    static String[] words;
    static boolean[] learned = new boolean[26];
    static int maxWords = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        sc.nextLine();

        words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = sc.nextLine().replaceAll("[antic]", "");
        }

        if (K < 5) {
            System.out.println(0);
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        }

        learned['a' - 'a'] = true;
        learned['n' - 'a'] = true;
        learned['t' - 'a'] = true;
        learned['i' - 'a'] = true;
        learned['c' - 'a'] = true;

        dfs(0, 0);

        System.out.println(maxWords);
    }

    static void dfs(int idx, int count) {
        if (count == K - 5) {
            int readableWords = countReadableWords();
            maxWords = Math.max(maxWords, readableWords);
            return;
        }

        for (int i = idx; i < 26; i++) {
            if (!learned[i]) {
                learned[i] = true;
                dfs(i + 1, count + 1);
                learned[i] = false;
            }
        }
    }

    static int countReadableWords() {
        int count = 0;
        for (String word : words) {
            boolean readable = true;
            for (char ch : word.toCharArray()) {
                if (!learned[ch - 'a']) {
                    readable = false;
                    break;
                }
            }
            if (readable) count++;
        }
        return count;
    }
}
