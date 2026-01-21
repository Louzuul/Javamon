
import sum.kern.*;
/**
 * @author 
 * @version 
 */
public class RedAI
{
    // Objekte
    Bildschirm derBildschirm;
    Stift meinStift;

    // Konstruktor
    public RedAI()
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