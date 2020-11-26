
import java.awt.*;  // Klasse Color

public class Kreis {
    
  // Attribute
  
   private FrmZeichnen kZf;
   private Graphics kLw;
   private int zX, zY, zR;
   private Color zFarbe;
   private boolean zSichtbar;

  // Konstruktoren
  
    /** Konstruktor: erzeugt ein Objekt der Klasse Kreis. */
    public Kreis (FrmZeichnen zf, int xPos, int yPos, int radius, Color farbe) {
       kZf = zf;
       kLw= kZf.getGraphics();  // Leinwand = Zeichenflaeche
       zX = xPos + kZf.getInsets().left;
       zY = yPos + kZf.getInsets().top;
       zR = radius;
       zFarbe = farbe;
       zSichtbar = false;
    }

   // Methoden
   
    /** Zeichnet die Figur. */
    public void zeichnen() {
       Color farbeAlt;
       farbeAlt = kLw.getColor();
       kLw.setColor (zFarbe);
       kLw.fillOval (zX-zR, zY-zR, 2*zR, 2*zR);
       kLw.setColor (Color.black);
       kLw.drawOval (zX-zR, zY-zR, 2*zR, 2*zR);
       kLw.setColor (farbeAlt);
       zSichtbar = true;
    }
 
    /** Uebermalt die Figur mit weisser Farbe */
    public void loeschen() {
       Color farbeAlt;
       farbeAlt = kLw.getColor();
       kLw.setColor (Color.white);
       kLw.fillOval (zX-zR, zY-zR, 2*zR, 2*zR);
       kLw.drawOval (zX-zR, zY-zR, 2*zR, 2*zR);
       kLw.setColor (farbeAlt);
       zSichtbar = false;
    }
    
    /** Zeichnet die Figur in der neuen Farbe. */
    public void setzeFarbe (Color farbe) {
        zFarbe = farbe;
        if (zSichtbar)
           zeichnen();
    }
    
    /** Bezugspunkt: Ecke unten links. */
    public void setzePosition (int xPos, int yPos) {
       if (zSichtbar) {
          loeschen();
          zX = xPos + kZf.getInsets().left;
          zY = yPos + kZf.getInsets().top;
          zeichnen();
       } 
       else {
          zX = xPos + kZf.getInsets().left;
          zY = yPos + kZf.getInsets().top; 
       }
    }
    
     /** Liefert die x-Koordinate der Figur. */
    public int liesXPosition() {
       return zX - kZf.getInsets().left;
    }
    
    /** Liefert die y-Koordinate der Figur. */
    public int liesYPosition() {
       return zY - kZf.getInsets().top;
    }
    
} // Klasse Kreis