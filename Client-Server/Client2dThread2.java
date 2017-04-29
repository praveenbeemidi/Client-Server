import java.net.*;
import java.io.*;
public class Client2dThread2 extends Thread
{
	private Socket socket   = null;
	private Client2d2 client   = null;
	private DataInputStream infromclient = null;
	public Client2dThread2(Client2d2 cclient, Socket ssocket)
	{
		client   = cclient;
		socket   = ssocket;
		open();  
		start();
	}
	public void open()
	{  
		try
		{
			infromclient  = new DataInputStream(socket.getInputStream());
		}
		catch(Exception e)
		{  
			client.stop();
		}
	}
	public void close()
	{  
		try
		{
			if (infromclient != null) 
				infromclient.close();
		}
		catch(Exception e)
		{  	
		}
	}
	public void run()
	{ 
		while (true)
		{
			try
			{ 
				client.handle(infromclient.readUTF());
			}
			catch(Exception e)
			{  
				client.stop();
			}
		}
	}
}