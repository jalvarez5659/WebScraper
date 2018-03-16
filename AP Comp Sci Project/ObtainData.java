import java.net.*;
import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ObtainData
{
    public ObtainData()
    {
        
    }

    public static void otherMain(String[] args)
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
        //Company Dow = new Company(d
        
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

    public static int betterFind(String line, String regex, ArrayList<Double> data, int i, boolean getAll, boolean wholeLine)
    {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(line);
        boolean stop = true;
        if(wholeLine == false)
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
    
    public static void main(String[] args)
    {
        
        JFrame frame = new JFrame();
        frame.setSize(600,600);
        frame.setTitle("Extra Research");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel checkBoxPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        JCheckBox iNews = new JCheckBox("In News");
        checkBoxPanel.add(iNews);
        JCheckBox nPub = new JCheckBox("Negative Publicity");
        checkBoxPanel.add(nPub);
        JCheckBox pPub = new JCheckBox("Positive Publicity");
        checkBoxPanel.add(pPub);
        JCheckBox dComp = new JCheckBox("Direct Competition");
        checkBoxPanel.add(dComp);
        JButton button = new JButton("Start Program");
        mainPanel.add(checkBoxPanel);
        mainPanel.add(buttonPanel);

        frame.add(mainPanel);

        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}
