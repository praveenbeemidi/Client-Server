import java.net.*;
import java.io.*;
public class Client2d2 implements Runnable
{ 
	private BufferedReader infromuser = null; 
	private Socket socket = null;
	private Client2dThread2 client = null;
	private DataOutputStream toserver = null;
	private Thread thread = null;
	public void connection2(String serverIP, int serverPort)
	{
		try
		{ 
			socket = new Socket(serverIP, serverPort);
			infromuser   = new BufferedReader( new InputStreamReader(System.in));
			toserver = new DataOutputStream(socket.getOutputStream());
			if (thread == null)
			{  
				client = new Client2dThread2(this, socket);
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
				String msgs=infromuser.readLine();
				if(msgs.equals("exit"))
				{
					socket.close();
				}
				toserver.writeUTF(msgs);
				toserver.flush();
			}
			catch(Exception e)
			{  
					}
		}
	}
	public void handle(String msg)
	{
		if (msg.equals("exit"))
		{  
			stop();
		}
		else
			System.out.println(msg);
	}
	public void stop()
	{  
		if (thread != null)
		{
			thread.stop();  
			thread = null;
		}
		try
		{
			if (infromuser   != null)  infromuser.close();
			if (toserver != null)  toserver.close();
			if (socket    != null)  socket.close();
		}
		catch(Exception e)
		{ 
		}
		client.close();  
		client.stop();
	}
	public static void main(String args[])
	{ 
		Client2d2 client = new Client2d2();
		client.connection2("10.103.0.9",40000);
	}
}