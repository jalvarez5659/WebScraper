import java.util.*;

public class StockQueue
{
    private PriorityQueue<Company> sQueue;
    private PriorityQueue<OwnedCompany> oQueue;

    StockQueue()
    {
        sQueue = new PriorityQueue<Company>();
        oQueue = new PriorityQueue<OwnedCompany>();
    }

    public void addComp(Company toAdd)
    {
        sQueue.add(toAdd);
        System.out.println(toAdd.getname() + " has been added to the list of stocks that can be bought. " + toAdd);
    }

    public void buy()
    {
        if(sQueue.peek() == null)
        {
            System.out.println("There are no stocks to buy.");
            return;
        }
        Company thing = sQueue.poll();
        OwnedCompany other = new OwnedCompany(thing.getstockPrice(), thing.getpreviousClose(), thing.getinNews(), thing.getnegPublicity(), thing.getposPublicity(), thing.getdirectCompetition(), thing.gettappedMarket(), thing.getname());
        oQueue.add(other);
        System.out.println(thing.getname() + " has been bought. " + thing);
    }

    public void optimalBuy()
    {
        if(sQueue.peek() == null)
        {
            System.out.println("There are no stocks to buy.");
            return;
        }
        System.out.println(sQueue.peek().getname() + " is the most optimal option to invest in. " + sQueue.peek());
    }

    public void sell()
    {
        if(oQueue.peek() == null)
        {
            System.out.println("There are no stocks to sell.");
            return;
        }
        OwnedCompany thing = oQueue.poll();
        Company other = new Company(thing.getstockPrice(), thing.getpreviousClose(), thing.getinNews(), thing.getnegPublicity(), thing.getposPublicity(), thing.getdirectCompetition(), thing.gettappedMarket(), thing.getname());
        sQueue.add(other);
        System.out.println(thing.getname() + " has been sold. " + thing);
    }

    public void optimalSell()
    {
        if(oQueue.peek() == null)
        {
            System.out.println("There are no stocks to sell.");
            return;
        }
        System.out.println(oQueue.peek().getname() + " is the most optimal option to sell of the stocks that are owned. " + sQueue.peek());
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        if(sQueue.peek() == null)
        {
            sb.append("There are no stocks available for purchase." + "\n");
        }
        else
        {
            sb.append(sQueue.toString() + "\n");
        }
        if(oQueue.peek() == null)
        {
            sb.append("No stocks are owned.");
        }
        else
        {
            sb.append(oQueue.toString());
        }
        return(sb.toString());
    }

    public static void main()
    {
        StockQueue thing = new StockQueue();
        Company a = new Company(5.00, 3.00, false, false, false, false, false, "Alphabet");
        Company b = new Company(5.00, 3.00, false, false, false, false, false, "Apple");
        Company c = new Company(5.00, 3.00, true, false, false, false, false, "Facebook");
        Company d = new Company(5.00, 3.00, true, true, false, false, false, "Samsung");
        Company e = new Company(5.00, 3.00, true, false, true, false, false, "Oculus");
        Company f = new Company(5.00, 3.00, false, false, false, true, true, "HTC");
        thing.addComp(a);
        thing.addComp(b);
        System.out.println(thing);
        thing.optimalBuy();
        thing.buy();
        thing.buy();
        thing.buy();
        System.out.println(thing);
        thing.optimalSell();
        thing.sell();
        thing.sell();
        thing.sell();
        thing.addComp(c);
        System.out.println(thing);
        thing.buy();
        thing.sell();
        thing.addComp(d);
        System.out.println(thing);
        thing.buy();
        thing.sell();
        thing.addComp(e);
        System.out.println(thing);
        thing.buy();
        thing.sell();
        thing.addComp(f);
        System.out.println(thing);
        thing.buy();
        thing.sell();
    }
}
