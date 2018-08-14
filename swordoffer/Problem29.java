package ldl.swordoffer;

import java.util.ArrayList;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * @author darlingliu
 * 思路：利用堆排序，每次建立最小堆
 */

public class Problem29 {
	
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if(input == null || input.length == 0 || k > input.length)
        	return result;
        initialMinHeap(input);
        for(int i = input.length-1; i >= input.length-k; i--) {
        	result.add(input[0]);
        	swap(input, 0, i);
        	bulidMinHeap(input, 0, i);
        }
        return result;
        
    }
	
	public void initialMinHeap(int[] input) {
		int pos = input.length/2-1;
		for(int i = pos; i >= 0; i--) {
			bulidMinHeap(input, i, input.length);
		}
	}
	
	public void bulidMinHeap(int[] input, int pos, int len) {
		int leftIndex = 2*pos+1;
		int rightIndex = 2*pos + 2;
		int minIndex = pos;
		if(leftIndex < len && input[leftIndex] < input[minIndex])
			minIndex = leftIndex;
		if(rightIndex < len && input[rightIndex] < input[minIndex])
			minIndex = rightIndex;
		
		if(minIndex != pos) {
			swap(input, minIndex, pos);
			bulidMinHeap(input, minIndex, len);
		}
	}
	
	public void swap(int[] input, int a, int b) {
		int tmp = input[a];
		input[a] = input[b];
		input[b] = tmp;
	}

	public static void main(String[] args) {
		Problem29 test = new Problem29();
		int[] input = {2,5,3,1,9,4,8};
		ArrayList<Integer> list = test.GetLeastNumbers_Solution(input, 3);
		System.out.println(list);
		
	}

}
