
import sum.kern.*;
/**
 * @author 
 * @version 
 */
public class Spielfeld {
    Spritesheet charakterSprites;
    Spritesheet itemSprites;
    Spritesheet effectSprites;
    
    Bildschirm derBildschirm;
    Buntstift meinStift;
    Maus dieMaus;
    
    public Spielfeld() {
        derBildschirm = new Bildschirm(1000,1000,true);   
        meinStift = new Buntstift();
        dieMaus = new Maus();
        
        // Spritesheets laden - Buntstift wird beim Erstellen übergeben
        charakterSprites = new Spritesheet(meinStift, "assets/sprites/Rival.png", Spritesheet.SPRITE_54);
    }
    
    public void zeichneSpieler() {
        if (charakterSprites.istGeladen()) {
            // Zeichne Charakter aus Spalte 0, Zeile 0
            charakterSprites.zeichneSpriteMitFaktor(0, 0, 10, 10,500);
            derBildschirm.zeichneDich();
            
            // Oder zeichne Charakter aus Spalte 2, Zeile 1
            // charakterSprites.zeichneSprite(2, 1, derSpieler.gibXpos(), derSpieler.gibYpos());
        }
    }
}