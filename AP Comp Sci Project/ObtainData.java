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
            URL cnbc = new URL("https://www.cnbc.com/stocks/");
            BufferedReader in = new BufferedReader(new InputStreamReader(cnbc.openStream()));
            String inputLine;
            //"<td data-field="last">24908.47</td>"
            while((inputLine = in.readLine()) == "<td data-field=\"last\">24924.18</td>")
            {
                System.out.println(inputLine);
            }
            in.close();
        }catch(IOException e){
            System.out.println("Didn't work");
        }
    }
}
