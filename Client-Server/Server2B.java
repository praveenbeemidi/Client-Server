import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server2B implements Runnable
{
        private ServerSocket serSoct = null;
	private DataInputStream dataInputStream  =  null;
	private Thread t1 = null;
	private Socket soct = null;
        public static void main(String args[]) throws IOException
	{ 
       
		Server2B server = new Server2B();
		server.mainMethodBServer();
        }
        public void mainMethodBServer() throws IOException
	{  
                        serSoct = new ServerSocket(20001);  
			System.out.println("Server started : "+serSoct);
			t1 = new Thread(this); 
                        t1.start();
	}
       
	public void run()
	{ 
		do{   
			try
			{
				soct = serSoct.accept();
				System.out.println("Client accepted: ");
				dataInputStream = new DataInputStream(soct.getInputStream());
				boolean flg = true;
				while (flg)
				{  
                                    String line = dataInputStream.readUTF();
                                    System.out.println(line);
                                    if(line.equals("exit")){
                                                    flg=false;
                                                    soct.close();
                                                    dataInputStream.close();
                                                }
                                }
				
			}
			catch(Exception e)
			{
			}
		}while(t1!=null);
	}
	
}
