
/** 
 * Dies ist die Klasse Fische. Sie enthaelt alle Datenfelder, gib und setze Methoden, 
 * die speziell auf Fische zutrifft. Sie erweitert die Klasse Wassertiere.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Fische extends Wassertiere
{
    /**
     * Dies sind die Datenfelder fuer die Klasse FIsche.
     */
    private String schuppenart;
    private String schuppenfarbe;
    
     /**
     * Der Konstruktor der Klasse Fische initialisiert alle Datenfelder. Teilweise gibt 
     * er die Informationen an die Elternklasse weiter mit dem Superbefehl. Der Konstruktor wird auch 
     * von den Kindklassen verwendet. 
     */
    public Fische(String name, String gattung, int lebenserwartung, String geburtsart, String haltung, String futter, String nutzen, int flossenzahl, int schwarmgroesse, String schuppenart, String schuppenfarbe)
    {
         super(name, gattung, lebenserwartung, geburtsart, haltung, futter, nutzen, flossenzahl, schwarmgroesse);
         this.schuppenart=schuppenart;
         this.schuppenfarbe=schuppenfarbe;
    }
    /**
     * Hier stehen die gib und setze Methoden fuer die in dieser Klasse befindlichen Datenfelder.
     */
    public void setzeSchuppenart(String schuppenart)
    {
        this.schuppenart=schuppenart;
    }
    public void setzeSchuppenfarbe(String schuppenfarbe)
    {
        this.schuppenfarbe=schuppenfarbe;
    }
    
    public String gibSchuppenart()
    {
        return schuppenart;
    }
    public String gibSchuppenfarbe()
    {
        return schuppenfarbe;
    }
    public void ausgeben()
    {
        super.ausgeben();
        System.out.println("Schuppenart: "+schuppenart);
        System.out.println("Schuppenfarbe: "+schuppenfarbe);
    }
        
}
