
public class OwnedCompany extends Company implements Comparable<Company>
{
    public OwnedCompany(double stockPrice, double previousClose, boolean inNews, boolean negPublicity, boolean posPublicity, boolean directCompetion, boolean tappedMarket, String name)
    {
        super(stockPrice, previousClose, inNews, negPublicity, posPublicity, directCompetion, tappedMarket, name);
    }
    
    @Override
    public int compareTo(Company thing)
    {
        int toRet = 0;
        toRet = (int)(getchange() - thing.getchange());
        if(getposPublicity() && !thing.getposPublicity())
        {
            toRet++;
        }
        if(getnegPublicity() && !thing.getnegPublicity())
        {
            toRet--;
        }
        if(gettappedMarket() && !thing.gettappedMarket())
        {
            toRet -= 2;
        }
        if(toRet == 0 && !getname().equals(thing.getname()))
        {
            return(-1);
        }
        return(toRet);
    }
    
    @Override
    public String toString()
    {
        return(getname() + " is owned and has an expected change in price of $" + getchange());
    }
}
