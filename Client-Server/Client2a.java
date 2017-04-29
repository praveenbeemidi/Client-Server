import java.io.*;
import java.net.*;
public class Client2a {
	public static void main(String[] args) {
		String msg;
		Boolean flag = true;
		BufferedReader inFromClient = new BufferedReader( new InputStreamReader(System.in));
		Socket clientSocket;
		try
		{
			do
			{
				clientSocket = new Socket("172.17.1.31", 11224);
				System.out.println("Text your message to server");
				msg = inFromClient.readLine();
				if(msg.contains("exit"))
				{
					flag=false;
					msgServer(msg, clientSocket);
					clientSocket.close();
				}
				else
				{
					msgServer(msg, clientSocket);
				}
			}while(flag);
		} 
		catch(Exception e)
		{

		}
		finally
		{
		}
	}
	private static void msgServer(String msg, Socket clientSocket) throws IOException
	{
		DataOutputStream msgToServer;
		msgToServer = new DataOutputStream(clientSocket.getOutputStream());
		msgToServer.writeBytes(msg + '\n');		
	}
}
