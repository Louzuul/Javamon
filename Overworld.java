
import sum.kern.*;
import sum.werkzeuge.*;
/**
 * @author 
 * @version 
 */
public class Overworld
{
    // Objekte
    Uhr dieUhr;
    Buntstift meinStift;
    Tastatur dieTastatur;
    PlayerOverworld player;
    Spritesheet Red;
    
    int Overworld = 1;

    // Konstruktor
    public Overworld(Buntstift stift, Bildschirm schirm, Uhr uhr, Tastatur tasten)
    {
        meinStift = stift;
        dieUhr = uhr;
        dieTastatur = tasten;
        player = new PlayerOverworld(meinStift, schirm, tasten);
        Red = new Spritesheet(meinStift, "assets/sprites/Red/RedOverworld.png", Spritesheet.SPRITE_16);
    }
    
    public int OverworldCheck(){
        return Overworld;
    }
    
    public void main(){
        Red.zeichneSpriteMitFaktor(0, 0, 990, 200, 200);
        player.main();
        if (player.gibX() == 990 && player.gibY() == 210){
            MP3Player.play("assets/bgm/encounter.wav");
            dieUhr.warte(1000);
            MP3Player.stop();
            Overworld = 0;
        }
    }
}