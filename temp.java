class A
{
	void walk()
	{
		System.out.println("Class A");
	}
}
class B extends A
{
	void run()
	{
		System.out.println("Class B");
	}
}
class C extends A
{
	void run()
	{
		System.out.println("Class C");
	}
}
class temp
{
	public static void main(String[] args)
	{
		A ob;
		ob = new B();
		ob.walk();
		ob.run();

		ob = new C();
		ob.walk();
		ob.run();
	}
}