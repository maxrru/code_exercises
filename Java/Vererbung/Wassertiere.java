
/**
 * Dies ist die Klasse Wassertiere. Sie enthaelt alle Datenfelder, gib und setze Methoden, 
 * die speziell auf die im Wasser lebenden Tiere zutrifft. Sie erweitert die Klasse Tier.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Wassertiere extends Tier
{
   /**
   * Dies sind die Datenfelder fuer die Klasse Wassertiere. 
   */
   private int flossenzahl;
   private int schwarmgroesse;
   
   /**
     * Der Konstruktor der Klasse Wassertiere initialisiert alle Datenfelder. Teilweise gibt 
     * er die Informationen an die Elternklasse weiter mit dem Superbefehl. Der Konstruktor wird auch 
     * von den Kindklassen verwendet. 
     */
   public Wassertiere(String name, String gattung, int lebenserwartung, String geburtsart, String haltung, String futter, String nutzen, int flossenzahl, int schwarmgroesse)
   {
       super(name, gattung, lebenserwartung, geburtsart, haltung, futter, nutzen);
       this.flossenzahl=flossenzahl;
       this.schwarmgroesse=schwarmgroesse;
    }
    /**
     * Hier stehen die gib und setze Methoden fuer die in dieser Klasse befindlichen Datenfelder.
     */
    public void setzeFlosse(int flossenzahl)
    {
        this.flossenzahl=flossenzahl;
    }
    public void setzeSchwarm(int schwarmgroesse)
    {
        this.schwarmgroesse=schwarmgroesse;
    }
    public int gibFlosse()
    {
        return flossenzahl;
    }
    public int gibSchwarm()
    {
        return schwarmgroesse;
    }
    
    public void ausgeben()
    {
        super.ausgeben();
        System.out.println("Flossenzahl: " +flossenzahl);
        System.out.println("Schwarmgroesse: "+schwarmgroesse);
    }
    
    
    
    
}
