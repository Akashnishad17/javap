import java.io.*;
class loop
{
	public static void main(String args[])
	{
		long start = System.nanoTime();
		long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
				System.out.println("Hello");
		}
		long end = System.nanoTime(); 
        	System.out.println((end - start) + "ns");
		start = System.nanoTime();
		long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		long actualMemUsed=afterUsedMem-beforeUsedMem;
		System.out.println(actualMemUsed);
		beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		for(int k=0;k<50;k++)
		{
			System.out.println("Hello");
		}
		for(int k=0;k<50;k++)
		{
			System.out.println("Hello");
		}
		end = System.nanoTime(); 
        	System.out.println((end - start) + "ns");
		afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		actualMemUsed=afterUsedMem-beforeUsedMem;
		System.out.println(actualMemUsed);
	}
}