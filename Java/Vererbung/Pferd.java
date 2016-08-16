
/**
 * Dies ist die Klasse Pferd. Sie enthaelt alle Datenfelder, gib und setze Methoden, 
 * die speziell auf Pferde zutrifft. Sie erweitert die Klasse Saeugetiere.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pferd extends Saeugetiere
{   
    /**
     * Dies sind die Datenfelder fuer die Klasse Pferd.
     */
    private int traglast;
    private int geschirrNr;
    
    /**
     * Der Konstruktor der Klasse Pferd initialisiert alle Datenfelder. Teilweise gibt 
     * er die Informationen an die Elternklasse weiter mit dem Superbefehl. 
     */
    public Pferd(String name, String gattung, int lebenserwartung, String geburtsart, String haltung, String futter, String nutzen, int beinanzahl, int herdengroesse, String stallplatz, int tragdauer, String fellart, String fellfarbe, String hufart, int traglast, int geschirrNr)
    {
        super(name, gattung, lebenserwartung, geburtsart, haltung, futter, nutzen, beinanzahl, herdengroesse, stallplatz, tragdauer, fellart, fellfarbe, hufart);
        this.traglast=traglast;
        this.geschirrNr=geschirrNr;
    }
     /**
     * Hier stehen die gib und setze Methoden fuer die in dieser Klasse befindlichen Datenfelder.
     */
    public void setzeTraglast(int traglast)
    {
        this.traglast=traglast;
    }
    public void setzeGeschirrNr(int geschirrNr)
    {
        this.geschirrNr=geschirrNr;
    }
    
    public int gibTraglast()
    {
        return traglast;
    }
    
    public int gibGeschirrNr()
    {
        return geschirrNr;
    }
    
    /**
     * In den folgenden Methoden wird das Verhalten des Tieres mithilfe einer Konsolenausgabe beschrieben.
     */
    public void lautGeben()
    {
        System.out.println("Das Pferd wiehert.");
    }
    public void traben()
    {
        System.out.println("Das Pferd faellt in einen leichten Trab.");
    }
    public void galoppieren()
    {
        System.out.println("Das Pferd beginnt zu galoppieren!!!!");
    }
    public void lastSchleppen()
    {
        System.out.println("Das Pferd wird jetzt als Lasttier verwendet.");
    }
    public void gerittenWerden()
    {
        System.out.println("Das Pferd wird geritten.");
    }
    public void bewegen()
    {
        System.out.println("*beweg*");
    }
    
    public void ausgeben()
    {
        super.ausgeben();
        System.out.println("traglast: "+traglast);
        System.out.println("geschirrNr: " +geschirrNr);
    }
        
}
