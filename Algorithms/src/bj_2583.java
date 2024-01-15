import java.util.*;
import java.io.*;

public class bj_2583 {

	static Queue<Integer> q;
	static int n, m, k, ans, count;
	static int[][] a;
	static int[] o = {-1,1,0,0};
	static int[] w = {0,0,-1,1};
	static int[] area;
	static Scanner in;
	static PrintWriter out;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("2583.in"));
			out = new PrintWriter(new File("2583.out"));
			
			init();
			out.println(count());
			Arrays.sort(area);
			for(int i = 0; i < k; i++) {
				out.print(area[i] + " ");
			}
			
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
		k = in.nextInt();
		a = new int[m][n];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				a[i][j] = 0;
			}
		}
		for(int i = 0; i < k; i++) {
			int[] arr = new int[2];
			int x1 = in.nextInt();
			int y1 = in.nextInt();
			int x2 = in.nextInt();
			int y2 = in.nextInt();
			arr[0] = x2-x1; //4
			arr[1] = y2-y1; //2
			for(int j = 0; j < arr[0]; j++) {
				for(int h = 0; h < arr[1]; h++) {
					a[y1+h][x1+j] = 1; 
				}
			}
		}
		area = new int[k];
		q = new LinkedList<Integer>();
	}
	static int count() {
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(a[i][j] == 0) {
					bfs(i, j);				
                    area[ans] = count+1;
                  	ans++;
                  	count=0;
				}
			}
		}
		return ans;
	}
	static void bfs(int x, int y) {
		q.add(x);
		q.add(y);
		a[x][y]=1;
		
			while(!q.isEmpty()) {
				x = q.poll();
				y = q.poll();
				for(int j = 0; j < 4; j++) {
					int nx = x+o[j];
					int ny = y+w[j];
					if(nx<0 || ny < 0 || nx >= m || ny >= n || a[nx][ny] == 1) continue;
					q.add(nx);
					q.add(ny);
					a[nx][ny]=1;
					count++;
				}
			}
		}

}
