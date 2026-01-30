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
    Spritesheet RedBattleSprites;
    Spritesheet PlayerPokemonSprites;
    Spritesheet UI;
    
    int Overworld = 1;
    int Battle = 0;
    int Win = 0;
    
    // Konstruktor
    public Main()
    {
        derBildschirm = new Bildschirm(1980,1080,true);
        meinStift = new Buntstift();
        dieUhr = new Uhr();
        dieTastatur = new Tastatur();
        overworld = new Overworld(meinStift, derBildschirm, dieUhr, dieTastatur);
        battle = new Battle(meinStift, derBildschirm, dieTastatur, dieUhr);
        UI = new Spritesheet(meinStift, "assets/sprites/BattleUI/UI.png", Spritesheet.SPRITE_160);
        RedBattleSprites = new Spritesheet(meinStift, "assets/sprites/Red/Red.png", Spritesheet.SPRITE_54);
        PlayerPokemonSprites = new Spritesheet(meinStift, "assets/sprites/Player/Pokemon.png", Spritesheet.SPRITE_48);
        main();
    }

    
    public void main(){
        if(Overworld == 1){
            MP3Player.loop("assets/bgm/overworld.mp3");
        }
        while (Overworld == 1){
            overworld.main();
            if (overworld.OverworldCheck() == 0){
                Overworld = 0;
                Battle = 1;
            }
        }
        if(Battle == 1){
            MP3Player.stop();
            MP3Player.loop("assets/bgm/battle.mp3");
        }
        while (Battle == 1){
            battle.main();
            if(battle.BattleCheck() == 0){
                Battle = 0;
                Win = 1;
            }
        }
        if(Win == 1){
            MP3Player.stop();
            MP3Player.loop("assets/bgm/battlewon.mp3");
            UI.zeichneSpriteMitFaktor(0, 0, 500, 0, 600);
            PlayerPokemonSprites.zeichneSpriteMitFaktor(0, 0, 530, 390, 600);
            RedBattleSprites.zeichneSpriteMitFaktor(0, 0, 1100, 0, 600);
            meinStift.setzeFarbe(Farbe.SCHWARZ);
            meinStift.bewegeBis(530, 900);
            meinStift.schreibeText("You successfully defeated Trainer Red!");
            derBildschirm.zeichneDich();
        }
    }
}