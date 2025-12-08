
import sum.kern.*;
/**
 * @author 
 * @version 
 */
public class Rival
{
    // Objekte
    Bildschirm derBildschirm;
    Stift meinStift;

    // Konstruktor
    public Rival()
    {
        derBildschirm = new Bildschirm();
        meinStift = new Stift();
    }

    // Dienste
    public void fuehreAus()
    {
        // Aktionsteil
        meinStift.bewegeBis(100, 100);
        meinStift.schreibeText("Hallo Welt");
        
        // Aufraeumen
        meinStift.gibFrei();
        derBildschirm.gibFrei();
    }
}