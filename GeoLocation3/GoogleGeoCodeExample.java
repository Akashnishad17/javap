import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


public class GoogleGeoCodeExample 
{
    public static void main(String[] args)
    {
        String code = "1600 Amphitheatre Parkway, Mountain View, CA";
        GeoCoder geoCode = new GeoCoder();
        GeocodeResponse response = geoCode.getLocation(code);
        System.out.print(response);
    }
}