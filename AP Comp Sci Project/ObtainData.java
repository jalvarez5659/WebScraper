import java.net.*;
import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.*;

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
        String line = "";
        try{
            URL dow = new URL("http://money.cnn.com/data/markets/dow/");
            BufferedReader in = new BufferedReader(new InputStreamReader(dow.openStream()));
            String inputLine;
            //"<td data-field="last">24908.47</td>"
            while((inputLine = in.readLine()) != null)
            {
                /*if(inputLine.length() > 26)
                {
                    if(inputLine.substring(15,26).equals("last_599362"))
                    {
                        String other = in.readLine();
                        String next = in.readLine();
                        double thing = (((Double.parseDouble(other.substring(1,3) + other.substring(4,5))) * 100) + Double.parseDouble(next.substring(12,14) + next.substring(15,17)));
                        System.out.println(thing);
                    }
                }*/
                line += inputLine + " ";
                //System.out.println(inputLine);
            }
            in.close();
        }catch(IOException e){
            System.out.println("Didn't work");
            System.exit(1);
        }
        
        String regex = "\\d\\d,\\d\\d\\d\\.\\d\\d";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(line);
        ArrayList<Double> data = new ArrayList<Double>(5);
        int i = 0;
        while(m.find())
        {
            System.out.println(m.group(0));
            data.add(Double.parseDouble(m.group(0).substring(0,2) + m.group(0).substring(3,9)));
            System.out.println(data.get(i));
            i++;
        }
        regex = "<span class=.posData.>(.)(\\d+\\.\\d+)</span>";
    }

    public static void test()
    {
        String thing = "12345.0";
        double thingy = Double.parseDouble(thing.substring(1,3) + thing.substring(3,7));
        System.out.println(thingy);
    }
}
