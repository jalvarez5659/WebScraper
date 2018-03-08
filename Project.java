import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.*;
import java.util.*;

public class Project
{
    public static void one()
    {
        String line = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(new File("/Volumes/J BACKUP/0. Regex/alice.txt")));
            String thing = "";
            while((thing = br.readLine()) != null)
            {
                line += thing + " ";
            }
            br.close();
        }catch(IOException e){
            System.out.println("No file to read from");
            System.exit(1);
        }

        String regex = "Alice";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(line);

        int alices = 0;
        while(m.find()){
            alices++;
        }
        System.out.println(alices);
    }

    public static void two()
    {
        String regex = "Alice";
        try{
            BufferedReader br = new BufferedReader(new FileReader(new File("/Volumes/J BACKUP/0. Regex/alice.txt")));
            String thing = "";
            int i = 1;
            while((thing = br.readLine()) != null)
            {
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(thing);
                if(m.find()){
                    System.out.print(i + " ");
                }
                i++;
            }
            System.out.println();
            br.close();
        }catch(IOException e){
            System.out.println("No file to read from");
            System.exit(1);
        }
    }

    public static void three()
    {
        String line = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(new File("/Volumes/J BACKUP/0. Regex/alice.txt")));
            String thing = "";
            while((thing = br.readLine()) != null)
            {
                line += thing + " ";
            }
            br.close();
        }catch(IOException e){
            System.out.println("No file to read from");
            System.exit(1);
        }

        String regex = "\\w'\\w";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(line);

        int c = 0;
        while(m.find()){
            c++;
        }
        System.out.println(c);
    }

    public static void four()
    {
        String line = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(new File("/Volumes/J BACKUP/0. Regex/alice.txt")));
            String thing = "";
            while((thing = br.readLine()) != null)
            {
                line += thing + " ";
            }
            br.close();
        }catch(IOException e){
            System.out.println("No file to read from");
            System.exit(1);
        }

        String regex = "\\b[A-Z]+('?[A-Z]*)\\b";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(line);

        int c = 0;
        while(m.find()){
            c++;
        }
        System.out.println(c);
    }

    public static void five()
    {
        String line = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(new File("/Volumes/J BACKUP/0. Regex/alice.txt")));
            String thing = "";
            while((thing = br.readLine()) != null)
            {
                line += thing + " ";
            }
            br.close();
        }catch(IOException e){
            System.out.println("No file to read from");
            System.exit(1);
        }

        String regex = "\\b([A-Za-z]{8})\\b";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(line);

        int c = 0;
        while(m.find()){
            c++;
        }
        System.out.println(c);
    }

    public static void six()
    {
        String line = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(new File("/Volumes/J BACKUP/0. Regex/alice.txt")));
            String thing = "";
            while((thing = br.readLine()) != null)
            {
                line += thing + " ";
            }
            br.close();
        }catch(IOException e){
            System.out.println("No file to read from");
            System.exit(1);
        }

        String regex = "\\b([A-Za-z]{4})\\s([A-Za-z]{4})\\b";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(line);

        int c = 0;
        while(m.find()){
            c++;
        }
        System.out.println(c);
    }

    public static void seven()
    {
        String regex = "(?i)(\\w+)[\\W\\w]+(\\b\\1\\b)";
        try{
            BufferedReader br = new BufferedReader(new FileReader(new File("/Volumes/J BACKUP/0. Regex/alice.txt")));
            String thing = "";
            int i = 1;
            while((thing = br.readLine()) != null)
            {
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(thing);
                if(m.find()){
                    System.out.println(true);
                    br.close();
                    return;
                }
                i++;
            }
            br.close();
            System.out.println(false);
        }catch(IOException e){
            System.out.println("No file to read from");
            System.exit(1);
        }
    }
    
    public static void eight()
    {
        String regex = "(?i)(\\w+).+(\\b\\1\\b)";
        try{
            BufferedReader br = new BufferedReader(new FileReader(new File("/Volumes/J BACKUP/0. Regex/alice.txt")));
            String thing = "";
            int i = 1;
            while((thing = br.readLine()) != null)
            {
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(thing);
                if(m.find()){
                    System.out.print(i + " ");
                }
                i++;
            }
            System.out.println();
            br.close();
        }catch(IOException e){
            System.out.println("No file to read from");
            System.exit(1);
        }
    }

    public static void nine()
    {
        ArrayList<String> characters = new ArrayList<String>(8);
        characters.add("Alice");
        characters.add("Hatter");
        characters.add("March Hare");
        characters.add("Dormouse");
        characters.add("Queen");
        characters.add("Elsie");
        characters.add("Lacie");
        characters.add("Tillie");
        ArrayList<Integer> other = new ArrayList<Integer>(8);
        other.add(0);
        other.add(0);
        other.add(0);
        other.add(0);
        other.add(0);
        other.add(0);
        other.add(0);
        other.add(0);

        String line = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(new File("/Volumes/J BACKUP/0. Regex/alice.txt")));
            String thing = "";
            while((thing = br.readLine()) != null)
            {
                line += thing + " ";
            }
            br.close();
        }catch(IOException e){
            System.out.println("No file to read from");
            System.exit(1);
        }

        for(int i = 0; i < characters.size(); i++)
        {
            String regex = characters.get(i);

            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(line);

            int c = 0;
            while(m.find()){
                c++;
            }
            other.set(i, c);
        }
        nineHelper(characters, other);
    }
    
    private static void nineHelper(ArrayList<String> characters, ArrayList<Integer> other)
    {
        while(characters.size() >= 1)
        {
            int thing = 0;
            for(int i = 1; i < characters.size(); i++)
            {
                if(other.get(thing) < other.get(i))
                {
                    thing = i;
                }
            }
            System.out.println(characters.get(thing) + " " + other.get(thing));
            characters.remove(thing);
            other.remove(thing);
        }
    }
}
