import sum.kern.*;
import sum.werkzeuge.*;
import java.util.*;
/**
 * @author 
 * @version 
 */
public class BattleInterface
{
    // Objekte
    Bildschirm derBildschirm;
    Buntstift meinStift;
    Tastatur dieTastatur;
    Random rand;
    Spritesheet UINotif;
    Spritesheet UISelect;
    Spritesheet PlayerBattleSprites;
    Spritesheet RedBattleSprites;
    Spritesheet PlayerPokemonSprites;
    Spritesheet RedPokemonSprites;
    RedAI RAI;
    PlayerPokemon PPKMN;
    
    String UI = "Start";

    // Konstruktor
    public BattleInterface(Buntstift stift, Bildschirm schirm, Tastatur tasten)
    {
        derBildschirm = schirm;
        meinStift = stift;
        dieTastatur = tasten;
        RAI = new RedAI();
        rand = new Random();
        PPKMN = new PlayerPokemon();
        UINotif = new Spritesheet(meinStift, "assets/sprites/BattleUI/UI.png", Spritesheet.SPRITE_160);
        UISelect = new Spritesheet(meinStift, "assets/sprites/BattleUI/UI2.png", Spritesheet.SPRITE_160);
        PlayerBattleSprites = new Spritesheet(meinStift, "assets/sprites/Player/PlayerBattle.png", Spritesheet.SPRITE_54);
        RedBattleSprites = new Spritesheet(meinStift, "assets/sprites/Red/Red.png", Spritesheet.SPRITE_54);
        PlayerPokemonSprites = new Spritesheet(meinStift, "assets/sprites/Player/Pokemon.png", Spritesheet.SPRITE_48);
        RedPokemonSprites = new Spritesheet(meinStift, "assets/sprites/Red/Pokemon.png", Spritesheet.SPRITE_48);
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
        if(UI == "Start"){
            
        }
        derBildschirm.zeichneDich();
    }
}