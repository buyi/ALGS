package studysort;

import java.util.Arrays;

// 主要有三个步骤 1.大顶堆化 2.构建大顶堆 3.堆排序
//  基础知识 parent left right
public class studyHeapSelf {
	
	private int heapSize = 10;
	private int[] source = new int[heapSize];
	
	
	public int left (int index) {
		return 2 * index + 1;
	}
	
	public int right (int index) {
		return 2 * index + 2;
	}
	
	public int parent (int index ) {
		return (int) Math.floor((index - 1) /2 );
	}
	
	public void HeapMaxy (int[] heap, int index) {
		int left = left(index);
		int right = right(index);
		int largest = index;
		
		if (left < heapSize && heap[left] > heap[index]) {
			largest = left;
		}
		
		if (right < heapSize && heap[right] > heap[largest]) {
			largest = right;
		}
		
	
		
		if (largest != index) {
			int temp = heap[index];
			heap[index] = heap[largest];
			heap[largest] = temp;
			printHeapTree(heap);
			HeapMaxy(heap, largest);
		}
	}
	
	
	private void printHeapTree(int[] array)
	{
	    for(int i=1;i<array.length;i=i*2)
	    {
	        for(int k=i-1;k<2*(i)-1&&k<array.length;k++)
	        {
	            System.out.print(array[k]+" ");
	        }
	        System.out.println();
	    }    
	}
	
	public void buildHeap (int[] heap) {
		int lastParent = parent (heapSize -1);
		for (int i= lastParent; i>=0; i--) {
			HeapMaxy (heap, i);
		}
		
	}
	
	public void heapSort (int[] heap) {
		buildHeap(heap);
		 System.out.println("Step:0 "+ Arrays.toString(heap));
		int step =1;
		
		for (int i = heapSize-1; i>=0; i--) {
			int temp = heap[0];
			heap[0] = heap[i];
			heap[i] = temp;
			 System.out.println("Step: " + (step++) + Arrays.toString(heap));
			heapSize --;
			HeapMaxy(heap, 0);
		}
	}
	
	public static void main(String[] args) {
		   int [] A = {3, 7, 2, 11, 3, 4, 9, 2, 18, 0};
		        System.out.println("Input: " + Arrays.toString(A));
		        studyHeapSelf maxhp = new studyHeapSelf();
		        maxhp.heapSort(A);
		        System.out.println("Output: " + Arrays.toString(A));
	}
	
	

}
