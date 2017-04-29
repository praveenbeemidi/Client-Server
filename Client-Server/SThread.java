import java.net.*;
import java.io.*;
public class SThread extends Thread
{
	private DataInputStream dataInputStream =  null;
	private Server2 clientServer = null;
	private Socket socket   = null;
  public SThread( Server2 _server, Socket _socket)
   {
	   clientServer = _server;
	   socket = _socket;
   }
   public void run()
   { 
	   while (true)
	   { 
		   try
		   {  
			   System.out.println(dataInputStream.readUTF());
		   }
		   catch(Exception e) 
		   { 
		   }
	   }
   }
   public void open() throws Exception
   { 
	   dataInputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
   }
   public void close() throws Exception
   {  
	   if (socket != null)  
		   socket.close();
	   if (dataInputStream != null) 
		   dataInputStream.close();
   }
}
