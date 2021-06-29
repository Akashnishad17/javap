import java.io.*;
import java.util.*;

public class Combination{

	static List<List<Integer>> res;
	static List<Integer> set;

	static void combinationSet(int[] arr, int n)
	{
		res = new ArrayList<>();
		set = new ArrayList<>();
		for(int i = 1; i <=n; i++)
			eachSizeSet(arr, i, n);
	}

	static void eachSizeSet(int[] arr, int size, int n)
	{
		generateNextSet(arr, size, 0, 0, n);
	}

	static void generateNextSet(int[] arr, int size, int index, int setSize, int n)
	{	
		if(size == setSize)
		{
			res.add(new ArrayList<>(set));
			return;
		}
		for(int i = index; i < n; i++)
		{
			set.add(arr[i]);
			generateNextSet(arr, size, i+1, setSize+1, n);
			set.remove(setSize);
		}
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		sc.close();
		combinationSet(arr, n);
		for(List<Integer> set : res)
			System.out.println(set);
	}
}