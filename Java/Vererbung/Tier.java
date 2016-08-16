
/**
 * Dies ist die Wurzelklasse Tier. Sie stellt Datenfelder zur verfuegung, die auf alle Tiere zutreffen. Zugehoerig 
 * auch die entsprechenden gib und setze Methoden. 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Tier
{
    /**
     * hier stehen die Datenfelder fuer die klasse Tier und deren kindklassen
     */
    private String name;
    private String gattung;
    private int lebenserwartung;
    private String geburtsart;
    private String haltung;
    private String futter;
    private String nutzen;
    
    /**
     * Konstruktor zum initialisieren der Datenfelder bei Erstellung eines Objekts
     * Der Konstruktor wird auch von den Kindklassen verwendet.
     */
    public Tier(String name, String gattung, int lebenserwartung, String geburtsart, String haltung, String futter, String nutzen)
    {
        this.name=name;
        this.gattung=gattung;
        this.lebenserwartung=lebenserwartung;
        this.geburtsart=geburtsart;
        this.haltung=haltung;
        this.futter=futter;
        this.nutzen=nutzen;
    }
    
    /**
     * im folgenden kommen die gib- und setzemethoden fuer die verschiedenen datenfelder
     */
    public void setzeName(String neuername)
    {
        name=neuername;
    }
    
    public void setzeGattung(String neueGattung)
    {
        gattung=neueGattung;
    }
    
    public void setzeLebenserwartung(int neuesLeben)
    {
        lebenserwartung=neuesLeben;
    }
    public void setzeGeburtsart(String geburt)
    {
        geburtsart=geburt;
    }
    public void setzeFutter(String neuesFutter)
    {
        futter=neuesFutter;
    }
    public void setzeNutzen(String neuerNutzen)
    {
        nutzen=neuerNutzen;
    }
    
    public String gibName()
    {
        return name;
    }
    public String gibGattung()
    {
        return gattung;
    }
    public int gibLeben()
    {
        return lebenserwartung;
    }
    public String gibGeburt()
    {
        return geburtsart;
    }
    public String gibFutter()
    {
        return futter;
    }
    public String gibNutzen()
    {
        return nutzen;
    }
    
    
    public void ausgeben()
    {
        System.out.println("Name: "+name);
        System.out.println("Gattung: "+gattung);
        System.out.println("Lebenserwartung: "+lebenserwartung);
        System.out.println("Geburtsart: "+geburtsart);
        System.out.println("Haltung: "+haltung);
        System.out.println("Futter: "+futter);
        System.out.println("Nutzen: "+nutzen);
    }
    
     public abstract void bewegen();
    
    public abstract void lautGeben();
   
    
    
}
