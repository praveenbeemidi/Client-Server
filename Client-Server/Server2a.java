import java.io.*;
import java.net.*;
public class Server2a
	{
	public static void main(String[] args)
		{
		String clientmsg;
		ServerSocket serverSocket;
		try
		{
			serverSocket = new ServerSocket(11224);
			while(true)
			{
				Socket connectionSocket = serverSocket.accept();
				BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
				clientmsg = inFromClient.readLine();
				if (clientmsg.equals("exit"))
				{
System.out.println("Client texted you\n " + clientmsg);
serverSocket.close();
break;
				}
				System.out.println("Client typed " + clientmsg);
				
			}
		}
		catch(Exception e)
		{

		}
		finally {
		}
	}
}