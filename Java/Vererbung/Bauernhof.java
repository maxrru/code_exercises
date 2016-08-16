import java.util.ArrayList;
import java.util.Iterator;
/**
 * Write a description of class Bauernhof here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bauernhof
{
   private ArrayList<Tier> tierbestand;
   private Tier einzelstall;
  
   
   public Bauernhof()
   {
       tierbestand = new ArrayList<Tier>();
       einzelstall=null;
    }
    
    public void tierHinzufuegen(Tier tier)
    {
        tierbestand.add(tier);
    }
   
    public void alleTiereAusgeben()
    {
       for(Tier tier : tierbestand)
       {
           tier.ausgeben();
        }
        
    }
    
   public void tierBewegen(Tier tier)
   {
       tier.bewegen();
    }
    
   public void tierLaut(Tier tier)
   {
       tier.lautGeben();
    }
    
    
    
    
    public void tierInQuarantaene(String name)
    {
        Iterator<Tier> it= tierbestand.iterator();
        while(it.hasNext())
        {
           Tier dasTier = it.next();
           if(dasTier.gibName()==name)
           {
               einzelstall=dasTier;
               it.remove();
            }
        }
    
    }
    
    public void tierInHerde()
    {
        if(einzelstall!=null)
        {
            tierbestand.add(einzelstall);
            einzelstall = null;
        }
        else
        {
            System.out.println("Der Einzelstall ist leer!!");
        }
    }

    
    
    
    
    public void bewegenQuarantaene()
    {
        if(einzelstall!=null)
        {
            einzelstall.bewegen();
        }
        else
        {
            System.out.println("Der Einzelstall ist leer!!");
        }
       
    }
   
    
    
    public void lautGebenQuarantaene()
    {
        if(einzelstall!=null)
        {
            einzelstall.lautGeben();
        }
        else
        {
            System.out.println("Der Einzelstall ist leer!!");
        }
        
    }
    
    
    
    
    

}
