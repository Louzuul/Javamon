
import sum.kern.*;
/**
 * @author 
 * @version 
 */
public class Battle
{
    // Objekte
    Bildschirm derBildschirm;
    Stift meinStift;
    PlayerBattle player;
    RedAI red;
    BattleInterface UI;

    // Konstruktor
    public Battle()
    {
        meinStift = new Stift();
        player = new PlayerBattle();
        red = new RedAI();
        UI = new BattleInterface();
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