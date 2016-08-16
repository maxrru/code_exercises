
/**
 * Dies ist die Klasse Gans Sie enthaelt alle Datenfelder, gib und setze Methoden, 
 * die speziell auf Gaense zutrifft. Sie erweitert die Klasse Voegel.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gans extends Voegel implements Haustier
{
    /**
     * Dies ist das Datenfeld fuer die Klasse Gans.
     */
    private int fleisch;
    private int gebjahr;
     /**
     * Der Konstruktor der Klasse Gans initialisiert alle Datenfelder. Teilweise gibt 
     * er die Informationen an die Elternklasse weiter mit dem Superbefehl. 
     */
    public Gans(String name, String gattung, int lebenserwartung, String geburtsart, String haltung, String futter, String nutzen, int beinanzahl, int herdengroesse, String stallplatz, String eiergroesse, String eierfarbe, int brutdauer, String gefiederfarbe, int fleisch, int gebjahr)
    {
        super(name, gattung, lebenserwartung, geburtsart, haltung, futter, nutzen, beinanzahl, herdengroesse, stallplatz, eiergroesse, eierfarbe, brutdauer, gefiederfarbe);
        this.fleisch=fleisch;
        this.gebjahr=gebjahr;
    }
    /**
     * Hier stehen die gib und setze Methoden fuer die in dieser Klasse befindlichen Datenfelder.
     */
    public void setzeFleisch(int fleisch)
    {
        this.fleisch=fleisch;
    }
    
    public int gibFleisch()
    {
        return fleisch;
    }
    
    public int gibGebJahr()
    {
        return gebjahr;
    }
    
    
    
    
    
    /**
     * In den folgenden Methoden wird das Verhalten des Tieres mithilfe einer Konsolenausgabe beschrieben.
     */
    public void bewegen()
    {
        System.out.println("Die Gans watschelt froehlich!");
    }
    
    public void lautGeben()
    {
        System.out.println("Die Gans quietscht vergnuegt =)");
    }
    
    public void geschlachtetWerden()
    {
        System.out.println("Nun hat es sich ausgequietscht. Die Gans wird jetzt Teil des Wirtschaftskreislaufs.");
    }
    
    public void ausgeben()
    {
        super.ausgeben();
        System.out.println("Fleisch: "+fleisch);
    }
    
}
