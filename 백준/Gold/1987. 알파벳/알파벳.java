import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static boolean[] visited;
    static char[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        visited = new boolean[26]; //알파벳의 개수

        for (int i = 0; i < R; i++) { // 보드 값 설정
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        dfs(0, 0, 1);
        System.out.println(ans);

    }

    static void dfs(int x, int y, int count) {
        ans = Math.max(ans, count);
        visited[board[x][y] - 65] = true;

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX < 0 || newX >= R || newY < 0 || newY >= C) { //상하좌우를 모두 돌 때 board의 크기를 벗어나면 dfs실행하지않음
                continue;
            }

            if(!visited[board[newX][newY] - 65]){
                dfs(newX, newY, count + 1);
                visited[board[newX][newY] - 'A'] = false; //65 대신 'A'써도 무방
            }
        }
    }
}
