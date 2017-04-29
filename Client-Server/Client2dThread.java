import java.net.*;
import java.io.*;
public class Client2dThread extends Thread
{ 
	private Socket socket   = null;
	private Client2d client   = null;
	private DataInputStream infromuser1 = null;
	public Client2dThread(Client2d cclient, Socket ssocket)
	{
		client   = cclient;
		socket   =ssocket;
		open();  
		start();
	}
	public void open()
	{  
		try
		{
			infromuser1= new DataInputStream(socket.getInputStream());
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
			if (infromuser1 != null) infromuser1.close();
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
				client.handle(infromuser1.readUTF());
			}
			catch(Exception e)
			{  
				client.stop();
			}
		}
	}
}