import java.io.*;
import java.util.*;

class A{
	A other;

	void fun(){
		A a = new A();
		A b = new B();

		a.other = b;
		b.other = a;
	}
}

class Example{
	public static void solve(BufferedReader br) throws Exception
	{
		A ex = new A();
		ex.fun();
		System.out.print("Hello"); 
	}

	public static void main(String[] args) throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input6.txt"));	System.setOut(new PrintStream(new File("output.txt")));
		
		solve(br);
	}
}