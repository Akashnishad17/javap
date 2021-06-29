import java.util.Scanner;

class TestClass
{
	static void singleDigitPrime(int a, int b)
	{
		int[] nums = new int[b+1];

		if(b >= 2)
			nums[2] = 1;
		for(int i = 3; i <= b; i += 2)
			nums[i] = 1;
		for(int i = 3; i <= b; i += 2)
		{
			if(nums[i] == 1)
			{
				for(int j = i*i; j <= b; j += i)
					nums[j] = 0;
			}
		} 
		for(int i = a; i <= b; i++)
		{
			if(nums[i] == 1 && valid(i, nums))
				System.out.print(i+" ");
		}
	}

	static boolean valid(int n, int[] nums)
	{
		int s = 0;

		while(n > 0)
		{
			s += n % 10;
			n /= 10;
		}

		s = (s - 1) % 9 + 1;

		return nums[s] == 1; 
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		singleDigitPrime(a, b);
	}
}