
public class Company implements Comparable<Company>
{
    private double stockPrice;
    private double yestStockPrice;
    private double projStockPrice;
    private boolean inNews;
    private boolean negPublicity;
    private boolean posPublicity;
    private boolean directCompetion;
    private boolean tappedMarket;
    private final String name;
    private double change;

    public Company(double stockPrice, double yestStockPrice, boolean inNews, boolean negPublicity, boolean posPublicity, boolean directCompetion, boolean tappedMarket, String name)
    {
        this.stockPrice = stockPrice;
        this.yestStockPrice = yestStockPrice;
        this.inNews = inNews;
        this.negPublicity = negPublicity;
        this.posPublicity = posPublicity;
        this.directCompetion = directCompetion;
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

    public double getyestStockPrice()
    {
        return(yestStockPrice);
    }

    public void setyestStockPrice(double yestStockPrice)
    {
        this.yestStockPrice = yestStockPrice;
        setprojStockPrice();
    }

    public double getprojStockPrice()
    {
        return(projStockPrice);
    }

    public void setprojStockPrice()
    {
        double toRet = (stockPrice - yestStockPrice) + stockPrice;
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
        } else if(stockPrice - yestStockPrice < 0)
        {
            toRet = ((stockPrice - yestStockPrice) * .5) + stockPrice;
        }

        if(directCompetion && !other)
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

    public boolean getdirectCompetion()
    {
        return(directCompetion);
    }

    public void setdirectCompetion(boolean directCompetition)
    {
        this.directCompetion = directCompetion;
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
}
