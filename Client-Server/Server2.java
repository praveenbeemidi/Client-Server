import java.net.*;
import java.io.*;

public class Server2 implements Runnable
{
	private SThread serverThread = null;
	private ServerSocket serverSocket = null;
	private Thread thread = null;
	public void connection(int port)
	{
		try
		{
			serverSocket = new ServerSocket(port);  
			if (thread == null)
			{  
				thread = new Thread(this); 
				thread.start();
			}
		}
		catch(Exception e)
		{  
		}
	}
	public void run()
	{  
		while (thread != null)
		{ 
			try
			{  
				addThread(serverSocket.accept());
			}
			catch(Exception e)
			{ 
			}
		}
	}
	public void addThread(Socket socket)
	{
		serverThread = new SThread(this, socket);
		try
		{  
			serverThread.open();
			serverThread.start();
		}
		catch(Exception e)
		{  
		}
	}
	public static void main(String args[])
	{  
		Server server =new Server();
		server.connection(12342);
	}
}
