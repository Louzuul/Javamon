import sum.kern.*;
import sum.werkzeuge.*;
/**
 * @author 
 * @version 
 */
public class BattleInstance
{
    // Objekte
    Bildschirm derBildschirm;
    Stift meinStift;
    Uhr dieUhr;

    // Konstruktor
    public BattleInstance()
    {
        derBildschirm = new Bildschirm();
        meinStift = new Stift();
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
        int battle = 1;
        while (battle != 0){
            if (battle == 1){
                MP3Player.play("assets/bgm/battle.mp3");
                dieUhr.warte(5000);
                battle++;
            }else if (battle == 2){
                MP3Player.stop();
                MP3Player.play("assets/bgm/battlewon.mp3");
            }
        }
    }
}