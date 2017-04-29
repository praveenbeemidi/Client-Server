import java.io.*;
import java.net.*;
import java.util.*;
public class Client2B
{ 
    public static void main(String args[]) throws IOException
	{  
	DataOutputStream outtoserver = null;
	Socket socket = null; 
        socket=new Socket("10.103.0.9",20001);
	Scanner infromuser = null;
       outtoserver = new DataOutputStream(socket.getOutputStream());
        infromuser= new Scanner(System.in);
        String msg="";
        
        while(!msg.equals("exit")){
            System.out.println("send message to server:");
            msg=infromuser.nextLine();
            outtoserver.writeUTF(msg);
        }
	}
}