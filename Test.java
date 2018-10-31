package cn.kgc.test;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		int[] a = {9,2,4,7,85,65,22,23,65,41,18,25,18,100};
		int[] b = a, c = a, d = a;
		selectSort(a);
		bubbleSort(b);
		quickSort(c);
		insertSort(a);
		mergeSort(d, 0, d.length - 1);
		System.out.println("πÈ≤¢≈≈–Ú£∫" + Arrays.toString(d));
	}
	
	public static void selectSort(int[] a) {
		for(int i = 0; i < a.length - 1; i++) {
			int flag = i;
			for(int j = i + 1; j < a.length; j++) {
				if(a[j] < a[flag])
					flag = j;
			}
			int temp = a[i];
			a[i] = a[flag];
			a[flag] = temp;
		}
		System.out.println("—°‘Ò≈≈–Ú£∫" + Arrays.toString(a));
	}
	
	public static void bubbleSort(int[] a) {
		for(int i = 0 ; i < a.length - 1; i++) {
			for(int j = 0; j < a.length - 1 - i; j++) {
				if(a[j + 1] < a[j]) {
					int temp = a[j + 1];
					a[j + 1] = a[j];
					a[j] = temp;
				}
			}
		}
		System.out.println("√∞≈›≈≈–Ú£∫" + Arrays.toString(a));
	}
	
	public static void quickSort(int[] a) {
		sort(a, 0, a.length - 1);
		System.out.println("øÏÀŸ≈≈–Ú£∫" + Arrays.toString(a));
	}
	
	public static void sort(int[] a, int low, int high) {
		if(low > high)
			return ;
		int i = low;
		int j = high;
		int index = a[i];
		while(i < j) {
			while(a[j] > index)
				j--;
			if(i < j)
				a[i++] = a[j];
			while(a[i] < index)
				i++;
			if(i < j)
				a[j--] = a[i];
		}
		a[i] = index;
		sort(a, low, i - 1);
		sort(a, i + 1, high);
	}
	
	public static void insertSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int j = i;
			int temp = a[i];
			if (a[j - 1] > a[j]) {
				while(j > 0 && a[j - 1] > a[j]) {
					a[j] = a[j - 1];
					j--;
				}
				a[j] = temp;
			}
		}
		System.out.println("≤Â»Î≈≈–Ú£∫" + Arrays.toString(a));
	}
	
	public static void mergeSort(int[] a, int low ,int high) {
		if(low < high) {
			int mid = (low + high) / 2;
			mergeSort(a, low, mid);
			mergeSort(a, mid + 1, high);
			merge(a, low, mid, high);
		}
	}
	
	public static void merge(int[] a, int low, int mid, int high) {
		int i, j, k, length1, length2;
		length1 = mid - low + 1;
		length2 = high - mid;
		int[] L = new int[length1];
		int[] R = new int[length2];
		for(i = 0, k = low; i < length1; i++, k++) 
			L[i] = a[k];
		for(j = 0, k = mid + 1; j < length2; j++, k++) 
			R[j] = a[k];
		for(k = low, i = 0, j =0; i<length1 && j < length2;k++) {
			if(L[i] < R[j]) {
				a[k] = L[i];
				i++;
			}else {
				a[k] = R[j];
				j++;
			}
		}
		if(i < length1) 
			for(; i < length1; i++, k++) 
				a[k] = L[i];
		if(j < length2)
			for(; j < length2;j++, k++)
				a[k] = R[j];
	}

}
