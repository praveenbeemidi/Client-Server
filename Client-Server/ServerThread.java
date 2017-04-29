import java.net.*;
import java.io.*;
public class ServerThread extends Thread
{
	private Server server = null;
	private Socket socket = null;
	private int ID = -1;
	private DataInputStream  dataInputStream  =  null;
	private DataOutputStream dataOutputStream = null;
	public ServerThread(Server _server, Socket _socket)
	{ 
		super();
		server = _server;
		socket = _socket;
		ID     = socket.getPort();
	}
	public void send(String msg)
	{  
		try
		{
			dataOutputStream.writeUTF(msg);
			dataOutputStream.flush();
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
				server.handle(ID, dataInputStream.readUTF());
			}
			catch(Exception e)
			{  
					stop();
			}
		}
	}
	public void open() throws Exception
	{
		dataInputStream = new DataInputStream(new 
				BufferedInputStream(socket.getInputStream()));
		dataOutputStream = new DataOutputStream(new
				BufferedOutputStream(socket.getOutputStream()));
	}
	public void close() throws Exception
	{  
		if (socket != null)    socket.close();
		if (dataInputStream != null)  dataInputStream.close();
		if (dataOutputStream != null) dataOutputStream.close();
	}
}