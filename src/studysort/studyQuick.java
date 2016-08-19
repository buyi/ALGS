package studysort;

import edu.princeton.cs.algs4.StdOut;

public class studyQuick {
	int a[] = new int[] {44, 6, 12, 2, 8};
	
	public static void main(String[] args) {
		studyQuick ss = new studyQuick();
		show(ss.a);
		ss.quick(ss.a, 0, ss.a.length-1);
	}
	
	public void quick (int a[], int low, int high) {
		if (high <= low) return;
		int p = part (a, low, high);
		quick(a, low, p-1);
		quick(a, p+1, high);
		
	}
	
	public int part (int a[], int low, int high) {
		int i = low, j = high+1;
		int v = a[low];
		
		while (true) {
			while (a[++i] < v) {
				if (i == high) break;
			}
			
			while (v < a[--j]) {if (j == low) break;}
			if (i >= j) break;
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		
		int temp = a[low];
		a[low] = a[j];
		a[j] = temp;
		show(a);
		return j;
		
	}
	
    // print array to standard output
    private static void show(int[] a) {
    	StringBuilder sb = new StringBuilder(64);
        for (int i = 0; i < a.length; i++) {
        	sb.append(a[i]).append(',');
          
        }
        StdOut.println(sb);
    }
}
