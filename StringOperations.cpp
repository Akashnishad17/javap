#include <bits/stdc++.h>
using namespace std;
 unordered_map<string,int>mp;
 
void generate(string s)
{
if(mp[s]>0)
return;

mp[s]++;

    for(int i=0;i<s.size();i++)
    {
    
        
        int count=0;
        for(int j=i;j<s.size();j++)
        {
  
       if(s[j]=='1') count++;
   
       if(count%2==0)
       {
           string h=s;
           
          reverse(h.begin()+i,h.end()+j+1-h.size());
          generate(h);
        
       }
        }
    }
}
int main() {
    
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    int t;
    cin>>t;
    while(t--)
    {
        int ans=0;
       mp.clear();
        string s;
        cin>>s;
       
        for(int i=0;i<s.size();i++)
        {
            string a;
            for(int j=i;j<s.size();j++)
            {
                a+=s[j];
                if(mp[a]==0)
                {
                   ans++;
            
                generate(a);
                
                
                }
            }
            
        }


       cout<<ans<endl;
     

    }

	return 0;
}