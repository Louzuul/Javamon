
import sum.kern.*;
/**
 * @author 
 * @version 
 */
public class Overworld
{
    // Objekte
    Bildschirm derBildschirm;
    Buntstift meinStift;
    Tastatur dieTastatur;
    PlayerOverworld player;
    Spritesheet Red;

    // Konstruktor
    public Overworld()
    {
        derBildschirm = new Bildschirm();
        meinStift = new Buntstift();
        dieTastatur = new Tastatur();
        player = new PlayerOverworld();
        Red = new Spritesheet(meinStift, "assets/sprites/Red/RedOverworld.png", Spritesheet.SPRITE_16);
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
        MP3Player.play("assets/bgm/overworld.wav");
        Red.zeichneSpriteMitFaktor(0, 0, 990, 200, 200);
        player.main();
        if (player.gibX() == 990 && player.gibY() == 210){
            MP3Player.play("assets/bgm/encounter.wav");
            meinStift.bewegeBis(700, 870);
            meinStift.zeichneRechteck(700, 200);
            meinStift.bewegeBis(720, 890);
            meinStift.schreibeText("...");
            if (dieTastatur.wurdeGedrueckt()){
                dieTastatur.weiter();
                MP3Player.stop();
            }
        }
    }
}