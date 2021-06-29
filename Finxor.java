import java.io.*;
import java.util.*;

class Finxor{

	public static int[] arr = new int[]{1,3,5,6,11};
	public static int n = 5;
	public static int count = 0;
	public static int sumxor(int k)
	{
		count++;
		if(count > 20)
			return -1;
		int sum = 0;
		for(int x : arr)
			sum += x^k;
		return sum;
	}

	public static int findxor()
	{
		int xor = 0;
		for(int x : arr)
			xor ^= x;
		return xor;
	}

	public static void main(String[] args)
	{
		System.out.println(findxor());
		int[] dp = new int[20];
		for(int i = 1; i <= 20; i++)
		{
			int sum = sumxor(1 << i);
			dp[i-1] = sum;
			/*for(int j = 1; j <= 32; j++)
				System.out.print((sum >> (32-j) & 1));
			System.out.println(" "+sum);*/
		}
		reverse(dp, 0, 19);
		int limit = dp[0] - n*(1 << 20);
		//System.out.println(limit);
		for(int i = 1; i < 20; i++)
		{
			if(dp[i] >= limit)
				dp[i] = (n-(dp[i]-limit)/(1<<(20-i)))/2;
			/*for(int j = 1; j <= 32; j++)
				System.out.print((dp[i] >> (32-j) & 1));
			System.out.println(" "+dp[i]);*/
		}
		int ans = 0;
		for(int i = 1; i < 20; i++)
		{
			if(dp[i]%2 != 0)
				ans += 	1<<(20-i);
			/*else if(dp[i] > 0 && !isPowerof2(dp[i]))
				ans += 1<<(20-i);*/
			if(limit%2 != 0)
				ans++;
			System.out.print(ans+" ");
		}
	}

	public static void reverse(int[] arr, int l, int r)
	{
		while(l < r)
		{
			int t = arr[l];
			arr[l] = arr[r];
			arr[r] = t;
			l++;
			r--;
		}
	}

	public static boolean isPowerof2(int n)
	{
		return n == 1 ? true : (n%2 != 0 ? false : isPowerof2(n/2));
	}
}

/*
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] dp = new int[21];
		for(int i = 0; i <= 20; i++)
		    dp[i] = 1 << i;
		while(t-- > 0)
		{
		    int n = sc.nextInt();
		    System.out.println(1+" "+dp[20]);
		    int sum = sc.nextInt();
		    sum -= dp[20]*n;
		    int xor = 0;
		    if(sum % 2 != 0)
		        xor++;
		    int temp, judge;
		    for(int i = 1; i < 20; i++)
		    {
		        temp = sum + dp[i]*n;
		        System.out.println(1+" "+dp[i]);
		        judge = sc.nextInt();
		        if( ((temp-judge)/(dp[i]*2)) % 2 != 0)
		            xor += dp[i];
		    }
		    System.out.println(2+" "+xor);
		    int check = sc.nextInt();
		}
	}
}*/


/*
# cook your dish here
t = int(input())

for i in range(22):
    dp = [0]*i
dp[0] = 1
for i in range(1,21):
    dp[i] = 2 * dp[i-1]

while t > 0:
    
    n = int(input())
    print(1," ",dp[20])
    s = int(input())
    s = s - n*dp[20]
    
    xor = 0
    if s % 2 != 0:
        xor = xor + 1
        
    for i in range(1,20):
        
        temp = s + dp[i]*n
        print(1," ",dp[i])
        s1 = int(input())
        
        if (((temp-s1)/(dp[i]*2))) % 2 != 0:
            xor = xor + dp[i]
            
    print(2," ",xor)
    ch = int(input())
    t = t - 1

*/