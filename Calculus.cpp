#include <iostream>
using namespace std;
using it=long long;

long long binpow(long long a, long long b, long long m) {
	
	a %= m;
	long long res = 1;

	while (b > 0) 
	{
		if (b & 1)
			res = res * a % m;
		a = a * a % m;
		b >>= 1;
	}

	return res;
}

int mod=998244353;

signed main(){
	
	it n, ans=1, inc=3;
	cin>>n;

	for(it i=2;i<=n;i++)
	{
		ans+=binpow(inc, mod-2, mod);
		ans%=mod;
		inc+=2;
	}
	
	cout<<(2*ans)%mod<<endl;
}