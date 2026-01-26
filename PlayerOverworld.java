import sum.kern.*;
import sum.werkzeuge.*;
/**
 * @author 
 * @version 
 */
public class PlayerOverworld
{
    // Objekte
    Bildschirm derBildschirm;
    Buntstift meinStift;
    Tastatur dieTastatur;
    Spritesheet playerOverworld;
    Spritesheet playerBattle;

    String direction = "up";
    int playerX = 990;
    int playerY = 540;
    int Spalte = 3;
    int Zeile = 0;
    int AnimUp = 1;
    int AnimDown = 1;
    int AnimLeft = 1;
    int AnimRight = 1;

    // Konstruktor
    public PlayerOverworld(Buntstift stift, Bildschirm schirm, Tastatur tasten)
    {
        derBildschirm = schirm;
        meinStift = stift;
        dieTastatur = tasten;
        playerOverworld = new Spritesheet(meinStift, "assets/sprites/Player/PlayerOverworld.png", Spritesheet.SPRITE_16);
    }

    public int gibX(){
        return playerX;
    }

    public int gibY(){
        return playerY;
    }

    public void main(){
        playerOverworld.zeichneSpriteMitFaktor(Spalte, Zeile, playerX, playerY, 200);
        derBildschirm.zeichneDich();
        controls();
        derBildschirm.loescheAlles();
    }

    public void controls(){
        if(dieTastatur.wurdeGedrueckt()){
            if(dieTastatur.zeichen() == 'w'){
                direction = "up";
                playerY = playerY-2;
                if (AnimUp == 1){
                    Spalte = 3;
                    Zeile = 1;
                }else if (AnimUp == 2){
                    Spalte = 3;
                    Zeile = 0;
                }else if (AnimUp == 3){
                    Spalte = 4;
                    Zeile = 1;
                }
                AnimUp++;
                if(AnimUp > 3){
                    AnimUp = 1;
                }
            }else if(dieTastatur.zeichen() == 's'){
                direction = "down";
                playerY = playerY+2;
                if (AnimDown == 1){
                    Spalte = 0;
                    Zeile = 1;
                }else if (AnimDown == 2){
                    Spalte = 0;
                    Zeile = 0;
                }else if (AnimDown == 3){
                    Spalte = 4;
                    Zeile = 0;
                }
                AnimDown++;
                if (AnimDown > 3){
                    AnimDown = 1;
                }
            }else if(dieTastatur.zeichen() == 'a'){
                direction = "left";
                playerX = playerX-2;
                if (AnimLeft == 1){
                    Spalte = 1;
                    Zeile = 1;
                }else if (AnimLeft == 2){
                    Spalte = 1;
                    Zeile = 0;
                }
                AnimLeft++;
                if (AnimLeft > 2){
                    AnimLeft = 1;
                }
            }else if(dieTastatur.zeichen() == 'd'){
                direction = "right";
                playerX = playerX+2;
                if (AnimRight == 1){
                    Spalte = 2;
                    Zeile = 1;
                }else if (AnimRight == 2){
                    Spalte = 2;
                    Zeile = 0;
                }
                AnimRight++;
                if (AnimRight > 2){
                    AnimRight = 1;
                }
            }
            dieTastatur.weiter();
        }
    }
}