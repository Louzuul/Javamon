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

    // Konstruktor
    public Player()
    {
        derBildschirm = new Bildschirm();
        meinStift = new Buntstift();
        dieTastatur = new Tastatur();
        dieUhr = new Uhr();
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
        controls();
    }
    
    public void controls(){
        while (true){
            if(dieTastatur.wurdeGedrueckt()){
                if(dieTastatur.zeichen() == 'w'){
                    
                }else if(dieTastatur.zeichen() == 's'){
                
                }else if(dieTastatur.zeichen() == 'a'){
                
                }else if(dieTastatur.zeichen() == 'd'){
                
                }
            }
        }
    }
}