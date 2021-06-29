#include <bits/stdc++.h>

using namespace std;
long mod=1000000007;
int main()
{
   int t;
   cin>>t;
   while(t--)
   {
       int n,flag=0,in1=-1;
       cin>>n;
       long a[n+1];
       for(int i=1;i<=n;i++){
            cin>>a[i];
            if(a[i]==1)
                in1=i;
       }
        long prefix[n+1];
        memset(prefix, 0 , sizeof(prefix));
        
        if(in1==1)
        {
            for(int i=1;i<=n;i++)
                prefix[i]=1;
        }
        else if(in1==n||in1==-1)
        {
            for(int i=1;i<=n;i++)
            {
                if(a[i]%2!=0)
                {        
                    if(i==n)
                        prefix[i]=prefix[i-1]+a[i];
                    else
                        prefix[i]=prefix[i-1]+a[i]-1;
                }
                else
                {
                    if(i==n)
                        prefix[i]=prefix[i-1]+a[i]-1;
                    else
                        prefix[i]=prefix[i-1]+a[i];
                }
            }
        }
        else if(in1!=-1)
        {
            for(int i=1;i<=n;i++)
            {
                if(i==in1)
                {
                    if(a[in1-1]%2==0)
                    {
                        prefix[in1-1]--;
                    }
                    else
                        prefix[in1-1]++;
                    prefix[in1]=prefix[in1-1];
                }
                else if(a[i]%2!=0)
                {        
                    if(i==n)
                        prefix[i]=prefix[i-1]+a[i];
                    else
                        prefix[i]=prefix[i-1]+a[i]-1;
                }
                else
                {
                    if(i==n)
                        prefix[i]=prefix[i-1]+a[i]-1;
                    else
                        prefix[i]=prefix[i-1]+a[i];
                }
            }
        }
       // for(int i=1;i<=n;i++)
        //    cout<<prefix[i]<<" ";
        //cout<<endl;
        int q;
        cin>>q;
        while(q--)
        {
            long r,temp,ans=0,n1;
           cin>>r;
           temp=r/n;
           if(r%n==0){
            temp--;n1=n;
           }
           else
           n1=r%n;
           ans=(prefix[n]%mod*temp%mod)%mod;
           
           if(n1>0){
               if(in1>1&&in1<n)
               {
                        ans=(ans%mod+prefix[n1]%mod)%mod;
                        if(in1==n1+1)
                            ans=(ans+1)%mod;
                        else if(in1==n1)
                        {
                            if(a[n1-1]%2==0)
                                ans=(ans+1)%mod;
                                ans=(ans+1)%mod;
                        }
                        else
                        ans=(ans-1)%mod;
               }
               else if(in1==1)
               {
                   //ans=(ans%mod+prefix[n1]%mod)%mod;
                   if(n1>1||r==1)
                   ans=(ans+1)%mod;
               }
               else if(in1==n||in1==-1){
                    ans=(ans%mod+prefix[n1]%mod)%mod;
                    
               }
           }
           else if(n1==0&&in1!=1&&in1!=n&&a[n]%2==0)
                ans=(ans+1)%mod;
           cout<<ans<<endl;
        }
   }
   
   return 0;
}
