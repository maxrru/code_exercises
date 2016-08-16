
/**
 * Dies ist die Klasse Saeugetiere. Sie enthaelt alle Datenfelder, gib und setze Methoden, 
 * die speziell auf die Saeugetiere zutrifft. Sie erweitert die Klasse Landtiere.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Saeugetiere extends Landtiere
{
   /**
   * Dies sind die Datenfelder fuer die Klasse Saeugetiere. 
   */
    private int tragdauer;
    private String fellart;
    private String fellfarbe;
    private String hufart;
    
    /**
     * Der Konstruktor der Klasse Saeugetiere initialisiert alle Datenfelder. Teilweise gibt 
     * er die Informationen an die Elternklasse weiter mit dem Superbefehl. Der Konstruktor wird auch 
     * von den Kindklassen verwendet. 
     */
    public Saeugetiere(String name, String gattung, int lebenserwartung, String geburtsart, String haltung, String futter, String nutzen, int beinanzahl, int herdengroesse, String stallplatz, int tragdauer, String fellart, String fellfarbe, String hufart)
    {
        super(name, gattung, lebenserwartung, geburtsart, haltung, futter, nutzen, beinanzahl, herdengroesse, stallplatz);
        this.tragdauer=tragdauer;
        this.fellart=fellart;
        this.fellfarbe=fellfarbe;
        this.hufart=hufart;
    }
     /**
     * Hier stehen die gib und setze Methoden fuer die in dieser Klasse befindlichen Datenfelder.
     */
    public void setzeTragdauer(int tragdauer)
    {
        this.tragdauer=tragdauer;
    }
    public void setzeFellart(String fellart)
    {
        this.fellart=fellart;
    }
    public void setzeFellfarbe(String fellfarbe)
    {
        this.fellfarbe=fellfarbe;
    }
    public void setzeHufart(String hufart)
    {
        this.hufart=hufart;
    }
    
    public int gibTragedauer()
    {
        return tragdauer;
    }
    public String gibFellart()
    {
        return fellart;
    }
    public String gibFellfarbe()
    {
        return fellfarbe;
    }
    public String gibHufart()
    {
        return hufart;
    }
    
    public void ausgeben()
    {
        super.ausgeben();
        System.out.println("Tragdauer: "+tragdauer);
        System.out.println("Fellfarbe: "+fellfarbe);
        System.out.println("Fellart: "+fellart);
        System.out.println("Hufart: "+hufart);
    }
        
}
