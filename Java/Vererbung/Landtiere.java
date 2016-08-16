
/**
 * Dies ist die Klasse Landtiere. Sie enthaelt alle Datenfelder, gib und setze Methoden, 
 * die speziell auf die an Land lebenden Tiere zutrifft. Sie erweitert die Klasse Tier.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Landtiere extends Tier
{
    /**
     * Dies sind die Datenfelder fuer die Klasse Landtiere. 
     */
    private int beinanzahl;
    private int herdengroesse;
    private String stallplatz;
    /**
     * Der Konstruktor der Klasse Landtiere initialisiert alle Datenfelder. Teilweise gibt 
     * er die Informationen an die Elternklasse weiter mit dem Superbefehl. Der Konstruktor wird auch 
     * von den Kindklassen verwendet. 
     */
    public Landtiere(String name, String gattung, int lebenserwartung, String geburtsart, String haltung, String futter, String nutzen, int beinanzahl, int herdengroesse, String stallplatz)
    {
         super(name, gattung, lebenserwartung, geburtsart, haltung, futter, nutzen);
         this.beinanzahl=beinanzahl;
         this.herdengroesse=herdengroesse;
         this.stallplatz=stallplatz;
    }
    /**
     * Hier stehen die gib und setze Methoden fuer die in dieser Klasse befindlichen Datenfelder.
     */
    public void setzeBeine(int beinanzahl)
    {
        this.beinanzahl=beinanzahl;
    }
    public void setzeHerde(int herdengroesse)
    {
        this.herdengroesse=herdengroesse;
    }
    public void setzeStall(String stallplatz)
    {
        this.stallplatz=stallplatz;
    }
    
    public int gibBeine()
    {
        return beinanzahl;
    }
    public int gibHerde()
    {
        return herdengroesse;
    }
    public String gibStall()
    {
        return stallplatz;
    }
    public void ausgeben()
    {
        super.ausgeben();
        System.out.println("Beinanzahl: "+beinanzahl);
        System.out.println("Herdengroesse: "+herdengroesse);
        System.out.println("Stallplatz: "+stallplatz);
    }
    
    
    
    
    
}
