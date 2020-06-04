import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.io.IOException; 
import java.util.StringTokenizer; 
import java.util.Arrays; 
class Solution6
{
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader()
        {
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next()
        {
            while(st==null||!st.hasMoreElements())
            {
                try{
                    st=new StringTokenizer(br.readLine());
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt()
        {
            return Integer.parseInt(next());
        }
        double nextDouble()
        {
            return Double.parseDouble(next());
        }

    }
    public static void main(String args[])
    {
        FastReader fs= new FastReader();
        Simm sim[]= new Simm[5];
        for (int i=0;i<5;i++)
        {
            sim[i]=new Simm(fs.nextInt(), fs.next(), fs.nextDouble(), fs.nextDouble(), fs.next());
        }
        String circle1=fs.next();
        String circle2=fs.next();
        Simm arr[]= transferCircle(sim,circle1,circle2);
        for(int i=0;i<arr.length;i++)
        {
    System.out.println(arr[i].getId()+" "+arr[i].getCustomerName()+" "+arr[i].getCircle()+" "+arr[i].getRatePerSecond());
        }

    }

    public static Simm[] transferCircle(Simm[] sim, String circle1, String circle2) {
        Simm newarr[]=new Simm[0];
        for(int i=0;i<sim.length;i++)
        {
            if(sim[i].getCircle().equalsIgnoreCase(circle1))
            {
                newarr=Arrays.copyOf(newarr, newarr.length+1);
                newarr[newarr.length-1]=sim[i];
                newarr[newarr.length-1].setCircle(circle2);
            }
        }
        for(int i=0;i<newarr.length-1;i++)
        {
        for(int j=0;j<newarr.length-i-1;j++)
        { if(newarr[j].getRatePerSecond()<newarr[j+1].getRatePerSecond())
            {
            Simm temp=newarr[j];
            newarr[j]=newarr[j+1];
            newarr[j+1]=temp;
        }
      }
    }
    return newarr;
}
}
class Simm
{
    int simid;
    String customerName;
    double balance;
    double ratePerSecond;
    String circle;
    public int getId()
    {
        return this.simid;
    }
    public String getCustomerName()
    {
        return this.customerName;
    }
    public double getBalance()
    {
        return this.balance;
    }
    public double getRatePerSecond()
    {
        return this.ratePerSecond;
    }
    public String getCircle()
    {
        return this.circle;
    }
    public void setId(int simid)
    {
        this.simid=simid;
    }
    public void setCompany(String customerName)
    {
        this.customerName=customerName;
    }
    public void setBalance(double balance)
    {
        this.balance=balance;
    }
    public void setRatePerSecond(double ratePerSecond)
    {
        this.ratePerSecond=ratePerSecond;
    }
    public void setCircle(String circle)
    {
    this.circle=circle;
    } 
    public Simm(int simid, String customerName, double balance, double ratePerSecond, String circle)
    {
        this.simid=simid;
        this.customerName=customerName;
        this.balance=balance;
        this.ratePerSecond=ratePerSecond;
        this.circle=circle;
    }
}