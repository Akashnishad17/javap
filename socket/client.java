import java.io.*;
import java.net.*;
public class client
{
	public static void main(String[] args)throws UnknownHostException,IOException,ClassNotFoundException,InterruptedException
	{
		InetAddress host =InetAddress.getLocalHost();
		Socket socket = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		int i;
		for(i=0;i<5;i++)
		{
			socket = new Socket(host.getHostName(),9876);
			oos = new ObjectOutputStream(socket.getOutputStream());
			System.out.println("Sending request to socket server");
			if(i==4)
				oos.writeObject("exit");
			else
				oos.writeObject(""+i);
			ois = new ObjectInputStream(socket.getInputStream());
			String msg = (String) ois.readObject();
			System.out.println("Message: "+msg);
			ois.close();
			oos.close();
			Thread.sleep(100);
		}
	}
}