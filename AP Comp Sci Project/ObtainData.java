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

    public static void main(String[] args)
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
            while((inputLine = in.readLine()) != null)
            {
                line += inputLine + " ";
                //System.out.println(inputLine);
            }
            in.close();
        }catch(IOException e){
            System.out.println("Didn't work");
            System.exit(1);
        }

        ArrayList<Double> data = new ArrayList<Double>();
        int i = 0;
        i = betterFind(line, "\\d\\d,\\d\\d\\d\\.\\d\\d", data, i, true, false);
        System.out.println(data.get(i-1));
        i = betterFind(line, "<span class=.posData.>(.)(\\d+\\.?\\d+)</span>", data, i, true, true);
        System.out.println(data.get(i-1));
        i = betterFind(line, "<span class=.posData.>(.)(\\d+\\.\\d+)\\%</span>", data, i, true, true);
        System.out.println(data.get(i-1));


        /*String regex = "\\d\\d,\\d\\d\\d\\.\\d\\d";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(line);*/

        /*while(m.find())
        {
        System.out.println(m.group(0));
        data.add(Double.parseDouble(m.group(0).substring(0,2) + m.group(0).substring(3,9)));
        System.out.println(data.get(i));
        i++;
        }*/
        /*regex = "<span class=.posData.>(.)(\\d+\\.?\\d+)</span>";
        p = Pattern.compile(regex);
        m = p.matcher(line);
        while(m.find())
        {
        System.out.println(m.group(0));
        Double thing = Double.parseDouble(m.group(2));
        if(m.group(1).equals("+"))
        {
        data.add(thing);
        }else{
        data.add(0-thing);
        }
        System.out.println(data.get(i));
        i++;
        }
        regex = "<span class=.posData.>(.)(\\d+\\.\\d+)\\%</span>";
        p = Pattern.compile(regex);
        m = p.matcher(line);
        if(m.find())
        {
        System.out.println(m.group(0));
        Double thing = Double.parseDouble(m.group(2));
        if(m.group(1).equals("+"))
        {
        data.add(thing);
        }else{
        data.add(0-thing);
        }
        System.out.println(data.get(i));
        i++;
        }*/
    }

    public static int betterFind(String line, String regex, ArrayList<Double> data, int i, boolean getAll, boolean change)
    {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(line);
        boolean stop = true;
        if(change == false)
        {
            while(m.find() && stop)
            {
                System.out.println(m.group(0));
                data.add(Double.parseDouble(m.group(0).substring(0,2) + m.group(0).substring(3,9)));
                System.out.println(data.get(i));
                i++;
                stop = getAll;
            }
        }else{
            while(m.find() && stop)
            {
                System.out.println(m.group(0));
                Double thing = Double.parseDouble(m.group(2));
                if(m.group(1).equals("+"))
                {
                    data.add(thing);
                }else{
                    data.add(0-thing);
                }
                System.out.println(data.get(i));
                i++;
                stop = getAll;
            }
        }
        return(i);
    }

    public static void test()
    {
        String thing = "12345.0";
        double thingy = Double.parseDouble(thing.substring(1,3) + thing.substring(3,7));
        System.out.println(thingy);
    }
}
