
import sum.kern.*;
/**
 * @author 
 * @version 
 */
public class Main
{
    // Objekte
    Bildschirm derBildschirm;
    Buntstift meinStift;
    Player player;
    
    int Overworld = 1;
    int Battle = 0;
    
    // Konstruktor
    public Main()
    {
        derBildschirm = new Bildschirm();
        meinStift = new Buntstift();
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
        player.main();
    }
    
    public void main(){
        while (Overworld == 1){
            player.main();
        }
    }
}