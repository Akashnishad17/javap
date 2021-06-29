import java.rmi.*;
import java.rmi.registry.*;
public class server
{
	public static void main(String[] args)
	{
		try
		{
			adder service = new adds();
			Naming.bind("AddService",service);
		}
		catch(Exception e){System.out.println(e);}
	}
}