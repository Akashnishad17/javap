import java.rmi.*;
public interface adder extends Remote
{
	public int sum(int a,int b)throws RemoteException;
}