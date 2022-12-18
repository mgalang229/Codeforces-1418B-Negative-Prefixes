import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.StringTokenizer;

/*

0 = unlocked
1 = locked

-8 4 -2 -6 4 7 1
 1 0  0  0 1 1 0

-8  4 1 -2 4 7 -6
 1  0 0  0 1 1 0
[-8, -4, -3, -5, -1, 6, 0]
k = 5 

non-increasing negatives and positives

0 1 -4 6 3
0 0  0 1 1

-4 1 0 6 3
 0 0 0 1 1
[-4, -3, -3, 3, 6]
k = 3

-1 7 10 4 -8 -1
 1 0  0 0  0  1
 
-1 10 7 4 -8 -1
 1  0 0 0  0  1
k = 1
 
positives before negatives (both non-increasing)

3 2 1 
2 -3 4 -1 
-8 4 1 -2 4 7 -6 
1 0 -4 6 3 
-1 10 7 4 -8 -1
 
 */

public class Main {
	
	public static void main(String[] args) {
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = fs.nextInt();
			int[] a = fs.readArray(n);
			int[] l = fs.readArray(n);
			ArrayList<Integer> positives = new ArrayList<>(), negatives = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				if (l[i] == 0) {
					if (a[i] >= 0) positives.add(a[i]);
					else negatives.add(a[i]);
				}
			}
			Collections.sort(positives, Collections.reverseOrder());
			Collections.sort(negatives, Collections.reverseOrder());
			int posIndex = 0, negIndex = 0;
			for (int i = 0; i < n; i++) {
				if (l[i] == 0) {
					if (posIndex < positives.size()) {
						a[i] = positives.get(posIndex);
						posIndex++;
					} else {
						a[i] = negatives.get(negIndex);
						negIndex++;
					}
				}
			}
			for (int x : a) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
		out.close();
	}
	
	static final Random rnd = new Random();
	static void shuffleSort(int[] a) { //change this
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int newInd = rnd.nextInt(n);
			int temp = a[newInd]; //change this
			a[newInd] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a);
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}
		
		double[] readDoubleArray(int n) {
			double[] a = new double[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextDouble();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				if (st.hasMoreTokens()) {
					str = st.nextToken("\n");
				} else {
					str = br.readLine();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
