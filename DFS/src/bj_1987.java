import java.util.*;
import java.io.*;

public class bj_1987 {

	static int n, m;
    static int[][] a;
    static boolean[][] v;
    static boolean[] check = new boolean[26];
    static int[] x = {1, -1, 0, 0}, y = {0, 0, 1, -1};
    static Scanner in;
    static PrintWriter out;

    public static void main (String[] args) {
    	try {
        	in = new Scanner(new File("1987.in"));
            out = new PrintWriter(new File("1987.out"));
            
            init();
            solve();
            
            in.close();
            out.close();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    private static void init() {
    	  n = in.nextInt();
          m = in.nextInt();
          a = new int[n][m];
          v = new boolean[n][m];

    }
    
    private static void solve() {
        for (int i = 0; i < n; i++) {
            String str = in.nextLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = str.charAt(j) - 'A';
            }
        }
        v[0][0] = true;
        check[a[0][0]] = true;
        out.print(dfs(0, 0));
    }
    

    private static int dfs (int dx, int dy) {
        int count = 0;
        for (int i = 0 ; i < 4; i++) {
            int x1 = dx + x[i], y1 = dy + y[i];
            if (x1 >= 0 && x1 < n && y1 >= 0 && y1 < m && !v[x1][y1]) {
                if (!check[a[x1][y1]]) {
                    v[x1][y1] = true;
                    check[a[x1][y1]] = true;
                    count = Math.max(count, dfs(x1, y1));
                    v[x1][y1] = false;
                }
            }
        }

        check[a[dx][dy]] = false;
        return count + 1;
    }
	

	

}
