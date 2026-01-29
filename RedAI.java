
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
    
    String currentPKMN = "Pikachu";

    // Konstruktor
    public RedAI()
    {
        
    }
    
    public String PKMN(){
        return currentPKMN;
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