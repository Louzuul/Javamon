
import sum.kern.*;
/**
 * @author 
 * @version 
 */
public class Overworld
{
    // Objekte

    Buntstift meinStift;
    PlayerOverworld player;
    Spritesheet Red;
    
    int Overworld = 1;

    // Konstruktor
    public Overworld(Buntstift stift, Bildschirm schirm)
    {

        meinStift = stift;
        player = new PlayerOverworld(meinStift, schirm);
        Red = new Spritesheet(meinStift, "assets/sprites/Red/RedOverworld.png", Spritesheet.SPRITE_16);
    }
    
    public int OverworldCheck(){
        return Overworld;
    }
    
    public void main(){
        Red.zeichneSpriteMitFaktor(0, 0, 990, 200, 200);
        player.main();
        if (player.gibX() == 990 && player.gibY() == 210){
            Overworld = 0;
        }
    }
}