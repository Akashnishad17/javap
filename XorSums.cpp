#include <bits/stdc++.h>
#define mod 998244353
using namespace std;

long power(long x, int n)
{
	if(n == 0)
		return 1;

	long half = power(x, n/2);
	long half_prod = (half * half) % mod;

	if(n % 2 == 0)
		return half_prod;

	return (half_prod * x) % mod;
}

long ncr(long fact[], int n, int r)
{
	if(r == 0)
		return 1;

	if(r == 1)
		return n;

	return (fact[n] * (power(fact[r], mod-2) * power(fact[n-r], mod - 2)) % mod) % mod;
}

int main()
{
    int n, x;
    
    cin >> n;
    
    int bits[31];
    memset(bits, 0, sizeof(bits));
    
    for(int i = 0; i < n; i++)
    {
        cin >> x;
        
        for(int j = 0; j < 31; j++)
        {
            if(x & (1 << j))
                bits[j]++;
        }
    }
    
    long fact[n+1];
    fact[0] = 1;
    
    for(int i = 1; i <= n; i++)
        fact[i] = (fact[i-1] * i) % mod;
        
    long dp[n+1];
    memset(dp, 0, sizeof(dp));
    
    int ones, zeroes;
	long temp;

	for(int i = 0; i < 31; i++)
	{
		ones = bits[i];
		zeroes = n - ones;

		for(int j = 1; j <= ones; j += 2)
		{
			temp = ncr(fact, ones, j);

			for(int k = 0; k <= zeroes; k++)
				dp[k+j] = (dp[k+j] + ((1 << i) * (temp * ncr(fact, zeroes, k)) % mod) % mod) % mod;
		}
	}
	
	for(int i = 1; i <= n; i++)
	    dp[i] = (dp[i] + dp[i-1]) % mod;
	    
	int q;
	cin >> q;
	
	while(q--)
	{
	    cin >> x;
	    cout << dp[x] << endl;
	}
	
	return 0;
}
