import java.util.*;
import java.io.*;

public class bj_7576 {
	
	static int n, m, ans;
	static Scanner in;
	static PrintWriter out;
	static int[][] a;
	static int[] o = {-1,1,0,0};
	static int[] w = {0,0,-1,1};
	static Queue<Integer> q;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("7576.in"));
			out = new PrintWriter(new File("7576.out"));
			
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
		m = in.nextInt();
		n = in.nextInt();
		a = new int[n][m];
        q = new LinkedList<Integer>();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				a[i][j] = in.nextInt();
                if(a[i][j]==1){ q.add(i); q.add(j); }
			}
		}
		
		ans = 0;
	}
	
	static int solve() {
		bfs();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(a[i][j] == 0) return -1;
				if(a[i][j] > ans) ans = a[i][j];
				
			}
		}
		return ans-1;
	}
	static void bfs(){
	  while(!q.isEmpty()) {
			int x = q.poll();
			int y = q.poll();
			for(int j = 0; j < 4; j++) {
				int nx = x+o[j];
				int ny = y+w[j];
				if(!isValid(nx, ny)) continue;
				q.add(nx);
				q.add(ny);
				a[nx][ny]=a[x][y]+1;
			}
		}
	}
	
  static boolean isValid(int nx, int ny){
	  return (nx>=0 && ny >= 0 && nx < n && ny < m && a[nx][ny] == 0);
  }
}
