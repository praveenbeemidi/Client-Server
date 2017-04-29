import java.io.*;
import java.net.*;
import java.util.*;
public class Client1a {

	public static void main(String[] args)throws Exception {
	try{
		String msg="";
		Socket client = new Socket("172.17.1.31",12345);
		DataInputStream in = new DataInputStream(client.getInputStream());
		DataOutputStream out = new DataOutputStream(client.getOutputStream());
		System.out.println("Send message to server");
		Scanner cin = new Scanner(System.in);
		while(!msg.equals("Hello from client-Praveen"))
		{
			System.out.print("client :");
			msg = cin.nextLine();
			if(msg.equals("Hello from client-Praveen"))
				out.writeUTF(msg);
			else
				System.out.println("enter message as in question");
		}
		while(true)
		{
			String send = null;
			String receive = null;
			receive = in.readUTF();
			System.out.println("server :"+receive);
			System.out.print("client :");
			send = cin.nextLine();
			out.writeUTF(send);
			if(receive.equals("Bye from server-Praveen"))
			{
				System.out.print("Server : Okay bye");
				client.close();
				break;
			}
			
		}
	}
	catch(Exception e)
	{
		System.out.println("connection closed");
	}
finally{}
	}

}

