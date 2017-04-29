import java.io.*;
import java.io.FileWriter;
import java.net.Socket;

public class Client1b {

	public static void main(String[] args)throws Exception {
		Socket sock=new Socket("172.1.17.31");
		byte[] mybytearray=new byte[20000];
		InputStream is = sock.getInputStream();
		FileOutputStream fos=new FileOutputStream("india.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		int bytesRead=is.read(mybytearray,0,mybytearray.length);
		bos.write(mybytearray,0,bytesRead);
		try{
			BufferedReader br = new BufferedReader(new FileReader("india.txt"));
			String line=null;
			while((line=br.readLine())!=null){
				System.out.println(line);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		try{
			String filename="newfile.txt";
			FileWriter fw= new FileWriter(filename,true);
			fw.write("\nhello this is server adding line\n");
			fw.close();
		}
		catch(IOException ioe){
			System.err.println("IOException:"+ioe.getMessage());
		}
		bos.close();
		sock.close();
		}
		

}
