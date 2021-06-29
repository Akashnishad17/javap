import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.InetAddress;
import java.util.Scanner;
 
public class latlong {
 
    public static void main(String[] args) throws IOException {
        try
        { 
            URL url_name = new URL("https://mycurrentlocation.net/"); 
            Scanner sc = new Scanner(url_name.openStream()); 
            String location;
            while (sc.hasNext())
            {
                location = sc.nextLine();
                System.out.println(location);
            }
            sc.close();
        } 
        catch (Exception e) 
        { 
            System.out.print(e); 
        } 
    }
 
}