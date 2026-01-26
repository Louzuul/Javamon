import sum.kern.*;
import sum.werkzeuge.*;
/**
 * @author 
 * @version 
 */
public class Main
{
    // Objekte
    Bildschirm derBildschirm;
    Buntstift meinStift;
    Uhr dieUhr;
    Tastatur dieTastatur;
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
        dieUhr = new Uhr();
        dieTastatur = new Tastatur();
        overworld = new Overworld(meinStift, derBildschirm, dieUhr, dieTastatur);
        battle = new Battle(meinStift, derBildschirm, dieTastatur);
        main();
    }

    
    public void main(){
        while (Overworld == 1){
            MP3Player.play("assets/bgm/overworld.wav");
            overworld.main();
            if (overworld.OverworldCheck() == 0){
                Overworld = 0;
                Battle = 1;
            }
        }
        while (Battle == 1){
            MP3Player.play("assets/bgm/battle.wav");
            battle.main();
        }
    }
}