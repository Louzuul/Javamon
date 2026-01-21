
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
    Overworld overworld;
    Battle battle;
    Spritesheet Font;
    
    int Overworld = 1;
    int Battle = 0;
    
    
    // Konstruktor
    public Main()
    {
        derBildschirm = new Bildschirm(1980,1080,true);
        overworld = new Overworld();
        battle = new Battle();
        Font = new Spritesheet(meinStift, "assets/sprites/Font.png", Spritesheet.SPRITE_22);
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
        while (Overworld == 1){
            overworld.main();
        }
        while (Battle == 1){
            battle.main();
        }
    }
}