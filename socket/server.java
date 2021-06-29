import java.io.*;
import java.net.*;
import java.lang.*;
public class server
{
	private static ServerSocket server;
	private static int port=9876;
	public static void main(String[] args)throws IOException,ClassNotFoundException
	{
		server = new ServerSocket(port);
		while(true)
		{
			Socket socket = server.accept();
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			String msg = (String) ois.readObject();
			System.out.println("Message received: "+msg);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject("Hi client "+msg);
			ois.close();
			oos.close();
			socket.close();
			if(msg.equalsIgnoreCase("exit"))
				break;
		}
		System.out.println("Shutting down Socker Server");
		server.close();
	} 
}