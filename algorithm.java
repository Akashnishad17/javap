import java.io.*;
class algorithm
{
	double p;
        static int a;
	algorithm(double x)
	{p=x;}
	double algo(int n)
	{
		if(n==0)
			return p;
		p=1-(1-p/2)*(1-p/2);
		a++;
		System.out.println("Output of p"+a+" is "+p);
	        return algo(n-1);
	}
	static
	{
		a=0;
	}
	public static void main(String args[])
	{
		long start = System.nanoTime();
		algorithm obj = new algorithm(0.1);
		double out=obj.algo(6);
		long end = System.nanoTime(); 
        	System.out.println((end - start) + "ns");
	}
} 