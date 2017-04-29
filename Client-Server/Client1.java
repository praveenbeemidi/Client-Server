import java.net.*;
import java.io.*;
public class Client1
{
	private DataOutputStream toserver = null; 
	private BufferedReader infromclient = null;
	private Socket socket = null;
	public void connection(String serverIP, int serverPort)
	{
		try
		{  
			socket = new Socket(serverIP, serverPort);
			infromclient   = new BufferedReader( new InputStreamReader(System.in));
			toserver = new DataOutputStream(socket.getOutputStream());
		}
		catch(Exception e)
		{ 
		}
		String msg = "";
		while (!msg.equals("exit"))
		{  
			try
			{  
				msg = infromclient.readLine();
				toserver.writeUTF(msg);
				toserver.flush();
			}
			catch(Exception e)
			{  
			}
		}

	}
	public void stop()
	{  
		try
		{  
			if (infromclient   != null)  infromclient.close();
			if (toserver != null)  toserver.close();
			if (socket    != null)  socket.close();
		}
		catch(Exception e)
		{  
		}
	}
	public static void main(String args[])
	{
		Client1 client = new Client1();
		client.connection("10.103.0.9",12342);
	}
}
