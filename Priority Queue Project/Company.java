import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Company implements Comparable<Company>
{
    private JFrame frame;
    private JPanel panel;
    private double stockPrice;
    private double previousClose;
    private double open;
    private double dayHigh;
    private double dayLow;
    private double projStockPrice;
    private double percentChange;
    private boolean inNews;
    private boolean negPublicity;
    private boolean posPublicity;
    private boolean directCompetition;
    private boolean tappedMarket;
    private final String name;
    private double change;
    private boolean projIncrease;

    public Company(double stockPrice, double previousClose, double open, double dayHigh, double dayLow, double percentChange)
    {
        this.stockPrice = stockPrice;
        this.previousClose = previousClose;
        this.open = open;
        this.dayHigh = dayHigh;
        this.dayLow = dayLow;
        this.percentChange = percentChange;
        frame = new JFrame();
        frame.setSize(500,500);
        frame.setTitle("Extra Research");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JCheckBox iNews = new JCheckBox("In News");
        panel.add(iNews);
        JCheckBox nPub = new JCheckBox("Negative Publicity");
        panel.add(nPub);
        JCheckBox pPub = new JCheckBox("Positive Publicity");
        panel.add(pPub);
        frame.add(panel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
    
    public Company(double stockPrice, double previousClose, boolean inNews, boolean negPublicity, boolean posPublicity, boolean directCompetition, boolean tappedMarket, String name)
    {
        this.stockPrice = stockPrice;
        this.previousClose = previousClose;
        this.inNews = inNews;
        this.negPublicity = negPublicity;
        this.posPublicity = posPublicity;
        this.directCompetition = directCompetition;
        this.tappedMarket = tappedMarket;
        this.name = name;
        setprojStockPrice();
    }

    @Override
    public int compareTo(Company thing)
    {
        int toRet = 0;
        toRet = (int)(thing.getchange() - change);
        if(posPublicity && !thing.getposPublicity())
        {
            toRet--;
        }
        if(negPublicity && !thing.getnegPublicity())
        {
            toRet++;
        }
        if(tappedMarket && !thing.gettappedMarket())
        {
            toRet += 2;
        }
        if(toRet == 0 && !getname().equals(thing.getname()))
        {
            return(-1);
        }
        return(toRet);
    }

    public double getstockPrice()
    {
        return(stockPrice);
    }

    public void setstockPrice(double stockPrice)
    {
        this.stockPrice = stockPrice;
        setprojStockPrice();
    }

    public double getpreviousClose()
    {
        return(previousClose);
    }

    public void setpreviousClose(double previousClose)
    {
        this.previousClose = previousClose;
        setprojStockPrice();
    }

    public double getprojStockPrice()
    {
        return(projStockPrice);
    }

    public void setprojStockPrice()
    {
        double toRet = (stockPrice - previousClose) + stockPrice;
        boolean other = false;
        if(inNews)
        {
            if(negPublicity)
            {
                toRet -= stockPrice*.2;
            }
            else if(posPublicity)
            {
                toRet += stockPrice*.2;
            }
            else
            {
                toRet += stockPrice*.1;
            }
            other = true;
        } else if(stockPrice - previousClose < 0)
        {
            toRet = ((stockPrice - previousClose) * .5) + stockPrice;
        }

        if(directCompetition && !other)
        {
            toRet = toRet * .8;
        }

        if(tappedMarket && !other)
        {
            toRet = toRet * .6;
        }
        projStockPrice = toRet;
        setchange();
    }

    public boolean getinNews()
    {
        return(inNews);
    }

    public void setinNews(boolean inNews)
    {
        this.inNews = inNews;
        setprojStockPrice();
    }

    public boolean getnegPublicity()
    {
        return(negPublicity);
    }

    public void setnegPublicity(boolean negPublicity)
    {
        this.negPublicity = negPublicity;
        setprojStockPrice();
    }

    public boolean getposPublicity()
    {
        return(posPublicity);
    }

    public void setposPublicity(boolean posPublicity)
    {
        this.posPublicity = posPublicity;
        setprojStockPrice();
    }

    public boolean getdirectCompetition()
    {
        return(directCompetition);
    }

    public void setdirectCompetition(boolean directCompetition)
    {
        this.directCompetition = directCompetition;
        setprojStockPrice();
    }

    public boolean gettappedMarket()
    {
        return(tappedMarket);
    }

    public void settappedMarket(boolean tappedMarket)
    {
        this.tappedMarket = tappedMarket;
        setprojStockPrice();
    }

    public String getname()
    {
        return(name);
    }
    
    public double getchange()
    {
        return(change);
    }
    
    public void setchange()
    {
        change = projStockPrice - stockPrice;
    }
    
    @Override
    public String toString()
    {
        return(name + " has a current stock price of $" + stockPrice + " and has a projected stock price of $" + projStockPrice + ".");
    }
    public static void main(String args[])
    {
        
    }
}
