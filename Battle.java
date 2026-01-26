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
    Stift meinStift;
    BattleInterface UI;

    // Konstruktor
    public Battle(Buntstift stift, Bildschirm schirm, Tastatur tasten)
    {
        meinStift = new Stift();
        UI = new BattleInterface();
    }


    
    public void main(){
    }
}