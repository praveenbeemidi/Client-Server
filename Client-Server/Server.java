import java.net.*;
import java.io.*;

public class Server implements Runnable
{  
	private ServerThread serverThread[] = new ServerThread[50];
	private ServerSocket serverSocket = null;
	private Thread thread = null;
	private int clientCount = 0;
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
				if (clientCount < serverThread.length)
				{
					serverThread[clientCount] = new ServerThread(this, serverSocket.accept());
					try
					{ 
						serverThread[clientCount].open(); 
						serverThread[clientCount].start();  
						clientCount++; 
					}
					catch(Exception e)
					{  
					}
				} 
			}
			catch(Exception e)
			{   
				if (thread != null)
				{  
					thread.stop(); 
					thread = null;
				}
			}
		}
	}
	public synchronized void handle(int ID, String input)
	{  
			System.out.println(input);
			for (int i = 0; i < clientCount; i++)
				serverThread[i].send(ID + ": " + input);   
	}
	public static void main(String args[]) 
	{
		Server server = new Server();
		server.connection(40000);
	}
}