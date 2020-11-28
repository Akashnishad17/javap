/*Enter your code here. Read input from STDIN. Print your output to STDOUT*/

#include <iostream>

#include <cassert>

using namespace std;

template<class T> inline void umax(T &a,T b){if(a<b) a = b ; }

template<class T> inline void umin(T &a,T b){if(a>b) a = b ; }

template<class T> inline T abs(T a){return a>0 ? a : -a;}

template<class T> inline T gcd(T a,T b){return __gcd(a, b);}

template<class T> inline T lcm(T a,T b){return a/gcd(a,b)*b;}

typedef long long ll;

typedef pair<int, int> ii;

const int inf = 1e9 + 143;

const ll longinf = 1e18 + 143;

inline int read()

{

int x;scanf(" %d",&x);

return x;

}

const int N = 20001;

int n;

int a[N];

void read_inp()

{

   n = read();

   assert(1 <= n && n <= 20000);

   for(int i = 1; i <= n; i++)

{

       a[i] = read();

       assert(abs(a[i]) <= int(1e6));

   }

}

int main()

{

#ifdef KAZAR

   freopen("f.input","r",stdin);

   freopen("f.output","w",stdout);

   freopen("error","w",stderr);

#endif

   read_inp();

   ll ans = -longinf;

   for(int i = 1; i <= n; i++)

{

       {

           int l = i - 1, r = i;

           ll best = 0ll, cur = 0ll;

           while(l >= 1 && r <= n)

  {

               ll val = (ll)a[l] * a[r];

               cur += val;

               umin(best, cur);

               umax(ans, cur - best);

               --l;

               ++r;

           }

       }

 {

           int l = i - 1, r = i + 1;

           ll best = 0ll, cur = 0ll;

           while(l >= 1 && r <= n)

  {

               ll val = (ll)a[l] * a[r];

               cur += val;

               umin(best, cur);

               umax(ans, cur - best);

               --l;

               ++r;

           }

       }

   }

   printf("%lld\n",ans);

   return 0;

}