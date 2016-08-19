package studysort;


// 一个5个元素 第一次比较4次 交换1次 第二次比较3次 交换一次 第三次比较两次 交换一次 第四次比较1次 交换一次 第五次不用比较 不用交换
// 总比较次数 4+3+2+1=10 交换次数4次
public class studySelection {
	
	int a[] = new int[] {44, 6, 12, 2, 8};
	
	public static void main(String[] args) {
		studySelection ss = new studySelection();
		ss.selection(ss.a);
	}
	
public void selection1 (int a[]) {
		
		
		for (int i = 0; i < a.length; i++) {
			int min = i;
			
			for (int j = i+1; j < a.length; j++) {
				
				if (a[min] > a[j]) {
					min = j;
			
				}
				
			}
			
			int temp = a[min];
			a[min] = a[i];
			a[i] = temp;
		}
	}
	
	public void selection (int a[]) {
		
		
		for (int i = 0; i < a.length; i++) {
			
			
			for (int j = i+1; j < a.length; j++) {
				
				if (a[i] > a[j]) {
					int temp = a[j];
					a[j] = a[i];
					a[i] = temp;
				}
				
			}
		}
	}
	

}
