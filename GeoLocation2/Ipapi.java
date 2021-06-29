import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class Ipapi {
    //static double[][] dL = new double[4][2]; //doctor
    static double[][] pL = new double[4][2]; //user
    static Statement statement;
    static
    {
        /*
        //Dr. Subhash 
        dL[0][0] = 30.376475;
        dL[0][1] = 77.976226;

        //Dr. Kaulagarh
        dL[1][0] = 30.350497;
        dL[1][1] = 78.005273;

        //Avontika Clinic
        dL[2][0] = 30.335316;
        dL[2][1] = 77.956080;

        //Keshav ent clinic
        dL[3][0] = 30.331594;
        dL[3][1] = 78.010726;
        */

        //hostel
        //30.401388,77.968962 harshit Upper Kandoli
        pL[0][0] = 30.401388;
        pL[0][1] = 77.968962;

        //30.412375,77.970433 akshat Bidholi
        pL[1][0] = 30.412375;
        pL[1][1] = 77.970433;

        //30.365598,77.971597 kompal pondha
        pL[2][0] = 30.365598;
        pL[2][1] = 77.971597;

        //30.343172,77.949447 akash nanka ki chawki
        pL[3][0] = 30.343172;
        pL[3][1] = 77.949447;
    } 

    public static void DatabaseConnect()
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost/doctormedico","root",""); 
            statement = conn.createStatement();
            System.out.print("Database Connected");
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public static void view()
    {
        try 
        {
            String insertquery = "select * from 'doctor' where area = 'Bidholi'";
            ResultSet result = statement.executeQuery(insertquery);
            while(result.next()){
                System.out.print("Lat " + result.getString(5));
                System.out.println("Long " + result.getString(6));
            }
        } catch (SQLException ex) {
            System.out.println("Problem To Show Data");
    }
 }

    public static double getDistanceFromLatLonInKm(double lat1,double lon1,double lat2,double lon2) 
    {
        double R = 6371; // Radius of the earth in km
        double dLat = deg2rad(lat2-lat1);  // deg2rad below
        double dLon = deg2rad(lon2-lon1); 
        double a = Math.sin(dLat/2)*Math.sin(dLat/2)+Math.cos(deg2rad(lat1))*Math.cos(deg2rad(lat2))*Math.sin(dLon/2)*Math.sin(dLon/2); 
        double c = 2*Math.atan2(Math.sqrt(a),Math.sqrt(1-a)); 
        double d = R * c; // Distance in km
        return d;
    }

    public static double deg2rad(double deg) 
    {
        return deg * (Math.PI/180);
    }
    public static void main(String[] args) throws IOException {
        String ip = ""; // for currnt location 
        try
        { 
            URL url_name = new URL("http://bot.whatismyipaddress.com"); 
            BufferedReader sc = new BufferedReader(new InputStreamReader(url_name.openStream())); 
            ip = sc.readLine().trim(); 
        } 
        catch (Exception e) 
        { 
            ip = "Cannot Execute Properly"; 
        } 
        URL ipapi = new URL("https://ipapi.co/"+ip+"/latlong/");
        URLConnection c = ipapi.openConnection();
        c.setRequestProperty("User-Agent", "java-ipapi-client");
        BufferedReader reader = new BufferedReader(new InputStreamReader(c.getInputStream())
        );
        String[] location = reader.readLine().split(",");
        System.out.println(location[0]+" "+location[1]);
        reader.close();
        /*for(int i = 0; i < 4; i++)
        {
            System.out.println("For doctor "+(i+1));
            for(int j = 0; j < 4; j++)
                System.out.println(getDistanceFromLatLonInKm(dL[i][0],dL[i][1],pL[j][0],pL[j][1]));
        }*/
        //DatabaseConnect();
        //view();
    }
}