package studysort;

import edu.princeton.cs.algs4.StdOut;

public class studyMerge {
	int a[] = new int[] {44, 6, 12, 2, 8};
	public static void main(String[] args) {
		studyMerge ss = new studyMerge();
		show(ss.a);
//		ss.mergeTopToDown(ss.a, 0, ss.a.length-1);
		
		ss.mergeDownToTop(ss.a);
	}
	int auk[] = new int[20];
	
	void mergeTopToDown (int a[], int lo, int hi) {
		
		if (hi <= lo) return;
		int mid = lo + (hi - lo) /2;
		mergeTopToDown(a, lo, mid);
		mergeTopToDown(a, mid+1,hi);
		merge(a, lo, mid, hi);
		
	}
	
	
	void mergeDownToTop (int a[]) {
		int n = a.length;
		for (int sz =1; sz < n; sz = sz+sz) {
			for (int lo = 0; lo < n - sz; lo +=sz+sz) {
				merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, n-1));
			}
			
			
		}
	}
	public void merge (int a[], int lo, int mid, int hi) {
		int i = lo, j = mid+1;
		for (int k =lo; k<= hi; k++) {
			auk[k] = a[k];
		}
		
		for (int k = lo; k <= hi; k++) {
			
			
			if (i > mid) a[k] = auk[j++];
			else if (j > hi) a[k] = auk[i++];
			else if (auk[j] < auk[i]) a[k] = auk[j++];
			else  a[k] = auk[i++];
 			
		}
		show(a);
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
