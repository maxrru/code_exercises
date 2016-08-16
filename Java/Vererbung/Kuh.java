
/**
 * Dies ist die Klasse Kuh. Sie enthaelt alle Datenfelder, gib und setze Methoden, 
 * die speziell auf Kuehe zutrifft. Sie erweitert die Klasse Saeugetiere.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kuh extends Saeugetiere
{
     /**
     * Dies sind die Datenfelder fuer die Klasse Kuh.
     */
    private int milchproduktion;
    private int fleischmenge;
    private int flecken;
   
     /**
     * Der Konstruktor der Klasse Kuh initialisiert alle Datenfelder. Teilweise gibt 
     * er die Informationen an die Elternklasse weiter mit dem Superbefehl. 
     */
    public Kuh(String name, String gattung, int lebenserwartung, String geburtsart, String haltung, String futter, String nutzen, int beinanzahl, int herdengroesse, String stallplatz, int tragdauer, String fellart, String fellfarbe, String hufart, int milchproduktion, int fleischmenge, int flecken)
    {
        super(name, gattung, lebenserwartung, geburtsart, haltung, futter, nutzen, beinanzahl, herdengroesse, stallplatz, tragdauer, fellart, fellfarbe, hufart);
        this.milchproduktion=milchproduktion;
        this.fleischmenge=fleischmenge;
        this.flecken=flecken;
    }
    /**
     * Hier stehen die gib und setze Methoden fuer die in dieser Klasse befindlichen Datenfelder.
     */
    public void setzeMilch(int milchproduktion)
    {
        this.milchproduktion=milchproduktion;
    }
    public void setzeFleisch(int fleischmenge)
    {
        this.fleischmenge=fleischmenge;
    }
    public void setzeFlecken(int flecken)
    {
        this.flecken=flecken;
    }
    
    public int gibMilch()
    {
        return milchproduktion;
    }
    public int gibFleisch()
    {
        return fleischmenge;
    }
    public int gibFlecken()
    {
        return flecken;
    }
    /**
     * Beschreibt Laute der Kuh ueber eine Konsolenausgabe.
     */
    public void lautGeben()
    {
        System.out.println("Die Kuh muht sehr laut.");
    }
    /**
     * Beschreibt die Nahrungsaufnahme der Kuh ueber eine Konsolenausgabe.
     */
    public void grasen()
    {
        System.out.println("Das Vieh spielt Rasenmaeher.");
    }
   /**
    * Beschreibt die Abgabe von Milch ueber eine Konsolenausgabe.
    */
    public void milchGeben()
    {
        System.out.println("Die Kuh wird abgezapft.");
    }
   /**
    * Beschreibt, was die Kuh ausser Milch geben noch kann in einer Konsolenausgabe.
    */
    public void geschlachtetWerden()
    {
        System.out.println("Lecker fleisch.");
    }
    
    public void bewegen()
    {
        System.out.println("*beweg*");
    }
    
    public void ausgeben()
    {
        super.ausgeben();
        System.out.println("milchproduktion: "+milchproduktion);
        System.out.println("fleischmenge: "+fleischmenge);
        System.out.println("flecken: " +flecken);
        
    }
    
    
    
}
