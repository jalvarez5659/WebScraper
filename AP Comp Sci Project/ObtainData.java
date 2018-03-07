import java.net.*;
import java.io.*;

public class ObtainData
{
    public ObtainData()
    {

    }

    public static void main()
    {
        /*try{
        URL oracle = new URL("https://www.oracle.com/index.html");
        BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
        String inputLine;
        while((inputLine = in.readLine()) != null)
        {
        System.out.println(inputLine);
        }
        in.close();
        }catch(IOException e){
        System.out.println("Didn't work");
        }*/
        try{
            URL cnbc = new URL("http://money.cnn.com/data/markets/dow//");
            BufferedReader in = new BufferedReader(new InputStreamReader(cnbc.openStream()));
            String inputLine;
            //"<td data-field="last">24908.47</td>"
            while((inputLine = in.readLine()) != null)
            {
                if(inputLine.length() > 26)
                {
                    if(inputLine.substring(15,26).equals("last_599362"))
                    {
                        String other = in.readLine();
                        String next = in.readLine();
                        double thing = (((Double.parseDouble(other.substring(1,3) + other.substring(4,5))) * 100) + Double.parseDouble(next.substring(12,14) + next.substring(15,17)));
                        System.out.println(thing);
                    }
                }
                //System.out.println(inputLine);
            }
            in.close();
        }catch(IOException e){
            System.out.println("Didn't work");
        }
    }

    public static void test()
    {
        String thing = "12345";
        int thingy = Integer.parseInt(thing.substring(1,3) + thing.substring(3,5));
        System.out.println(thingy);
    }
}
