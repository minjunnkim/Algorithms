import java.util.*;
import java.io.*;

public class bfs {
	
	static Queue<Integer> q;
	static int n, m, ans;
	static int[][] a;
	static int[] o = {-1,1,0,0};
	static int[] w = {0,0,-1,1};
	static Scanner in;
	static PrintWriter out;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("bfs.in"));
			out = new PrintWriter(new File("bfs.out"));
			
			init();
			out.print(solve());
			
			in.close();
			out.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	static void init() {
		n = in.nextInt();
		m = in.nextInt();
		a = new int[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				a[i][j] = in.nextInt();
			}
		}
		q = new LinkedList<Integer>();
		ans = 0;
	}
	static int solve() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(a[i][j] == 1) {
					bfs(i, j);
					ans++;
				}
			}
		}
		return ans;
	}
	static void bfs(int x, int y) {
		q.add(x);
		q.add(y);
		a[x][y]=0;
		

			
			while(!q.isEmpty()) {
				x = q.poll();
				y = q.poll();
				for(int j = 0; j < 4; j++) {
					int nx = x+o[j];
					int ny = y+w[j];
					if(nx<0 || ny < 0 || nx >= n || ny >= m || a[nx][ny] == 0) continue;
					q.add(nx);
					q.add(ny);
					a[nx][ny]=0;
				}
			}
		}
	

}
