
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

        player = new PlayerBattle();
        red = new RedAI();
        UI = new BattleInterface();
    }


    
    public void main(){
    
    }
}