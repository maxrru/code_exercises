
/**
 * Dies ist die Klasse Henne. Sie enthaelt alle Datenfelder, gib und setze Methoden, 
 * die speziell auf Hennen zutrifft. Sie erweitert die Klasse Voegel.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Henne extends Voegel
{
    /**
     * Dies ist das Datenfeld fuer die Klasse Henne.
     */
    private int eierprotag;
     /**
     * Der Konstruktor der Klasse Henne initialisiert alle Datenfelder. Teilweise gibt 
     * er die Informationen an die Elternklasse weiter mit dem Superbefehl. 
     */
    public Henne(String name, String gattung, int lebenserwartung, String geburtsart, String haltung, String futter, String nutzen, int beinanzahl, int herdengroesse, String stallplatz, String eiergroesse, String eierfarbe, int brutdauer, String gefiederfarbe, int eierprotag)
    {
        super(name, gattung, lebenserwartung, geburtsart, haltung, futter, nutzen, beinanzahl, herdengroesse, stallplatz, eiergroesse, eierfarbe, brutdauer, gefiederfarbe);
        this.eierprotag=eierprotag;
    }
    /**
     * Hier stehen die gib und setze Methoden fuer die in dieser Klasse befindlichen Datenfelder.
     */
    public void setzeEier(int eierprotag)
    {
        this.eierprotag=eierprotag;
    }
    public int gibEier()
    {
        return eierprotag;
    }
    /**
     * In den folgenden Methoden wird das Verhalten des Tieres mithilfe einer Konsolenausgabe beschrieben.
     */
    public void lautGeben()
    {
        System.out.println("Die Henne gurrt.");
    }
    public void eiLegen()
    {
        System.out.println("Das Huhn legt ein Ei.");
    }
    public void kornFinden()
    {
        System.out.println("Huch, da hat das Huhn ein korn gefunden!");
    }
    public void erblinden()
    {
        System.out.println("Ploetzlich ist das Huhn erblindet, wie konnte das passieren?");
    }
    public void bewegen()
    {
        System.out.println("Das Huhn stolziert umher.");
    }
    public void ausgeben()
    {
        super.ausgeben();
        System.out.println("Eier pro Tag: "+eierprotag);
    }
}
