package studysort;

import edu.princeton.cs.algs4.StdOut;

public class studyShell {
	int a[] = new int[] {44, 6, 12, 2, 8};
	
	public static void main(String[] args) {
		studyShell ss = new studyShell();
		show(ss.a);
		ss.shell(ss.a);
	}
	
	public void shell (int a[]) {
		// j表示要插入的元素
		
		int n = a.length;
		int h = 1;
		if (h < n /3) h = h*3+1;
		
		while (h >=1) {
			for (int j =h; j <a.length; j++) {
				// i表示要插入的正确位置
				for (int i = j ; i > h && a[i] < a[i-h]; i=i-h) {
					int temp = a[i-h];
					a[i-h] = a[i];
					a[i] = temp;
				}
				
			}
			
			h = h /3;
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
