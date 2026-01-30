import sum.kern.*;
import sum.werkzeuge.*;
import java.util.*;
/**
 * @author 
 * @version 
 */
public class Battle
{
    // Objekte
    Bildschirm derBildschirm;
    Buntstift meinStift;
    Tastatur dieTastatur;
    Uhr dieUhr;
    Random rand;
    Spritesheet UI;
    Spritesheet PlayerBattleSprites;
    Spritesheet RedBattleSprites;
    Spritesheet PlayerPokemonSprites;
    Spritesheet RedPokemonSprites;
    
    String UIState = "Start";
    String UIPointer = "Fight";
    boolean Win = false;
    boolean EnemyHeal = true;
    int MaxHeal = 1;
    int Attack = 0;
    int Heal = 0;
    int PlayerHP = 350;
    int EnemyHP = 350;
    int HealTimes = 4;
    int PlayerDamage = 0;
    int EnemyDamage = 0;
    int Battle = 1;
    
    // Konstruktor
    public Battle(Buntstift stift, Bildschirm schirm, Tastatur tasten, Uhr uhr)
    {
        derBildschirm = schirm;
        meinStift = stift;
        dieTastatur = tasten;
        dieUhr = uhr;
        rand = new Random();
        UI = new Spritesheet(meinStift, "assets/sprites/BattleUI/UI.png", Spritesheet.SPRITE_160);
        PlayerBattleSprites = new Spritesheet(meinStift, "assets/sprites/Player/PlayerBattle.png", Spritesheet.SPRITE_48);
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
    
    public int BattleCheck(){
        return Battle;
    }
    
    public void main(){
        if(UIState == "Start"){
            UI.zeichneSpriteMitFaktor(0, 0, 500, 0, 600);
            PlayerBattleSprites.zeichneSpriteMitFaktor(0, 0, 530, 390, 600);
            RedBattleSprites.zeichneSpriteMitFaktor(0, 0, 1100, 0, 600);
            meinStift.setzeSchriftGroesse(45);
            meinStift.setzeFarbe(Farbe.SCHWARZ);
            meinStift.bewegeBis(530, 900);
            meinStift.schreibeText("Trainer Red challenges you!");
            derBildschirm.zeichneDich();
            if(dieTastatur.wurdeGedrueckt()){
                if(dieTastatur.zeichen() == 'j'){
                    UIState = "Action";
                    derBildschirm.loescheAlles();
                }
                dieTastatur.weiter();
            }
        }else if(UIState == "Action"){
            UI.zeichneSpriteMitFaktor(0, 1, 500, 0, 600);
            PlayerPokemonSprites.zeichneSpriteMitFaktor(0, 0, 530, 390, 600);
            RedPokemonSprites.zeichneSpriteMitFaktor(0, 0, 1100, 0, 700);
            meinStift.bewegeBis(530, 50);
            meinStift.setzeFarbe(Farbe.SCHWARZ);
            meinStift.schreibeText("HP: " + EnemyHP);
            meinStift.bewegeBis(1100, 420);
            meinStift.setzeFarbe(Farbe.SCHWARZ);
            meinStift.schreibeText("HP: " + PlayerHP);
            derBildschirm.zeichneDich();
            if(PlayerHP <= 0 || EnemyHP <= 0){
                UIState = "End";
            }
            if(dieTastatur.wurdeGedrueckt()){
                if(dieTastatur.zeichen() == 'w'){
                    if(UIPointer == "Fight"){
                        UIPointer = "Fight";
                    }else if(UIPointer == "Heal"){
                        UIPointer = "Fight";
                    }
                }
                if(dieTastatur.zeichen() == 's'){
                    if(UIPointer == "Fight"){
                        UIPointer = "Heal";
                    }else if(UIPointer == "Heal"){
                        UIPointer = "Heal";
                    }
                }
                if(dieTastatur.zeichen() == 'j'){
                    if(UIPointer == "Fight"){
                        Attack = 1;
                        UIState = "Attack/Heal";
                        derBildschirm.loescheAlles();
                    }else if(UIPointer == "Heal"){
                        if(HealTimes > 0 && HealTimes <= 4){
                            Heal = 1;
                            UIState = "Attack/Heal";
                            derBildschirm.loescheAlles();
                        }else if(HealTimes == 0){
                            UIState = "Attack/Heal";
                        }
                    }
                }
                if(UIPointer == "Fight"){
                    derBildschirm.loescheAlles();
                    UI.zeichneSpriteMitFaktor(0, 1, 500, 0, 600);
                    PlayerPokemonSprites.zeichneSpriteMitFaktor(0, 0, 530, 390, 600);
                    RedPokemonSprites.zeichneSpriteMitFaktor(0, 0, 1100, 0, 700);
                    meinStift.bewegeBis(990, 810);
                    meinStift.setzeFuellMuster(1);
                    meinStift.setzeFarbe(Farbe.SCHWARZ);
                    meinStift.zeichneRechteck(20, 20);
                    derBildschirm.zeichneDich();
                }
                if(UIPointer == "Heal"){
                    derBildschirm.loescheAlles();
                    UI.zeichneSpriteMitFaktor(0, 1, 500, 0, 600);
                    PlayerPokemonSprites.zeichneSpriteMitFaktor(0, 0, 530, 390, 600);
                    RedPokemonSprites.zeichneSpriteMitFaktor(0, 0, 1100, 0, 700);
                    meinStift.bewegeBis(990, 890);
                    meinStift.setzeFuellMuster(1);
                    meinStift.setzeFarbe(Farbe.SCHWARZ);
                    meinStift.zeichneRechteck(20, 20);
                    derBildschirm.zeichneDich();
                }
                dieTastatur.weiter();
            }
        }else if(UIState == "Attack/Heal"){
            UI.zeichneSpriteMitFaktor(0, 0, 500, 0, 600);
            PlayerPokemonSprites.zeichneSpriteMitFaktor(0, 0, 530, 390, 600);
            RedPokemonSprites.zeichneSpriteMitFaktor(0, 0, 1100, 0, 700);
            if(Attack == 1){
                if(dieTastatur.wurdeGedrueckt()){
                    if(dieTastatur.zeichen() == 'j'){
                        EnemyDamage = rand.nextInt(100);
                        EnemyHP = EnemyHP - PlayerDamage;
                        meinStift.setzeFarbe(Farbe.SCHWARZ);
                        meinStift.bewegeBis(530, 900);
                        meinStift.schreibeText("Typhlosion inflicted " + PlayerDamage + " Damage!");
                        meinStift.bewegeBis(530, 50);
                        meinStift.setzeFarbe(Farbe.SCHWARZ);
                        meinStift.schreibeText("HP: " + EnemyHP);
                        meinStift.bewegeBis(1100, 420);
                        meinStift.setzeFarbe(Farbe.SCHWARZ);
                        meinStift.schreibeText("HP: " + PlayerHP);
                        derBildschirm.zeichneDich();
                        dieUhr.warte(2000);
                        if(EnemyHP <= 100){
                            if (EnemyHeal == true){
                                EnemyHP = EnemyHP + 100;
                                derBildschirm.loescheAlles();
                                UI.zeichneSpriteMitFaktor(0, 0, 500, 0, 600);
                                PlayerPokemonSprites.zeichneSpriteMitFaktor(0, 0, 530, 390, 600);
                                RedPokemonSprites.zeichneSpriteMitFaktor(0, 0, 1100, 0, 700);
                                meinStift.setzeFarbe(Farbe.SCHWARZ);
                                meinStift.bewegeBis(530, 900);
                                meinStift.schreibeText("Blastoise regenerated 100 HP!");
                                derBildschirm.zeichneDich();
                                dieUhr.warte(2000);
                                EnemyHeal = false;
                            }
                        }
                        derBildschirm.loescheAlles();
                        PlayerDamage = rand.nextInt(100);
                        PlayerHP = PlayerHP - EnemyDamage;
                        UI.zeichneSpriteMitFaktor(0, 0, 500, 0, 600);
                        PlayerPokemonSprites.zeichneSpriteMitFaktor(0, 0, 530, 390, 600);
                        RedPokemonSprites.zeichneSpriteMitFaktor(0, 0, 1100, 0, 700);
                        meinStift.setzeFarbe(Farbe.SCHWARZ);
                        meinStift.bewegeBis(530, 900);
                        meinStift.schreibeText("Blastoise inflicted " + EnemyDamage + " Damage!");
                        meinStift.bewegeBis(530, 50);
                        meinStift.setzeFarbe(Farbe.SCHWARZ);
                        meinStift.schreibeText("HP: " + EnemyHP);
                        meinStift.bewegeBis(1100, 420);
                        meinStift.setzeFarbe(Farbe.SCHWARZ);
                        meinStift.schreibeText("HP: " + PlayerHP);
                        derBildschirm.zeichneDich();
                        dieUhr.warte(2000);
                        MaxHeal = 0;
                        Attack = 0;
                        UIState = "Action";
                        derBildschirm.loescheAlles();
                    }
                    dieTastatur.weiter();
                }
            }else if(Heal == 1){
                if (MaxHeal == 1){
                    meinStift.setzeFarbe(Farbe.SCHWARZ);
                    meinStift.bewegeBis(530, 900);
                    meinStift.schreibeText("Typhlosion is already at Full HP!");
                    meinStift.bewegeBis(530, 30);
                    meinStift.setzeFarbe(Farbe.SCHWARZ);
                    meinStift.schreibeText("HP: " + EnemyHP);
                    meinStift.bewegeBis(1100, 420);
                    meinStift.setzeFarbe(Farbe.SCHWARZ);
                    meinStift.schreibeText("HP: " + PlayerHP);
                    derBildschirm.zeichneDich();
                    if(dieTastatur.wurdeGedrueckt()){
                        if(dieTastatur.zeichen() == 'j'){
                            Heal = 0;
                            UIState = "Action";
                            derBildschirm.loescheAlles();
                        }
                        dieTastatur.weiter();
                    }
                }else{
                    if(dieTastatur.wurdeGedrueckt()){
                        if(dieTastatur.zeichen() == 'h'){
                            PlayerHP = PlayerHP + 50;
                            HealTimes = HealTimes - 1;
                            if(PlayerHP >= 350){
                                PlayerHP = 350;
                                MaxHeal = 1;
                                meinStift.setzeFarbe(Farbe.SCHWARZ);
                                meinStift.bewegeBis(530, 900);
                                meinStift.schreibeText("Typhlosion healed to Full HP!");
                                meinStift.bewegeBis(530, 30);
                                meinStift.setzeFarbe(Farbe.SCHWARZ);
                                meinStift.schreibeText("HP: " + EnemyHP);
                                meinStift.bewegeBis(1100, 420);
                                meinStift.setzeFarbe(Farbe.SCHWARZ);
                                meinStift.schreibeText("HP: " + PlayerHP);
                                derBildschirm.zeichneDich();
                            }else{
                                meinStift.setzeFarbe(Farbe.SCHWARZ);
                                meinStift.bewegeBis(530, 900);
                                meinStift.schreibeText("Typhlosion Regenerated 50 HP!");
                                meinStift.bewegeBis(530, 50);
                                meinStift.setzeFarbe(Farbe.SCHWARZ);
                                meinStift.schreibeText("HP: " + EnemyHP);
                                meinStift.bewegeBis(1100, 420);
                                meinStift.setzeFarbe(Farbe.SCHWARZ);
                                meinStift.schreibeText("HP: " + PlayerHP);
                                derBildschirm.zeichneDich();
                            }
                        }else if(dieTastatur.zeichen() == 'j'){
                            Heal = 0;
                            UIState = "Action";
                            derBildschirm.loescheAlles();
                        }
                        dieTastatur.weiter();
                    }
                }
            }else if(Heal == 0 && Attack == 0){
                meinStift.setzeFarbe(Farbe.SCHWARZ);
                meinStift.bewegeBis(530, 900);
                meinStift.schreibeText("You already used up all your heals!");
                meinStift.bewegeBis(530, 30);
                meinStift.setzeFarbe(Farbe.SCHWARZ);
                meinStift.schreibeText("HP: " + EnemyHP);
                meinStift.bewegeBis(1100, 420);
                meinStift.setzeFarbe(Farbe.SCHWARZ);
                meinStift.schreibeText("HP: " + PlayerHP);
                derBildschirm.zeichneDich();
                dieUhr.warte(2000);
                UIState = "Action";
                derBildschirm.loescheAlles();
            }
        }else if(UIState == "End"){
            if(PlayerHP <= 0){
                UI.zeichneSpriteMitFaktor(0, 0, 500, 0, 600);
                PlayerBattleSprites.zeichneSpriteMitFaktor(0, 0, 530, 390, 600);
                RedPokemonSprites.zeichneSpriteMitFaktor(0, 0, 1100, 0, 700);
                meinStift.setzeFarbe(Farbe.SCHWARZ);
                meinStift.bewegeBis(530, 900);
                meinStift.schreibeText("You Lost!");
                derBildschirm.zeichneDich();
            }else if(EnemyHP <= 0){
                Battle = 0;
            }
        }
    }
}