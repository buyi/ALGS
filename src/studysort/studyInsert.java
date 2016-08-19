package studysort;


//插入算法 假设玩牌的插入顺序 一共五个元素 第一次默认第一个元素有序（没有做任何事情） 第二次把排名第二的元素插入到只有一个元素的数组中 跟数组里边的元素进行比较 如果比其小 则往前插 直到一个合适的地方
// 第三次就是把排名第三的元素插入到只有两个元素的数组中 第四次就是把排名第四的元素插入到只有三个元素的数组中 第五次把排名第五的元素插入到有四个元素的数组中
public class studyInsert {
	int a[] = new int[] {44, 6, 12, 2, 8};
	
	public static void main(String[] args) {
		studyInsert ss = new studyInsert();
		ss.insert(ss.a);
	}
	
	public void insert (int a[]) {
		// j表示要插入的元素
		for (int j =1; j <a.length; j++) {
			// i表示要插入的正确位置
			for (int i = j ; i > 0 && a[i] < a[i-1]; i--) {
				int temp = a[i-1];
				a[i-1] = a[i];
				a[i] = temp;
			}
			
		}
	}
}
