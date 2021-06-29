import java.rmi.*;
public class client
{
	public static void main(String[] args)
	{
		try
		{
			adder serve = (adder) Naming.lookup("rmi://"+args[0]+"/AddService");
			System.out.println("Sum is "+serve.sum(10,5));
		}
		catch(Exception e){System.out.println(e);}
	}
}