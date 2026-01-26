import sum.kern.*;
import sum.werkzeuge.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.Color;

/**
 * Klasse für ein einzelnes Spritesheet mit fester Sprite-Größe
 * für die "Stifte und Mäuse" Bibliothek
 */
public class Spritesheet {
    
    // Standard Sprite-Größen als Konstanten
    public static final int SPRITE_16 = 16;
    public static final int SPRITE_22 = 22;
    public static final int SPRITE_32 = 32;
    public static final int SPRITE_48 = 48;
    public static final int SPRITE_54 = 54;
    public static final int SPRITE_64 = 64;
    public static final int SPRITE_160 = 160;
    
    private BufferedImage spritesheet;
    private int spriteGroesse;
    private int spritesProZeile;
    private int spritesProSpalte;
    private Buntstift stift;
    
    /**
     * Konstruktor - lädt ein Spritesheet mit fester Sprite-Größe
     * @param stift Der Buntstift zum Zeichnen
     * @param pfad Der Pfad zur Spritesheet-Datei (z.B. "sprites/charaktere.png")
     * @param spriteGroesse Die Größe eines einzelnen Sprites (16, 32 oder 64)
     */
    public Spritesheet(Buntstift stift, String pfad, int spriteGroesse) {
        this.stift = stift;
        this.spriteGroesse = spriteGroesse;
        ladeSpritesheet(pfad);
    }
    
    /**
     * Lädt das Spritesheet von der Festplatte
     */
    private void ladeSpritesheet(String pfad) {
        try {
            File datei = new File(pfad);
            this.spritesheet = ImageIO.read(datei);
            
            if (this.spritesheet != null) {
                // Berechne Anzahl der Sprites
                this.spritesProZeile = this.spritesheet.getWidth() / this.spriteGroesse;
                this.spritesProSpalte = this.spritesheet.getHeight() / this.spriteGroesse;
                
                System.out.println("Spritesheet erfolgreich geladen: " + pfad);
                System.out.println("Sprite-Größe: " + spriteGroesse + "x" + spriteGroesse);
                System.out.println("Sprites pro Zeile: " + spritesProZeile);
                System.out.println("Sprites pro Spalte: " + spritesProSpalte);
                System.out.println("Gesamt Sprites: " + (spritesProZeile * spritesProSpalte));
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Laden des Spritesheets: " + pfad);
            System.err.println("Fehlermeldung: " + e.getMessage());
            this.spritesheet = null;
        }
    }
    
    /**
     * Prüft ob das Spritesheet erfolgreich geladen wurde
     */
    public boolean istGeladen() {
        return this.spritesheet != null;
    }
    
    /**
     * Gibt die Anzahl der Sprites pro Zeile zurück
     */
    public int getSpritesProZeile() {
        return this.spritesProZeile;
    }
    
    /**
     * Gibt die Anzahl der Sprites pro Spalte zurück
     */
    public int getSpritesProSpalte() {
        return this.spritesProSpalte;
    }
    
    /**
     * Gibt die Sprite-Größe zurück
     */
    public int getSpriteGroesse() {
        return this.spriteGroesse;
    }
    
    /**
     * Zeichnet einen Sprite anhand seiner Spalte und Zeile
     * @param spalte Die Spalte des Sprites (0-basiert)
     * @param zeile Die Zeile des Sprites (0-basiert)
     * @param startX X-Position wo der Sprite gezeichnet werden soll
     * @param startY Y-Position wo der Sprite gezeichnet werden soll
     */
    public void zeichneSprite(int spalte, int zeile, int startX, int startY) {
        if (!istGeladen()) {
            System.err.println("Spritesheet ist nicht geladen!");
            return;
        }
        
        if (spalte < 0 || spalte >= spritesProZeile || zeile < 0 || zeile >= spritesProSpalte) {
            System.err.println("Sprite-Position (" + spalte + "," + zeile + ") liegt außerhalb des Spritesheets!");
            return;
        }
        
        // Berechne die Position des gewünschten Sprites im Sheet
        int spriteX = spalte * spriteGroesse;
        int spriteY = zeile * spriteGroesse;
        
        zeichneSpriteVonPosition(spriteX, spriteY, startX, startY);
    }
    
    /**
     * Zeichnet einen Sprite mit Skalierungsfaktor
     * @param spalte Die Spalte des Sprites (0-basiert)
     * @param zeile Die Zeile des Sprites (0-basiert)
     * @param startX X-Position
     * @param startY Y-Position
     * @param skalierungsProzent Skalierung in Prozent (100 = Originalgröße)
     */
    public void zeichneSpriteMitFaktor(int spalte, int zeile, int startX, int startY, int skalierungsProzent) {
        if (!istGeladen()) {
            System.err.println("Spritesheet ist nicht geladen!");
            return;
        }
        
        if (skalierungsProzent <= 0) {
            System.err.println("Skalierungsfaktor muss größer als 0 sein!");
            return;
        }
        
        if (spalte < 0 || spalte >= spritesProZeile || zeile < 0 || zeile >= spritesProSpalte) {
            System.err.println("Sprite-Position (" + spalte + "," + zeile + ") liegt außerhalb des Spritesheets!");
            return;
        }
        
        // Berechne die Position des gewünschten Sprites im Sheet
        int spriteX = spalte * spriteGroesse;
        int spriteY = zeile * spriteGroesse;
        
        // Neue Größe berechnen
        int neueGroesse = (spriteGroesse * skalierungsProzent) / 100;
        double scale = (double) spriteGroesse / neueGroesse;
        
        stift.setzeFuellMuster(1);
        
        // Zeichne den skalierten Sprite
        for (int y = 0; y < neueGroesse; y++) {
            for (int x = 0; x < neueGroesse; x++) {
                // Entsprechende Position im Original-Sprite berechnen
                int origX = (int)(x * scale);
                int origY = (int)(y * scale);
                
                // RGB-Wert holen
                int rgb = spritesheet.getRGB(spriteX + origX, spriteY + origY);
                Color farbe = new Color(rgb, true);
                
                // Überspringe transparente Pixel
                if (farbe.getAlpha() == 0) {
                    continue;
                }
                
                // Buntstift positionieren
                stift.bewegeBis(startX + x, startY + y);
                
                // Farbe setzen und Pixel zeichnen
                stift.setzeFarbe(Farbe.rgb(farbe.getRed(), farbe.getGreen(), farbe.getBlue()));
                stift.zeichneRechteck(1, 1);
            }
        }
    }
    
    /**
     * Hilfsmethode zum Zeichnen eines Sprites von einer bestimmten Position im Spritesheet
     */
    private void zeichneSpriteVonPosition(int spriteX, int spriteY, int startX, int startY) {
        stift.setzeFuellMuster(1);
        
        // Zeichne den Sprite Pixel für Pixel
        for (int y = 0; y < spriteGroesse; y++) {
            for (int x = 0; x < spriteGroesse; x++) {
                // RGB-Wert des aktuellen Pixels im Spritesheet holen
                int rgb = spritesheet.getRGB(spriteX + x, spriteY + y);
                Color farbe = new Color(rgb, true); // true für Alpha-Kanal
                
                // Überspringe transparente Pixel
                if (farbe.getAlpha() == 0) {
                    continue;
                }
                
                // Buntstift positionieren
                stift.bewegeBis(startX + x, startY + y);
                
                // Farbe setzen und Pixel zeichnen
                stift.setzeFarbe(Farbe.rgb(farbe.getRed(), farbe.getGreen(), farbe.getBlue()));
                stift.zeichneRechteck(1, 1);
            }
        }
    }
}

// Beispiel für die Verwendung:
/*
public class Spielfeld {
    Spritesheet charakterSprites;
    Spritesheet itemSprites;
    Spritesheet effectSprites;
    
    public Spielfeld() {
        derBildschirm = new Bildschirm(1000,1000,true);   
        meinStift = new Buntstift();
        dieMaus = new Maus();
        
        // Spritesheets laden - Buntstift wird beim Erstellen übergeben
        charakterSprites = new Spritesheet(meinStift, "sprites/charaktere.png", Spritesheet.SPRITE_32);
        itemSprites = new Spritesheet(meinStift, "sprites/items.png", Spritesheet.SPRITE_16);
        effectSprites = new Spritesheet(meinStift, "sprites/effects.png", Spritesheet.SPRITE_64);
        
        Spiel();
    }
    
    public void zeichneSpieler() {
        if (charakterSprites.istGeladen()) {
            // Zeichne Charakter aus Spalte 0, Zeile 0
            charakterSprites.zeichneSprite(0, 0, derSpieler.gibXpos(), derSpieler.gibYpos());
            
            // Oder zeichne Charakter aus Spalte 2, Zeile 1
            // charakterSprites.zeichneSprite(2, 1, derSpieler.gibXpos(), derSpieler.gibYpos());
        }
    }
    
    public void zeichneItem(int x, int y, int itemSpalte, int itemZeile) {
        if (itemSprites.istGeladen()) {
            // Zeichne Item vergrößert (150%)
            itemSprites.zeichneSpriteMitFaktor(itemSpalte, itemZeile, x, y, 150);
        }
    }
    
    public void zeichneExplosion(int x, int y, int animationsSpalte, int animationsZeile) {
        if (effectSprites.istGeladen()) {
            // Zeichne Explosions-Animation
            effectSprites.zeichneSprite(animationsSpalte, animationsZeile, x, y);
        }
    }
}
*/