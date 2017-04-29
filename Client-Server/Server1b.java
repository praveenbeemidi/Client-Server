import java.io.*;
import java.net.*;
import java.util.*;
public class Server1b {

	public static void main(String[] args)throws IOException {
		ServerSocket servsock=new ServerSocker();
		File myFile=new File("newfile.txt");
		while(true){
			Socket sock=servsock.accept();
			byte[] mybytearray=new byte[(int)myFile.length()];
			BufferedInputStream bis=new BufferedInputStream(new FileInputStream(myFile));
			bis.read(mybytearray,0,mybytearray.length);
			OutputStream os=sock.getOutputStream();
			os.write(mybytearray,0,mybytearray.length);
			os.flush();
			try{
				BufferedReader br=new BufferedReader(new FileReader("india.txt"));
				String line=null;
				while((line=br.readLine())!=null){
					System.out.println(line);
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			sock.close();
		}
		

	}

}
