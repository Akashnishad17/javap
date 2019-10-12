import java.rmi.*;
import java.rmi.server.*;
public class adds extends UnicastRemoteObject implements adder
{
	adds() throws RemoteException
	{
		super();
	}
	public int sum(int a,int b) throws RemoteException
	{
		return a+b;
	}
}