
/**
 * Dies ist die Klasse Koi. Sie enthaelt alle Datenfelder, gib und setze Methoden, 
 * die speziell auf Kois zutrifft. Sie erweitert die Klasse Fische.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Koi extends Fische
{
     /**
     * Dies sind die Datenfelder fuer die Klasse Koi.
     */
    private int laenge;
    private int wert;
    
    /**
     * Der Konstruktor der Klasse Koi initialisiert alle Datenfelder. Teilweise gibt 
     * er die Informationen an die Elternklasse weiter mit dem Superbefehl. 
     */
    public Koi(String name, String gattung, int lebenserwartung, String geburtsart, String haltung, String futter, String nutzen, int flossenzahl, int schwarmgroesse, String schuppenart, String schuppenfarbe, int laenge, int wert)
    {
        super(name, gattung, lebenserwartung, geburtsart, haltung, futter, nutzen, flossenzahl, schwarmgroesse, schuppenart, schuppenfarbe);
        this.laenge=laenge;
        this.wert=wert;
    }
    /**
     * Hier stehen die gib und setze Methoden fuer die in dieser Klasse befindlichen Datenfelder.
     */
    public void setzeLaenge(int laenge)
    {
        this.laenge=laenge;
    }
    public void setzeWert(int wert)
    {
        this.wert=wert;
    }
    
    
    public int gibLaenge()
    {
        return laenge;
    }
    public int gibWert()
    {
        return wert;
    }
    
    /**
     * Beschreibt das Verhalten der Fortbewegung des Kois ueber eine Konsolenausgabe.
     */
    public void schwimmen()
    {
        System.out.println("Dieser Koi schwimmt froehlich im Becken herum.");
    }
    
    /**
     * Beschreibt die Freizeitbeschaeftigung des Kois ueber eine Konsolenausgabe.
     */
    public void blubbern()
    {
        System.out.println("Der Koi macht kleine Blasen. Sieht voll putzig aus!");
    }
    /**
     * Beschreibt das Schicksal, dass uns alle irgendwann mal ereilen wird ueber eine Konsolenausgabe.
     */
    public void sterben()
    {
        System.out.println("Ups... der ist in den Koihimmel aufgefahren... War wohl ueberzuechtet...");
    }
    /**
     * Beschreibt, dass der Koi verkauft wird ueber eine Konsolenausgabe.
     */
    public void verkauftWerden()
    {
        System.out.println("Das Ding wird jetzt verscherbelt. An nen Sammler. Der hat dann was davon.");
    }
    public void bewegen()
    {
        System.out.println("*Schwimm*");
    }
    public void lautGeben()
    {
        System.out.println("*blubb*");
    }
    
    
    
    public void ausgeben()
    {
        super.ausgeben();
        System.out.println("Wert " + wert);
        System.out.println("Laenge "+ laenge);
    }
}
