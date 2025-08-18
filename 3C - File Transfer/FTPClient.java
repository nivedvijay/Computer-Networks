import java.io.*;
import java.net.*;
public class FTPClient 
{
    public static void main(String[] args) throws Exception 
    {
        InetAddress ia = InetAddress.getLocalHost();
        Socket s = new Socket(ia, 1024);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a name for the new file (to save received content):");
        String fname = br.readLine();
        File f1 = new File(fname);
        PrintWriter fileWriter = new PrintWriter(new FileWriter(f1));
        BufferedReader socketReader = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String str;
        while ((str = socketReader.readLine()) != null) 
        {
            fileWriter.println(str);
        }
        System.out.println("File received and saved as: " + fname);
        fileWriter.close();
        socketReader.close();
        s.close();
    }
}
