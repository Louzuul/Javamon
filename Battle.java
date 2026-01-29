import sum.kern.*;
import sum.werkzeuge.*;
/**
 * @author 
 * @version 
 */
public class Battle
{
    // Objekte
    Bildschirm derBildschirm;
    Buntstift meinStift;
    Tastatur dieTastatur;
    BattleInterface UI;

    // Konstruktor
    public Battle(Buntstift stift, Bildschirm schirm, Tastatur tasten)
    {
        derBildschirm = schirm;
        meinStift = stift;
        dieTastatur = tasten;
        UI = new BattleInterface(stift, schirm, tasten);
    }
    
    public void main(){
        UI.main();
    }
}