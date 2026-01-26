
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
        meinStift = new Buntstift();
        overworld = new Overworld(meinStift, derBildschirm);
        battle = new Battle();
        Font = new Spritesheet(meinStift, "assets/sprites/Font.png", Spritesheet.SPRITE_22);
        main();
    }

    
    public void main(){
        while (Overworld == 1){
            overworld.main();
            if (overworld.OverworldCheck() == 0){
                Overworld = 0;
                Battle = 1;
            }
        }
        while (Battle == 1){
            battle.main();
        }
    }
}