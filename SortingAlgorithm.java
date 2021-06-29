import java.io.*;
import java.util.*;

class SortingAlgorithm{
	
	public static void printArray(int[] arr, int n)
	{
		for(int i = 0; i < n; i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		int[] arr = new int[]{-34, 40, 26, 0, -78, 49, 99, -5, -15, 47, -99, 75, 22, -30, 49, -30, 47, -1, 40, 5};
		int n = arr.length;
		
		//SelectionSort.sort(arr, n);			//Line 29
		//BubbleSort.sort(arr, n);				//Line 48
		//InsertionSort.sort(arr, n);			//Line 67
		//MergeSort.sort(arr, n);				//Line 85
		//QuickSort.sort(arr, n);				//Line 137
		//HeapSort.sort(arr, n);				//Line 172
		//RadixSort.sort(arr, n);				//Line 205
		//CountingSort.sort(arr, n);			//Line 245
		TreeSort.sort(arr, n);					//Line 270

		printArray(arr, n);
	}
}

class SelectionSort{
	public static void sort(int[] arr, int n)
	{
		int min_index, temp;
		for(int i = 0; i < n-1; i++)
		{
			min_index = i;
			for(int j = i+1; j < n; j++)
			{
				if(arr[min_index] > arr[j])
					min_index = j;
			}
			temp = arr[min_index];
			arr[min_index] = arr[i];
			arr[i] = temp;
		}
	}
}

class BubbleSort{
	public static void sort(int[] arr, int n)
	{
		int temp;
		for(int i = 0; i < n-1; i++)
		{
			for(int j = 0; j < n-1-i; j++)
			{
				if(arr[j] > arr[j+1])
				{
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
}

class InsertionSort{
	public static void sort(int[] arr, int n)
	{
		int key, j;
		for(int i = 1; i < n; i++)
		{
			key = arr[i];
			j = i-1;
			while(j >= 0 && arr[j] > key)
			{
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
	}
}

class MergeSort{
	public static void sort(int[] arr, int n)
	{
		mergeSort(arr, 0, n-1);
	}
	public static void mergeSort(int[] arr, int l, int r)
	{
		if(l < r)
		{
			int mid = l + (r-l)/2;
			mergeSort(arr, l, mid);
			mergeSort(arr, mid+1, r);
			merge(arr, l, mid, r);
		}
	}
	public static void merge(int[] arr, int l, int mid, int r)
	{
		int len1 = mid-l+1;
		int len2 = r-mid;
		int[] arr1 = new int[len1];
		int[] arr2 = new int[len2];
		for(int i = 0; i < len1; i++)
			arr1[i] = arr[l+i];
		for(int i = 0; i < len2; i++)
			arr2[i] = arr[mid+1+i];
		int i = 0, j = 0;
		while(i < len1 && j < len2)
		{
			if(arr1[i] < arr2[j])
			{
				arr[l+i+j] = arr1[i];
				i++;
			}
			else
			{
				arr[l+i+j] = arr2[j];
				j++;
			}
		}
		while(i < len1)
		{
			arr[l+i+j] = arr1[i];
			i++;
		}
		while(j < len2)
		{
			arr[l+i+j] = arr2[j];
			j++;
		}
	}
}

class QuickSort{
	public static void sort(int[] arr, int n)
	{
		quickSort(arr, 0, n-1);
	}
	public static void quickSort(int[] arr, int l, int r)
	{
		if(l < r)
		{
			int index = partition(arr, l, r);
			quickSort(arr, l, index-1);
			quickSort(arr, index+1, r);
		}
	}
	public static int partition(int[] arr, int l, int r)
	{
		int pivot = arr[l];
		int i = r+1, temp;
		for(int j = r; j > l; j--)
		{
			if(arr[j] > pivot)
			{
				i--;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		temp = arr[i-1];
		arr[i-1] = arr[l];
		arr[l] = temp;
		return i-1;
	}
}

class HeapSort{
	public static void sort(int[] arr, int n)
	{
		for(int i = n/2-1; i >= 0; i--)
			heapify(arr, n, i);
		int temp;
		for(int i = n-1; i > 0; i--)
		{
			temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr, i, 0);
		}
	}
	public static void heapify(int[] arr, int n, int i)
	{
		int lar = i;
		int l = 2*i + 1;
		int r = 2*i + 2;
		if(l < n && arr[l] > arr[lar])
			lar = l;
		if(r < n && arr[r] > arr[lar])
			lar = r;
		if(lar != i)
		{
			int temp = arr[i];
			arr[i] = arr[lar];
			arr[lar] = temp;
			heapify(arr, n, lar);
		}
	}
}

class RadixSort{
	public static void sort(int[] arr, int n)
	{
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int x : arr)
		{
			min = Math.min(x,min);
			max = Math.max(x,max);
		}
		if(min < 0)
		{
			for(int i = 0; i < n; i++)
				arr[i] -= min;	
			max -= min;
		}
		for(int i = 1; max/i > 0; i *= 10)
			countSort(arr, n, i);
		if(min < 0)
		{
			for(int i = 0; i < n; i++)
				arr[i] += min;
		}
	}
	public static void countSort(int[] arr, int n, int d)
	{
		int[] counts = new int[10];
		for(int x : arr)
			counts[(x/d)%10]++;
		for(int i = 1; i < 10; i++)
			counts[i] += counts[i-1];
		int[] res = new int[n];
		for(int i = n-1; i >= 0; i--)
			res[counts[(arr[i]/d)%10]-- -1] = arr[i];
		for(int i = 0; i < n; i++)
			arr[i] = res[i];
	}
}

class CountingSort{
	public static void sort(int[] arr, int n)
	{
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int x : arr)
		{
			min = Math.min(x, min);
			max = Math.max(x, max);
		}
		int range = max - min + 1;
		int[] counts = new int[range];
		for(int x : arr)
			counts[x-min]++;
		for(int i = 1; i < range; i++)
			counts[i] += counts[i-1];
		int[] res = new int[n];
		for(int i = n-1; i >= 0; i--)
			res[counts[arr[i]-min]-- - 1] = arr[i];
		for(int i = 0; i < n; i++)
			arr[i] = res[i];
	}
}

class TreeSort{
	public static class Node{
		int val;
		Node left;
		Node right;
		int count;
		public Node(int val)
		{
			this.val = val;
			this.count = 1;
		}
	}
	public static Node root = null;
	public static int index = 0;
	public static void insert(int x)
	{
		root = insertVal(root, x);
	}
	public static Node insertVal(Node root, int val)
	{
		if(root == null)
		{
			root = new Node(val);
			return root;
		}
		if(root.val == val)
		{
			root.count++;
			return root;
		}
		if(val < root.val)
			root.left = insertVal(root.left, val);
		else
			root.right = insertVal(root.right, val);
		return root;
	}
	public static void traverse(Node root, int[] arr)
	{
		if(root == null)
			return;
		traverse(root.left, arr);
		while(root.count-- > 0)
			arr[index++] = root.val;
		traverse(root.right, arr);
	}
	public static void sort(int[] arr, int n)
	{
		for(int x : arr)
			insert(x);
		traverse(root, arr);
	}
}