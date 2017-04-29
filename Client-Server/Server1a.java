import java.io.*;
import java.net.*;
import java.util.*;
public class Server1a {

	public static void main(String[] args)throws IOException
	{
		ServerSocket socketServer = new ServerSocket(12345);
		Scanner cin = new Scanner(System.in);
		Socket server = socketServer.accept();
		DataInputStream in = new DataInputStream(server.getInputStream());
		DataOutputStream out = null;
		out = new DataOutputStream(server.getOutputStream());
		try{
			System.out.println("waiting for message from client");
			String d = in.readUTF();
			String f = "Hello from server-Praveen";
			if(d.equals("Hello from client-Praveen"))
			{
				System.out.println("client :"+d);
				System.out.println("Server :"+f);
				out.writeUTF(f);
				while(true){
					String send = null;
					String receive = null;
					receive = in.readUTF();
					System.out.println("client :"+receive);
					if(receive.equals("Bye from client-Praveen")){
						System.out.println("server :Okay bye");
						socketServer.close();
						break;
						}
					System.out.print("Server :");
					send = cin.nextLine();
					out.writeUTF(send);
				}
			}
		}
		catch(Exception e){
			System.out.println("connection closed");
		}
finally{}
	}

}
