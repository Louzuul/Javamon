import sum.kern.*;
import sum.werkzeuge.*;
/**
 * @author 
 * @version 
 */
public class Player
{
    // Objekte
    Bildschirm derBildschirm;
    Buntstift meinStift;
    Tastatur dieTastatur;
    Uhr dieUhr;
    Spritesheet charakterSprites;
    
    String direction = "up";
    int walkUp = 0;
    int walkRight = 0;
    int walkDown = 0;
    int walkLeft = 0;
    int idleUp = 1;
    int idleRight = 0;
    int idleDown = 0;
    int idleLeft = 0;
    int playerX = 10;
    int playerY = 10;

    // Konstruktor
    public Player()
    {
        derBildschirm = new Bildschirm();
        meinStift = new Buntstift();
        dieTastatur = new Tastatur();
        dieUhr = new Uhr();
        charakterSprites = new Spritesheet(meinStift, "assets/sprites/Player/PlayerIdleUp", Spritesheet.SPRITE_16);
        charakterSprites = new Spritesheet(meinStift, "assets/sprites/Player/PlayerIdleDown", Spritesheet.SPRITE_16);
        charakterSprites = new Spritesheet(meinStift, "assets/sprites/Player/PlayerIdleLeft", Spritesheet.SPRITE_16);
        charakterSprites = new Spritesheet(meinStift, "assets/sprites/Player/PlayerIdleRight", Spritesheet.SPRITE_16);
        charakterSprites = new Spritesheet(meinStift, "assets/sprites/Player/PlayerWalkUp1", Spritesheet.SPRITE_16);
        charakterSprites = new Spritesheet(meinStift, "assets/sprites/Player/PlayerWalkUp2", Spritesheet.SPRITE_16);
        charakterSprites = new Spritesheet(meinStift, "assets/sprites/Player/PlayerWalkDown1", Spritesheet.SPRITE_16);
        charakterSprites = new Spritesheet(meinStift, "assets/sprites/Player/PlayerWalkDown2", Spritesheet.SPRITE_16);
        charakterSprites = new Spritesheet(meinStift, "assets/sprites/Player/PlayerWalkLeft", Spritesheet.SPRITE_16);
        charakterSprites = new Spritesheet(meinStift, "assets/sprites/Player/PlayerWalkRight", Spritesheet.SPRITE_16);
        charakterSprites = new Spritesheet(meinStift, "assets/sprites/Player/PlayerBattle", Spritesheet.SPRITE_48);
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
    
    public void playermain(){
        controlsOverworld();
    }
    
    public void controlsOverworld(){
        while (true){
            if(dieTastatur.wurdeGedrueckt()){
                if(dieTastatur.zeichen() == 'w'){
                    if(direction == "right"){
                        meinStift.dreheUm(90);
                    }else if(direction == "left"){
                        meinStift.dreheUm(-90);
                    }else if(direction == "down"){
                        meinStift.dreheUm(180);
                    }
                    direction = "up";
                }else if(dieTastatur.zeichen() == 's'){
                    if(direction == "right"){
                        meinStift.dreheUm(-90);
                    }else if(direction == "left"){
                        meinStift.dreheUm(90);
                    }else if(direction == "up"){
                        meinStift.dreheUm(180);
                    }
                    direction = "down";
                }else if(dieTastatur.zeichen() == 'a'){
                    if(direction == "right"){
                        meinStift.dreheUm(180);
                    }else if(direction == "up"){
                        meinStift.dreheUm(-90);
                    }else if(direction == "down"){
                        meinStift.dreheUm(90);
                    }
                    direction = "left";
                }else if(dieTastatur.zeichen() == 'd'){
                    if(direction == "left"){
                        meinStift.dreheUm(180);
                    }else if(direction == "up"){
                        meinStift.dreheUm(90);
                    }else if(direction == "down"){
                        meinStift.dreheUm(-90);
                    }
                    direction = "right";
                }
            }
        }
    }
}