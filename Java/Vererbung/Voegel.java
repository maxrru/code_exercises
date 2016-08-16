
/**
 * Dies ist die Klasse Voegel. Sie enthaelt alle Datenfelder, gib und setze Methoden, 
 * die speziell auf Voegel zutrifft. Sie erweitert die Klasse Landtiere.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Voegel extends Landtiere
{
    /**
     * Dies sind die Datenfelder fuer die Klasse Voegel.
     */
    private String eiergroesse;
    private String eierfarbe;
    private int brutdauer;
    private String gefiederfarbe;
    
    /**
     * Der Konstruktor der Klasse Voegel initialisiert alle Datenfelder. Teilweise gibt 
     * er die Informationen an die Elternklasse weiter mit dem Superbefehl. Der Konstruktor wird auch 
     * von den Kindklassen verwendet. 
     */
    public Voegel(String name, String gattung, int lebenserwartung, String geburtsart, String haltung, String futter, String nutzen, int beinanzahl, int herdengroesse, String stallplatz, String eiergroesse, String eierfarbe, int brutdauer, String gefiederfarbe)
    {
        super(name, gattung, lebenserwartung, geburtsart, haltung, futter, nutzen, beinanzahl, herdengroesse, stallplatz);
        this.eiergroesse=eiergroesse;
        this.eierfarbe=eierfarbe;
        this.brutdauer=brutdauer;
        this.gefiederfarbe=gefiederfarbe;
    }
    /**
     * Hier stehen die gib und setze Methoden fuer die in dieser Klasse befindlichen Datenfelder.
     */
    public void setzeEiergroesse(String eiergroesse)
    {
        this.eiergroesse=eiergroesse;
    }
    public void setzeEierfarbe(String eierfarbe)
    {
        this.eierfarbe=eierfarbe;
    }
    public void setzeBrutdauer(int brutdauer)
    {
        this.brutdauer=brutdauer;
    }
    public void setzeGefieder(String gefiederfarbe)
    {
        this.gefiederfarbe=gefiederfarbe;
    }
    public String gibEiergroesse()
    {
        return eiergroesse;
    }
    public String gibEierfarbe()
    {
        return eierfarbe;
    }
    public int gibBrutdauer()
    {
        return brutdauer;
    }
    public String gibGefieder()
    {
        return gefiederfarbe;
    }
    public void ausgeben()
    {
        super.ausgeben();
        System.out.println("Eiergroesse: "+eiergroesse);
        System.out.println("Eierfarbe: "+eierfarbe);
        System.out.println("Gefiederfarbe: "+gefiederfarbe);
        System.out.println("Brutdauer: "+brutdauer);
        
    }
    
    
}
