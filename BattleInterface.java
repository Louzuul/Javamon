import sum.kern.*;
import sum.werkzeuge.*;
/**
 * @author 
 * @version 
 */
public class BattleInterface
{
    // Objekte
    Bildschirm derBildschirm;
    Buntstift meinStift;
    Uhr dieUhr;
    Spritesheet charakterSprites;

    // Konstruktor
    public BattleInterface()
    {
        derBildschirm = new Bildschirm();
        meinStift = new Buntstift();
        dieUhr = new Uhr();
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
    
    public void main(){
    
    }
}
