#include <iostream>

using namespace std;
int Ap10[10],key1[8],key2[8],IP[8];
int LE[4],RE[4]; 
int FKEY1[8];
void key1generate(int input[],int key[]){
    
    
    int p10[10]={3,5,2,7,4,10,1,9,8,6};
    int count=0;
    
    for(int i=0;i<10;i++){
       Ap10[i]=key[p10[count]-1];
       count++;
       
    }
    //LS-1 application
    int temp=Ap10[0];
    for(int i=0;i<9;i++){
        Ap10[i]=Ap10[i+1];
    }
    Ap10[9]=temp;
    
    //Apply P8
    
    int p8[8]={6,3,7,4,8,5,10,9};
    
    count=0;
    for(int i=0;i<8;i++){
        key1[i]=Ap10[p8[count]-1];
        count++;
    }
  cout<<endl;
  cout<<"Key1 is : ";
    for(int i=0;i<8;i++){
        cout<<key1[i];
    }
    cout<<endl;
    
}

void key2generate(int input[],int key[]){
  //Apply LS-2
    int t=2;
    while(t){
        int temp=Ap10[0];
    for(int i=0;i<9;i++){
        Ap10[i]=Ap10[i+1];
    }
    Ap10[9]=temp;
    t--;
    }
    cout<<endl;
    
    //Apply P8
    int p8[8]={6,3,7,4,8,5,10,9};
    
    
    
    int count=0;
    for(int i=0;i<8;i++){
        key2[i]=Ap10[p8[count]-1];
        count++;
    }
    cout<<"Key2 is : ";
    for(int i=0;i<8;i++){
        cout<<key2[i];
    }
    
    
    cout<<endl;  
}



void fkey1(int IP[],int key1[]){
    
   for(int i=0;i<4;i++){
       LE[i]=IP[i];
   }
   
   for(int i=4;i<8;i++){
       RE[i]=IP[i];
   }
   
   int EP[8]={4,1,2,3,2,3,4,1};
   int EP1[8];
   int count=0;
    for(int i=0;i<8;i++){
        EP1[i]=RE[EP[count]-1];
        count++;
    }
   int XOR[8];
   for(int i=0;i<8;i++){
       if((RE[i]==0&&key1[i]==0)||(RE[i]==1&&key1[i]==1)){
           XOR[i]=0;
       }
       else{
           XOR[i]=1;
       }
       
   }
   
   int S0[4][4]={1,0,3,2,  
        3,2,1,0,
        0,2,1,3,
        3,1,3,2
    };
   
    int S1[4][4]={0,1,2,3,   
        2,0,1,3,
        3,0,1,0,
        2,1,0,3
    };
    
    
    int x,y;
    int P4[4]; 
    
    
    x=2*XOR[0]+XOR[3];
    y=2*XOR[1]+XOR[2];
    
    int z=S0[x][y];
    int k = 0; 
    while (z > 0) { 
  
        
        P4[k] = z % 2; 
        z = z / 2; 
        k++; 
    } 
    
    x=2*XOR[4]+XOR[7];
    y=2*XOR[5]+XOR[6];
    
     z=S1[x][y];
    
    while (z > 0) { 
  
        
        P4[k] = z % 2; 
        z = z / 2; 
        k++; 
    } 
    
    
    
    int P4A[4]={2,4,3,1};
    int P4R[4];
    count=0;
    for(int i=0;i<4;i++){
        P4R[i]=P4[P4A[count]-1];
        count++;
    }
    
    int XOR4[4];
    for(int i=0;i<4;i++){
       if((LE[i]==0&&P4R[i]==0)||(LE[i]==1&&P4R[i]==1)){
           XOR4[i]=0;
       }
       else{
           XOR4[i]=1;
       }
       
   }
   
   
   for(int i=0;i<4;i++){
       FKEY1[i]=XOR4[i];
   }
   for(int i=4;i<8;i++){
       FKEY1[i]=RE[i];
   }
   cout<<endl;
   cout<<"FKey1 is : ";
   for(int i=0;i<8;i++){
       cout<<FKEY1[i];
   } 

}


void fkey2(){
    
    int SW[8];
    
    for(int i=0;i<4;i++){
        SW[i]=IP[i+4];
    }
    
    for(int i=4;i<8;i++){
        SW[i]=FKEY1[i];
    }
    
   for(int i=0;i<4;i++){
       LE[i]=SW[i];
   }
   
   for(int i=4;i<8;i++){
       RE[i]=SW[i];
   }
   
   int EP[8]={4,1,2,3,2,3,4,1};
   int EP1[8];
   int count=0;
    for(int i=0;i<8;i++){
        EP1[i]=RE[EP[count]-1];
        count++;
    } 
    int XOR[8];
    for(int i=0;i<8;i++){
       if((RE[i]==0&&key2[i]==0)||(RE[i]==1&&key2[i]==1)){
           XOR[i]=0;
       }
       else{
           XOR[i]=1;
       }
       
   }
   
   int S0[4][4]={1,0,3,2,  
        3,2,1,0,
        0,2,1,3,
        3,1,3,2
    };
   
    int S1[4][4]={0,1,2,3,   
        2,0,1,3,
        3,0,1,0,
        2,1,0,3
    };
    
    
    int x,y;
    int P4[4]; 
    
    
    x=2*XOR[0]+XOR[3];
    y=2*XOR[1]+XOR[2];
    
    int z=S0[x][y];
    int k = 0; 
    while (z > 0) { 
  
        
        P4[k] = z % 2; 
        z = z / 2; 
        k++; 
    } 
    
    x=2*XOR[4]+XOR[7];
    y=2*XOR[5]+XOR[6];
    
     z=S1[x][y];
    
    while (z > 0) { 
  
        
        P4[k] = z % 2; 
        z = z / 2; 
        k++; 
    } 
    
    
    
    int P4A[4]={2,4,3,1};
    int P4R[4];
    count=0;
    for(int i=0;i<4;i++){
        P4R[i]=P4[P4A[count]-1];
        count++;
    }
    
    int XOR4[4];
    for(int i=0;i<4;i++){
       if((LE[i]==0&&P4R[i]==0)||(LE[i]==1&&P4R[i]==1)){
           XOR4[i]=0;
       }
       else{
           XOR4[i]=1;
       }
       
   }
   int FKEY2[8];
   for(int i=0;i<4;i++){
       FKEY2[i]=XOR4[i];
   }
   for(int i=4;i<8;i++){
       FKEY2[i]=RE[i];
   }
   cout<<endl;
   cout<<"\nFKey2 is : ";
   for(int i=0;i<8;i++){
       cout<<FKEY2[i];
   } 
   
   int IPI[8]={4,1,3,5,7,2,8,6};
  
   
   int Final[8];
    count=0;
    for(int i=0;i<8;i++){
        Final[i]=FKEY2[IPI[count]-1];
        count++;
    } 
    cout<<"\n\nEncrypted text is : ";
   for(int i=0;i<8;i++){
       cout<<Final[i];
   } 
   
}

int main()
{
   int input[8];
   int key[10];
   cout<<"Enter input  ";
   for(int i=0;i<8;i++){
       cin>>input[i];
   }
   
   for(int i=0;i<8;i++){
        cout<<input[i];
    }
    
    cout<<endl;
    
    cout<<"Enter key  ";
    for(int i=0;i<10;i++){
        cin>>key[i];
    }
    
    for(int i=0;i<10;i++){
        cout<<key[i];
    }
    cout<<endl;
    
   key1generate(input,key);
   key2generate(input,key);
    
   int ip[8]={2,6,3,1,4,8,5,7};
   
    int count=0;
    
    for(int i=0;i<8;i++){
       IP[i]=input[ip[count]-1];
       count++;
       
    }
    fkey1(IP,key1);
    
    fkey2();
       
    return 0;
}