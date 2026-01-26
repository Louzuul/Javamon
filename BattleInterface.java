import sum.kern.*;
import sum.werkzeuge.*;
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
    Spritesheet UIsprites;
    Spritesheet BagSprites;
    Spritesheet PokemonUIsprites;
    Spritesheet PlayerBattleSprites;
    Spritesheet RedBattleSprites;
    Spritesheet PlayerPokemonSprites;
    Spritesheet RedPokemonSprites;
    RedAI RAI;
    PlayerPokemon PPKMN;
    
    String UI = "Start";

    // Konstruktor
    public BattleInterface()
    {
        meinStift = new Buntstift();
        dieTastatur = new Tastatur();
        RAI = new RedAI();
        PPKMN = new PlayerPokemon();
        UIsprites = new Spritesheet(meinStift, "assets/sprites/BattleUI/BattleUI.png", Spritesheet.SPRITE_160);
        BagSprites = new Spritesheet(meinStift, "assets/sprites/BattleUI/BagUI.png", Spritesheet.SPRITE_160);
        PokemonUIsprites = new Spritesheet(meinStift, "assets/sprites/BattleUI/PokemonUI.png", Spritesheet.SPRITE_160);
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
            UIsprites.zeichneSpriteMitFaktor(0, 0, 500, 0, 600);
            if(dieTastatur.wurdeGedrueckt()){
                if(dieTastatur.zeichen() == 'j'){
                    UI = "Base";
                }
                dieTastatur.weiter();
            }
        }else if(UI == "Base"){
            UIsprites.zeichneSpriteMitFaktor(0, 1, 500, 0, 600);
        }else if(UI == "SelectAttack")
        derBildschirm.zeichneDich();
    }
}
